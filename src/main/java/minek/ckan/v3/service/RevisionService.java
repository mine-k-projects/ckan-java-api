package minek.ckan.v3.service;

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

    @GET("api/3/action/revision_list")
    Call<List<UUID>> revisionList(@Query("since_id") UUID sinceId,
                                  @Query("since_time") LocalDateTime sinceTime,
                                  @Query("sort") UnderscoreSort<RevisionListSortField> sort);

    default Call<List<UUID>> revisionList() {
        return revisionList(null, null, null);
    }

    @GET("api/3/action/revision_show")
    Call<Revision> revisionShow(@Query("id") UUID id);

}
