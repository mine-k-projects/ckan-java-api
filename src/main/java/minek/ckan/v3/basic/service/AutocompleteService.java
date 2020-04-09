package minek.ckan.v3.basic.service;

import lombok.NonNull;
import minek.ckan.v3.basic.model.GroupAutocomplete;
import minek.ckan.v3.basic.model.PackageAutocomplete;
import minek.ckan.v3.basic.model.UserAutocomplete;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AutocompleteService {

    @GET("api/3/action/format_autocomplete")
    Call<List<String>> formatAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    default Call<List<String>> formatAutocomplete(@NonNull String q) {
        return formatAutocomplete(q, null);
    }

    @GET("api/3/action/group_autocomplete")
    Call<List<GroupAutocomplete>> groupAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    default Call<List<GroupAutocomplete>> groupAutocomplete(@NonNull String q) {
        return groupAutocomplete(q, null);
    }

    @GET("api/3/action/organization_autocomplete")
    Call<List<GroupAutocomplete>> organizationAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    default Call<List<GroupAutocomplete>> organizationAutocomplete(@NonNull String q) {
        return organizationAutocomplete(q, null);
    }

    @GET("api/3/action/package_autocomplete")
    Call<List<PackageAutocomplete>> packageAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    default Call<List<PackageAutocomplete>> packageAutocomplete(@NonNull String q) {
        return packageAutocomplete(q, null);
    }

    @GET("api/3/action/tag_autocomplete")
    Call<List<String>> tagAutocomplete(@Query("query") String query,
                                       @Query("vocabulary_id") String vocabularyIdOrName,
                                       @Deprecated @Query("fields") String fields,
                                       @Query("offset") Integer offset,
                                       @Query("limit") Integer limit);

    default Call<List<String>> tagAutocomplete(@NonNull String query) {
        return tagAutocomplete(query, null, null, null, null);
    }

    @GET("api/3/action/user_autocomplete")
    Call<List<UserAutocomplete>> userAutocomplete(@NonNull @Query("q") String q, @Query("limit") Integer limit);

    default Call<List<UserAutocomplete>> userAutocomplete(@NonNull String q) {
        return userAutocomplete(q, null);
    }
}
