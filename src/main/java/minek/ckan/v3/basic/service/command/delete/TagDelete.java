package minek.ckan.v3.basic.service.command.delete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TagDelete {
    private String id;
    @JsonProperty("vocabulary_id")
    private String vocabularyId;

    public static TagDelete of(UUID id) {
        return new TagDelete(id.toString(), null);
    }

    public static TagDelete of(String id) {
        return new TagDelete(id, null);
    }

    public static TagDelete of(UUID id, UUID vocabularyId) {
        return new TagDelete(id.toString(), vocabularyId.toString());
    }

    public static TagDelete of(UUID id, String vocabularyId) {
        return new TagDelete(id.toString(), vocabularyId);
    }

    public static TagDelete of(String id, String vocabularyId) {
        return new TagDelete(id, vocabularyId);
    }
}
