package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.harvest.model.enums.HarvestJobStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class HarvestJob {
    private UUID id;
    private LocalDateTime created;
    @JsonProperty("gather_started")
    private LocalDateTime gatherStarted;
    @JsonProperty("gather_finished")
    private LocalDateTime gatherFinished;
    private String finished;
    @JsonProperty("source_id")
    private UUID sourceId;
    private HarvestJobStatus status;
    private Stats stats;
    @JsonProperty("object_error_summary")
    private List<HarvestObjectError> objectErrorSummary;
    @JsonProperty("gather_error_summary")
    private List<HarvestGatherError> gatherErrorSummary;

    @Data
    public static class Stats {
        private int deleted;
        private int updated;
        private int added;
        @JsonProperty("not modified")
        private int notModified;
        private int errored;
    }
}
