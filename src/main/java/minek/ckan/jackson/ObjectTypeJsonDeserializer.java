package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import minek.ckan.v3.enums.ObjectType;

import java.io.IOException;

public class ObjectTypeJsonDeserializer extends JsonDeserializer<ObjectType> {

    @Override
    public ObjectType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);
        String s = jsonNode.asText();
        for (ObjectType value : ObjectType.values()) {
            if (value.getCode().equals(s)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
