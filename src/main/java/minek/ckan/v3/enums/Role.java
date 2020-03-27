package minek.ckan.v3.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

// https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/authz.py#L227
@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public enum Role {
    admin(Arrays.asList(Permission.admin)),
    editor(Arrays.asList(Permission.read, Permission.delete_dataset, Permission.create_dataset, Permission.update_dataset, Permission.manage_group)),
    member(Arrays.asList(Permission.read, Permission.manage_group));

    @Getter
    private final List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public enum Permission {
        admin, read, delete_dataset, create_dataset, update_dataset, manage_group
    }
}