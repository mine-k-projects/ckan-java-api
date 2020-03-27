package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Revision;
import minek.ckan.v3.enums.RevisionListSortField;
import minek.ckan.v3.sort.UnderscoreSort;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RevisionService {

    @GET("api/3/action/revision_show")
    Call<Revision> revisionShow(@NonNull @Query("id") UUID id);

    @GET("api/3/action/package_revision_list")
    Call<List<Revision>> packageRevisionList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/group_revision_list")
    Call<List<Revision>> groupRevisionList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/organization_revision_list")
    Call<List<Revision>> organizationRevisionList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/revision_list")
    Call<List<UUID>> siteRevisionList(@Query("since_id") UUID sinceId,
                                      @Query("since_time") LocalDateTime sinceTime,
                                      @Query("sort") UnderscoreSort<RevisionListSortField> sort);

    default Call<List<UUID>> siteRevisionList() {
        return siteRevisionList(null, null, null);
    }

}
