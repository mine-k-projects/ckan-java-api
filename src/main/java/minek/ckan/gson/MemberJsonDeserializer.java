package minek.ckan.gson;

import com.google.gson.*;
import minek.ckan.v3.Member;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.ObjectType;

import java.lang.reflect.Type;
import java.util.UUID;

public class MemberJsonDeserializer implements JsonDeserializer<Member> {

    @Override
    public Member deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray jsonArray = json.getAsJsonArray();
        String id = jsonArray.get(0).getAsString();
        String type = jsonArray.get(1).getAsString().toLowerCase();
        if (type.equals("package")) {
            type = "_" + type;
        }
        String capacity = jsonArray.get(2).getAsString().toLowerCase();
        if (capacity.equals("public") || capacity.equals("private")) {
            capacity = "_" + capacity;
        }
        return new Member(UUID.fromString(id), ObjectType.valueOf(type), Capacity.valueOf(capacity));
    }
}
