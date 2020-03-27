package minek.ckan.v3;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import minek.ckan.gson.ActivityTypeJsonDeserializer;
import minek.ckan.gson.LocalDateTimeJsonDeserializer;
import minek.ckan.gson.MemberJsonDeserializer;
import minek.ckan.retrofit.AuthorizationInterceptor;
import minek.ckan.retrofit.ConverterFactory;
import minek.ckan.retrofit.ResponseBodyInterceptor;
import minek.ckan.v3.enums.ActivityType;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.ObjectType;
import minek.ckan.v3.service.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

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

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonDeserializer())
                .registerTypeAdapter(Member.class, new MemberJsonDeserializer())
                .registerTypeAdapter(ActivityType.class, new ActivityTypeJsonDeserializer())
                .create();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")));
        module.addDeserializer(Member.class, new JsonDeserializer<Member>() {
            @Override
            public Member deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                ObjectCodec objectCodec = p.getCodec();
                JsonNode jsonNode = objectCodec.readTree(p);
                ArrayNode jsonArray = (ArrayNode) jsonNode;
                String id = jsonArray.get(0).asText();
                String type = jsonArray.get(1).asText().toLowerCase();
                if (type.equals("package")) {
                    type = "_" + type;
                }
                String capacity = jsonArray.get(2).asText().toLowerCase();
                if (capacity.equals("public") || capacity.equals("private")) {
                    capacity = "_" + capacity;
                }
                return new Member(UUID.fromString(id), ObjectType.valueOf(type), Capacity.valueOf(capacity));
            }
        });
        module.addDeserializer(ActivityType.class, new JsonDeserializer<ActivityType>() {
            @Override
            public ActivityType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                ObjectCodec objectCodec = p.getCodec();
                JsonNode jsonNode = objectCodec.readTree(p);
                String s = jsonNode.asText();
                for (ActivityType value : ActivityType.values()) {
                    if (value.getCode().equals(s)) {
                        return value;
                    }
                }
                return null;
            }
        });
        module.addDeserializer(Capacity.class, new JsonDeserializer<Capacity>() {
            @Override
            public Capacity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                ObjectCodec objectCodec = p.getCodec();
                JsonNode jsonNode = objectCodec.readTree(p);
                String s = jsonNode.asText();
                for (Capacity value : Capacity.values()) {
                    if (value.getCode().equals(s)) {
                        return value;
                    }
                }
                return null;
            }
        });

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new AuthorizationInterceptor("ee761722-6d84-44b5-b304-d2c8b24e4ac4"));
        httpClient.addInterceptor(new ResponseBodyInterceptor());

        retrofit = new Retrofit.Builder()
                .baseUrl("https://demo.ckan.org/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addConverterFactory(new ConverterFactory())
                .client(httpClient.build())
                .build();
    }

}
