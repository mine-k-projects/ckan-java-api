package minek.ckan.v3.datastore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.datastore.model.enums.RecordsFormat;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class DatastoreSearchResult {
    @JsonProperty("include_total")
    private boolean includeTotal;
    @JsonProperty("resource_id")
    private UUID resourceId;
    private boolean distinct;
    private boolean plain;
    @JsonProperty("records_format")
    private RecordsFormat recordsFormat;
    private Records records;
    private List<Field> fields;
    @JsonProperty("_links")
    private Link links;
    private Integer total;

    public interface Records {
    }

    @Data
    @AllArgsConstructor
    public static class ListRecords implements Records {
        private List<List<Object>> records;
    }

    @Data
    @AllArgsConstructor
    public static class ObjectRecords implements Records {
        private List<Map<String, Object>> records;
    }

    @Data
    @AllArgsConstructor
    public static class CsvRecords implements Records {
        private String csv;
    }

    @Data
    @AllArgsConstructor
    public static class TsvRecords implements Records {
        private String tsv;
    }

    @Data
    public static class Link {
        private String start;
        private String next;
    }
}
