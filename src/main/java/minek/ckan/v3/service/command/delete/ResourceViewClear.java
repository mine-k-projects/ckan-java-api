package minek.ckan.v3.service.command.delete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.enums.ResourceViewType;

import java.util.List;

@Data
@AllArgsConstructor
public class ResourceViewClear {
    @JsonProperty("view_types")
    private List<ResourceViewType> viewTypes;

    public static ResourceViewClear of(List<ResourceViewType> viewTypes) {
        return new ResourceViewClear(viewTypes);
    }
}
