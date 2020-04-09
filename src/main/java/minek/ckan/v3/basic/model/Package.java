package minek.ckan.v3.basic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.basic.model.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Package {

    @JsonProperty("license_title")
    private String licenseTitle;
    private String maintainer;
    @JsonProperty("relationships_as_object")
    private List<String> relationshipsAsObject;
    @JsonProperty("private")
    private boolean private_;
    @JsonProperty("maintainer_email")
    private String maintainerEmail;
    @JsonProperty("num_tags")
    private int numTags;
    private UUID id;
    @JsonProperty("metadata_created")
    private LocalDateTime metadataCreated;
    @JsonProperty("metadata_modified")
    private LocalDateTime metadataModified;
    private String author;
    @JsonProperty("author_email")
    private String authorEmail;
    private State state;
    private String version;
    @JsonProperty("creator_user_id")
    private UUID creatorUserId;
    private String type;
    private List<Resource> resources;
    @JsonProperty("num_resources")
    private int numResources;
    private List<Tag> tags;
    private List<Group> groups;
    @JsonProperty("license_id")
    private String licenseId;
    @JsonProperty("relationships_as_subject")
    private List<String> relationshipsAsSubject;
    private Group organization;
    private String name;
    private boolean isopen;
    private String url;
    private String notes;
    @JsonProperty("owner_org")
    private UUID ownerOrg;
    private List<Extra> extras;
    @JsonProperty("license_url")
    private String licenseUrl;
    private String title;
    @JsonProperty("revision_id")
    private UUID revisionId;
    @JsonProperty("tracking_summary")
    private TrackingSummary trackingSummary;
}
