package minek.ckan.v3.basic.service.command.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.service.command.get.sort.Direction;
import minek.ckan.v3.basic.service.command.get.sort.Sort;

import java.util.List;

@Data
public class GroupNameListQuery {
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("groups")
    private List<String> groups;
    @JsonProperty("all_fields")
    private Boolean allFields = false;

    public void setSort(Sort sort) {
        this.sort = sort.getField() + " " + sort.getDirection();
    }

    public void setSort(GroupSortField field, Direction direction) {
        this.sort = field + " " + direction;
    }

    public void setAllFields(Boolean allFields) {
        // ignore
    }
}
