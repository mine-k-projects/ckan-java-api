package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class GroupDetail extends Group {
    private LocalDateTime created;
    @SerializedName("is_organization")
    private boolean isOrganization;
    private State state;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("revision_id")
    private UUID revisionId;
    private String type;
    @SerializedName("approval_status")
    private ApprovalStatus approvalStatus;
    @SerializedName("num_followers")
    private int numFollowers;
    @SerializedName("package_count")
    private int packageCount;
    private List<Extra> extras;
    private List<String> groups;
    private List<Tag> tags;
    private List<User> users;
    private List<Package> packages;
}
