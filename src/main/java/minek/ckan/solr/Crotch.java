package minek.ckan.solr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Crotch extends Criteria {

    private List<Criteria> siblings = new ArrayList<>();
    private Node mostRecentSibling = null;

    public Crotch() {
    }

    @Override
    public String getField() {
        if (this.mostRecentSibling instanceof Criteria) {
            return ((Criteria) this.mostRecentSibling).getField();
        }
        return null;
    }

    @Override
    public Collection<Criteria> getSiblings() {
        return Collections.unmodifiableCollection(siblings);
    }

    @Override
    public Crotch is(Object o) {
        mostRecentSibling.is(o);
        return this;
    }

    @Override
    public Crotch not() {
        mostRecentSibling.not();
        return this;
    }

    @Override
    public Crotch notOperator() {
        if (this.isRoot()) {
            this.setNegating(true);
        } else {
            super.notOperator();
        }
        return this;
    }

    @Override
    public Crotch endsWith(String postfix) {
        mostRecentSibling.endsWith(postfix);
        return this;
    }

    @Override
    public Crotch startsWith(String prefix) {
        mostRecentSibling.startsWith(prefix);
        return this;
    }

    @Override
    public Crotch contains(String value) {
        mostRecentSibling.contains(value);
        return this;
    }

    @Override
    public Crotch is(Object... values) {
        mostRecentSibling.is(values);
        return this;
    }

    @Override
    public Crotch is(Iterable<?> values) {
        mostRecentSibling.is(values);
        return this;
    }

    @Override
    public Crotch isNull() {
        mostRecentSibling.isNull();
        return this;
    }

    @Override
    public Crotch isNotNull() {
        mostRecentSibling.isNotNull();
        return this;
    }

    @Override
    public Crotch contains(String... values) {
        mostRecentSibling.contains(values);
        return this;
    }

    @Override
    public Crotch contains(Iterable<String> values) {
        mostRecentSibling.contains(values);
        return this;
    }

    @Override
    public Crotch startsWith(String... values) {
        mostRecentSibling.startsWith(values);
        return this;
    }

    @Override
    public Crotch startsWith(Iterable<String> values) {
        mostRecentSibling.startsWith(values);
        return this;
    }

    @Override
    public Crotch endsWith(String... values) {
        mostRecentSibling.endsWith(values);
        return this;
    }

    @Override
    public Crotch endsWith(Iterable<String> values) {
        mostRecentSibling.endsWith(values);
        return this;
    }

    @Override
    public Crotch expression(String expression) {
        mostRecentSibling.expression(expression);
        return this;
    }

    @Override
    public Crotch between(Object lowerBound, Object upperBound) {
        mostRecentSibling.between(lowerBound, upperBound);
        return this;
    }

    @Override
    public Crotch between(Object lowerBound, Object upperBound, boolean includeLowerBound, boolean includeUpperBound) {
        mostRecentSibling.between(lowerBound, upperBound, includeLowerBound, includeUpperBound);
        return this;
    }

    @Override
    public Crotch lessThan(Object upperBound) {
        mostRecentSibling.lessThan(upperBound);
        return this;
    }

    @Override
    public Crotch lessThanEqual(Object upperBound) {
        mostRecentSibling.lessThanEqual(upperBound);
        return this;
    }

    @Override
    public Crotch greaterThan(Object lowerBound) {
        mostRecentSibling.greaterThan(lowerBound);
        return this;
    }

    @Override
    public Crotch greaterThanEqual(Object lowerBound) {
        mostRecentSibling.greaterThanEqual(lowerBound);
        return this;
    }

    @Override
    public Crotch in(Object... values) {
        mostRecentSibling.in(values);
        return this;
    }

    @Override
    public Crotch in(Iterable<?> values) {
        mostRecentSibling.in(values);
        return this;
    }

    @Override
    public Crotch fuzzy(String value) {
        mostRecentSibling.fuzzy(value);
        return this;
    }

    @Override
    public Crotch fuzzy(String value, float distance) {
        mostRecentSibling.fuzzy(value, distance);
        return this;
    }

    @Override
    public Crotch sloppy(String phrase, int distance) {
        mostRecentSibling.sloppy(phrase, distance);
        return this;
    }

    @Override
    public Crotch boost(float boost) {
        mostRecentSibling.boost(boost);
        return this;
    }

    // conjunctions

    void add(Node node) {
        if (!(node instanceof Criteria)) {
            throw new IllegalArgumentException("Can only add instances of Criteria");
        }

        node.setParent(this);

        Criteria criteria = (Criteria) node;
        this.siblings.add(criteria);

        this.mostRecentSibling = node;
    }

    @Override
    public Crotch and(Node part) {
        add(part);
        return this;
    }

    @Override
    public Crotch or(Node part) {
        part.setOr(true);
        add(part);
        return this;
    }

    @Override
    public Crotch and(String field) {
        if (this.mostRecentSibling instanceof Crotch) {
            ((Crotch) mostRecentSibling).add(new Criteria(field));
        } else {
            and(new Criteria(field));
        }
        return this;
    }

    @Override
    public Crotch or(String field) {
        Criteria criteria = new Criteria(field);
        criteria.setOr(true);

        if (this.mostRecentSibling instanceof Crotch) {
            ((Crotch) mostRecentSibling).add(criteria);
        } else {
            or(new Criteria(field));
        }
        return this;
    }
}
