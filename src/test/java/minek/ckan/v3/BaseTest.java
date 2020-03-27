package minek.ckan.v3;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import minek.ckan.jackson.Module;
import minek.ckan.retrofit.AuthorizationInterceptor;
import minek.ckan.retrofit.ConverterFactory;
import minek.ckan.retrofit.ResponseBodyInterceptor;
import minek.ckan.v3.service.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BaseTest {

    public ActivityService activityService() {
        return retrofit.create(ActivityService.class);
    }

    public AutocompleteService autocompleteService() {
        return retrofit.create(AutocompleteService.class);
    }

    public GroupService groupService() {
        return retrofit.create(GroupService.class);
    }

    public PackageService packageService() {
        return retrofit.create(PackageService.class);
    }

    public RevisionService revisionService() {
        return retrofit.create(RevisionService.class);
    }

    public SiteService siteService() {
        return retrofit.create(SiteService.class);
    }

    public TagService tagService() {
        return retrofit.create(TagService.class);
    }

    public UserService userService() {
        return retrofit.create(UserService.class);
    }

    private Retrofit retrofit;

    public BaseTest() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Module());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new AuthorizationInterceptor("ee761722-6d84-44b5-b304-d2c8b24e4ac4"));
        httpClient.addInterceptor(new ResponseBodyInterceptor(objectMapper));

        retrofit = new Retrofit.Builder()
                .baseUrl("https://demo.ckan.org/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addConverterFactory(new ConverterFactory())
                .client(httpClient.build())
                .build();
    }

}
