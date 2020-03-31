package minek.ckan.v3.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.PackageRelationship;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PackageRelationshipDelete {
    private String subject;
    private String object;
    private PackageRelationship type;

    public static PackageRelationshipDelete of(String subject, String object, PackageRelationship type) {
        return new PackageRelationshipDelete(subject, object, type);
    }

    public static PackageRelationshipDelete of(UUID subject, String object, PackageRelationship type) {
        return new PackageRelationshipDelete(subject.toString(), object, type);
    }

    public static PackageRelationshipDelete of(String subject, UUID object, PackageRelationship type) {
        return new PackageRelationshipDelete(subject, object.toString(), type);
    }

    public static PackageRelationshipDelete of(UUID subject, UUID object, PackageRelationship type) {
        return new PackageRelationshipDelete(subject.toString(), object.toString(), type);
    }
}
