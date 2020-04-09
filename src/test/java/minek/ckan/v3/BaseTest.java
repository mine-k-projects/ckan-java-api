package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import minek.ckan.jackson.Module;
import minek.ckan.retrofit.AuthorizationInterceptor;
import minek.ckan.retrofit.ConverterFactory;
import minek.ckan.retrofit.ResponseBodyInterceptor;
import minek.ckan.v3.basic.service.*;
import minek.ckan.v3.datastore.service.DatastoreService;
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

    public DatasetService datasetService() {
        return retrofit.create(DatasetService.class);
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

    public MemberService memberService() {
        return retrofit.create(MemberService.class);
    }

    public DatastoreService dataStoreService() {
        return retrofit.create(DatastoreService.class);
    }

    private Retrofit retrofit;

    public BaseTest() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Module());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new AuthorizationInterceptor("77e4e2a0-d557-4447-a1a4-df3a47017b5c"));
        httpClient.addInterceptor(new ResponseBodyInterceptor(objectMapper));

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.45/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addConverterFactory(new ConverterFactory())
                .client(httpClient.build())
                .build();
    }

}
