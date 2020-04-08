package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.model.Job;
import minek.ckan.v3.model.License;
import minek.ckan.v3.model.SiteStatus;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
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

    @Test
    void configOptionList() throws IOException {
        Call<List<String>> b = siteService().configOptionList();
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void configOptionShow() throws IOException {
        List<String> options = Arrays.asList(
                "ckan.site_custom_css",
                "ckan.main_css",
                "ckan.site_description",
                "ckan.site_intro_text",
                "logo_upload",
                "ckan.homepage_style",
                "ckan.site_title",
                "ckan.site_about",
                "ckan.site_url",
                "ckan.site_logo",
                "clear_logo_upload");
        for (String option : options) {
            Call<String> b = siteService().configOptionShow(option);
            Response<String> execute = b.execute();
            String body = execute.body();
            System.out.println();
        }
    }

    @Test
    void jobList() throws IOException {
        Call<List<Job>> b = siteService().jobList();
        Response<List<Job>> execute = b.execute();
        List<Job> body = execute.body();
        System.out.println();
    }

}
