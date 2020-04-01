package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.model.Tag;
import minek.ckan.v3.model.TagSearch;
import minek.ckan.v3.model.Vocabulary;
import minek.ckan.v3.service.command.create.TagCreate;
import minek.ckan.v3.service.command.create.VocabularyCreate;
import minek.ckan.v3.service.command.delete.TagDelete;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.UUID;

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
    Call<TagSearch> tagSearch(@NonNull @Query("query") String query,
                              @Query("vocabulary_id") String vocabularyIdOrName,
                              @Deprecated @Query("fields") String fields,
                              @Query("offset") Integer offset,
                              @Query("limit") Integer limit);

    @GET("api/3/action/vocabulary_list")
    Call<List<Vocabulary>> vocabularyList();

    @GET("api/3/action/vocabulary_show")
    Call<Vocabulary> vocabularyShow(@NonNull @Query("id") String idOrName);

    @POST("api/3/action/vocabulary_create")
    Call<Vocabulary> vocabularyCreate(@Body VocabularyCreate vocabularyCreate);

    @POST("api/3/action/tag_create")
    Call<Tag> tagCreate(@Body TagCreate tagCreate);

    @FormUrlEncoded
    @POST("api/3/action/vocabulary_delete")
    Call<Void> vocabularyDelete(@Field("id") UUID id);

    @POST("api/3/action/tag_delete")
    Call<Void> tagDelete(@Body TagDelete tagDelete);
}
