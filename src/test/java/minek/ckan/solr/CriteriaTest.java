package minek.ckan.solr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CriteriaTest {

    private QueryParser parser = QueryParser.getInstance();

    @Test
    public void and_test() {
        Criteria criteria = new Criteria("field_1").startsWith("start").endsWith("end")
                .and("field_2").startsWith("2start").endsWith("2end");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:(start* *end) AND field_2:(2start* *2end)", query);
    }

    @Test
    public void or_test() {
        Criteria criteria = new Criteria("field_1").startsWith("start")
                .or("field_2").endsWith("end").startsWith("start2");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:start* OR field_2:(*end start2*)", query);
    }

    @Test
    public void nested_Or_with_and_test() {
        Criteria criteria = Criteria.where("field_1").is("foo")
                .and(Criteria.where("field_2").is("bar").or("field_3").is("roo"))
                .or(Criteria.where("field_4").is("spring").and("field_5").is("data"));
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:foo AND (field_2:bar OR field_3:roo) OR (field_4:spring AND field_5:data)", query);
    }

    @Test
    public void empty_test() {
        Criteria criteria = Criteria.where("test2");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test2:[* TO *]", query);
    }

    @Test
    public void is_test() {
        Criteria criteria = Criteria.where("test2").is("value");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test2:value", query);
    }

    @Test
    public void is_not_test() {
        Criteria criteria = Criteria.where("test").is("value").not();
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("-test:value", query);
    }

    @Test
    public void is_startsWith_test() {
        Criteria criteria = Criteria.where("test").is("value").startsWith("hahaha");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:(value hahaha*)", query);
    }

    @Test
    public void is_startsWith_endsWith_test() {
        Criteria criteria = Criteria.where("test").is("value").startsWith("hahaha").endsWith("zzz");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:(value hahaha* *zzz)", query);
    }

    @Test
    public void is_in_startsWith_endsWith_test() {
        Criteria criteria = Criteria.where("test").is("value").in("value1", "value2").startsWith("hahaha").endsWith("test");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:(value value1 value2 hahaha* *test)", query);
    }

    @Test
    public void is_contains_test() {
        Criteria criteria = Criteria.where("test").is("value").contains("con1", "con2");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:(value *con1* *con2*)", query);
    }

    @Test
    public void between_test() {
        Criteria criteria = Criteria.where("test").between("0", "10");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:[0 TO 10]", query);
    }

    @Test
    public void between_excludeLowerBound_test() {
        Criteria criteria = Criteria.where("test").between("0", "10", false, false);
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:{0 TO 10}", query);
    }

    @Test
    public void is_between_test() {
        Criteria criteria = Criteria.where("test").is("hahaha").between("0", "10");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:(hahaha [0 TO 10])", query);
    }

    @Test
    public void isNull_test() {
        Criteria criteria = Criteria.where("test").isNull();
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("-test:[* TO *]", query);
    }

    @Test
    public void isNotNull_test() {
        Criteria criteria = Criteria.where("test").isNotNull();
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:[* TO *]", query);
    }

    @Test
    public void isNull_isNotNull_test() {
        Criteria criteria = Criteria.where("test").isNull().isNotNull();
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("-test:([* TO *] [* TO *])", query);
    }

    @Test
    public void greaterThan_test() {
        Criteria criteria = Criteria.where("test").greaterThan("1");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:{1 TO *]", query);
    }

    @Test
    public void greaterThanEqual_test() {
        Criteria criteria = Criteria.where("test").greaterThanEqual("1");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:[1 TO *]", query);
    }

    @Test
    public void lessThan_test() {
        Criteria criteria = Criteria.where("test").lessThan("1");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:[* TO 1}", query);
    }

    @Test
    public void lessThanEqual_test() {
        Criteria criteria = Criteria.where("test").lessThanEqual("1");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test:[* TO 1]", query);
    }

    @Test
    public void white_space_test() {
        Criteria criteria = Criteria.where("test1").is("white space");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test1:\"white space\"", query);
    }

    @Test
    public void is_white_space_test() {
        Criteria criteria = Criteria.where("test1").is("value").is("white space");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test1:(value \"white space\")", query);
    }

    @Test
    public void double_quotes_test() {
        Criteria criteria = Criteria.where("test1").is("with \"quote");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("test1:\"with \\\"quote\"", query);
    }

    @Test
    public void and_keyword_test() {
        Criteria criteria = new Criteria("field_1").is("AND");
        String query = parser.createQueryStringFromNode(criteria);

        assertEquals("field_1:\"AND\"", query);
    }

    @Test
    public void containing_and_keyword_test() {
        Criteria criteria = new Criteria("field_1").is("this AND that");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:\"this AND that\"", query);
    }

    @Test
    public void or_keyword_test() {
        Criteria criteria = new Criteria("field_1").is("OR");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:\"OR\"", query);
    }

    @Test
    public void not_keyword_test() {
        Criteria criteria = new Criteria("field_1").is("NOT");
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:\"NOT\"", query);
    }

    @Test
    public void between_negative_number_test() {
        Criteria criteria = new Criteria("field_1").between(-200, -100);
        String query = parser.createQueryStringFromNode(criteria);
        assertEquals("field_1:[\\-200 TO \\-100]", query);
    }

}