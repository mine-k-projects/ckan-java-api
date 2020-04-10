package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HarvestSourceShowStatus {
    @JsonProperty("job_count")
    private int jobCount;
    @JsonProperty("total_datasets")
    private int totalDatasets;
    @JsonProperty("last_job")
    private HarvestJob lastJob;
}
