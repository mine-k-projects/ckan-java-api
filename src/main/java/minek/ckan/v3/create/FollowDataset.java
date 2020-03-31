package minek.ckan.v3.create;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class FollowDataset {
    private String id;

    public static FollowDataset of(UUID id) {
        return new FollowDataset(id.toString());
    }

    public static FollowDataset of(String name) {
        return new FollowDataset(name);
    }
}
