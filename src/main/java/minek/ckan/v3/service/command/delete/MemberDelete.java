package minek.ckan.v3.service.command.delete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.enums.ObjectType;

import java.util.UUID;

@Data
@AllArgsConstructor
public class MemberDelete {
    private UUID id;
    private String object;
    @JsonProperty("object_type")
    private ObjectType objectType;

    public static MemberDelete of(UUID id, String object, ObjectType objectType) {
        return new MemberDelete(id, object, objectType);
    }

    public static MemberDelete of(UUID id, UUID object, ObjectType objectType) {
        return new MemberDelete(id, object.toString(), objectType);
    }
}
