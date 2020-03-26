package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import minek.ckan.v3.enums.ActivityType;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@lombok.Data
public class GroupActivity {
    @SerializedName("user_id")
    private UUID userId;
    private LocalDateTime timestamp;
    @SerializedName("object_id")
    private UUID objectId;
    @SerializedName("revision_id")
    private UUID revisionId;
    private Data data;
    private UUID id;
    @SerializedName("activity_type")
    private ActivityType activityType;

    @lombok.Data
    public static class Data {
        private Group group;
    }

    @lombok.Data
    public static class Group {
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

}
