package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import minek.ckan.v3.basic.model.Member;
import minek.ckan.v3.basic.model.enums.Capacity;
import minek.ckan.v3.basic.model.enums.ObjectType;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class MemberDeserializer extends JsonDeserializer<Member> {

    @Override
    public Member deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);
        ArrayNode jsonArray = (ArrayNode) jsonNode;
        String id = jsonArray.get(0).asText();
        String type = jsonArray.get(1).asText().toLowerCase();
        String capacity = jsonArray.get(2).asText().toLowerCase();
        //noinspection OptionalGetWithoutIsPresent
        return new Member(
                UUID.fromString(id),
                Arrays.stream(ObjectType.values()).filter(it -> it.getCode().equals(type)).findFirst().get(),
                Arrays.stream(Capacity.values()).filter(it -> it.getCode().equals(capacity)).findFirst().get()
        );
    }
}
