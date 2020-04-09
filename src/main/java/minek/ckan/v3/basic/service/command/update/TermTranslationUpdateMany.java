package minek.ckan.v3.basic.service.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.basic.model.TermTranslation;

import java.util.List;

@Data
@AllArgsConstructor
public class TermTranslationUpdateMany {
    private List<TermTranslation> data;

    public static TermTranslationUpdateMany of(List<TermTranslation> data) {
        return new TermTranslationUpdateMany(data);
    }
}
