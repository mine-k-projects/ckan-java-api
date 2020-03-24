package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PackageRevision {
    private UUID id;
    private LocalDateTime timestamp;
    private String message;
    private String author;
    @SerializedName("approved_timestamp")
    private LocalDateTime approvedTimestamp;
}
