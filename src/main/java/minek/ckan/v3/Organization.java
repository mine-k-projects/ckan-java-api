package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Organization {
    private String description;
    private LocalDateTime created;
    private String title;
    private String name;
    @SerializedName("is_organization")
    private boolean isOrganization;
    private State state;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("revision_id")
    private UUID revisionId;
    private String type;
    private UUID id;
    @SerializedName("approval_status")
    private ApprovalStatus approvalStatus;
}
