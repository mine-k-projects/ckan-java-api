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
    private Map<String, SearchFacet> searchFacets;

    @Data
    public static class SearchFacet {
        private String title;
        private List<Item> items;

        @Data
        public static class Item {
            private String name;
            @JsonProperty("display_name")
            private String displayName;
            private int count;
        }
    }
}
