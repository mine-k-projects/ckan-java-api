package minek.ckan.solr;

import java.util.Collection;
import java.util.Collections;

public abstract class Node {

    private Node parent;
    private boolean isOr = false;
    private boolean negating = false;

    protected Node() {
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isOr() {
        return isOr;
    }

    public void setOr(boolean or) {
        isOr = or;
    }

    public boolean isNegating() {
        return negating;
    }

    public void setNegating(boolean negating) {
        this.negating = negating;
    }

    public boolean hasSiblings() {
        return !getSiblings().isEmpty();
    }

    public Collection<Criteria> getSiblings() {
        return Collections.emptyList();
    }

    // conjunctions

    public abstract <T extends Node> T and(Node node);

    public abstract <T extends Node> T and(String field);

    public abstract <T extends Node> T or(Node node);

    public abstract <T extends Node> T or(String field);

    // commands

    public abstract Node is(Object value);

    public abstract Node is(Object... values);

    public abstract Node is(Iterable<?> values);

    public abstract Node isNull();

    public abstract Node isNotNull();

    public abstract Node contains(String value);

    public abstract Node contains(String... values);

    public abstract Node contains(Iterable<String> values);

    public abstract Node startsWith(String prefix);

    public abstract Node startsWith(String... values);

    public abstract Node startsWith(Iterable<String> values);

    public abstract Node endsWith(String postfix);

    public abstract Node endsWith(String... values);

    public abstract Node endsWith(Iterable<String> values);

    public abstract Node not();

//    public abstract Node fuzzy(String value);

//    public abstract Node fuzzy(String values, float distance);

//    public abstract Node sloppy(String phrase, int distance);

    public abstract Node expression(String expression);

//    public abstract Node boost(float value);

    public abstract Node between(Object lowerBound, Object upperBound);

    public abstract Node between(Object lowerBound, Object upperBound, boolean includeLowerBound, boolean includeUpperBound);

    public abstract Node lessThan(Object upperBound);

    public abstract Node lessThanEqual(Object upperBound);

    public abstract Node greaterThan(Object lowerBound);

    public abstract Node greaterThanEqual(Object lowerBound);

    public abstract Node in(Object... values);

    public abstract Node in(Iterable<?> values);

//    public abstract Node within(Point location, Distance distance);
//
//    public abstract Node near(Box box);
//
//    public abstract Node near(Point location, Distance distance);

}
