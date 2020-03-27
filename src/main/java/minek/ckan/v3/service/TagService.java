package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Tag;
import minek.ckan.v3.TagSearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface TagService {

    @GET("api/3/action/tag_list")
    Call<List<String>> tagNameList(@Query("query") String query, @Query("vocabulary_id") String vocabularyIdOrName);

    @GET("api/3/action/tag_list?all_fields=true")
    Call<List<Tag>> tagList(@Query("query") String query, @Query("vocabulary_id") String vocabularyIdOrName);

    @GET("api/3/action/tag_show")
    Call<Tag> tagShow(@NonNull @Query("id") String idOrName,
                      @Query("vocabulary_id") String vocabularyIdOrName,
                      @Query("include_datasets") Boolean includeDatasets);

    @GET("api/3/action/tag_search")
    Call<TagSearch> tagSearch(@Query("query") String query,
                              @Query("vocabulary_id") String vocabularyIdOrName,
                              @Deprecated @Query("fields") String fields,
                              @Query("offset") Integer offset,
                              @Query("limit") Integer limit);

    // TODO : vocabulary_list. api 는 리턴 데이터 확인 못함

    // TODO : vocabulary_show. api 는 리턴 데이터 확인 못함

}
