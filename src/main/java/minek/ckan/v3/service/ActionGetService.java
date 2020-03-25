package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Group;
import minek.ckan.v3.Member;
import minek.ckan.v3.Package;
import minek.ckan.v3.PackageRevision;
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
    Call<List<PackageRevision>> packageRevisionList(@NonNull @Query("id") UUID id);

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
    Call<List<Group>> groupList(@Query("sort") Sort<GroupListSortField> sort,
                                @Query("limit") Integer limit,
                                @Query("offset") Integer offset,
                                @Query("groups") List<String> groups,
                                @Query("include_dataset_count") Boolean includeDatasetCount,
                                @Query("include_extras") Boolean includeExtras,
                                @Query("include_tags") Boolean includeTags,
                                @Query("include_groups") Boolean includeGroups,
                                @Query("include_users") Boolean includeUsers);

}
