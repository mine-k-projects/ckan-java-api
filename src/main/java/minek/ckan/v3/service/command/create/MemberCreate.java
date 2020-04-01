package minek.ckan.v3.service.command.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.enums.Capacity;
import minek.ckan.v3.model.enums.ObjectType;

import java.util.UUID;

@Data
@AllArgsConstructor
public class MemberCreate {
    private String id;
    private String object;
    @JsonProperty("object_type")
    private ObjectType objectType;
    private Capacity capacity;

    public static MemberCreate of(String id, String object, ObjectType objectType, Capacity capacity) {
        return new MemberCreate(id, object, objectType, capacity);
    }

    public static MemberCreate of(String id, UUID object, ObjectType objectType, Capacity capacity) {
        return new MemberCreate(id, object.toString(), objectType, capacity);
    }

    public static MemberCreate of(UUID id, String object, ObjectType objectType, Capacity capacity) {
        return new MemberCreate(id.toString(), object, objectType, capacity);
    }

    public static MemberCreate of(UUID id, UUID object, ObjectType objectType, Capacity capacity) {
        return new MemberCreate(id.toString(), object.toString(), objectType, capacity);
    }
}
