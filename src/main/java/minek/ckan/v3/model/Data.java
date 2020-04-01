package minek.ckan.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Data {

    @JsonProperty("package")
    private Package package_;
    private Resource resource;
    private Group group;
}
