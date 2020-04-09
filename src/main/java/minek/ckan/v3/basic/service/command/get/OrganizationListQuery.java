package minek.ckan.v3.basic.service.command.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrganizationListQuery extends OrganizationNameListQuery {
    @JsonProperty("all_fields")
    private Boolean allFields = true;

    @JsonProperty("include_dataset_count")
    private Boolean includeDatasetCount;
    @JsonProperty("include_extras")
    private Boolean includeExtras;
    @JsonProperty("include_tags")
    private Boolean includeTags;
    @JsonProperty("include_groups")
    private Boolean includeGroups;
    @JsonProperty("include_users")
    private Boolean includeUsers;

    public void setAllFields(Boolean allFields) {
        // ignore
    }
}
