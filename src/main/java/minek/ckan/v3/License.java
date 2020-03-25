package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class License {
    private String status;
    private String maintainer;
    @SerializedName("od_conformance")
    private String odConformance;
    private String family;
    @SerializedName("osd_conformance")
    private String osdConformance;
    @SerializedName("domain_data")
    private boolean domainData;
    private String title;
    private String url;
    @SerializedName("is_generic")
    private boolean isGeneric;
    @SerializedName("is_okd_compliant")
    private boolean isOkdCompliant;
    @SerializedName("is_osi_compliant")
    private boolean isOsiCompliant;
    @SerializedName("domain_content")
    private boolean domainContent;
    @SerializedName("domain_software")
    private boolean domainSoftware;
    private String id;
}
