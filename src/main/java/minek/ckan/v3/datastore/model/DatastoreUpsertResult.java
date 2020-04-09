package minek.ckan.v3.datastore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.datastore.model.enums.Method;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class DatastoreUpsertResult {
    private List<Map<String, Object>> records;
    private Method method;
    @JsonProperty("resource_id")
    private UUID resourceId;
    @JsonProperty("__extras")
    private Extra extra;
}
