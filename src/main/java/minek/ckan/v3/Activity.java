package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.enums.ActivityObjectType;
import minek.ckan.v3.enums.ActivityType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Activity {
    @JsonProperty("user_id")
    private UUID userId;
    private LocalDateTime timestamp;
    @JsonProperty("object_id")
    private UUID objectId;
    @JsonProperty("revision_id")
    private UUID revisionId;
    private minek.ckan.v3.Data data;
    private UUID id;
    @JsonProperty("activity_type")
    private ActivityType activityType;
    @JsonProperty("activity_id")
    private UUID activityId;
    @JsonProperty("is_new")
    private Boolean isNew;
    @JsonProperty("object_type")
    private ActivityObjectType objectType;
}
