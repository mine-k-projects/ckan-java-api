package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class HarvestObjectError {
    private UUID id;
    @JsonProperty("harvest_object_id")
    private UUID harvestObjectId;
    private String message;
    private String stage;
    private Integer line;
    private LocalDateTime created;
}
