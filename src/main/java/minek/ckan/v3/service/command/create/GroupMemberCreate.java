package minek.ckan.v3.service.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.enums.Role;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GroupMemberCreate {
    private String id;
    private String username;
    private Role role;

    public static GroupMemberCreate of(String id, String username, Role role) {
        return new GroupMemberCreate(id, username, role);
    }

    public static GroupMemberCreate of(UUID id, String username, Role role) {
        return new GroupMemberCreate(id.toString(), username, role);
    }

    public static GroupMemberCreate of(String id, UUID username, Role role) {
        return new GroupMemberCreate(id, username.toString(), role);
    }

    public static GroupMemberCreate of(UUID id, UUID username, Role role) {
        return new GroupMemberCreate(id.toString(), username.toString(), role);
    }
}
