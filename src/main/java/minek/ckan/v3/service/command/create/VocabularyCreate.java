package minek.ckan.v3.service.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class VocabularyCreate {
    private String name;
    private List<Tag> tags;

    @Data
    @AllArgsConstructor
    public static class Tag {
        private String name;

        public static Tag of(@NonNull String name) {
            return new Tag(name);
        }
    }

    public static VocabularyCreate of(@NonNull String name, List<String> tags) {
        return new VocabularyCreate(name, tags.stream().map(Tag::of).collect(Collectors.toList()));
    }
}
