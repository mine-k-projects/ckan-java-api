package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import minek.ckan.v3.enums.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// TODO : api 주욱 만든 다음에 그룹화 시켜서 서비스 쪼개기
public interface ActionGetService {

    @GET("api/3/action/site_read")
    Call<Boolean> siteRead();

    @GET("api/3/action/package_list")
    Call<List<String>> packageList();

    @GET("api/3/action/package_list")
    Call<List<String>> packageList(@Query("offset") int offset, @Query("limit") int limit);

    @GET("api/3/action/current_package_list_with_resources")
    Call<List<Package>> currentPackageListWithResources();

    @GET("api/3/action/current_package_list_with_resources")
    Call<List<Package>> currentPackageListWithResources(@Query("offset") int offset, @Query("limit") int limit);

    @GET("api/3/action/revision_list")
    Call<List<UUID>> revisionList();

    @GET("api/3/action/revision_list")
    Call<List<UUID>> revisionList(@Query("since_id") UUID sinceId,
                                  @Query("since_time") LocalDateTime sinceTime,
                                  @Query("sort") Sort<RevisionListSortField> sort);

    @GET("api/3/action/package_revision_list")
    Call<List<Revision>> packageRevisionList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") UUID id,
                                  @Query("type") ObjectType type,
                                  @Query("capacity") Capacity capacity);

    @GET("api/3/action/group_list")
    Call<List<String>> groupNameList(@Query("sort") Sort<GroupListSortField> sort,
                                     @Query("limit") Integer limit,
                                     @Query("offset") Integer offset,
                                     @Query("groups") List<String> groups);

    @GET("api/3/action/group_list?all_fields=true")
    Call<List<GroupDetail>> groupList(@Query("sort") Sort<GroupListSortField> sort,
                                      @Query("limit") Integer limit,
                                      @Query("offset") Integer offset,
                                      @Query("groups") List<String> groups,
                                      @Query("include_dataset_count") Boolean includeDatasetCount,
                                      @Query("include_extras") Boolean includeExtras,
                                      @Query("include_tags") Boolean includeTags,
                                      @Query("include_groups") Boolean includeGroups,
                                      @Query("include_users") Boolean includeUsers);

    @GET("api/3/action/organization_list")
    Call<List<String>> organizationNameList(@Query("sort") Sort<GroupListSortField> sort,
                                            @Query("limit") Integer limit,
                                            @Query("offset") Integer offset,
                                            @Query("organizations") List<String> organizations);

    @GET("api/3/action/organization_list?all_fields=true")
    Call<List<GroupDetail>> organizationList(@Query("sort") Sort<GroupListSortField> sort,
                                             @Query("limit") Integer limit,
                                             @Query("offset") Integer offset,
                                             @Query("organizations") List<String> organizations,
                                             @Query("include_dataset_count") Boolean includeDatasetCount,
                                             @Query("include_extras") Boolean includeExtras,
                                             @Query("include_tags") Boolean includeTags,
                                             @Query("include_groups") Boolean includeGroups,
                                             @Query("include_users") Boolean includeUsers);

    @GET("api/3/action/group_list_authz")
    Call<List<UserAuthorizedGroup>> groupListAuthz(@Query("available_only") Boolean availableOnly,
                                                   @Query("am_member") Boolean amMember);

    @GET("api/3/action/organization_list_for_user")
    Call<List<UserAuthorizedOrganization>> organizationListForUser(@Query("id") String idOrName,
                                                                   @Query("permission") Role.Permission permission,
                                                                   @Query("include_dataset_count") Boolean includeDatasetCount);


    @GET("api/3/action/group_revision_list")
    Call<List<Revision>> groupRevisionList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/organization_revision_list")
    Call<List<Revision>> organizationRevisionList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/license_list")
    Call<List<License>> licenseList();

    @GET("api/3/action/tag_list")
    Call<List<String>> tagNameList(@Query("query") String query, @Query("vocabulary_id") String vocabularyIdOrName);

    @GET("api/3/action/tag_list?all_fields=true")
    Call<List<Tag>> tagList(@Query("query") String query, @Query("vocabulary_id") String vocabularyIdOrName);

    // NOTE : order_by 는 name 이에 정상작동 안한다. 추후 확인
    @GET("api/3/action/user_list")
    Call<List<String>> userNameList(@Query("q") String q/*, @Query("order_by") String orderBy*/);

    @GET("api/3/action/user_list?all_fields=true")
    Call<List<User>> userList(@Query("q") String q/*, @Query("order_by") String orderBy*/);

    // package_relationships_list api 는 리턴 데이터 확인 못함

    // NOTE : use_default_schema 는 IDatasetForm 플러그인에 의존성을 가진다. 샘플 데이터 찾기가 어렵...
    @GET("api/3/action/package_show")
    Call<Package> packageShow(@Query("id") String idOrName,
            /*@Query("use_default_schema") Boolean useDefaultSchema,*/
                              @Query("include_tracking") Boolean includeTracking);

    @GET("api/3/action/resource_show")
    Call<Resource> resourceShow(@Query("id") UUID id, @Query("include_tracking") Boolean includeTracking);

    @GET("api/3/action/resource_view_show")
    Call<ResourceView> resourceViewShow(@Query("id") UUID id);

    @GET("api/3/action/resource_view_list")
    Call<List<ResourceView>> resourceViewList(@Query("id") UUID id);

    @GET("api/3/action/revision_show")
    Call<Revision> revisionShow(@Query("id") UUID id);

    @GET("api/3/action/group_show")
    Call<GroupDetail> groupShow(@NonNull @Query("id") String idOrName,
                                @Query("include_datasets") Boolean includeDatasets);

    @GET("api/3/action/group_show")
    Call<GroupDetail> groupShow(@NonNull @Query("id") String idOrName,
                                @Query("include_datasets") Boolean includeDatasets,
                                @Query("include_dataset_count") Boolean includeDatasetCount,
                                @Query("include_extras") Boolean includeExtras,
                                @Query("include_users") Boolean includeUsers,
                                @Query("include_groups") Boolean includeGroups,
                                @Query("include_tags") Boolean includeTags,
                                @Query("include_followers") Boolean includeFollowers);

    @GET("api/3/action/organization_show")
    Call<GroupDetail> organizationShow(@NonNull @Query("id") String idOrName,
                                       @Query("include_datasets") Boolean includeDatasets);

    @GET("api/3/action/organization_show")
    Call<GroupDetail> organizationShow(@NonNull @Query("id") String idOrName,
                                       @Query("include_datasets") Boolean includeDatasets,
                                       @Query("include_dataset_count") Boolean includeDatasetCount,
                                       @Query("include_extras") Boolean includeExtras,
                                       @Query("include_users") Boolean includeUsers,
                                       @Query("include_groups") Boolean includeGroups,
                                       @Query("include_tags") Boolean includeTags,
                                       @Query("include_followers") Boolean includeFollowers);

    @GET("api/3/action/group_package_show")
    Call<List<Package>> groupPackageShow(@NonNull @Query("id") String idOrName,
                                         @Query("limit") Integer limit);

    @GET("api/3/action/tag_show")
    Call<Tag> tagShow(@NonNull @Query("id") String idOrName,
                      @Query("vocabulary_id") String vocabularyIdOrName,
                      @Query("include_datasets") Boolean includeDatasets);

    // NOTE : user_obj 는 user dictionary 라서 막 보내기 위험해 보인다.
    @GET("api/3/action/user_show")
    Call<User> userShow(@NonNull @Query("id") String idOrName,
//                        @Query("user_obj") String user_obj,
                        @Query("include_datasets") Boolean includeDatasets,
                        @Query("include_num_followers") Boolean includeNumFollowers,
                        @Query("include_password_hash") Boolean includePasswordHash);


}
