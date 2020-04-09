package minek.ckan.v3.basic.service.command.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.service.command.get.sort.Direction;
import minek.ckan.v3.basic.service.command.get.sort.Sort;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SiteRevisionListQuery {
    @JsonProperty("since_id")
    private UUID sinceId;
    @JsonProperty("since_time")
    private LocalDateTime sinceTime;
    private String sort;

    public void setSort(Sort sort) {
        this.sort = sort.getField() + "_" + sort.getDirection();
    }

    public void setSort(RevisionSortField field, Direction direction) {
        this.sort = field + "_" + direction;
    }

    public enum RevisionSortField {
        time
    }
}