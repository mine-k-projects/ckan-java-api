package minek.ckan.v3.service.command.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResourceSearchQuery {
    @JsonProperty("query")
    private String query;
    @JsonProperty("fields")
    @Deprecated
    private String fields;
    @JsonProperty("order_by")
    private String orderBy;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("limit")
    private Integer limit;

    public void setQuery(ResourceColumn column, String value) {
        this.query = column + ":" + value;
    }

    // https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/model/resource.py#L25
    // https://github.com/ckan/ckan/blob/fcb38ba903b2c2b51b8620bd24571b284a86a2d6/ckan/model/resource.py#L118
    public enum ResourceColumn {
        url,
        format,
        description,
        hash,
        name,
        resource_type,
        mimetype,
        mimetype_inner,
        size,
        created,
        last_modified,
        metadata_modified,
        cache_url,
        cache_last_updated,
        url_type
    }
}
