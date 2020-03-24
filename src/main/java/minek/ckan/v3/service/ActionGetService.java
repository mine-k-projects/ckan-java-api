package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Member;
import minek.ckan.v3.Package;
import minek.ckan.v3.PackageRevision;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.ObjectType;
import minek.ckan.v3.enums.RevisionListSort;
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
    Call<List<UUID>> revisionList(@Query("since_id") UUID sinceId, @Query("since_time") LocalDateTime sinceTime, @Query("sort") RevisionListSort sort);

    @GET("api/3/action/package_revision_list")
    Call<List<PackageRevision>> packageRevisionList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/member_list")
    Call<List<Member>> memberList(@NonNull @Query("id") UUID id, @Query("type") ObjectType type, @Query("capacity") Capacity capacity);

//    group_list

}
