package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.UUID;

@Data
public class Group {
    @SerializedName("display_name")
    private String displayName;
    private String description;
    @SerializedName("image_display_url")
    private String imageDisplayUrl;
    private String title;
    private UUID id;
    private String name;
}
