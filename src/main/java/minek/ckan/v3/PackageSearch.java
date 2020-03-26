package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PackageSearch {
    private int count;
    private String sort;
    private Map<String, Object> facets;
    private List<Package> results;
    @SerializedName("search_facets")
    private Map<String, Object> searchFacets;
}
