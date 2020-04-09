package minek.ckan.v3.basic.service.command.delete;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrganizationMemberDelete {
    private String id;
    private String username;

    public static OrganizationMemberDelete of(UUID id, UUID username) {
        return new OrganizationMemberDelete(id.toString(), username.toString());
    }

    public static OrganizationMemberDelete of(UUID id, String username) {
        return new OrganizationMemberDelete(id.toString(), username);
    }

    public static OrganizationMemberDelete of(String id, String username) {
        return new OrganizationMemberDelete(id, username);
    }
}
