package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Resource {
    private String mimetype;
    @JsonProperty("cache_url")
    private String cacheUrl;
    private String hash;
    private String description;
    private String name;
    private String format;
    private String url;
    @JsonProperty("datastore_active")
    private boolean datastoreActive;
    @JsonProperty("cache_last_updated")
    private String cacheLastUpdated;
    @JsonProperty("package_id")
    private UUID packageId;
    private LocalDateTime created;
    private State state;
    @JsonProperty("mimetype_inner")
    private String mimetypeInner;
    @JsonProperty("last_modified")
    private String lastModified;
    private int position;
    @JsonProperty("revision_id")
    private UUID revisionId;
    @JsonProperty("url_type")
    private String urlType;
    private UUID id;
    @JsonProperty("resource_type")
    private String resourceType;
    private Integer size;
    private Extra extras;
    @JsonProperty("tracking_summary")
    private TrackingSummary trackingSummary;
}
