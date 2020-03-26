package minek.ckan.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import minek.ckan.v3.enums.ActivityType;

import java.lang.reflect.Type;

public class ActivityTypeJsonDeserializer implements JsonDeserializer<ActivityType> {
    @Override
    public ActivityType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String s = json.getAsString();
        if (s != null) {
            return ActivityType.valueOf(s.replace(" ", "_"));
        }
        return null;
    }

}