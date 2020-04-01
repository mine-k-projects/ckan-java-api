package minek.ckan.v3.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import minek.ckan.v3.enums.ActivityType;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ActivityCreate {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("object_id")
    private String objectId;
    @JsonProperty("activity_type")
    private ActivityType activityType;
    private Map<String, Object> data;

    public static ActivityCreate of(@NonNull String userId, @NonNull String objectId, @NonNull ActivityType activityType, Map<String, Object> data) {
        return new ActivityCreate(userId, objectId, activityType, data);
    }

    public static ActivityCreate of(@NonNull String userId, @NonNull UUID objectId, @NonNull ActivityType activityType, Map<String, Object> data) {
        return new ActivityCreate(userId, objectId.toString(), activityType, data);
    }

    public static ActivityCreate of(@NonNull UUID userId, @NonNull String objectId, @NonNull ActivityType activityType, Map<String, Object> data) {
        return new ActivityCreate(userId.toString(), objectId, activityType, data);
    }

    public static ActivityCreate of(@NonNull UUID userId, @NonNull UUID objectId, @NonNull ActivityType activityType, Map<String, Object> data) {
        return new ActivityCreate(userId.toString(), objectId.toString(), activityType, data);
    }
}
