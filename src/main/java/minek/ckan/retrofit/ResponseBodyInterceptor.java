package minek.ckan.retrofit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class ResponseBodyInterceptor implements Interceptor {

    final JsonParser jsonParser = new JsonParser();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (response.code() == 200) {
            ResponseBody responseBody = response.body();
            JsonElement jsonElement = jsonParser.parse(responseBody.charStream());
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String help = jsonObject.get("help").getAsString();
            boolean success = jsonObject.get("success").getAsBoolean();
            if (success) {
                JsonElement result = jsonObject.get("result");
                ResponseBody body = ResponseBody.create(responseBody.contentType(), result.toString());
                return response.newBuilder().body(body).build();
            }
        }
        return response;
    }
}