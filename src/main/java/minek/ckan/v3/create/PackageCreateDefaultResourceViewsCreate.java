package minek.ckan.v3.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.Package;

// https://github.com/ckan/ckan/blob/0adbdd778a7569854d74e45f1fc147c2fe26d8d4/ckan/lib/datapreview.py#L260
// package 의 resources 만 있으면 되는 것으로 보이나...
// 3rd party 플러그인들이 뭔짓을 할지 모르기 때문에 packageShow 로 받아온 객체 통째로 넘겨 줘야 한다
// -_-.............................................
@Data
@AllArgsConstructor
public class PackageCreateDefaultResourceViewsCreate {
    @JsonProperty("package")
    private Package package_;
    @JsonProperty("create_datastore_views")
    private boolean createDatastoreViews;

    public static PackageCreateDefaultResourceViewsCreate of(Package package_) {
        return new PackageCreateDefaultResourceViewsCreate(package_, false);
    }

    public static PackageCreateDefaultResourceViewsCreate of(Package package_, boolean createDatastoreViews) {
        return new PackageCreateDefaultResourceViewsCreate(package_, createDatastoreViews);
    }
}
