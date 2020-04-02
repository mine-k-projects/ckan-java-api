package minek.ckan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import minek.ckan.jackson.Module;
import minek.ckan.retrofit.AuthorizationInterceptor;
import minek.ckan.retrofit.ConverterFactory;
import minek.ckan.retrofit.ResponseBodyInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;

public class CkanClientFactory {

    private String baseUrl;
    private String apiKey;

    private Duration connectTimeout;
    private Duration readTimeout;
    private Duration writeTimeout;

    private HttpLoggingInterceptor.Level loggingLevel;

    public CkanClientFactory(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Duration getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(Duration writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public HttpLoggingInterceptor.Level getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(HttpLoggingInterceptor.Level loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public CkanClient build() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Module());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (connectTimeout != null) {
            httpClient.connectTimeout(connectTimeout);
        }
        if (readTimeout != null) {
            httpClient.readTimeout(readTimeout);
        }
        if (writeTimeout != null) {
            httpClient.writeTimeout(writeTimeout);
        }

        if (loggingLevel != null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(loggingLevel);
            httpClient.addInterceptor(logging);
        }

        httpClient.addInterceptor(new AuthorizationInterceptor(apiKey));
        httpClient.addInterceptor(new ResponseBodyInterceptor(objectMapper));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.endsWith("/") ? baseUrl : baseUrl + "/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addConverterFactory(new ConverterFactory())
                .client(httpClient.build())
                .build();

        return new CkanClient(retrofit);
    }
}
