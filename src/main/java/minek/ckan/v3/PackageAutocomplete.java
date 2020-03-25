package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PackageAutocomplete {
    @SerializedName("match_field")
    private String matchField;
    @SerializedName("match_displayed")
    private String matchDisplayed;
    private String name;
    private String title;
}
