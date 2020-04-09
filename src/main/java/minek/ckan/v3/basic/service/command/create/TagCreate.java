package minek.ckan.v3.basic.service.command.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TagCreate {
    @NonNull
    private String name;
    @JsonProperty("vocabulary_id")
    private UUID vocabularyId;

    public static TagCreate of(@NonNull String name) {
        return new TagCreate(name, null);
    }

    public static TagCreate of(@NonNull String name, UUID vocabularyId) {
        return new TagCreate(name, vocabularyId);
    }
}
