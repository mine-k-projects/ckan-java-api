package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import minek.ckan.v3.enums.ActivityType;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@lombok.Data
public class PackageActivity {
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
        @SerializedName("package")
        private Package _package;
    }

    @lombok.Data
    public static class Package {
        private String maintainer;
        private String name;
        @SerializedName("metadata_modified")
        private LocalDateTime metadataModified;
        private String author;
        private String url;
        private String notes;
        @SerializedName("owner_org")
        private UUID ownerOrg;
        @SerializedName("private")
        private boolean _private;
        @SerializedName("maintainer_email")
        private String maintainerEmail;
        @SerializedName("author_email")
        private String authorEmail;
        private State state;
        private String version;
        @SerializedName("creator_user_id")
        private UUID creatorUserId;
        private UUID id;
        private String title;
        @SerializedName("revision_id")
        private UUID revisionId;
        private String type;
        @SerializedName("license_id")
        private String licenseId;
        @SerializedName("metadata_created")
        private LocalDateTime metadataCreated;
    }

}
