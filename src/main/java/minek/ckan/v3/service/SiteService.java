package minek.ckan.v3.service;

import minek.ckan.v3.License;
import minek.ckan.v3.MemberRole;
import minek.ckan.v3.SiteStatus;
import minek.ckan.v3.enums.GroupType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface SiteService {

    @GET("api/3/action/site_read")
    Call<Boolean> siteRead();

    @GET("api/3/action/license_list")
    Call<List<License>> licenseList();

    @GET("api/3/action/status_show")
    Call<SiteStatus> statusShow();

    @GET("api/3/action/member_roles_list")
    Call<List<MemberRole>> memberRolesList(@Query("group_type") GroupType groupType);

    @GET("api/3/action/help_show")
    Call<String> helpShow(@Query("name") String name);

    // TODO : task_status_show. api 는 리턴 데이터 확인 못함

    // TODO : term_translation_show. api 는 리턴 데이터 확인 못함

    // TODO. config_option_show.

    // TODO. config_option_list

    // TODO. job_list

    // TODO. job_show

}
