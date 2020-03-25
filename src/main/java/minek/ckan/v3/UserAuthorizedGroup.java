package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserAuthorizedGroup {
    @SerializedName("image_display_url")
    private String imageDisplayUrl;
    @SerializedName("display_name")
    private String displayName;
    private String description;
    private String title;
    @SerializedName("package_count")
    private int packageCount;
    private LocalDateTime created;
    @SerializedName("approval_status")
    private ApprovalStatus approvalStatus;
    @SerializedName("is_organization")
    private boolean isOrganization;
    private State state;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("revision_id")
    private UUID revisionId;
    private String type;
    private UUID id;
    private String name;
}