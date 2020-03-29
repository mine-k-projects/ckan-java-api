package minek.ckan.v3;

import lombok.Data;
import minek.ckan.v3.enums.PackageRelationshipType;

/**
 * @see <a href="https://github.com/ckan/ckan/blob/master/ckan/model/package_relationship.py#L67">package_relationship dictionary</a>
 */
@Data
public class PackageRelationship {
    private String subject;
    private PackageRelationshipType type;
    private String object;
    private String comment;
}
