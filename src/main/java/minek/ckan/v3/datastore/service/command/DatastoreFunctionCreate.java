package minek.ckan.v3.datastore.service.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class DatastoreFunctionCreate {
    private String name;
    @JsonProperty("or_replace")
    private boolean orReplace = false;
    @Setter(AccessLevel.PRIVATE)
    private String rettype = "trigger";
    private String definition;
}
