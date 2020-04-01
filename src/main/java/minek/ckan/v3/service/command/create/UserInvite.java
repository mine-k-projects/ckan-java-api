package minek.ckan.v3.service.command.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.enums.Role;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserInvite {
    private String email;
    @JsonProperty("group_id")
    private UUID groupId;
    private Role role;

    public static UserInvite of(String email, UUID groupId, Role role) {
        return new UserInvite(email, groupId, role);
    }
}
