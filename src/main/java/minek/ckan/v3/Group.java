package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Group {
    private List<User> users;
    @SerializedName("display_name")
    private String displayName;
    private String description;
    @SerializedName("image_display_url")
    private String imageDisplayUrl;
    @SerializedName("package_count")
    private int packageCount;
    private LocalDateTime created;
    private String name;
    @SerializedName("is_organization")
    private boolean isOrganization;
    private State state;
    private List<Extra> extras;
    @SerializedName("image_url")
    private String imageUrl;
    private List<String> groups;
    private String type;
    private String title;
    @SerializedName("revision_id")
    private UUID revisionId;
    @SerializedName("num_followers")
    private int numFollowers;
    private UUID id;
    private List<Tag> tags;
    @SerializedName("approval_status")
    private ApprovalStatus approvalStatus;
}
