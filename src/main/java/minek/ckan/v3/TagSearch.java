package minek.ckan.v3;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import minek.ckan.v3.enums.State;

import java.util.List;
import java.util.UUID;

@Data
public class TagSearch {
    private int count;
    private List<Tag> results;
}
