package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class License {
    private String status;
    private String maintainer;
    @JsonProperty("od_conformance")
    private String odConformance;
    private String family;
    @JsonProperty("osd_conformance")
    private String osdConformance;
    @JsonProperty("domain_data")
    private boolean domainData;
    private String title;
    private String url;
    @JsonProperty("is_generic")
    private boolean isGeneric;
    @JsonProperty("is_okd_compliant")
    private boolean isOkdCompliant;
    @JsonProperty("is_osi_compliant")
    private boolean isOsiCompliant;
    @JsonProperty("domain_content")
    private boolean domainContent;
    @JsonProperty("domain_software")
    private boolean domainSoftware;
    private String id;
}
