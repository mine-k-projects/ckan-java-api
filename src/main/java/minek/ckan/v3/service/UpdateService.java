package minek.ckan.v3.service;

import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import minek.ckan.v3.update.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;
import java.util.UUID;

public interface UpdateService {

    @FormUrlEncoded
    @POST("api/3/action/resource_update")
    Call<Resource> resourceUpdate(@Field("id") UUID id);

    @FormUrlEncoded
    @POST("api/3/action/resource_view_update")
    Call<ResourceView> resourceviewupdate(@Field("id") UUID id);

    @POST("api/3/action/resource_view_reorder")
    Call<ResourceViewReorder> resourceViewReorder(@Body ResourceViewReorder resourceViewReorder);

    @FormUrlEncoded
    @POST("api/3/action/package_update")
    Call<Package> packageUpdate(@Field("id") String idOrName);

    @POST("api/3/action/package_resource_reorder")
    Call<PackageResourceReorder> packageResourceReorder(@Body PackageResourceReorder packageResourceReorder);

    @POST("api/3/action/package_relationship_update")
    Call<PackageRelationship> packageRelationshipUpdate(@Body PackageRelationship packageRelationship);

    @FormUrlEncoded
    @POST("api/3/action/group_update")
    Call<Group> groupUpdate(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/organization_update")
    Call<Group> organizationUpdate(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/user_update")
    Call<User> userUpdate(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/user_generate_apikey")
    Call<User> userGenerateApikey(@Field("id") String idOrName);

    @POST("api/3/action/task_status_update")
    Call<TaskStatus> taskStatusUpdate(@Body TaskStatus taskStatus);

    @POST("api/3/action/task_status_update_many")
    Call<TaskStatusUpdateManyResult> taskStatusUpdateMany(@Body TaskStatusUpdateMany taskStatusUpdateMany);

    @POST("api/3/action/task_status_update")
    Call<TermTranslationUpdate> taskStatusUpdate(@Body TermTranslationUpdate termTranslationUpdate);

    @POST("api/3/action/term_translation_update_many")
    Call<TermTranslationUpdateManyResult> termTranslationUpdateMany(@Body TermTranslationUpdateMany termTranslationUpdateMany);

    @FormUrlEncoded
    @POST("api/3/action/vocabulary_update")
    Call<Vocabulary> vocabularyUpdate(@Field("id") UUID id);

    @POST("api/3/action/dashboard_mark_activities_old")
    Call<Void> dashboardMarkActivitiesOld();

    @POST("api/3/action/send_email_notifications")
    Call<Void> sendEmailNotifications();

    @POST("api/3/action/package_owner_org_update")
    Call<Void> packageOwnerOrgUpdate(@Body PackageOwnerOrgUpdate packageOwnerOrgUpdate);

    @POST("api/3/action/bulk_update_private")
    Call<Void> bulkUpdatePrivate(@Body BulkUpdate bulkUpdate);

    @POST("api/3/action/bulk_update_public")
    Call<Void> bulkUpdatePublic(@Body BulkUpdate bulkUpdate);

    @POST("api/3/action/bulk_update_delete")
    Call<Void> bulkUpdateDelete(@Body BulkUpdate bulkUpdate);

    @POST("api/3/action/config_option_update")
    Call<Map<String, Object>> configOptionUpdate(@Body Map<String, Object> configOptions);

}
