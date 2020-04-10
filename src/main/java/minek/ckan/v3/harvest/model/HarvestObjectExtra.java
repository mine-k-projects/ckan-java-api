package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class HarvestObjectExtra {
    private UUID id;
    @JsonProperty("harvest_object_id")
    private UUID harvestObjectId;
    private String key;
    private String value;
}
