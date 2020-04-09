package minek.ckan.v3.datastore.service.command;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DatastoreSearchSql {
    private List<String> columns;
    private String table;
    private String condition;

    public List<String> getColumns() {
        if (columns == null) {
            return new ArrayList<>();
        }
        return columns;
    }

    public String query() {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        if (getColumns().isEmpty()) {
            query.append("*");
        } else {
            query.append(String.join(", ", getColumns()));
        }
        query.append(" from ");
        query.append(table);
        String whereCause = condition != null ? condition.trim() : "";
        if (whereCause.length() > 0) {
            query.append(" where ");
            query.append(whereCause);
        }
        return query.toString();
    }
}
