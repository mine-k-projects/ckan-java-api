package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Package {

    @SerializedName("license_title")
    private String licenseTitle;
    private String maintainer;
    @SerializedName("relationships_as_object")
    private List<String> relationshipsAsObject;
    @SerializedName("private")
    private boolean isPrivate;
    @SerializedName("maintainer_email")
    private String maintainerEmail;
    @SerializedName("num_tags")
    private int numTags;
    private UUID id;
    @SerializedName("metadata_created")
    private LocalDateTime metadataCreated;
    @SerializedName("metadata_modified")
    private LocalDateTime metadataModified;
    private String author;
    @SerializedName("author_email")
    private String authorEmail;
    private State state;
    private String version;
    @SerializedName("creator_user_id")
    private UUID creatorUserId;
    private String type;
    private List<Resource> resources;
    @SerializedName("num_resources")
    private int numResources;
    @SerializedName("tracking_summary")
    private TrackingSummary trackingSummary;
    private List<Tag> tags;
    private List<Group> groups;
    @SerializedName("license_id")
    private String licenseId;
    @SerializedName("relationships_as_subject")
    private List<String> relationshipsAsSubject;
    private Organization organization;
    private String name;
    private boolean isopen;
    private String url;
    private String notes;
    @SerializedName("owner_org")
    private UUID ownerOrg;
    private List<Extra> extras;
    @SerializedName("license_url")
    private String licenseUrl;
    private String title;
    @SerializedName("revision_id")
    private UUID revisionId;

}
