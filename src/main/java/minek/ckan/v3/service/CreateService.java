package minek.ckan.v3.service;

import minek.ckan.v3.Package;
import minek.ckan.v3.Resource;
import minek.ckan.v3.create.PackageCreate;
import minek.ckan.v3.create.ResourceCreate;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import java.io.File;
import java.io.IOException;

import static minek.ckan.retrofit.RetrofitUtils.createPartFromString;
import static minek.ckan.retrofit.RetrofitUtils.prepareFilePart;

// TODO : api 작업 후 각 service 로 이동 처리
public interface CreateService {

    @POST("api/3/action/package_create")
    Call<Package> packageCreate(@Body PackageCreate package_);

    @POST("api/3/action/resource_create")
    Call<Resource> resourceCreate(@Body ResourceCreate resource);

    // NOTE : demo 사이트가 이상한 건지 파일 업로드가 안된다.
    @Multipart
    @POST("api/3/action/resource_create")
    Call<Resource> resourceCreate(
            @Part("package_id") RequestBody packageId,
            @Part("url") RequestBody url,
            @Part("revision_id") RequestBody revisionId,
            @Part("description") RequestBody description,
            @Part("format") RequestBody format,
            @Part("hash") RequestBody hash,
            @Part("name") RequestBody name,
            @Part("resource_type") RequestBody resourceType,
            @Part("mimetype") RequestBody mimetype,
            @Part("mimetype_inner") RequestBody mimetypeInner,
            @Part("cache_url") RequestBody cacheUrl,
            @Part("size") RequestBody size,
            @Part("created") RequestBody created,
            @Part("last_modified") RequestBody lastModified,
            @Part("cache_last_updated") RequestBody cacheLastUpdated,
            @Part MultipartBody.Part upload
    );

    default Call<Resource> resourceCreate(ResourceCreate resource, File file) throws IOException {
        return resourceCreate(
                createPartFromString(resource.getPackageId()),
                createPartFromString(resource.getUrl()),
                createPartFromString(resource.getRevisionId()),
                createPartFromString(resource.getDescription()),
                createPartFromString(resource.getFormat()),
                createPartFromString(resource.getHash()),
                createPartFromString(resource.getName()),
                createPartFromString(resource.getResourceType()),
                createPartFromString(resource.getMimetype()),
                createPartFromString(resource.getMimetypeInner()),
                createPartFromString(resource.getCacheUrl()),
                createPartFromString(resource.getSize()),
                createPartFromString(resource.getCreated()),
                createPartFromString(resource.getLastModified()),
                createPartFromString(resource.getCacheLastUpdated()),
                prepareFilePart("upload", file)
        );
    }
}
