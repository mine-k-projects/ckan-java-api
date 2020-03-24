package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Resource {
    private String mimetype;
    private String cache_url;
    private String hash;
    private String description;
    private String name;
    private String format;
    private String url;
    @SerializedName("datastore_active")
    private boolean datastoreActive;
    @SerializedName("cache_last_updated")
    private String cacheLastUpdated;
    @SerializedName("package_id")
    private UUID packageId;
    private LocalDateTime created;
    private State state;
    @SerializedName("mimetype_inner")
    private String mimetypeInner;
    @SerializedName("last_modified")
    private String lastModified;
    private int position;
    @SerializedName("revision_id")
    private UUID revisionId;
    @SerializedName("url_type")
    private String urlType;
    private UUID id;
    @SerializedName("resourceType")
    private String resource_type;
    private Integer size;
}
