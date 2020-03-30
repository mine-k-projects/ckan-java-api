package minek.ckan.v3.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceViewCreate {
    @JsonProperty("resource_id")
    private String resourceId;
    private String title;
    private String description;
    @JsonProperty("view_type")
    private String viewType;
    private Map<String, Object> config;
}
