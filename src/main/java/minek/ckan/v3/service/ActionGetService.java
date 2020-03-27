package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import minek.ckan.v3.enums.*;
import minek.ckan.v3.sort.BlankSpaceSort;
import minek.ckan.v3.sort.UnderscoreSort;
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
    Call<List<String>> packageList(@Query("offset") Integer offset, @Query("limit") Integer limit);

    default Call<List<String>> packageList() {
        return packageList(null, null);
    }

    @GET("api/3/action/current_package_list_with_resources")
    Call<List<Package>> currentPackageListWithResources(@Query("offset") Integer offset, @Query("limit") Integer limit);

    default Call<List<Package>> currentPackageListWithResources() {
        return currentPackageListWithResources(null, null);
    }

    @GET("api/3/action/revision_list")
    Call<List<UUID>> revisionList(@Query("since_id") UUID sinceId,
                                  @Query("since_time") LocalDateTime sinceTime,
                                  @Query("sort") UnderscoreSort<RevisionListSortField> sort);

    default Call<List<UUID>> revisionList() {
        return revisionList(null, null, null);
    }

    @GET("api/3/action/package_revision_list")
    Call<List<Revision>> packageRevisionList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") UUID id,
                                  @Query("type") ObjectType type,
                                  @Query("capacity") Capacity capacity);

    default Call<List<Member>> memberList(@NonNull @Query("id") UUID id) {
        return memberList(id, null, null);
    }

    @GET("api/3/action/group_list")
    Call<List<String>> groupNameList(@Query("sort") BlankSpaceSort<GroupListSortField> sort,
                                     @Query("limit") Integer limit,
                                     @Query("offset") Integer offset,
                                     @Query("groups") List<String> groups);

    @GET("api/3/action/group_list?all_fields=true")
    Call<List<GroupDetail>> groupList(@Query("sort") BlankSpaceSort<GroupListSortField> sorts,
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
    Call<List<GroupDetail>> organizationList(@Query("sort") BlankSpaceSort<GroupListSortField> sort,
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

    default Call<List<UserAuthorizedOrganization>> organizationListForUser() {
        return organizationListForUser(null, null, null);
    }

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

    // TODO : package_relationships_list. api 는 리턴 데이터 확인 못함

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
    Call<List<GroupPackageShow>> groupPackageShow(@NonNull @Query("id") String idOrName,
                                                  @Query("limit") Integer limit);

    @GET("api/3/action/tag_show")
    Call<TagShow> tagShow(@NonNull @Query("id") String idOrName,
                          @Query("vocabulary_id") String vocabularyIdOrName,
                          @Query("include_datasets") Boolean includeDatasets);

    // NOTE : user_obj 는 user dictionary 라서 막 보내기 위험해 보인다.
    @GET("api/3/action/user_show")
    Call<UserShow> userShow(@NonNull @Query("id") String idOrName,
//                        @Query("user_obj") String user_obj,
                            @Query("include_datasets") Boolean includeDatasets,
                            @Query("include_num_followers") Boolean includeNumFollowers,
                            @Query("include_password_hash") Boolean includePasswordHash);

    @GET("api/3/action/package_autocomplete")
    Call<List<PackageAutocomplete>> packageAutocomplete(@NonNull @Query("q") String q);

    @GET("api/3/action/package_autocomplete")
    Call<List<PackageAutocomplete>> packageAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    @GET("api/3/action/format_autocomplete")
    Call<List<String>> formatAutocomplete(@NonNull @Query("q") String q);

    @GET("api/3/action/format_autocomplete")
    Call<List<String>> formatAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    @GET("api/3/action/user_autocomplete")
    Call<List<UserAutocomplete>> userAutocomplete(@NonNull @Query("q") String q);

    @GET("api/3/action/user_autocomplete")
    Call<List<UserAutocomplete>> userAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    @GET("api/3/action/group_autocomplete")
    Call<List<GroupAutocomplete>> groupAutocomplete(@NonNull @Query("q") String q);

    @GET("api/3/action/group_autocomplete")
    Call<List<GroupAutocomplete>> groupAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    @GET("api/3/action/organization_autocomplete")
    Call<List<GroupAutocomplete>> organizationAutocomplete(@NonNull @Query("q") String q);

    @GET("api/3/action/organization_autocomplete")
    Call<List<GroupAutocomplete>> organizationAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

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

    // NOTE : query 의 표현식이 {field}:{term} 이기 때문에 파라미터 고도화 필요
    @GET("api/3/action/resource_search")
    Call<ResourceSearch> resourceSearch(@Query("query") String query,
                                        @Deprecated @Query("fields") String fields,
                                        @Query("order_by") String orderBy,
                                        @Query("offset") Integer offset,
                                        @Query("limit") Integer limit);

    @GET("api/3/action/tag_search")
    Call<TagSearch> tagSearch(@Query("query") String query,
                              @Query("vocabulary_id") String vocabularyIdOrName,
                              @Deprecated @Query("fields") String fields,
                              @Query("offset") Integer offset,
                              @Query("limit") Integer limit);

    @GET("api/3/action/tag_autocomplete")
    Call<List<String>> tagAutocomplete(@Query("query") String query,
                                       @Query("vocabulary_id") String vocabularyIdOrName,
                                       @Deprecated @Query("fields") String fields,
                                       @Query("offset") Integer offset,
                                       @Query("limit") Integer limit);

    // TODO : task_status_show. api 는 리턴 데이터 확인 못함

    // TODO : term_translation_show. api 는 리턴 데이터 확인 못함

    /**
     * Only internal services are allowed to call get_site_user
     *
     * @param deferCommit
     * @return
     */
    @GET("api/3/action/get_site_user")
    Call<SiteUser> getSiteUser(@Query("defer_commit") Boolean deferCommit);

    @GET("api/3/action/status_show")
    Call<SiteStatus> statusShow();

    // TODO : vocabulary_list. api 는 리턴 데이터 확인 못함

    // TODO : vocabulary_show. api 는 리턴 데이터 확인 못함

    @GET("api/3/action/user_activity_list")
    Call<List<UserActivity>> userActivityList(@Query("id") String idOrName,
                                              @Query("offset") Integer offset,
                                              @Query("limit") Integer limit);

    @GET("api/3/action/package_activity_list")
    Call<List<PackageActivity>> packageActivityList(@Query("id") String idOrName,
                                                    @Query("offset") Integer offset,
                                                    @Query("limit") Integer limit);

    @GET("api/3/action/group_activity_list")
    Call<List<GroupActivity>> groupActivityList(@Query("id") String idOrName,
                                                @Query("offset") Integer offset,
                                                @Query("limit") Integer limit);

    @GET("api/3/action/organization_activity_list")
    Call<List<OrganizationActivity>> organizationActivityList(@Query("id") String idOrName,
                                                              @Query("offset") Integer offset,
                                                              @Query("limit") Integer limit);

    @GET("api/3/action/recently_changed_packages_activity_list")
    Call<List<PackageActivity>> recentlyChangedPackagesActivityList(@Query("offset") Integer offset,
                                                                    @Query("limit") Integer limit);

    @GET("api/3/action/activity_detail_list")
    Call<List<ActivityDetail>> activityDetailList(@Query("id") UUID id);

    @GET("api/3/action/user_activity_list_html")
    Call<String> userActivityListHtml(@Query("id") String idOrName,
                                      @Query("offset") Integer offset,
                                      @Query("limit") Integer limit);

    @GET("api/3/action/package_activity_list_html")
    Call<String> packageActivityListHtml(@Query("id") String idOrName,
                                         @Query("offset") Integer offset,
                                         @Query("limit") Integer limit);

    @GET("api/3/action/group_activity_list_html")
    Call<String> groupActivityListHtml(@Query("id") String idOrName,
                                       @Query("offset") Integer offset,
                                       @Query("limit") Integer limit);

    @GET("api/3/action/organization_activity_list_html")
    Call<String> organizationActivityListHtml(@Query("id") String idOrName,
                                              @Query("offset") Integer offset,
                                              @Query("limit") Integer limit);

    @GET("api/3/action/recently_changed_packages_activity_list_html")
    Call<String> recentlyChangedPackagesActivityListHtml(@Query("offset") Integer offset,
                                                         @Query("limit") Integer limit);


    @GET("api/3/action/user_follower_count")
    Call<Integer> userFollowerCount(@Query("id") String idOrName);

    @GET("api/3/action/dataset_follower_count")
    Call<Integer> datasetFollowerCount(@Query("id") String idOrName);

    @GET("api/3/action/group_follower_count")
    Call<Integer> groupFollowerCount(@Query("id") String idOrName);

    @GET("api/3/action/organization_follower_count")
    Call<Integer> organizationFollowerCount(@Query("id") String idOrName);

    // 아래 4개는 api 하나만 확인 되면......

    // TODO : user_follower_list. api 는 리턴 데이터 확인 못함

    // TODO : dataset_follower_list. api 는 리턴 데이터 확인 못함

    // TODO : group_follower_list. api 는 리턴 데이터 확인 못함

    // TODO : organization_follower_list. api 는 리턴 데이터 확인 못함

    @GET("api/3/action/am_following_user")
    Call<Boolean> amFollowingUser(@Query("id") String idOrName);

    @GET("api/3/action/am_following_dataset")
    Call<Boolean> amFollowingDataset(@Query("id") String idOrName);

    @GET("api/3/action/am_following_group")
    Call<Boolean> amFollowingGroup(@Query("id") String idOrName);

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
    Call<List<UserFollowee>> userFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/dataset_followee_list")
    Call<List<DatasetFollowee>> datasetFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/group_followee_list")
    Call<List<GroupFollowee>> groupFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/organization_followee_list")
    Call<List<OrganizationFollowee>> organizationFolloweeList(@Query("id") String idOrName);

    @GET("api/3/action/dashboard_activity_list")
    Call<List<DashboardActivity>> dashboardActivityList(@Query("offset") Integer offset,
                                                        @Query("limit") Integer limit);

    @GET("api/3/action/dashboard_activity_list_html")
    Call<String> dashboardActivityListHtml(@Query("offset") Integer offset,
                                           @Query("limit") Integer limit);

    @GET("api/3/action/dashboard_new_activities_count")
    Call<Integer> dashboardNewActivitiesCount(@Query("id") String idOrName);

    @GET("api/3/action/member_roles_list")
    Call<List<MemberRole>> memberRolesList(@Query("group_type") GroupType groupType);

    @GET("api/3/action/help_show")
    Call<String> helpShow(@Query("name") String name);

    // TODO. config_option_show.

    // TODO. config_option_list

    // TODO. job_list

    // TODO. job_show

}
