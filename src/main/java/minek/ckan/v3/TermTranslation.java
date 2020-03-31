package minek.ckan.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

// https://github.com/ckan/ckan/blob/ef103f02292e0b50fbe7edc6a9e07f70d2fb9f45/ckan/model/term_translation.py
@Data
@AllArgsConstructor
public class TermTranslation {
    private String term;
    @JsonProperty("term_translation")
    private String termTranslation;
    @JsonProperty("lang_code")
    private String langCode;

    public static TermTranslation of(String term, String termTranslation, String langCode) {
        return new TermTranslation(term, termTranslation, langCode);
    }
}
