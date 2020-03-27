package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ResourceSearch {
    private int count;
    private List<Resource> results;

    @Data
    public static class Resource {
        private String mimetype;
        @SerializedName("cache_url")
        private String cacheUrl;
        private State state;
        private String hash;
        private String description;
        private String format;
        private String url;
        @SerializedName("datastore_active")
        private boolean datastoreActive;
        private LocalDateTime created;
        @SerializedName("cache_last_updated")
        private String cacheLastUpdated;
        @SerializedName("package_id")
        private UUID packageId;
        @SerializedName("mimetype_inner")
        private String mimetypeInner;
        @SerializedName("last_modified")
        private String lastModified;
        private int position;
        @SerializedName("revision_id")
        private UUID revisionId;
        private Integer size;
        @SerializedName("url_type")
        private String urlType;
        private UUID id;
        @SerializedName("resource_type")
        private String resourceType;
        private String name;
    }
}
