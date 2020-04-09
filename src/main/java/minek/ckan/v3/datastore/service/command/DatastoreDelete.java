package minek.ckan.v3.datastore.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class DatastoreDelete {
    @JsonProperty("resource_id")
    private UUID resourceId;
    private boolean force = false;
    private Map<String, Object> filters;
}
