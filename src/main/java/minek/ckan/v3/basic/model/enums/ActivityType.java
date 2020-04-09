package minek.ckan.v3.basic.model.enums;

import lombok.Getter;

// https://github.com/ckan/ckan/blob/master/ckan/logic/validators.py#L279
public enum ActivityType implements EnumCode {
    new_package("new package"),
    changed_package("changed package"),
    deleted_package("deleted package"),
    follow_dataset("follow dataset"),
    new_user("new user"),
    changed_user("changed user"),
    follow_user("follow user"),
    new_group("new group"),
    changed_group("changed group"),
    deleted_group("deleted group"),
    new_organization("new organization"),
    changed_organization("changed organization"),
    deleted_organization("deleted organization"),
    follow_group("follow group"),
    new_("new"),
    changed("changed"),
    deleted("deleted"),
    follow("follow");

    @Getter
    private String code;

    ActivityType(String code) {
        this.code = code;
    }
}
