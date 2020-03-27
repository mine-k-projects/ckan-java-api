package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import minek.ckan.v3.enums.ActivityType;

import java.io.IOException;

public class ActivityTypeJsonDeserializer extends JsonDeserializer<ActivityType> {

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
}
