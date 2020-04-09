package minek.ckan.v3.basic.service.command.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RatingCreate {
    @JsonProperty("package")
    private String package_;
    private int rating;

    public static RatingCreate of(UUID packageId, int rating) {
        return new RatingCreate(packageId.toString(), rating);
    }

    public static RatingCreate of(String packageName, int rating) {
        return new RatingCreate(packageName, rating);
    }
}
