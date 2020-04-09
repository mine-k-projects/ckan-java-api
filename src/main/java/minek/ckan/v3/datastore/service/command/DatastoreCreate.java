package minek.ckan.v3.datastore.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.basic.service.command.create.ResourceCreate;
import minek.ckan.v3.datastore.model.Field;

import java.util.List;
import java.util.Map;

// https://github.com/ckan/ckan/blob/master/ckanext/datastore/logic/action.py#L29
// https://github.com/ckan/ckan/blob/96af71f310852621e4a33a453a8f3640d16b1a95/ckanext/datastore/backend/postgres.py#L1833
@Data
public class DatastoreCreate {
    private String resource_id;
    private boolean force = false;
    private ResourceCreate resource;
    private List<String> aliases;
    private List<Field> fields;
    private List<Map<String, Object>> records;
    @JsonProperty("primary_key")
    private List<String> primaryKey;
    private List<String> indexes;
    private List<Trigger> triggers;
    @JsonProperty("calculate_record_count")
    private boolean calculateRecordCount = false;

    @Data
    @AllArgsConstructor
    public static class Trigger {
        private String function;

        public static Trigger of(String function) {
            return new Trigger(function);
        }
    }
}
