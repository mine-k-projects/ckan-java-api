package minek.ckan.v3.basic.service.command.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.solr.Criteria;
import minek.ckan.solr.QueryParser;
import minek.ckan.v3.basic.service.command.get.sort.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://lucene.apache.org/solr/guide/6_6/common-query-parameters.html
// https://github.com/ckan/ckan/blob/64774670b722ed1bd3808901137fa80753d3c772/ckan/lib/search/query.py#L293
@Data
public class PackageSearchQuery {

    @JsonProperty("q")
    private String solrQuery = "*:*";
    @JsonProperty("fq")
    private String filterQuery;
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
    private List<String> facetField;
    @JsonProperty("include_drafts")
    private Boolean includeDrafts;
    @JsonProperty("include_private")
    private Boolean includePrivate;
    @JsonProperty("use_default_schema")
    private Boolean useDefaultSchema;

    public void setSolrQuery(String solrQuery) {
        this.solrQuery = solrQuery;
    }

    public void setSolrQuery(Criteria criteria) {
        this.solrQuery = QueryParser.getInstance().createQuery(criteria);
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }

    public void setFilterQuery(Criteria criteria) {
        this.filterQuery = QueryParser.getInstance().createQuery(criteria);
    }

    public void setSort(Sort... sorts) {
        this.sort = Arrays.stream(sorts)
                .map(s -> s.getField() + "_" + s.getDirection())
                .collect(Collectors.joining(","));
    }
}
