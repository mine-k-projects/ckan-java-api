package minek.ckan.v3.service.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PackageResourceReorder {
    private String id;
    private List<UUID> order;

    public static PackageResourceReorder of(String id, List<UUID> order) {
        return new PackageResourceReorder(id, order);
    }

    public static PackageResourceReorder of(UUID id, List<UUID> order) {
        return new PackageResourceReorder(id.toString(), order);
    }
}
