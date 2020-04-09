package minek.ckan.v3.basic.service.command.delete;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GroupMemberDelete {
    private String id;
    private String username;

    public static GroupMemberDelete of(UUID id, UUID username) {
        return new GroupMemberDelete(id.toString(), username.toString());
    }

    public static GroupMemberDelete of(UUID id, String username) {
        return new GroupMemberDelete(id.toString(), username);
    }

    public static GroupMemberDelete of(String id, String username) {
        return new GroupMemberDelete(id, username);
    }
}
