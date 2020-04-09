package minek.ckan.v3.basic.service.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ResourceViewReorder {
    private UUID id;
    private List<UUID> order;

    public static ResourceViewReorder of(UUID id, List<UUID> order) {
        return new ResourceViewReorder(id, order);
    }
}
