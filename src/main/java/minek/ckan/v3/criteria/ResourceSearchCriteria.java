package minek.ckan.v3.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ResourceSearchCriteria {
    private ResourceColumn field;
    private String value;

    public String query() {
        return field + ":" + value;
    }

    public static ResourceSearchCriteria of(@NonNull String query) {
        String[] split = query.split(":");
        return new ResourceSearchCriteria(ResourceColumn.valueOf(split[0]), split[1]);
    }

    public static ResourceSearchCriteria of(@NonNull ResourceColumn column, @NonNull String value) {
        return new ResourceSearchCriteria(column, value);
    }
}
