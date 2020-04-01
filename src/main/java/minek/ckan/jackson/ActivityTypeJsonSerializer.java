package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import minek.ckan.v3.model.enums.ActivityType;

import java.io.IOException;

public class ActivityTypeJsonSerializer extends JsonSerializer<ActivityType> {

    @Override
    public void serialize(ActivityType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getCode());
    }
}
