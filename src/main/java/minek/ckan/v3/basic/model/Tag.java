package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.model.enums.State;

import java.util.List;
import java.util.UUID;

@Data
public class Tag {
    @JsonProperty("vocabulary_id")
    private UUID vocabularyId;
    private State state;
    @JsonProperty("display_name")
    private String displayName;
    private UUID id;
    private String name;
    private List<Package> packages;
}
