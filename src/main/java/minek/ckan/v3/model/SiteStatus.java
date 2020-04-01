package minek.ckan.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SiteStatus {
    @JsonProperty("ckan_version")
    private String ckanVersion;
    @JsonProperty("site_url")
    private String siteUrl;
    @JsonProperty("site_description")
    private String siteDescription;
    @JsonProperty("site_title")
    private String siteTitle;
    @JsonProperty("error_emails_to")
    private String errorEmailsTo;
    @JsonProperty("locale_default")
    private String localeDefault;
    private List<String> extensions;
}
