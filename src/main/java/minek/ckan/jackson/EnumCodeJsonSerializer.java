package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import minek.ckan.v3.basic.model.enums.EnumCode;

import java.io.IOException;

public class EnumCodeJsonSerializer extends JsonSerializer<EnumCode> {

    @Override
    public void serialize(EnumCode value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getCode());
    }
}
