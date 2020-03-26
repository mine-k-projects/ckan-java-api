package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

public class ActivityDetail {

    @SerializedName("activity_id")
    private UUID activityId;
    @SerializedName("object_type")
    private String objectType;
    @SerializedName("object_id")
    private String objectId;
    private Data data;
    private UUID id;
    @SerializedName("activity_type")
    private String activityType;

    @lombok.Data
    public static class Data {
        private Resource resource;
        @SerializedName("package")
        private Package _package;
    }

    @lombok.Data
    public static class Resource {
        private String mimetype;
        @SerializedName("cache_url")
        private String cacheUrl;
        @SerializedName("mimetype_inner")
        private String mimetypeInner;
        private String hash;
        private String description;
        private String format;
        private String url;
        private LocalDateTime created;
        @SerializedName("package_id")
        private UUID packageId;
        private String name;
        @SerializedName("cache_last_updated")
        private String cacheLastUpdated;
        private State state;
        private Extras extra;
        @SerializedName("last_modified")
        private String lastModified;
        private int position;
        @SerializedName("revision_id")
        private UUID revisionId;
        @SerializedName("url_type")
        private String urlType;
        private UUID id;
        @SerializedName("resource_type")
        private String resourceType;
        private Integer size;

        @lombok.Data
        public static class Extras {
            @SerializedName("datastore_active")
            private boolean datastoreActive;
        }
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
