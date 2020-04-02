package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.model.Package;
import minek.ckan.v3.model.*;
import minek.ckan.v3.model.enums.PackageRelationshipType;
import minek.ckan.v3.service.command.create.*;
import minek.ckan.v3.service.command.delete.PackageRelationshipDelete;
import minek.ckan.v3.service.command.delete.ResourceViewClear;
import minek.ckan.v3.service.command.get.PackageSearchQuery;
import minek.ckan.v3.service.command.get.ResourceSearchQuery;
import minek.ckan.v3.service.command.update.BulkUpdate;
import minek.ckan.v3.service.command.update.PackageOwnerOrgUpdate;
import minek.ckan.v3.service.command.update.PackageResourceReorder;
import minek.ckan.v3.service.command.update.ResourceViewReorder;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static minek.ckan.retrofit.RetrofitUtils.createPartFromString;
import static minek.ckan.retrofit.RetrofitUtils.prepareFilePart;

public interface DatasetService {

    @GET("api/3/action/am_following_dataset")
    Call<Boolean> amFollowingDataset(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/bulk_update_delete")
    Call<Void> bulkUpdateDelete(@Body BulkUpdate bulkUpdate);

    @POST("api/3/action/bulk_update_private")
    Call<Void> bulkUpdatePrivate(@Body BulkUpdate bulkUpdate);

    @POST("api/3/action/bulk_update_public")
    Call<Void> bulkUpdatePublic(@Body BulkUpdate bulkUpdate);

    @GET("api/3/action/current_package_list_with_resources")
    Call<List<Package>> currentPackageListWithResources(@Query("offset") Integer offset, @Query("limit") Integer limit);

    default Call<List<Package>> currentPackageListWithResources() {
        return currentPackageListWithResources(null, null);
    }

    @GET("api/3/action/dataset_follower_count")
    Call<Integer> datasetFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/dataset_follower_list")
    Call<List<User>> datasetFollowerList(@NonNull @Query("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/dataset_purge")
    Call<Void> datasetPurge(@Field("id") String idOrName);

    @POST("api/3/action/follow_dataset")
    Call<Follower> followDataset(@Body FollowDataset followDataset);

    @POST("api/3/action/package_create")
    Call<Package> packageCreate(@Body PackageCreate packageCreate);

    @POST("api/3/action/package_create_default_resource_views")
    Call<List<ResourceView>> packageCreateDefaultResourceViews(@Body PackageCreateDefaultResourceViewsCreate packageCreateDefaultResourceViewsCreate);

    @FormUrlEncoded
    @POST("api/3/action/package_delete")
    Call<Void> packageDelete(@Field("id") String idOrName);

    @GET("api/3/action/package_list")
    Call<List<String>> packageList(@Query("offset") Integer offset, @Query("limit") Integer limit);

    default Call<List<String>> packageList() {
        return packageList(null, null);
    }

    @POST("api/3/action/package_owner_org_update")
    Call<Void> packageOwnerOrgUpdate(@Body PackageOwnerOrgUpdate packageOwnerOrgUpdate);

    @FormUrlEncoded
    @POST("api/3/action/package_patch")
    Call<Void> packagePatch(@Field("id") String idOrName);

    @POST("api/3/action/package_relationship_create")
    Call<PackageRelationship> packageRelationshipCreate(@Body PackageRelationship packageRelationship);

    @POST("api/3/action/package_relationship_delete")
    Call<Void> packageRelationshipDelete(@Body PackageRelationshipDelete packageRelationshipDelete);

    @POST("api/3/action/package_relationship_update")
    Call<PackageRelationship> packageRelationshipUpdate(@Body PackageRelationship packageRelationship);

    @GET("api/3/action/package_relationships_list")
    Call<List<PackageRelationship>> packageRelationshipsList(@NonNull @Query("id") String id,
                                                             @NonNull @Query("id2") String id2);

    @GET("api/3/action/package_relationships_list")
    Call<List<PackageRelationship>> packageRelationshipsList(@NonNull @Query("id") String id,
                                                             @NonNull @Query("id2") String id2,
                                                             @Query("rel") PackageRelationshipType rel);

    @POST("api/3/action/package_resource_reorder")
    Call<PackageResourceReorder> packageResourceReorder(@Body PackageResourceReorder packageResourceReorder);

    // NOTE : facet.field 파라미터는
    // facet.field=1&facet.field=2 로 보내면 안되고 facet.field=["1", "2"] 로 보내야 한다 -_-...
    // sort 역시 마찬가지로 sort=relevance asc, metadata_modified desc
    // q, fq, sort 에 대해서 파라미터 고도화를 해야 한다.
    @POST("api/3/action/package_search")
    Call<PackageSearch> packageSearch(@Body PackageSearchQuery query);

    // NOTE : use_default_schema 는 IDatasetForm 플러그인에 의존성을 가진다. 샘플 데이터 찾기가 어렵...
    @GET("api/3/action/package_show")
    Call<Package> packageShow(@NonNull @Query("id") String idOrName,
            /*@Query("use_default_schema") Boolean useDefaultSchema,*/
                              @Query("include_tracking") Boolean includeTracking);

    @FormUrlEncoded
    @POST("api/3/action/package_update")
    Call<Package> packageUpdate(@Field("id") String idOrName);

    @POST("api/3/action/rating_create")
    Call<Rating> ratingCreate(@Body RatingCreate ratingCreate);

    @POST("api/3/action/resource_create")
    Call<Resource> resourceCreate(@Body ResourceCreate resourceCreate);

    // NOTE : demo 사이트가 이상한 건지 파일 업로드가 안된다.
    @Multipart
    @POST("api/3/action/resource_create")
    Call<Resource> resourceCreate(
            @Part("package_id") RequestBody packageId,
            @Part("url") RequestBody url,
            @Part("revision_id") RequestBody revisionId,
            @Part("description") RequestBody description,
            @Part("format") RequestBody format,
            @Part("hash") RequestBody hash,
            @Part("name") RequestBody name,
            @Part("resource_type") RequestBody resourceType,
            @Part("mimetype") RequestBody mimetype,
            @Part("mimetype_inner") RequestBody mimetypeInner,
            @Part("cache_url") RequestBody cacheUrl,
            @Part("size") RequestBody size,
            @Part("created") RequestBody created,
            @Part("last_modified") RequestBody lastModified,
            @Part("cache_last_updated") RequestBody cacheLastUpdated,
            @Part MultipartBody.Part upload
    );

    default Call<Resource> resourceCreate(ResourceCreate resource, File file) throws IOException {
        return resourceCreate(
                createPartFromString(resource.getPackageId()),
                createPartFromString(resource.getUrl()),
                createPartFromString(resource.getRevisionId()),
                createPartFromString(resource.getDescription()),
                createPartFromString(resource.getFormat()),
                createPartFromString(resource.getHash()),
                createPartFromString(resource.getName()),
                createPartFromString(resource.getResourceType()),
                createPartFromString(resource.getMimetype()),
                createPartFromString(resource.getMimetypeInner()),
                createPartFromString(resource.getCacheUrl()),
                createPartFromString(resource.getSize()),
                createPartFromString(resource.getCreated()),
                createPartFromString(resource.getLastModified()),
                createPartFromString(resource.getCacheLastUpdated()),
                prepareFilePart("upload", file)
        );
    }

    @POST("api/3/action/resource_create_default_resource_views")
    Call<List<ResourceView>> resourceCreateDefaultResourceViews(@Body ResourceCreateDefaultResourceViewsCreate resourceCreateDefaultResourceViewsCreate);

    @FormUrlEncoded
    @POST("api/3/action/resource_delete")
    Call<Void> resourceDelete(@Field("id") UUID id);

    @FormUrlEncoded
    @POST("api/3/action/resource_patch")
    Call<Void> resourcePatch(@Field("id") String idOrName);

    @POST("api/3/action/resource_search")
    Call<ResourceSearch> resourceSearch(@Body ResourceSearchQuery query);

    default Call<ResourceSearch> resourceSearch(@NonNull ResourceSearchQuery.ResourceColumn column, @NonNull String value) {
        ResourceSearchQuery query = new ResourceSearchQuery();
        query.setQuery(column, value);
        return resourceSearch(query);
    }

    @GET("api/3/action/resource_show")
    Call<Resource> resourceShow(@NonNull @Query("id") UUID id, @Query("include_tracking") Boolean includeTracking);

    @FormUrlEncoded
    @POST("api/3/action/resource_update")
    Call<Resource> resourceUpdate(@Field("id") UUID id);

    @POST("api/3/action/resource_view_clear")
    Call<Void> resourceViewClear(@Body ResourceViewClear resourceViewClear);

    @POST("api/3/action/resource_view_create")
    Call<ResourceView> resourceViewCreate(@Body ResourceViewCreate resourceViewCreate);

    @FormUrlEncoded
    @POST("api/3/action/resource_view_delete")
    Call<Void> resourceViewDelete(@Field("id") UUID id);

    @GET("api/3/action/resource_view_list")
    Call<List<ResourceView>> resourceViewList(@NonNull @Query("id") UUID id);

    @POST("api/3/action/resource_view_reorder")
    Call<ResourceViewReorder> resourceViewReorder(@Body ResourceViewReorder resourceViewReorder);

    @GET("api/3/action/resource_view_show")
    Call<ResourceView> resourceViewShow(@NonNull @Query("id") UUID id);

    @FormUrlEncoded
    @POST("api/3/action/resource_view_update")
    Call<ResourceView> resourceviewupdate(@Field("id") UUID id);

    @FormUrlEncoded
    @POST("api/3/action/unfollow_dataset")
    Call<Void> unfollowDataset(@Field("id") String idOrName);

}
