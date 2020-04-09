package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import minek.ckan.v3.datastore.model.enums.FieldType;

import java.io.IOException;

public class FieldTypeJsonDeserializer extends JsonDeserializer<FieldType> {

    @Override
    public FieldType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);
        String s = jsonNode.asText();
        for (FieldType value : FieldType.values()) {
            if (value.getCode().equals(s)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
