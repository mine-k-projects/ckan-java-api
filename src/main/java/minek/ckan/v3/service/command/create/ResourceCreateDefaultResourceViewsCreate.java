package minek.ckan.v3.service.command.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.Resource;

// https://github.com/ckan/ckan/blob/0adbdd778a7569854d74e45f1fc147c2fe26d8d4/ckan/lib/datapreview.py#L260
// ckan 의 기본뷰만 보면 Resource 의 id, package_id, format, datastore_active 만 있으면 되나
// 3rd party 플러그인들이 뭔짓을 할지 모르기 때문에 resourceShow 로 받아온 객체 통째로 넘겨 줘야 한다. -_-
@Data
@AllArgsConstructor
public class ResourceCreateDefaultResourceViewsCreate {
    @JsonProperty("resource")
    private Resource resource;
    @JsonProperty("create_datastore_views")
    private boolean createDatastoreViews;

    public static ResourceCreateDefaultResourceViewsCreate of(Resource resource) {
        return new ResourceCreateDefaultResourceViewsCreate(resource, false);
    }

    public static ResourceCreateDefaultResourceViewsCreate of(Resource resource, boolean createDatastoreViews) {
        return new ResourceCreateDefaultResourceViewsCreate(resource, createDatastoreViews);
    }
}
