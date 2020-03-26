package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserFollowee {
    @SerializedName("email_hash")
    private String emailHash;
    private String about;
    @SerializedName("display_name")
    private String displayName;
    private String name;
    private LocalDateTime created;
    private UUID id;
    private boolean sysadmin;
    @SerializedName("activity_streams_email_notifications")
    private boolean activityStreamsEmailNotifications;
    private State state;
    @SerializedName("number_of_edits")
    private int numberOfEdits;
    private String fullname;
    @SerializedName("number_created_packages")
    private int numberCreatedPackages;
}