package minek.ckan.v3.basic.service;

import minek.ckan.v3.basic.model.Activity;
import minek.ckan.v3.basic.model.ActivityDetail;
import minek.ckan.v3.BaseTest;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ActivityServiceTest extends BaseTest {

    @Test
    void userActivityList() throws IOException {
        Call<List<Activity>> b = activityService().userActivityList("minek", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void packageActivityList() throws IOException {
        Call<List<Activity>> b = activityService().packageActivityList("test", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void groupActivityList() throws IOException {
        Call<List<Activity>> b = activityService().groupActivityList("test", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationActivityList() throws IOException {
        Call<List<Activity>> b = activityService().organizationActivityList("mine-k", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void recentlyChangedPackagesActivityList() throws IOException {
        Call<List<Activity>> b = activityService().recentlyChangedPackagesActivityList(0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void activityDetailList_package() throws IOException {
        Call<List<ActivityDetail>> b = activityService().activityDetailList(UUID.fromString("4d094867-5311-4b9c-b1ce-9c5d94a26af0"));
        Response<List<ActivityDetail>> execute = b.execute();
        List<ActivityDetail> body = execute.body();
        System.out.println();
    }

    @Test
    void activityDetailList_resources() throws IOException {
        Call<List<ActivityDetail>> b = activityService().activityDetailList(UUID.fromString("cac31002-ca56-4a7f-96cb-ffe8ce2e1263"));
        Response<List<ActivityDetail>> execute = b.execute();
        List<ActivityDetail> body = execute.body();
        System.out.println();
    }

    @Test
    void userActivityListHtml() throws IOException {
        Call<String> b = activityService().userActivityListHtml("allbegray", 0, 10);
        Response<String> execute = b.execute();
        String body = execute.body();
        System.out.println(body);
    }

    @Test
    void dashboardActivityList() throws IOException {
        Call<List<Activity>> b = activityService().dashboardActivityList(0, 100);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println(body);
    }

}
