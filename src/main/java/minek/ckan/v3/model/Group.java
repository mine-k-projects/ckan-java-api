package minek.ckan.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.model.enums.ApprovalStatus;
import minek.ckan.v3.model.enums.Capacity;
import minek.ckan.v3.model.enums.GroupType;
import minek.ckan.v3.model.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Group {
    @JsonProperty("image_display_url")
    private String imageDisplayUrl;
    private Capacity capacity;
    private String description;
    private String title;
    private LocalDateTime created;
    @JsonProperty("approval_status")
    private ApprovalStatus approvalStatus;
    @JsonProperty("is_organization")
    private boolean isOrganization;
    private State state;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("revision_id")
    private UUID revisionId;
    private GroupType type;
    private UUID id;
    private String name;
    @JsonProperty("num_followers")
    private Integer numFollowers;
    @JsonProperty("package_count")
    private int packageCount;
    private List<Extra> extras;
    private List<Group> groups;
    private List<Tag> tags;
    private List<User> users;
    private List<Package> packages;
}
