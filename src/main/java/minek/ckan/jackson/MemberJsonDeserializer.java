package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import minek.ckan.v3.Member;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.ObjectType;

import java.io.IOException;
import java.util.UUID;

public class MemberJsonDeserializer extends JsonDeserializer<Member> {

    @Override
    public Member deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
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
}
