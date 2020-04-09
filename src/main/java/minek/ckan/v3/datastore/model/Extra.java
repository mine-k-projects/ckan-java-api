package minek.ckan.v3.datastore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Extra {
    @JsonProperty("calculate_record_count")
    private boolean calculateRecordCount;
    @JsonProperty("dry_run")
    private boolean dryRun;
}