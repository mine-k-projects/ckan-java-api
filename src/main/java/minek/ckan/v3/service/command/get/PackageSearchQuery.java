package minek.ckan.v3.service.command.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.service.command.get.sort.Sort;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
public class PackageSearchQuery {

    @JsonProperty("q")
    private String q;
    @JsonProperty("fq")
    private String fq;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("rows")
    private Integer rows;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("facet")
    private Boolean facet;
    @JsonProperty("facet.mincount")
    private Integer facetMincount;
    @JsonProperty("facet.limit")
    private Integer facetLimit;
    @JsonProperty("facet.field")
    private String facetField;
    @JsonProperty("include_drafts")
    private Boolean includeDrafts;
    @JsonProperty("include_private")
    private Boolean includePrivate;
    @JsonProperty("use_default_schema")
    private Boolean useDefaultSchema;

    public void setSort(Sort... sorts) {
        this.sort = Arrays.stream(sorts)
                .map(s -> s.getField() + "_" + s.getDirection())
                .collect(Collectors.joining(","));
    }

    public void setFacetField(String... facetFields) {
        this.facetField = Arrays.stream(facetFields)
                .map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(",", "[", "]"));
    }

}
