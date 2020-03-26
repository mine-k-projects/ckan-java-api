package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SiteStatus {
    @SerializedName("ckan_version")
    private String ckanVersion;
    @SerializedName("site_url")
    private String siteUrl;
    @SerializedName("site_description")
    private String siteDescription;
    @SerializedName("site_title")
    private String siteTitle;
    @SerializedName("error_emails_to")
    private String errorEmailsTo;
    @SerializedName("locale_default")
    private String localeDefault;
    private List<String> extensions;
}
