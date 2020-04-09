package minek.ckan.v3.datastore.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.datastore.model.enums.Method;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class DatastoreUpsert {
    @JsonProperty("resource_id")
    private UUID resourceId;
    private boolean force = false;
    private List<Map<String, Object>> records;
    private Method method = Method.upsert;
    @JsonProperty("calculate_record_count")
    private boolean calculateRecordCount = false;
    @JsonProperty("dry_run")
    private boolean dryRun = false;
}
