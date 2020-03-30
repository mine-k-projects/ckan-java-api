package minek.ckan.v3.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResourceCreate {
    @JsonProperty("package_id")
    private UUID packageId;
    private String url;
    @JsonProperty("revision_id")
    private UUID revisionId;
    private String description;
    private String format;
    private String hash;
    private String name;
    @JsonProperty("resource_type")
    private String resourceType;
    private String mimetype;
    @JsonProperty("mimetype_inner")
    private String mimetypeInner;
    @JsonProperty("cache_url")
    private String cacheUrl;
    private Integer size;
    private String created;
    @JsonProperty("last_modified")
    private String lastModified;
    @JsonProperty("cache_last_updated")
    private String cacheLastUpdated;
}
