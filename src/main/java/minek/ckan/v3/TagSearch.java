package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TagSearch {
    private int count;
    private List<Tag> results;

    @Data
    public static class Tag {
        @SerializedName("vocabulary_id")
        private UUID vocabularyId;
        private UUID id;
        private String name;
    }
}
