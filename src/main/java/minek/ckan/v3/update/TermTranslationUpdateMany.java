package minek.ckan.v3.update;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TermTranslationUpdateMany {
    private List<TermTranslationUpdate> data;

    public static TermTranslationUpdateMany of(List<TermTranslationUpdate> data) {
        return new TermTranslationUpdateMany(data);
    }
}
