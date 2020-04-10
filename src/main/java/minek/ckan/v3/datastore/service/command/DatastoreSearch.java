package minek.ckan.v3.datastore.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import minek.ckan.v3.datastore.model.enums.RecordsFormat;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class DatastoreSearch {
    @JsonProperty("resource_id")
    private UUID resourceId;
    private Map<String, Object> filters;
    private String q;
    private boolean distinct = false;
    private boolean plain = true;
    private String language;
    private Integer limit;
    private Integer offset;
    private List<String> fields;
    private String sort;
    @JsonProperty("include_total")
    private boolean includeTotal = true;
    @JsonProperty("records_format")
    private RecordsFormat recordsFormat;
}
