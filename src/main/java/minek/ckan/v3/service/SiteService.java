package minek.ckan.v3.service;

import lombok.NonNull;
import minek.ckan.v3.*;
import minek.ckan.v3.enums.GroupType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

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
    Call<String> helpShow(@NonNull @Query("name") String name);

    @GET("api/3/action/task_status_show")
    Call<TaskStatus> taskStatusShow(@Query("id") String id,
                                    @Query("entity_id") String entityId,
                                    @Query("task_type") String taskType,
                                    @Query("key") String key);

    default Call<TaskStatus> taskStatusShow(@NonNull String id) {
        return taskStatusShow(id, null, null, null);
    }

    default Call<TaskStatus> taskStatusShow(@NonNull String entityId, @NonNull String taskType, @NonNull String key) {
        return taskStatusShow(null, entityId, taskType, key);
    }

    @GET("api/3/action/term_translation_show")
    Call<List<TermTranslation>> termTranslationShow(@NonNull @Query("terms") List<String> terms,
                                                    @Query("lang_codes") List<String> langCodes);

    // https://github.com/ckan/ckan/blob/8f271bfe3eccaa83a419ee55e3e35042d1196c5a/ckan/tests/controllers/test_admin.py#L297
    // https://github.com/ckan/ckan/blob/8f271bfe3eccaa83a419ee55e3e35042d1196c5a/ckan/lib/app_globals.py#L29
    // FIXME : API 문서에는 리턴이 string 이라고만 나와 있는데, 구조체 옵션 key 로 확인을 해야 한다.
    @GET("api/3/action/config_option_show")
    Call<String> configOptionShow(@NonNull @Query("key") String key);

    @GET("api/3/action/config_option_list")
    Call<Map<String, Object>> configOptionList();

    @GET("api/3/action/job_list")
    Call<List<Job>> jobList();

    @GET("api/3/action/job_show")
    Call<Job> jobShow(@NonNull @Query("id") String id);

}
