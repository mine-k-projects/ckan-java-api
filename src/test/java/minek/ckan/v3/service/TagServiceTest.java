package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.model.Tag;
import minek.ckan.v3.model.TagSearch;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class TagServiceTest extends BaseTest {

    @Test
    void tagNameList() throws IOException {
        Call<List<String>> b = tagService().tagNameList(null, null);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void tagList() throws IOException {
        Call<List<Tag>> b = tagService().tagList(null, null);
        Response<List<Tag>> execute = b.execute();
        List<Tag> body = execute.body();
        System.out.println();
    }

    @Test
    void tagShow() throws IOException {
        Call<Tag> b = tagService().tagShow("0f0d9b61-b103-486c-bbd7-bec98bfcf406", null, true);
        Response<Tag> execute = b.execute();
        Tag body = execute.body();
        System.out.println();
    }

    @Test
    void tagSearch() throws IOException {
        Call<TagSearch> b = tagService().tagSearch(
                "test",
                null,
                null,
                0,
                10);
        Response<TagSearch> execute = b.execute();
        TagSearch body = execute.body();
        System.out.println();
    }

}
