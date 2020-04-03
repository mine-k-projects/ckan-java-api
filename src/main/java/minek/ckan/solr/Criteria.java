package minek.ckan.solr;

import java.util.*;

public class Criteria {

    public static final String WILDCARD = "*";

    private String field;
    private boolean negating = false;
    private Set<Predicate> predicates = new LinkedHashSet<>();

    public Criteria(String field) {
        this.field = field;
    }

    public boolean isNegating() {
        return negating;
    }

    public void setNegating(boolean negating) {
        this.negating = negating;
    }

    public String getField() {
        return field;
    }

    public Set<Predicate> getPredicates() {
        return Collections.unmodifiableSet(predicates);
    }

    public Criteria is(Object value) {
        predicates.add(new Predicate(Operation.EQUALS, value));
        return this;
    }

    public Criteria startsWith(String s) {
        predicates.add(new Predicate(Operation.STARTS_WITH, s));
        return this;
    }

    public Criteria endsWith(String s) {
        predicates.add(new Predicate(Operation.ENDS_WITH, s));
        return this;
    }

    public Criteria in(Object... values) {
        return in(Arrays.asList(values));
    }

    public Criteria in(Iterable<?> values) {
        for (Object value : values) {
            if (value instanceof Collection) {
                in((Collection<?>) value);
            } else {
                is(value);
            }
        }
        return this;
    }

    public Criteria contains(String s) {
        predicates.add(new Predicate(Operation.CONTAINS, s));
        return this;
    }

    public Criteria contains(String... values) {
        return contains(Arrays.asList(values));
    }

    public Criteria contains(Iterable<String> values) {
        for (String value : values) {
            contains(value);
        }
        return this;
    }

    public Criteria between(Object lowerBound, Object upperBound) {
        return between(lowerBound, upperBound, true, true);
    }

    public Criteria between(Object lowerBound, Object upperBound, boolean includeLowerBound, boolean includeUpperBound) {
        predicates.add(new Predicate(Operation.BETWEEN, new Object[]{lowerBound, upperBound, includeLowerBound, includeUpperBound}));
        return this;
    }

    public Criteria lessThan(Object upperBound) {
        between(null, upperBound, true, false);
        return this;
    }

    public Criteria lessThanEqual(Object upperBound) {
        between(null, upperBound);
        return this;
    }

    public Criteria greaterThan(Object lowerBound) {
        between(lowerBound, null, false, true);
        return this;
    }

    public Criteria greaterThanEqual(Object lowerBound) {
        between(lowerBound, null);
        return this;
    }

    public Criteria isNull() {
        return between(null, null).not();
    }

    public Criteria isNotNull() {
        return between(null, null);
    }

    public Criteria not() {
        setNegating(true);
        return this;
    }

    public enum Operation {
        EQUALS, CONTAINS, STARTS_WITH, ENDS_WITH, EXPRESSION, BETWEEN
    }

    public static class Predicate {
        private final Operation key;
        private final Object value;

        public Predicate(Operation key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Operation getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

    }

    static Criteria where(String field) {
        return new Criteria(field);
    }
}
