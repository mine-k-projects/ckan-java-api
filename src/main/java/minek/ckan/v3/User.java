package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class User {
    @SerializedName("email_hash")
    private String emailHash;
    private String about;
    private List<Package> datasets;
    private Capacity capacity;
    private String name;
    private LocalDateTime created;
    private boolean sysadmin;
    @SerializedName("activity_streams_email_notifications")
    private boolean activityStreamsEmailNotifications;
    private State state;
    @SerializedName("number_of_edits")
    private int numberOfEdits;
    @SerializedName("display_name")
    private String displayName;
    private String fullname;
    private UUID id;
    @SerializedName("num_followers")
    private Integer numFollowers;
    @SerializedName("number_created_packages")
    private int numberCreatedPackages;
}
