package minek.ckan.v3.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PatchService {

    @FormUrlEncoded
    @POST("api/3/action/package_patch")
    Call<Void> packagePatch(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/resource_patch")
    Call<Void> resourcePatch(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/group_patch")
    Call<Void> groupPatch(@Field("id") String idOrName);

    @FormUrlEncoded
    @POST("api/3/action/organization_patch")
    Call<Void> organizationPatch(@Field("id") String idOrName);

}
