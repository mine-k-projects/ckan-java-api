package minek.ckan.v3.model.enums;

// https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/model/package_relationship.py#L33
public enum PackageRelationshipType {
    depends_on, dependency_of, derives_from, has_derivation, links_to, linked_from, child_of, parent_of
}