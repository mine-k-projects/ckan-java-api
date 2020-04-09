package minek.ckan.v3.datastore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import minek.ckan.v3.datastore.model.enums.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    private String id;
    private FieldType type;
    private Info info;

    @Data
    public static class Info {
        private String label;
        private String notes;
        private String example;
    }

    public static Field of(String id) {
        return new Field(id, FieldType.text, null);
    }

    public static Field of(String id, FieldType type) {
        return new Field(id, type, null);
    }
}