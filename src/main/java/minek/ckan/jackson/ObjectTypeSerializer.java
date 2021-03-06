package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import minek.ckan.v3.basic.model.enums.ObjectType;

import java.io.IOException;

public class ObjectTypeSerializer extends JsonSerializer<ObjectType> {

    @Override
    public void serialize(ObjectType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getCode());
    }
}
