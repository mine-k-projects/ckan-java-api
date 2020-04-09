package minek.ckan.v3.basic.service.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class FollowUser {
    private String id;

    public static FollowUser of(UUID id) {
        return new FollowUser(id.toString());
    }

    public static FollowUser of(String name) {
        return new FollowUser(name);
    }
}
