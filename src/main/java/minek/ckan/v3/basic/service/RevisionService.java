package minek.ckan.v3.basic.service;

import lombok.NonNull;
import minek.ckan.v3.basic.model.Revision;
import minek.ckan.v3.basic.service.command.get.SiteRevisionListQuery;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;
import java.util.UUID;

public interface RevisionService {

    @GET("api/3/action/group_revision_list")
    Call<List<Revision>> groupRevisionList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/organization_revision_list")
    Call<List<Revision>> organizationRevisionList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/package_revision_list")
    Call<List<Revision>> packageRevisionList(@NonNull @Query("id") String idOrName);

    @GET("api/3/action/revision_show")
    Call<Revision> revisionShow(@NonNull @Query("id") UUID id);

    @POST("api/3/action/revision_list")
    Call<List<UUID>> siteRevisionList(@Body SiteRevisionListQuery query);

    default Call<List<UUID>> siteRevisionList() {
        return siteRevisionList(new SiteRevisionListQuery());
    }
}
