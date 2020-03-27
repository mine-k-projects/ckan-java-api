package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.GroupAutocomplete;
import minek.ckan.v3.PackageAutocomplete;
import minek.ckan.v3.UserAutocomplete;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class AutocompleteServiceTest extends BaseTest {

    @Test
    void packageAutocomplete() throws IOException {
        Call<List<PackageAutocomplete>> b = autocompleteService().packageAutocomplete("test", 10);
        Response<List<PackageAutocomplete>> execute = b.execute();
        List<PackageAutocomplete> body = execute.body();
        System.out.println();
    }

    @Test
    void formatAutocomplete() throws IOException {
        Call<List<String>> b = autocompleteService().formatAutocomplete("csv", 10);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void userAutocomplete() throws IOException {
        Call<List<UserAutocomplete>> b = autocompleteService().userAutocomplete("te", 10);
        Response<List<UserAutocomplete>> execute = b.execute();
        List<UserAutocomplete> body = execute.body();
        System.out.println();
    }

    @Test
    void groupAutocomplete() throws IOException {
        Call<List<GroupAutocomplete>> b = autocompleteService().groupAutocomplete("te", 10);
        Response<List<GroupAutocomplete>> execute = b.execute();
        List<GroupAutocomplete> body = execute.body();
        System.out.println();
    }

    @Test
    void tagAutocomplete() throws IOException {
        Call<List<String>> b = autocompleteService().tagAutocomplete(
                "test",
                null,
                null,
                0,
                10);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

}
