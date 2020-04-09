package minek.ckan.v3.datastore.model;

import lombok.Data;
import minek.ckan.v3.datastore.model.enums.FieldType;

import java.util.Map;

@Data
public class DatastoreInfo {
    private Meta meta;
    private Map<String, FieldType> schema;

    @Data
    public static class Meta {
        private int count;
    }
}
