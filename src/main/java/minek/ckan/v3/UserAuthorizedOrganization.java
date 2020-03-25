package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserAuthorizedOrganization {
    @SerializedName("image_display_url")
    private String imageDisplayUrl;
    private Capacity capacity;
    private String description;
    private String title;
    @SerializedName("package_count")
    private Integer packageCount;
    private LocalDateTime created;
    @SerializedName("approval_status")
    private ApprovalStatus approvalStatus;
    @SerializedName("is_organization")
    private boolean isOrganization;
    private State state;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("revision_id")
    private UUID revisionId;
    private String type;
    private UUID id;
    private String name;
}