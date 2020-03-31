package minek.ckan.v3.enums;

import lombok.Getter;

// https://github.com/ckan/ckan/blob/ef103f02292e0b50fbe7edc6a9e07f70d2fb9f45/ckan/model/group.py#L61
public enum Capacity implements EnumCode {
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
