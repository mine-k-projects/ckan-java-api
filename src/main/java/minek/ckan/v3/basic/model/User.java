package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.model.enums.Capacity;
import minek.ckan.v3.basic.model.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class User {
    @JsonProperty("email_hash")
    private String emailHash;
    private String about;
    private List<Package> datasets;
    private Capacity capacity;
    private String name;
    private LocalDateTime created;
    private boolean sysadmin;
    @JsonProperty("activity_streams_email_notifications")
    private boolean activityStreamsEmailNotifications;
    private State state;
    @JsonProperty("number_of_edits")
    private int numberOfEdits;
    @JsonProperty("display_name")
    private String displayName;
    private String fullname;
    private UUID id;
    @JsonProperty("num_followers")
    private Integer numFollowers;
    @JsonProperty("number_created_packages")
    private int numberCreatedPackages;
    private String apikey;
    private String email;
}
