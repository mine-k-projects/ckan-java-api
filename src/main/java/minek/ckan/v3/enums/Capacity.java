package minek.ckan.v3.enums;

import lombok.Getter;

public enum Capacity {
    member("member"),
    editor("editor"),
    admin("admin"),
    public_("public"),
    private_("private");

    @Getter
    private String code;

    Capacity(String code) {
        this.code = code;
    }
}
