package minek.ckan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import minek.ckan.jackson.Module;
import minek.ckan.retrofit.AuthorizationInterceptor;
import minek.ckan.retrofit.ConverterFactory;
import minek.ckan.retrofit.ResponseBodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CkanClientFactory {

    private String baseUrl;
    private String apiKey;

    public CkanClientFactory(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public CkanClient build() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Module());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new AuthorizationInterceptor(apiKey));
        httpClient.addInterceptor(new ResponseBodyInterceptor(objectMapper));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addConverterFactory(new ConverterFactory())
                .client(httpClient.build())
                .build();

        return new CkanClient(retrofit);
    }
}
