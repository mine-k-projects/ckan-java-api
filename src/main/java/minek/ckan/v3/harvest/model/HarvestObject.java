package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class HarvestObject {
    private UUID id;
    private String guid;
    private boolean current;
    private LocalDateTime gathered;
    @JsonProperty("fetch_started")
    private LocalDateTime fetchStarted;
    private String content;
    @JsonProperty("fetch_finished")
    private LocalDateTime fetchFinished;
    @JsonProperty("import_started")
    private LocalDateTime importStarted;
    @JsonProperty("import_finished")
    private LocalDateTime importFinished;
    private String state;
    @JsonProperty("metadata_modified_date")
    private LocalDateTime metadataModifiedDate;
    @JsonProperty("retry_times")
    private int retryTimes;
    @JsonProperty("harvest_job_id")
    private UUID harvestJobId;
    @JsonProperty("harvest_source_id")
    private UUID harvestSourceId;
    @JsonProperty("package_id")
    private UUID packageId;
    private String report_status;
}
