package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PackageAutocomplete {
    @JsonProperty("match_field")
    private String matchField;
    @JsonProperty("match_displayed")
    private String matchDisplayed;
    private String name;
    private String title;
}
