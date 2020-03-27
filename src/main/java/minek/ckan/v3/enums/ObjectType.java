package minek.ckan.v3.enums;

import lombok.Getter;

public enum ObjectType implements EnumCode {
    user("user"),
    package_("package");

    @Getter
    private String code;

    ObjectType(String code) {
        this.code = code;
    }
}