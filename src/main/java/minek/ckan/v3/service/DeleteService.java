package minek.ckan.v3.service;

import minek.ckan.v3.delete.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.List;
import java.util.UUID;

public interface DeleteService {

    @FormUrlEncoded
    @POST("api/3/action/user_delete")
    Call<Void> userDelete(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/package_delete")
    Call<Void> packageDelete(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/dataset_purge")
    Call<Void> datasetPurge(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/resource_delete")
    Call<Void> resourceDelete(@Field("id") UUID id);

    @FormUrlEncoded
    @POST("api/3/action/resource_view_delete")
    Call<Void> resourceViewDelete(@Field("id") UUID id);

    @POST("api/3/action/resource_view_clear")
    Call<Void> resourceViewClear(@Body ResourceViewClear resourceViewClear);

    @POST("api/3/action/package_relationship_delete")
    Call<Void> packageRelationshipDelete(@Body PackageRelationshipDelete packageRelationshipDelete);

    @POST("api/3/action/member_delete")
    Call<Void> memberDelete(@Body MemberDelete memberDelete);

    @FormUrlEncoded
    @POST("api/3/action/group_delete")
    Call<Void> groupDelete(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/organization_delete")
    Call<Void> organizationDelete(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/group_purge")
    Call<Void> groupPurge(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/organization_purge")
    Call<Void> organizationPurge(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/task_status_delete")
    Call<Void> taskStatusDelete(@Field("id") UUID id);

    @FormUrlEncoded
    @POST("api/3/action/vocabulary_delete")
    Call<Void> vocabularyDelete(@Field("id") UUID id);

    @POST("api/3/action/tag_delete")
    Call<Void> tagDelete(@Body TagDelete tagDelete);

    @FormUrlEncoded
    @POST("api/3/action/unfollow_user")
    Call<Void> unfollowUser(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/unfollow_dataset")
    Call<Void> unfollowDataset(@Field("id") String idOrName);

    @POST("api/3/action/group_member_delete")
    Call<Void> groupMemberDelete(@Body GroupMemberDelete groupMemberDelete);

    @POST("api/3/action/organization_member_delete")
    Call<Void> organizationMemberDelete(@Body OrganizationMemberDelete organizationMemberDelete);

    @FormUrlEncoded
    @POST("api/3/action/unfollow_group")
    Call<Void> unfollowGroup(@Field("id") String idOrName);

    @POST("api/3/action/job_clear")
    Call<List<String>> jobClear(@Body JobClear jobClear);

    @FormUrlEncoded
    @POST("api/3/action/job_cancel")
    Call<Void> jobCancel(@Field("id") UUID id);
}
