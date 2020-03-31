package minek.ckan.retrofit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class RetrofitUtils {

    public static final MediaType MEDIA_TYPE_TEXT_PLAIN = MediaType.get("text/plain");
    public static final MediaType MEDIA_TYPE_APPLICATION_OCTET_STREAM = MediaType.get("application/octet-stream");

    public static RequestBody createPartFromString(Object value) {
        if (value == null) {
            return null;
        }
        return RequestBody.create(MultipartBody.FORM, value.toString());
    }

    public static MultipartBody.Part prepareFilePart(String name, File file) throws IOException {
        if (file == null) {
            return null;
        }
        String contentType = Files.probeContentType(file.toPath());
        RequestBody requestFile = RequestBody.create(MediaType.parse(contentType), file);
//        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, file);
        return MultipartBody.Part.createFormData(name, file.getName(), requestFile);
    }
}
