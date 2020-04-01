package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.model.Package;
import minek.ckan.v3.model.*;
import minek.ckan.v3.service.command.create.FollowUser;
import minek.ckan.v3.service.command.create.UserCreate;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.UUID;

public interface UserService {

    // NOTE : order_by 는 name 이에 정상작동 안한다. 추후 확인
    @GET("api/3/action/user_list")
    Call<List<String>> userNameList(@Query("q") String q/*, @Query("order_by") String orderBy*/);

    @GET("api/3/action/user_list?all_fields=true")
    Call<List<User>> userList();

    @GET("api/3/action/user_list?all_fields=true")
    Call<List<User>> userList(@Query("q") String q/*, @Query("order_by") String orderBy*/);

    // NOTE : user_obj 는 user dictionary 라서 막 보내기 위험해 보인다.
    @GET("api/3/action/user_show")
    Call<User> userShow(@NonNull @Query("id") String idOrName,
//                        @Query("user_obj") String user_obj,
                        @Query("include_datasets") Boolean includeDatasets,
                        @Query("include_num_followers") Boolean includeNumFollowers,
                        @Query("include_password_hash") Boolean includePasswordHash);

    /**
     * Only internal services are allowed to call get_site_user
     *
     * @param deferCommit
     * @return
     */
    @GET("api/3/action/get_site_user")
    Call<SiteUser> getSiteUser(@Query("defer_commit") Boolean deferCommit);

    @GET("api/3/action/followee_count")
    Call<Integer> followeeCount(@NonNull @Query("id") UUID userId);

    @GET("api/3/action/user_followee_count")
    Call<Integer> userFolloweeCount(@NonNull @Query("id") UUID userId);

    @GET("api/3/action/dataset_followee_count")
    Call<Integer> datasetFolloweeCount(@NonNull @Query("id") UUID userId);

    @GET("api/3/action/group_followee_count")
    Call<Integer> groupFolloweeCount(@NonNull @Query("id") UUID userId);

    @GET("api/3/action/followee_list")
    Call<List<Followee<?>>> followeeList(@Query("id") UUID userId);

    @GET("api/3/action/user_followee_list")
    Call<List<User>> userFolloweeList(@Query("id") UUID userId);

    @GET("api/3/action/dataset_followee_list")
    Call<List<Package>> datasetFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/group_followee_list")
    Call<List<Group>> groupFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/organization_followee_list")
    Call<List<Group>> organizationFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/am_following_user")
    Call<Boolean> amFollowingUser(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/user_follower_count")
    Call<Integer> userFollowerCount(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/user_follower_list")
    Call<List<User>> userFollowerList(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/user_create")
    Call<User> userCreate(@Body UserCreate userCreate);

    @POST("api/3/action/follow_user")
    Call<Follower> followUser(@Body FollowUser followUser);

    @FormUrlEncoded
    @POST("api/3/action/user_delete")
    Call<Void> userDelete(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/unfollow_user")
    Call<Void> unfollowUser(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/user_update")
    Call<User> userUpdate(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/user_generate_apikey")
    Call<User> userGenerateApikey(@Field("id") String idOrName);

}
