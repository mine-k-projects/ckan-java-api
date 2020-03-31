package minek.ckan.v3.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TermTranslationUpdate {
    private String term;
    @JsonProperty("term_translation")
    private String termTranslation;
    @JsonProperty("lang_code")
    private String langCode;

    public static TermTranslationUpdate of(String term, String termTranslation, String langCode) {
        return new TermTranslationUpdate(term, termTranslation, langCode);
    }
}
