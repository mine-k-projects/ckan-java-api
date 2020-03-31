package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import minek.ckan.v3.enums.ObjectType;

import java.io.IOException;

public class ObjectTypeJsonSerializer extends JsonSerializer<ObjectType> {

    @Override
    public void serialize(ObjectType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getCode());
    }
}
