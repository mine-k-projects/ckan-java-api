package minek.ckan.v3.datastore.service;

import minek.ckan.v3.datastore.model.DatastoreCreateResult;
import minek.ckan.v3.datastore.model.DatastoreInfo;
import minek.ckan.v3.datastore.model.DatastoreUpsertResult;
import minek.ckan.v3.datastore.service.command.create.DatastoreCreate;
import minek.ckan.v3.datastore.service.command.create.DatastoreUpsert;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.UUID;

// https://docs.ckan.org/en/2.8/maintaining/datastore.html#ckanext.datastore.logic.action.datastore_delete
// https://github.com/ckan/ckan/blob/master/ckanext/datastore/logic/action.py
public interface DatastoreService {

    @POST("api/3/action/datastore_create")
    Call<DatastoreCreateResult> datastoreCreate(@Body DatastoreCreate datastoreCreate);

    @FormUrlEncoded
    @POST("api/3/action/datastore_run_triggers")
    Call<Integer> datastoreRunTriggers(@Field("resource_id") UUID id);

    @POST("api/3/action/datastore_upsert")
    Call<DatastoreUpsertResult> datastoreUpsert(@Body DatastoreUpsert datastoreUpsert);

    @FormUrlEncoded
    @POST("api/3/action/datastore_info")
    Call<DatastoreInfo> datastoreInfo(@Field("id") UUID id);

}
