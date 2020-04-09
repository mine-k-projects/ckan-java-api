package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Follower {
    @JsonProperty("follower_id")
    private UUID followerId;
    @JsonProperty("object_id")
    private UUID objectId;
    private LocalDateTime datetime;
}
