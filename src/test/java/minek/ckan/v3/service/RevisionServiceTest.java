package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.Revision;
import minek.ckan.v3.enums.RevisionListSortField;
import minek.ckan.v3.sort.Sort;
import minek.ckan.v3.sort.UnderscoreSort;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RevisionServiceTest extends BaseTest {

    @Test
    void revisionList() throws IOException {
        Call<List<UUID>> b = revisionService().revisionList();
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

    @Test
    void revisionList2() throws IOException {
        Call<List<UUID>> b = revisionService().revisionList(
                null,
                LocalDateTime.of(2020, 3, 24, 0, 0, 0),
                UnderscoreSort.of(RevisionListSortField.time, Sort.Direction.asc)
        );
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

    @Test
    void revisionShow() throws IOException {
        Call<Revision> b = revisionService().revisionShow(UUID.fromString("4df1cb61-f0c9-4981-b3e2-717ed57e6ead"));
        Response<Revision> execute = b.execute();
        Revision body = execute.body();
        System.out.println();
    }

}
