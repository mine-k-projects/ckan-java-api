package minek.ckan.v3.datastore.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DatastoreSearchSqlResult {
    private List<Map<String, Object>> records;
    private List<Field> fields;
    private String sql;
}
