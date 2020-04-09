package minek.ckan.v3.basic.service.command.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import minek.ckan.v3.basic.model.PackageRelationship;
import minek.ckan.v3.basic.model.enums.State;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PackageCreate {
    @NonNull
    private String name;
    @NonNull
    private String title;
    @NonNull
    @JsonProperty("private")
    private boolean private_;
    private String author;
    @JsonProperty("author_email")
    private String authorEmail;
    private String maintainer;
    @JsonProperty("maintainer_email")
    private String maintainerEmail;
    @JsonProperty("license_id")
    private String licenseId;
    private String notes;
    private String url;
    private String version;
    private State state;
    private String type;
    private List<ResourceCreate> resources;
    private List<TagCreate> tags;
    private List<Extra> extras;
    @JsonProperty("relationships_as_object")
    private List<PackageRelationship> relationshipsAsObject;
    @JsonProperty("relationships_as_subject")
    private List<PackageRelationship> relationshipsAsSubject;
    private List<Group> groups;
    @JsonProperty("owner_org")
    private UUID ownerOrg;

    public void addResource(ResourceCreate resource) {
        if (resources == null) {
            resources = new ArrayList<>();
        }
        resources.add(resource);
    }

    public void addExtra(String key, String value) {
        if (extras == null) {
            extras = new ArrayList<>();
        }
        extras.add(Extra.of(key, value));
    }

    @Data
    @AllArgsConstructor
    public static class Extra {
        private String key;
        private String value;

        public static Extra of(String key, String value) {
            return new Extra(key, value);
        }
    }

    public void addGroup(UUID id) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        getGroups().add(Group.of(id));
    }

    @Data
    @AllArgsConstructor
    public static class Group {
        private UUID id;

        public static Group of(UUID id) {
            return new Group(id);
        }
    }

    public static PackageCreateBuilder builder(String name, String title, boolean private_) {
        return new PackageCreateBuilder().name(name).title(title).private_(private_);
    }
}
