package minek.ckan.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PackageSearch {
    private int count;
    private String sort;
    private Map<String, Object> facets;
    private List<Package> results;
    @JsonProperty("search_facets")
    private Map<String, Object> searchFacets;
}
