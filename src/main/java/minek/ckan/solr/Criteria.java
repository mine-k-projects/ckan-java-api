package minek.ckan.solr;

import java.util.*;

public class Criteria extends Node {

    public static final String WILDCARD = "*";

    private String field;
    private Set<Predicate> predicates = new LinkedHashSet<>();

    public Criteria() {
    }

    public Criteria(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public Set<Predicate> getPredicates() {
        return Collections.unmodifiableSet(predicates);
    }

    // commands

    @Override
    public Criteria is(Object value) {
        predicates.add(new Predicate(Operation.EQUALS, value));
        return this;
    }

    @Override
    public Criteria is(Object... values) {
        return in(values);
    }

    @Override
    public Criteria is(Iterable<?> values) {
        return in(values);
    }

    @Override
    public Criteria startsWith(String s) {
        predicates.add(new Predicate(Operation.STARTS_WITH, s));
        return this;
    }

    @Override
    public Criteria startsWith(String... values) {
        return startsWith(Arrays.asList(values));
    }

    @Override
    public Criteria startsWith(Iterable<String> values) {
        for (String value : values) {
            startsWith(value);
        }
        return this;
    }

    @Override
    public Criteria endsWith(String s) {
        predicates.add(new Predicate(Operation.ENDS_WITH, s));
        return this;
    }

    @Override
    public Criteria endsWith(String... values) {
        return endsWith(Arrays.asList(values));
    }

    @Override
    public Criteria endsWith(Iterable<String> values) {
        for (String value : values) {
            endsWith(value);
        }
        return this;
    }

    @Override
    public Criteria in(Object... values) {
        return in(Arrays.asList(values));
    }

    @Override
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

    @Override
    public Criteria contains(String s) {
        predicates.add(new Predicate(Operation.CONTAINS, s));
        return this;
    }

    @Override
    public Criteria contains(String... values) {
        return contains(Arrays.asList(values));
    }

    @Override
    public Criteria contains(Iterable<String> values) {
        for (String value : values) {
            contains(value);
        }
        return this;
    }

    @Override
    public Criteria between(Object lowerBound, Object upperBound) {
        return between(lowerBound, upperBound, true, true);
    }

    @Override
    public Criteria between(Object lowerBound, Object upperBound, boolean includeLowerBound, boolean includeUpperBound) {
        predicates.add(new Predicate(Operation.BETWEEN, new Object[]{lowerBound, upperBound, includeLowerBound, includeUpperBound}));
        return this;
    }

    @Override
    public Criteria lessThan(Object upperBound) {
        between(null, upperBound, true, false);
        return this;
    }

    @Override
    public Criteria lessThanEqual(Object upperBound) {
        between(null, upperBound);
        return this;
    }

    @Override
    public Criteria greaterThan(Object lowerBound) {
        between(lowerBound, null, false, true);
        return this;
    }

    @Override
    public Criteria greaterThanEqual(Object lowerBound) {
        between(lowerBound, null);
        return this;
    }

    @Override
    public Criteria isNull() {
        return between(null, null).not();
    }

    @Override
    public Criteria isNotNull() {
        return between(null, null);
    }

    @Override
    public Criteria not() {
        setNegating(true);
        return this;
    }

    public Criteria notOperator() {
        Crotch c = new Crotch();
        c.setNegating(true);
        c.add(this);
        return c;
    }

    @Override
    public Criteria expression(String expression) {
        predicates.add(new Predicate(Operation.EXPRESSION, expression));
        return this;
    }

    // conjunctions

    public Criteria connect() {
        Crotch c = new Crotch();
        c.add(this);
        return c;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Crotch and(Node node) {
        if (!(node instanceof Criteria)) {
            throw new IllegalArgumentException("Can only add instances of Criteria");
        }
        Crotch crotch = new Crotch();
        crotch.setParent(this.getParent());
        crotch.add(this);
        crotch.add(node);
        return crotch;
    }

    @SuppressWarnings("unchecked")
    public Crotch and(String field) {
        Criteria node = new Criteria(field);
        return and(node);
    }

    @SuppressWarnings("unchecked")
    public Crotch or(Node node) {
        if (!(node instanceof Criteria)) {
            throw new IllegalArgumentException("Can only add instances of Criteria");
        }
        node.setOr(true);

        Crotch crotch = new Crotch();
        crotch.setParent(this.getParent());
        crotch.add(this);
        crotch.add(node);
        return crotch;
    }

    @SuppressWarnings("unchecked")
    public Crotch or(String field) {
        Criteria node = new Criteria(field);
        node.setOr(true);
        return or(node);
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
