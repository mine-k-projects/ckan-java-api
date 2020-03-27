package minek.ckan.retrofit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

@AllArgsConstructor
public class ResponseBodyInterceptor implements Interceptor {

    private ObjectMapper objectMapper;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (response.code() == 200) {
            ResponseBody responseBody = response.body();
            JsonNode jsonNode = objectMapper.readTree(responseBody.charStream());
            String help = jsonNode.get("help").asText();
            boolean success = jsonNode.get("success").asBoolean();
            if (success) {
                JsonNode result = jsonNode.get("result");
                ResponseBody body = ResponseBody.create(responseBody.contentType(), result.toString());
                return response.newBuilder().body(body).build();
            }
        }
        return response;
    }
}