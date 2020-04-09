package minek.ckan.v3.basic.service;

import lombok.NonNull;
import minek.ckan.v3.basic.model.Follower;
import minek.ckan.v3.basic.model.Group;
import minek.ckan.v3.basic.model.Package;
import minek.ckan.v3.basic.model.User;
import minek.ckan.v3.basic.model.enums.Role;
import minek.ckan.v3.basic.service.command.create.FollowGroup;
import minek.ckan.v3.basic.service.command.create.GroupCreate;
import minek.ckan.v3.basic.service.command.create.UserInvite;
import minek.ckan.v3.basic.service.command.get.GroupListQuery;
import minek.ckan.v3.basic.service.command.get.GroupNameListQuery;
import minek.ckan.v3.basic.service.command.get.OrganizationListQuery;
import minek.ckan.v3.basic.service.command.get.OrganizationNameListQuery;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GroupService {

    @GET("api/3/action/am_following_group")
    Call<Boolean> amFollowingGroup(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/follow_group")
    Call<Follower> followGroup(@Body FollowGroup followGroup);

    @POST("api/3/action/group_create")
    Call<Group> groupCreate(@Body GroupCreate groupCreate);

    @FormUrlEncoded
    @POST("api/3/action/group_delete")
    Call<Void> groupDelete(@Field("id") String idOrName);

    @GET("api/3/action/group_follower_count")
    Call<Integer> groupFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/group_follower_list")
    Call<List<User>> groupFollowerList(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/group_list")
    Call<List<Group>> groupList(@Body GroupListQuery query);

    @GET("api/3/action/group_list_authz")
    Call<List<Group>> groupListAuthz(@Query("available_only") Boolean availableOnly,
                                     @Query("am_member") Boolean amMember);

    @POST("api/3/action/group_list")
    Call<List<String>> groupNameList(@Body GroupNameListQuery query);

    default Call<List<String>> groupNameList() {
        return groupNameList(new GroupNameListQuery());
    }

    @GET("api/3/action/group_package_show")
    Call<List<Package>> groupPackageShow(@NonNull @Query("id") String idOrName,
                                         @Query("limit") Integer limit);

    @FormUrlEncoded
    @POST("api/3/action/group_patch")
    Call<Void> groupPatch(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/group_purge")
    Call<Void> groupPurge(@Field("id") String idOrName);

    @GET("api/3/action/group_show")
    Call<Group> groupShow(@NonNull @Query("id") String idOrName,
                          @Query("include_datasets") Boolean includeDatasets,
                          @Query("include_dataset_count") Boolean includeDatasetCount,
                          @Query("include_extras") Boolean includeExtras,
                          @Query("include_users") Boolean includeUsers,
                          @Query("include_groups") Boolean includeGroups,
                          @Query("include_tags") Boolean includeTags,
                          @Query("include_followers") Boolean includeFollowers);

    default Call<Group> groupShow(@NonNull String idOrName, Boolean includeDatasets) {
        return groupShow(idOrName, includeDatasets, null, null, null, null, null, null);
    }

    @FormUrlEncoded
    @POST("api/3/action/group_update")
    Call<Group> groupUpdate(@Field("id") String idOrName);

    @POST("api/3/action/organization_create")
    Call<Group> organizationCreate(@Body GroupCreate groupCreate);

    @FormUrlEncoded
    @POST("api/3/action/organization_delete")
    Call<Void> organizationDelete(@Field("id") String idOrName);

    @GET("api/3/action/organization_follower_count")
    Call<Integer> organizationFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/organization_follower_list")
    Call<List<User>> organizationFollowerList(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/organization_list")
    Call<List<Group>> organizationList(@Body OrganizationListQuery query);

    @GET("api/3/action/organization_list_for_user")
    Call<List<Group>> organizationListForUser(@Query("id") String idOrName,
                                              @Query("permission") Role.Permission permission,
                                              @Query("include_dataset_count") Boolean includeDatasetCount);

    default Call<List<Group>> organizationListForUser() {
        return organizationListForUser(null, null, null);
    }

    @POST("api/3/action/organization_list")
    Call<List<String>> organizationNameList(@Body OrganizationNameListQuery query);

    default Call<List<String>> organizationNameList() {
        return organizationNameList(new OrganizationNameListQuery());
    }

    @FormUrlEncoded
    @POST("api/3/action/organization_patch")
    Call<Void> organizationPatch(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/organization_purge")
    Call<Void> organizationPurge(@Field("id") String idOrName);

    @GET("api/3/action/organization_show")
    Call<Group> organizationShow(@NonNull @Query("id") String idOrName,
                                 @Query("include_datasets") Boolean includeDatasets,
                                 @Query("include_dataset_count") Boolean includeDatasetCount,
                                 @Query("include_extras") Boolean includeExtras,
                                 @Query("include_users") Boolean includeUsers,
                                 @Query("include_groups") Boolean includeGroups,
                                 @Query("include_tags") Boolean includeTags,
                                 @Query("include_followers") Boolean includeFollowers);

    default Call<Group> organizationShow(@NonNull String idOrName, Boolean includeDatasets) {
        return organizationShow(idOrName, includeDatasets, null, null, null, null, null, null);
    }

    @FormUrlEncoded
    @POST("api/3/action/organization_update")
    Call<Group> organizationUpdate(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/unfollow_group")
    Call<Void> unfollowGroup(@Field("id") String idOrName);

    @POST("api/3/action/user_invite")
    Call<User> userInvite(@Body UserInvite userInvite);
}
