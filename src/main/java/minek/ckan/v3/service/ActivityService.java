package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.Activity;
import minek.ckan.v3.ActivityDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.UUID;

public interface ActivityService {

    @GET("api/3/action/user_activity_list")
    Call<List<Activity>> userActivityList(@NonNull @Query("id") String idOrName,
                                          @Query("offset") Integer offset,
                                          @Query("limit") Integer limit);

    default Call<List<Activity>> userActivityList(@NonNull String idOrName) {
        return userActivityList(idOrName, null, null);
    }

    @GET("api/3/action/package_activity_list")
    Call<List<Activity>> packageActivityList(@NonNull @Query("id") String idOrName,
                                             @Query("offset") Integer offset,
                                             @Query("limit") Integer limit);

    default Call<List<Activity>> packageActivityList(@NonNull String idOrName) {
        return packageActivityList(idOrName, null, null);
    }

    @GET("api/3/action/group_activity_list")
    Call<List<Activity>> groupActivityList(@NonNull @Query("id") String idOrName,
                                           @Query("offset") Integer offset,
                                           @Query("limit") Integer limit);

    default Call<List<Activity>> groupActivityList(@NonNull String idOrName) {
        return groupActivityList(idOrName, null, null);
    }

    @GET("api/3/action/organization_activity_list")
    Call<List<Activity>> organizationActivityList(@NonNull @Query("id") String idOrName,
                                                  @Query("offset") Integer offset,
                                                  @Query("limit") Integer limit);

    default Call<List<Activity>> organizationActivityList(@NonNull String idOrName) {
        return organizationActivityList(idOrName, null, null);
    }

    @GET("api/3/action/recently_changed_packages_activity_list")
    Call<List<Activity>> recentlyChangedPackagesActivityList(@Query("offset") Integer offset,
                                                             @Query("limit") Integer limit);

    @GET("api/3/action/activity_detail_list")
    Call<List<ActivityDetail>> activityDetailList(@NonNull @Query("id") UUID id);

    @GET("api/3/action/user_activity_list_html")
    Call<String> userActivityListHtml(@NonNull @Query("id") String idOrName,
                                      @Query("offset") Integer offset,
                                      @Query("limit") Integer limit);

    default Call<String> userActivityListHtml(@NonNull String idOrName) {
        return userActivityListHtml(idOrName, null, null);
    }

    @GET("api/3/action/package_activity_list_html")
    Call<String> packageActivityListHtml(@NonNull @Query("id") String idOrName,
                                         @Query("offset") Integer offset,
                                         @Query("limit") Integer limit);

    default Call<String> packageActivityListHtml(@NonNull String idOrName) {
        return packageActivityListHtml(idOrName, null, null);
    }

    @GET("api/3/action/group_activity_list_html")
    Call<String> groupActivityListHtml(@NonNull @Query("id") String idOrName,
                                       @Query("offset") Integer offset,
                                       @Query("limit") Integer limit);

    default Call<String> groupActivityListHtml(@NonNull String idOrName) {
        return groupActivityListHtml(idOrName, null, null);
    }

    @GET("api/3/action/organization_activity_list_html")
    Call<String> organizationActivityListHtml(@NonNull @Query("id") String idOrName,
                                              @Query("offset") Integer offset,
                                              @Query("limit") Integer limit);

    default Call<String> organizationActivityListHtml(@NonNull String idOrName) {
        return organizationActivityListHtml(idOrName, null, null);
    }

    @GET("api/3/action/recently_changed_packages_activity_list_html")
    Call<String> recentlyChangedPackagesActivityListHtml(@Query("offset") Integer offset,
                                                         @Query("limit") Integer limit);

    @GET("api/3/action/dashboard_activity_list")
    Call<List<Activity>> dashboardActivityList(@Query("offset") Integer offset,
                                               @Query("limit") Integer limit);

    @GET("api/3/action/dashboard_activity_list_html")
    Call<String> dashboardActivityListHtml(@Query("offset") Integer offset,
                                           @Query("limit") Integer limit);

    @GET("api/3/action/dashboard_new_activities_count")
    Call<Integer> dashboardNewActivitiesCount(@NonNull @Query("id") String idOrName);

}
