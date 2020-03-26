package minek.ckan.v3.enums;

// https://github.com/ckan/ckan/blob/master/ckan/logic/validators.py#L279
public enum ActivityType {
    new_package,
    changed_package,
    deleted_package,
    follow_dataset,
    new_user,
    changed_user,
    follow_user,
    new_group,
    changed_group,
    deleted_group,
    new_organization,
    changed_organization,
    deleted_organization,
    follow_group
}
