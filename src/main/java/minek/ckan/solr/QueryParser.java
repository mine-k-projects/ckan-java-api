package minek.ckan.solr;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class QueryParser {

    protected static final String CRITERIA_VALUE_SEPARATOR = " ";
    protected static final String DELIMINATOR = ":";
    protected static final String NOT = "-";
    protected static final String BOOST = "^";

    private static QueryParser instance = null;
    private Map<Criteria.Operation, PredicateProcessor> predicateProcessorMap = new HashMap<>();

    private QueryParser() {
        predicateProcessorMap.put(Criteria.Operation.EQUALS, new EqualsProcessor());
        predicateProcessorMap.put(Criteria.Operation.CONTAINS, new ContainsProcessor());
        predicateProcessorMap.put(Criteria.Operation.STARTS_WITH, new StartsWithProcessor());
        predicateProcessorMap.put(Criteria.Operation.ENDS_WITH, new EndsWithProcessor());
        predicateProcessorMap.put(Criteria.Operation.EXPRESSION, new ExpressionProcessor());
        predicateProcessorMap.put(Criteria.Operation.BETWEEN, new BetweenProcessor());
        predicateProcessorMap.put(Criteria.Operation.FUZZY, new FuzzyProcessor());
        predicateProcessorMap.put(Criteria.Operation.SLOPPY, new SloppyProcessor());
    }

    public static QueryParser getInstance() {
        if (instance == null) {
            instance = new QueryParser();
        }
        return instance;
    }

    public String createQuery(Node node) {
        return createQuery(node, 0);
    }

    private String createQuery(Node node, int position) {
        StringBuilder query = new StringBuilder();
        if (position > 0) {
            query.append(node.isOr() ? " OR " : " AND ");
        }

        if (node.hasSiblings()) {
            if (node.isNegating()) {
                query.append(NOT);
            }
            if (!node.isRoot() || (node.isRoot() && node.isNegating())) {
                query.append('(');
            }

            int i = 0;
            for (Node nested : node.getSiblings()) {
                query.append(createQuery(nested, i++));
            }

            if (!node.isRoot() || (node.isRoot() && node.isNegating())) {
                query.append(')');
            }
        } else {
            query.append(createQueryFragment((Criteria) node));
        }
        return query.toString();
    }

    private String createQueryFragment(Criteria criteria) {
        StringBuilder query = new StringBuilder();

        String field = criteria.getField();

        if (criteria.isNegating()) {
            query.append(NOT);
        }
        query.append(field);
        query.append(DELIMINATOR);

        Set<Criteria.Predicate> predicates = criteria.getPredicates();

        if (predicates.isEmpty()) {
            query.append("[* TO *]");
            return query.toString();
        }

        boolean oneMorePredicate = predicates.size() > 1;
        if (oneMorePredicate) {
            query.append("(");
        }

        String collect = predicates.stream()
                .map(predicate -> {
                    Criteria.Operation key = predicate.getKey();
                    PredicateProcessor predicateProcessor = predicateProcessorMap.get(key);
                    return predicateProcessor.process(field, predicate);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.joining(CRITERIA_VALUE_SEPARATOR));
        query.append(collect);

        if (oneMorePredicate) {
            query.append(")");
        }

        if (!Float.isNaN(criteria.getBoost())) {
            query.append(BOOST).append(criteria.getBoost());
        }

        return query.toString();
    }

    interface PredicateProcessor {
        String process(String field, Criteria.Predicate predicate);
    }

    static class DefaultPredicateProcessor implements PredicateProcessor {

        protected static final String DOUBLE_QUOTE = "\"";

        protected final Set<String> BOOLEAN_OPERATORS = new HashSet<>(Arrays.asList("NOT", "AND", "OR"));

        protected final String[] RESERVED_CHARS = {
                DOUBLE_QUOTE, "+", "-", "&&", "||",
                "!", "(", ")", "{", "}",
                "[", "]", "^", "~", "*",
                "?", ":", "\\"
        };

        protected String[] RESERVED_CHARS_REPLACEMENT = {
                "\\" + DOUBLE_QUOTE, "\\+", "\\-", "\\&\\&", "\\|\\|",
                "\\!", "\\(", "\\)", "\\{", "\\}",
                "\\[", "\\]", "\\^", "\\~", "\\*",
                "\\?", "\\:", "\\\\"
        };

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            if (predicate == null || predicate.getValue() == null) {
                return null;
            }
            return (String) filterCriteriaValue(predicate.getValue());
        }

        protected Object filterCriteriaValue(Object criteriaValue) {
            String value = escapeCriteriaValue(criteriaValue.toString());
            return processWhiteSpaces(value);
        }

        private String escapeCriteriaValue(String criteriaValue) {
            return StringUtils.replaceEach(criteriaValue, RESERVED_CHARS, RESERVED_CHARS_REPLACEMENT);
        }

        private String processWhiteSpaces(String criteriaValue) {
            if (StringUtils.contains(criteriaValue, CRITERIA_VALUE_SEPARATOR) || BOOLEAN_OPERATORS.contains(criteriaValue)) {
                return DOUBLE_QUOTE + criteriaValue + DOUBLE_QUOTE;
            }
            return criteriaValue;
        }
    }

    static class EqualsProcessor extends DefaultPredicateProcessor {
    }

    static class ContainsProcessor extends DefaultPredicateProcessor {

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            return Criteria.WILDCARD + filterCriteriaValue(predicate.getValue()) + Criteria.WILDCARD;
        }
    }

    static class StartsWithProcessor extends DefaultPredicateProcessor {

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            return filterCriteriaValue(predicate.getValue()) + Criteria.WILDCARD;
        }
    }

    static class EndsWithProcessor extends DefaultPredicateProcessor {

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            return Criteria.WILDCARD + filterCriteriaValue(predicate.getValue());
        }
    }

    static class ExpressionProcessor implements PredicateProcessor {

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            return predicate.getValue().toString();
        }
    }

    static class BetweenProcessor extends DefaultPredicateProcessor {

        private static final String RANGE_OPERATOR = " TO ";

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            Object[] args = (Object[]) predicate.getValue();
            Object lowerBound = args[0];
            Object upperBound = args[1];
            boolean includeLowerBound = (boolean) args[2];
            boolean includeUpperBound = (boolean) args[3];

            String fragment = "";
            fragment += includeLowerBound ? "[" : "{";
            fragment += lowerBound != null ? filterCriteriaValue(lowerBound) : Criteria.WILDCARD;
            fragment += RANGE_OPERATOR;
            fragment += upperBound != null ? filterCriteriaValue(upperBound) : Criteria.WILDCARD;
            fragment += includeUpperBound ? "]" : "}";

            return fragment;
        }
    }

    static class FuzzyProcessor extends DefaultPredicateProcessor {

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            Object[] args = (Object[]) predicate.getValue();
            String value = (String) args[0];
            Float distance = (Float) args[1];
            return filterCriteriaValue(value) + "~" + (distance.isNaN() ? "" : distance);
        }
    }

    static class SloppyProcessor extends DefaultPredicateProcessor {

        @Override
        public String process(String field, Criteria.Predicate predicate) {
            Object[] args = (Object[]) predicate.getValue();
            String phrase = (String) args[0];
            Integer distance = (Integer) args[1];
            return filterCriteriaValue(phrase) + "~" + distance;
        }
    }

}
