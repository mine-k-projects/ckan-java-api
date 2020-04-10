package minek.ckan.v3.harvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HarvesterInfo {
    private String name;
    private String description;
    private String title;
    @JsonProperty("show_config")
    private boolean showConfig;
    @JsonProperty("form_config_interface")
    private String formConfigInterface;
}
