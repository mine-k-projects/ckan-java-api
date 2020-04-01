package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.model.License;
import minek.ckan.v3.model.SiteStatus;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class SiteServiceTest extends BaseTest {

    @Test
    void siteRead() throws IOException {
        Call<Boolean> b = siteService().siteRead();
        Response<Boolean> execute = b.execute();
        Boolean body = execute.body();
        System.out.println();
    }

    @Test
    void licenseList() throws IOException {
        Call<List<License>> b = siteService().licenseList();
        Response<List<License>> execute = b.execute();
        List<License> body = execute.body();
        System.out.println();
    }

    @Test
    void statusShow() throws IOException {
        Call<SiteStatus> b = siteService().statusShow();
        Response<SiteStatus> execute = b.execute();
        SiteStatus body = execute.body();
        System.out.println();
    }

}
