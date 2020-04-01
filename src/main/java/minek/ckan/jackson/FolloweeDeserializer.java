package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import minek.ckan.v3.model.Followee;
import minek.ckan.v3.model.Group;
import minek.ckan.v3.model.Package;
import minek.ckan.v3.model.User;
import minek.ckan.v3.model.enums.FolloweeType;

import java.io.IOException;

public class FolloweeDeserializer extends JsonDeserializer<Followee<?>> {

    @Override
    public Followee<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);

        final String displayName = jsonNode.get("display_name").textValue();
        final String typeText = jsonNode.get("type").textValue();
        final FolloweeType type = FolloweeType.valueOf(typeText);
        final JsonParser dictParser = objectCodec.treeAsTokens(jsonNode.get("dict"));

        switch (type) {
            case user:
                return Followee.of(displayName, type, dictParser.readValueAs(User.class));
            case dataset:
                return Followee.of(displayName, type, dictParser.readValueAs(Package.class));
            case group:
            case organization:
                return Followee.of(displayName, type, dictParser.readValueAs(Group.class));
        }

        throw new IOException("unexpected type: " + typeText);
    }
}
