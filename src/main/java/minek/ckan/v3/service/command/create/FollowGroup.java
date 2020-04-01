package minek.ckan.v3.service.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class FollowGroup {
    private String id;

    public static FollowGroup of(UUID id) {
        return new FollowGroup(id.toString());
    }

    public static FollowGroup of(String name) {
        return new FollowGroup(name);
    }
}
