package minek.ckan.v3.datastore.model.enums;

import lombok.Getter;
import minek.ckan.v3.basic.model.enums.EnumCode;

public enum FieldType implements EnumCode {
    text("text"),
    json("json"),
    date("date"),
    time("time"),
    timestamp("timestamp"),
    int_("int"),
    float_("float"),
    bool("bool"),
    number("number"),
    int4("int4"),
    tsvector("tsvector");

    @Getter
    private String code;

    FieldType(String code) {
        this.code = code;
    }
}
