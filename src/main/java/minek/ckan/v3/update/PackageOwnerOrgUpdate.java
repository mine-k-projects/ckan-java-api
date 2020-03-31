package minek.ckan.v3.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

// https://github.com/ckan/ckan/blob/master/ckan/logic/action/update.py#L981
// https://github.com/ckan/ckan/blob/master/ckan/logic/action/update.py#L989
// 매뉴얼에 organizationId 는 id, name 으로 적혀 있지만 실제 코드는 id 만 사용하는거 같은데??
@Data
@AllArgsConstructor
public class PackageOwnerOrgUpdate {
    private String id;
    @JsonProperty("organization_id")
    private String organizationId;

    public static PackageOwnerOrgUpdate of(UUID id, UUID organizationId) {
        return new PackageOwnerOrgUpdate(id.toString(), organizationId.toString());
    }

    public static PackageOwnerOrgUpdate of(UUID id, String organizationId) {
        return new PackageOwnerOrgUpdate(id.toString(), organizationId);
    }

    public static PackageOwnerOrgUpdate of(String id, String organizationId) {
        return new PackageOwnerOrgUpdate(id, organizationId);
    }
}