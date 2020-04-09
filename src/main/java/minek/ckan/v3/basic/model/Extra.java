package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.model.enums.State;

import java.util.UUID;

@Data
public class Extra {
    private State state;
    private String value;
    @JsonProperty("package_id")
    private UUID packageId;
    private String key;
    @JsonProperty("revision_id")
    private UUID revisionId;
    private UUID id;
    @JsonProperty("datastore_active")
    private Boolean datastoreActive;
}
