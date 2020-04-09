package minek.ckan.v3.basic.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static minek.ckan.v3.basic.model.enums.Role.Permission.*;

// https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/authz.py#L227
@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public enum Role {
    admin(Arrays.asList(Permission.admin)),
    editor(Arrays.asList(read, delete_dataset, create_dataset, update_dataset, manage_group)),
    member(Arrays.asList(read, manage_group));

    @Getter
    private final List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public enum Permission {
        admin, read, delete_dataset, create_dataset, update_dataset, manage_group
    }
}