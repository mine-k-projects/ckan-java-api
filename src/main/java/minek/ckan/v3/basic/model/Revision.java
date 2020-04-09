package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Revision {
    private UUID id;
    private LocalDateTime timestamp;
    private String message;
    private String author;
    @JsonProperty("approved_timestamp")
    private LocalDateTime approvedTimestamp;
    private List<String> packages;
    private List<String> groups;
}
