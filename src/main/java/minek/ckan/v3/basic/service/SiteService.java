package minek.ckan.v3.basic.service;

import lombok.NonNull;
import minek.ckan.v3.basic.model.*;
import minek.ckan.v3.basic.model.enums.GlobalConfigOption;
import minek.ckan.v3.basic.model.enums.GroupType;
import minek.ckan.v3.basic.service.command.delete.JobClear;
import minek.ckan.v3.basic.service.command.update.TaskStatusUpdateMany;
import minek.ckan.v3.basic.service.command.update.TaskStatusUpdateManyResult;
import minek.ckan.v3.basic.service.command.update.TermTranslationUpdateMany;
import minek.ckan.v3.basic.service.command.update.TermTranslationUpdateManyResult;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface SiteService {

    @GET("api/3/action/config_option_list")
    Call<List<String>> configOptionList();

    // https://github.com/ckan/ckan/blob/8f271bfe3eccaa83a419ee55e3e35042d1196c5a/ckan/tests/controllers/test_admin.py#L297
    // https://github.com/ckan/ckan/blob/8f271bfe3eccaa83a419ee55e3e35042d1196c5a/ckan/lib/app_globals.py#L29
    // FIXME : API 문서에는 리턴이 string 이라고만 나와 있는데, 구조체 옵션 key 로 확인을 해야 한다.
    @GET("api/3/action/config_option_show")
    Call<String> configOptionShow(@NonNull @Query("key") String key);

    default Call<String> configOptionShow(@NonNull GlobalConfigOption key) {
        return configOptionShow(key.getCode());
    }

    @POST("api/3/action/config_option_update")
    Call<Map<String, Object>> configOptionUpdate(@Body Map<String, Object> configOptions);

    @GET("api/3/action/help_show")
    Call<String> helpShow(@NonNull @Query("name") String name);

    @FormUrlEncoded
    @POST("api/3/action/job_cancel")
    Call<Void> jobCancel(@Field("id") UUID id);

    @POST("api/3/action/job_clear")
    Call<List<String>> jobClear(@Body JobClear jobClear);

    @GET("api/3/action/job_list")
    Call<List<Job>> jobList();

    @GET("api/3/action/job_show")
    Call<Job> jobShow(@NonNull @Query("id") String id);

    @GET("api/3/action/license_list")
    Call<List<License>> licenseList();

    @GET("api/3/action/member_roles_list")
    Call<List<MemberRole>> memberRolesList(@Query("group_type") GroupType groupType);

    @GET("api/3/action/site_read")
    Call<Boolean> siteRead();

    @GET("api/3/action/status_show")
    Call<SiteStatus> statusShow();

    @FormUrlEncoded
    @POST("api/3/action/task_status_delete")
    Call<Void> taskStatusDelete(@Field("id") UUID id);

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

    @POST("api/3/action/task_status_update")
    Call<TaskStatus> taskStatusUpdate(@Body TaskStatus taskStatus);

    @POST("api/3/action/task_status_update")
    Call<TermTranslation> taskStatusUpdate(@Body TermTranslation termTranslationUpdate);

    @POST("api/3/action/task_status_update_many")
    Call<TaskStatusUpdateManyResult> taskStatusUpdateMany(@Body TaskStatusUpdateMany taskStatusUpdateMany);

    @GET("api/3/action/term_translation_show")
    Call<List<TermTranslation>> termTranslationShow(@NonNull @Query("terms") List<String> terms,
                                                    @Query("lang_codes") List<String> langCodes);

    @POST("api/3/action/term_translation_update_many")
    Call<TermTranslationUpdateManyResult> termTranslationUpdateMany(@Body TermTranslationUpdateMany termTranslationUpdateMany);

}
