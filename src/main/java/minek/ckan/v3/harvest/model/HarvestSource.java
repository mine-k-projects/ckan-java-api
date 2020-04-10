package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.harvest.model.enums.HarvestFrequency;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class HarvestSource {
    private UUID id;
    private String url;
    private String title;
    private String description;
    private String config;
    private LocalDateTime created;
    private String type;
    private boolean active;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("publisher_id")
    private String publisherId;
    private HarvestFrequency frequency;
    @JsonProperty("next_run")
    private String nextRun;
    @JsonProperty("publisher_title")
    private String publisherTitle;
    private Status status;
    @JsonProperty("last_job_status")
    private HarvestJob lastJobStatus;

    public static class Status {
        @JsonProperty("job_count")
        private int jobCount;
        @JsonProperty("last_harvest_request")
        private String lastHarvestRequest;
        @JsonProperty("next_harvest")
        private String nextHarvest;
    }

}