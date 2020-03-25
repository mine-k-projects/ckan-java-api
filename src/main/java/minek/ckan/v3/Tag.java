package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.util.List;
import java.util.UUID;

@Data
public class Tag {
    @SerializedName("vocabulary_id")
    private UUID vocabularyId;
    private State state;
    @SerializedName("display_name")
    private String displayName;
    private UUID id;
    private String name;
    private List<Package> packages;
}
