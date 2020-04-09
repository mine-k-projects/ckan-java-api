package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

// https://github.com/ckan/ckan/blob/0adbdd778a7569854d74e45f1fc147c2fe26d8d4/ckan/model/task_status.py
public class TaskStatus {
    private UUID id;
    @JsonProperty("entity_id")
    private String entityId;
    @JsonProperty("entity_type")
    private String entityType;
    @JsonProperty("task_type")
    private String taskType;
    private String key;
    private String value;
    private String state;
    private String error;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
