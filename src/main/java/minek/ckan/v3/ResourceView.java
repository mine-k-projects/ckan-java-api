package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.ViewType;

import java.util.UUID;

@Data
public class ResourceView {
    private String description;
    private String title;
    @SerializedName("resource_id")
    private UUID resourceId;
    @SerializedName("view_type")
    private ViewType viewType;
    private UUID id;
    @SerializedName("package_id")
    private UUID packageId;
}
