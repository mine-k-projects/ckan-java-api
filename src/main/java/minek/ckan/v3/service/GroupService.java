package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.model.Follower;
import minek.ckan.v3.model.Group;
import minek.ckan.v3.model.Package;
import minek.ckan.v3.model.User;
import minek.ckan.v3.model.enums.Role;
import minek.ckan.v3.service.command.create.FollowGroup;
import minek.ckan.v3.service.command.create.GroupCreate;
import minek.ckan.v3.service.command.create.UserInvite;
import minek.ckan.v3.service.command.criteria.GroupListSortField;
import minek.ckan.v3.service.command.criteria.sort.BlankSpaceSort;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GroupService {

    @GET("api/3/action/group_list")
    Call<List<String>> groupNameList(@Query("sort") BlankSpaceSort<GroupListSortField> sort,
                                     @Query("limit") Integer limit,
                                     @Query("offset") Integer offset,
                                     @Query("groups") List<String> groups);

    @GET("api/3/action/group_list?all_fields=true")
    Call<List<Group>> groupList(@Query("sort") BlankSpaceSort<GroupListSortField> sorts,
                                @Query("limit") Integer limit,
                                @Query("offset") Integer offset,
                                @Query("groups") List<String> groups,
                                @Query("include_dataset_count") Boolean includeDatasetCount,
                                @Query("include_extras") Boolean includeExtras,
                                @Query("include_tags") Boolean includeTags,
                                @Query("include_groups") Boolean includeGroups,
                                @Query("include_users") Boolean includeUsers);

    @GET("api/3/action/organization_list")
    Call<List<String>> organizationNameList(@Query("sort") BlankSpaceSort<GroupListSortField> sort,
                                            @Query("limit") Integer limit,
                                            @Query("offset") Integer offset,
                                            @Query("organizations") List<String> organizations);

    @GET("api/3/action/organization_list?all_fields=true")
    Call<List<Group>> organizationList(@Query("sort") BlankSpaceSort<GroupListSortField> sort,
                                       @Query("limit") Integer limit,
                                       @Query("offset") Integer offset,
                                       @Query("organizations") List<String> organizations,
                                       @Query("include_dataset_count") Boolean includeDatasetCount,
                                       @Query("include_extras") Boolean includeExtras,
                                       @Query("include_tags") Boolean includeTags,
                                       @Query("include_groups") Boolean includeGroups,
                                       @Query("include_users") Boolean includeUsers);

    @GET("api/3/action/group_list_authz")
    Call<List<Group>> groupListAuthz(@Query("available_only") Boolean availableOnly,
                                     @Query("am_member") Boolean amMember);

    @GET("api/3/action/organization_list_for_user")
    Call<List<Group>> organizationListForUser(@Query("id") String idOrName,
                                              @Query("permission") Role.Permission permission,
                                              @Query("include_dataset_count") Boolean includeDatasetCount);

    default Call<List<Group>> organizationListForUser() {
        return organizationListForUser(null, null, null);
    }

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

    @GET("api/3/action/group_package_show")
    Call<List<Package>> groupPackageShow(@NonNull @Query("id") String idOrName,
                                         @Query("limit") Integer limit);

    @GET("api/3/action/am_following_group")
    Call<Boolean> amFollowingGroup(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/group_follower_count")
    Call<Integer> groupFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/organization_follower_count")
    Call<Integer> organizationFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/group_follower_list")
    Call<List<User>> groupFollowerList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/organization_follower_list")
    Call<List<User>> organizationFollowerList(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/group_create")
    Call<Group> groupCreate(@Body GroupCreate groupCreate);

    @POST("api/3/action/organization_create")
    Call<Group> organizationCreate(@Body GroupCreate groupCreate);

    @POST("api/3/action/user_invite")
    Call<User> userInvite(@Body UserInvite userInvite);

    @POST("api/3/action/follow_group")
    Call<Follower> followGroup(@Body FollowGroup followGroup);

    @FormUrlEncoded
    @POST("api/3/action/group_patch")
    Call<Void> groupPatch(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/organization_patch")
    Call<Void> organizationPatch(@Field("id") String idOrName);

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
    @POST("api/3/action/unfollow_group")
    Call<Void> unfollowGroup(@Field("id") String idOrName);
}
