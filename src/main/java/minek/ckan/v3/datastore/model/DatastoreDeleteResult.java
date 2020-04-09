package minek.ckan.v3.datastore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class DatastoreDeleteResult {
    @JsonProperty("resource_id")
    private UUID resourceId;
    private Map<String, Object> filters;
}
