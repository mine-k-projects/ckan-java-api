package minek.ckan.v3.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BulkUpdate {
    @JsonProperty("org_id")
    private UUID orgId;
    private List<UUID> datasets;

    public static BulkUpdate of(UUID orgId, List<UUID> datasets) {
        return new BulkUpdate(orgId, datasets);
    }

}
