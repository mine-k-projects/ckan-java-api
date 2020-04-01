package minek.ckan.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.model.enums.ResourceViewType;

import java.util.UUID;

@Data
public class ResourceView {
    private String description;
    private String title;
    @JsonProperty("resource_id")
    private UUID resourceId;
    @JsonProperty("view_type")
    private ResourceViewType viewType;
    private UUID id;
    @JsonProperty("package_id")
    private UUID packageId;
}
