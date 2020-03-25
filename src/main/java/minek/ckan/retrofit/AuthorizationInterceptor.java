package minek.ckan.retrofit;

import lombok.AllArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@AllArgsConstructor
public class AuthorizationInterceptor implements Interceptor {

    private String apiKey;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", apiKey)
                .build();
        return chain.proceed(request);
    }
}
