package minek.ckan.v3.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minek.ckan.v3.enums.ResourceViewType;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceViewCreate {
    @JsonProperty("resource_id")
    private UUID resourceId;
    private String title;
    private String description;
    @JsonProperty("view_type")
    private ResourceViewType viewType;
    private String config;

    public void setConfig(JsonNode config) {
        this.config = config.toString();
    }
}
