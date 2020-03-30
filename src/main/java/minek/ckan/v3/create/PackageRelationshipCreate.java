package minek.ckan.v3.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minek.ckan.v3.enums.PackageRelationshipType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageRelationshipCreate {
    private String subject;
    private String object;
    private PackageRelationshipType type;
    private String comment;
}
