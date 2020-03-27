package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Data {

    @JsonProperty("package")
    private Package _package;
    private Resource resource;
    private Group group;
}
