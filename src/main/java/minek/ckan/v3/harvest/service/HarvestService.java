package minek.ckan.v3.harvest.service;

import minek.ckan.v3.harvest.model.*;
import minek.ckan.v3.harvest.model.enums.HarvestJobStatus;
import minek.ckan.v3.harvest.model.enums.HarvestLogLevel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.UUID;

// https://github.com/ckan/ckanext-harvest/blob/94f0438c0ec6bfd7c85e64a3c15338a4d7800f2c/ckanext/harvest/model/__init__.py#L220
public interface HarvestService {

    // FIXME : HarvestSource 와 Package 가 섞여서 나온다.
    @GET("api/3/action/harvest_source_show")
    Call<String> harvestSourceShow(@Query("id") String idOrName, @Query("url") String url);

    default Call<String> harvestSourceShow(UUID id) {
        return harvestSourceShow(id.toString(), null);
    }

    @GET("api/3/action/harvest_source_show_status")
    Call<HarvestSourceShowStatus> harvestSourceShowStatus(@Query("id") UUID id);

    @GET("api/3/action/harvest_source_list")
    Call<List<HarvestSource>> harvestSourceList(@Query("return_last_job_status") boolean returnLastJobStatus);

    default Call<List<HarvestSource>> harvestSourceList() {
        return harvestSourceList(false);
    }

    @GET("api/3/action/harvest_job_show")
    Call<HarvestJob> harvestJobShow(@Query("id") UUID id);

    // TODO. harvest_job_report

    @GET("api/3/action/harvest_job_list")
    Call<List<HarvestJob>> harvestJobList(@Query("source_id") UUID sourceId, @Query("status") HarvestJobStatus status);

    default Call<List<HarvestJob>> harvestJobList(UUID sourceId) {
        return harvestJobList(sourceId, null);
    }

    // TODO. harvest_object_show

    @GET("api/3/action/harvest_object_list")
    Call<List<UUID>> harvestObjectList(@Query("source_id") UUID sourceId, @Query("only_current") Boolean onlyCurrent);

    default Call<List<UUID>> harvestObjectList(UUID sourceId) {
        return harvestObjectList(sourceId, null);
    }

    @GET("api/3/action/harvesters_info_show")
    Call<List<HarvesterInfo>> harvestersInfoShow();

    @GET("api/3/action/harvest_log_list")
    Call<List<HarvestLog>> harvestLogList(@Query("limit") Integer limit, @Query("offset") Integer offset, @Query("level") HarvestLogLevel level);

    default Call<List<HarvestLog>> harvestLogList() {
        return harvestLogList(null, null, null);
    }

}
