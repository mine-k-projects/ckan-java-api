package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.ObjectType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.UUID;

public interface UserService {

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") UUID id,
                                  @Query("type") ObjectType type,
                                  @Query("capacity") Capacity capacity);

    default Call<List<Member>> memberList(@NonNull UUID id) {
        return memberList(id, null, null);
    }

    // NOTE : order_by 는 name 이에 정상작동 안한다. 추후 확인
    @GET("api/3/action/user_list")
    Call<List<String>> userNameList(@Query("q") String q/*, @Query("order_by") String orderBy*/);

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
    Call<Integer> followeeCount(@Query("id") String idOrName);

    @GET("api/3/action/user_followee_count")
    Call<Integer> userFolloweeCount(@Query("id") String idOrName);

    @GET("api/3/action/dataset_followee_count")
    Call<Integer> datasetFolloweeCount(@Query("id") String idOrName);

    @GET("api/3/action/group_followee_count")
    Call<Integer> groupFolloweeCount(@Query("id") String idOrName);

    // TODO. followee_list.

    @GET("api/3/action/user_followee_list")
    Call<List<User>> userFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/dataset_followee_list")
    Call<List<Package>> datasetFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/group_followee_list")
    Call<List<Group>> groupFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/organization_followee_list")
    Call<List<Group>> organizationFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/am_following_user")
    Call<Boolean> amFollowingUser(@Query("id") String idOrName);

    @GET("api/3/action/user_follower_count")
    Call<Integer> userFollowerCount(@Query("id") String idOrName);

    // TODO : user_follower_list. api 는 리턴 데이터 확인 못함

}
