package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.model.enums.ActivityType;

import java.time.LocalDateTime;
import java.util.UUID;

// https://github.com/ckan/ckan/blob/64af68cb8eb77658b0a56f64dde2a494f8c2aed1/ckan/model/activity.py#L26
@Data
public class Activity {
    private UUID id;
    private LocalDateTime timestamp;
    @JsonProperty("user_id")
    private UUID userId;
    @JsonProperty("object_id")
    private UUID objectId;
    @JsonProperty("revision_id")
    private UUID revisionId;
    @JsonProperty("activity_type")
    private ActivityType activityType;
    @JsonProperty("is_new")
    private Boolean isNew;
    private minek.ckan.v3.basic.model.Data data;
}
