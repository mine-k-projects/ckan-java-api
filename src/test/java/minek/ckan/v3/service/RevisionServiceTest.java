package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.model.Revision;
import minek.ckan.v3.service.command.get.SiteRevisionListQuery;
import minek.ckan.v3.service.command.get.sort.Direction;
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
        Call<Revision> b = revisionService().revisionShow(UUID.fromString("acf29135-913c-4fa1-9d18-d2b25d6bd1b6"));
        Response<Revision> execute = b.execute();
        Revision body = execute.body();
        System.out.println();
    }

    @Test
    void groupRevisionList() throws IOException {
        Call<List<Revision>> b = revisionService().groupRevisionList("test-group");
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationRevisionList() throws IOException {
        Call<List<Revision>> b = revisionService().organizationRevisionList("9dbbdacc-51d1-4f6b-ae61-3e38963bbac3");
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void packageRevisionList() throws IOException {
        Call<List<Revision>> b = revisionService().packageRevisionList("020ef7ec-dd66-4e35-9ee6-4d525262dece");
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
    void siteRevisionListQuery() throws IOException {
        SiteRevisionListQuery query = new SiteRevisionListQuery();
        query.setSinceTime(LocalDateTime.of(2020, 3, 24, 0, 0, 0));
        query.setSort(SiteRevisionListQuery.RevisionSortField.time, Direction.asc);

        Call<List<UUID>> b = revisionService().siteRevisionList(query);
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

}
