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
    void revisionShow() throws IOException {
        Call<Revision> b = revisionService().revisionShow(UUID.fromString("4df1cb61-f0c9-4981-b3e2-717ed57e6ead"));
        Response<Revision> execute = b.execute();
        Revision body = execute.body();
        System.out.println();
    }

    @Test
    void groupRevisionList() throws IOException {
        Call<List<Revision>> b = revisionService().groupRevisionList(UUID.fromString("e5a22d53-3330-4b7c-9b41-dfd5500fc23a"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationRevisionList() throws IOException {
        Call<List<Revision>> b = revisionService().organizationRevisionList(UUID.fromString("9dbbdacc-51d1-4f6b-ae61-3e38963bbac3"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void packageRevisionList() throws IOException {
        Call<List<Revision>> b = revisionService().packageRevisionList(UUID.fromString("020ef7ec-dd66-4e35-9ee6-4d525262dece"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void siteRevisionList() throws IOException {
        Call<List<UUID>> b = revisionService().siteRevisionList();
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

    @Test
    void siteRevisionList2() throws IOException {
        Call<List<UUID>> b = revisionService().siteRevisionList(
                null,
                LocalDateTime.of(2020, 3, 24, 0, 0, 0),
                UnderscoreSort.of(RevisionListSortField.time, Sort.Direction.asc)
        );
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

}
