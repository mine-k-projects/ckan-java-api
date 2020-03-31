package minek.ckan.v3.service;

import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import minek.ckan.v3.create.*;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static minek.ckan.retrofit.RetrofitUtils.createPartFromString;
import static minek.ckan.retrofit.RetrofitUtils.prepareFilePart;

public interface CreateService {

    @POST("api/3/action/package_create")
    Call<Package> packageCreate(@Body PackageCreate packageCreate);

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

    @POST("api/3/action/resource_view_create")
    Call<ResourceView> resourceViewCreate(@Body ResourceViewCreate resourceViewCreate);

    @POST("api/3/action/resource_create_default_resource_views")
    Call<List<ResourceView>> resourceCreateDefaultResourceViews(@Body ResourceCreateDefaultResourceViewsCreate resourceCreateDefaultResourceViewsCreate);

    @POST("api/3/action/package_create_default_resource_views")
    Call<List<ResourceView>> packageCreateDefaultResourceViews(@Body PackageCreateDefaultResourceViewsCreate packageCreateDefaultResourceViewsCreate);

    @POST("api/3/action/package_relationship_create")
    Call<PackageRelationship> packageRelationshipCreate(@Body PackageRelationship packageRelationship);

    // TODO. ckan.logic.action.create.member_create

    // TODO. ckan.logic.action.create.group_create

    // TODO. ckan.logic.action.create.organization_create

    @POST("api/3/action/rating_create")
    Call<Rating> ratingCreate(@Body RatingCreate ratingCreate);

    // TODO. ckan.logic.action.create.user_create

    // TODO. ckan.logic.action.create.user_invite

    // TODO. ckan.logic.action.create.vocabulary_create

    // TODO. ckan.logic.action.create.activity_create

    // TODO. ckan.logic.action.create.tag_create

    @POST("api/3/action/follow_user")
    Call<Follower> followUser(@Body FollowUser followUser);

    @POST("api/3/action/follow_dataset")
    Call<Follower> followDataset(@Body FollowDataset followDataset);

    // TODO. ckan.logic.action.create.group_member_create

    // TODO. ckan.logic.action.create.organization_member_create

    @POST("api/3/action/follow_group")
    Call<Follower> followGroup(@Body FollowGroup followGroup);

}
