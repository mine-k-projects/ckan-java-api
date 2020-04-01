package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.enums.ActivityObjectType;
import minek.ckan.v3.enums.ActivityType;

import java.util.UUID;

// https://github.com/ckan/ckan/blob/64af68cb8eb77658b0a56f64dde2a494f8c2aed1/ckan/model/activity.py#L38
@Data
public class ActivityDetail {
    private UUID id;
    @JsonProperty("activity_id")
    private UUID activityId;
    @JsonProperty("object_id")
    private UUID objectId;
    @JsonProperty("object_type")
    private ActivityObjectType objectType;
    @JsonProperty("activity_type")
    private ActivityType activityType;
    private minek.ckan.v3.Data data;
}
