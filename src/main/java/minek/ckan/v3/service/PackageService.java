package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import minek.ckan.v3.criteria.ResourceSearchCriteria;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.UUID;

public interface PackageService {

    @GET("api/3/action/package_list")
    Call<List<String>> packageList(@Query("offset") Integer offset, @Query("limit") Integer limit);

    default Call<List<String>> packageList() {
        return packageList(null, null);
    }

    @GET("api/3/action/current_package_list_with_resources")
    Call<List<Package>> currentPackageListWithResources(@Query("offset") Integer offset, @Query("limit") Integer limit);

    default Call<List<Package>> currentPackageListWithResources() {
        return currentPackageListWithResources(null, null);
    }

    // TODO : package_relationships_list. api 는 리턴 데이터 확인 못함

    // NOTE : use_default_schema 는 IDatasetForm 플러그인에 의존성을 가진다. 샘플 데이터 찾기가 어렵...
    @GET("api/3/action/package_show")
    Call<Package> packageShow(@NonNull @Query("id") String idOrName,
            /*@Query("use_default_schema") Boolean useDefaultSchema,*/
                              @Query("include_tracking") Boolean includeTracking);

    @GET("api/3/action/resource_show")
    Call<Resource> resourceShow(@NonNull @Query("id") UUID id, @Query("include_tracking") Boolean includeTracking);

    @GET("api/3/action/resource_view_show")
    Call<ResourceView> resourceViewShow(@NonNull @Query("id") UUID id);

    @GET("api/3/action/resource_view_list")
    Call<List<ResourceView>> resourceViewList(@NonNull @Query("id") UUID id);

    // NOTE : facet.field 파라미터는
    // facet.field=1&facet.field=2 로 보내면 안되고 facet.field=["1", "2"] 로 보내야 한다 -_-...
    // sort 역시 마찬가지로 sort=relevance asc, metadata_modified desc
    // q, fq, sort 에 대해서 파라미터 고도화를 해야 한다.
    @GET("api/3/action/package_search")
    Call<PackageSearch> packageSearch(@Query("q") String q,
                                      @Query("fq") String fq,
                                      @Query("sort") String sort,
                                      @Query("rows") Integer rows,
                                      @Query("start") Integer start,
                                      @Query("facet") Boolean facet,
                                      @Query("facet.mincount") Integer facetMincount,
                                      @Query("facet.limit") Integer facetLimit,
                                      @Query("facet.field") String facetField,
                                      @Query("include_drafts") Boolean includeDrafts,
                                      @Query("include_private") Boolean includePrivate,
                                      @Query("use_default_schema") Boolean useDefaultSchema);

    @GET("api/3/action/resource_search")
    Call<ResourceSearch> resourceSearch(@NonNull @Query("query") ResourceSearchCriteria query,
                                        @Deprecated @Query("fields") String fields,
                                        @Query("order_by") String orderBy,
                                        @Query("offset") Integer offset,
                                        @Query("limit") Integer limit);

    default Call<ResourceSearch> resourceSearch(@NonNull ResourceSearchCriteria query) {
        return resourceSearch(query, null, null, null, null);
    }

    @GET("api/3/action/am_following_dataset")
    Call<Boolean> amFollowingDataset(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/dataset_follower_count")
    Call<Integer> datasetFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/dataset_follower_list")
    Call<List<User>> datasetFollowerList(@NonNull @Query("id") String idOrName);

}
