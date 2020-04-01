package minek.ckan.v3.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import minek.ckan.v3.enums.ApprovalStatus;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.GroupType;
import minek.ckan.v3.enums.State;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GroupCreate {

    @NonNull
    private String name;
    private UUID id;
    private String title;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private GroupType type;
    private State state;
    @JsonProperty("approval_status")
    private ApprovalStatus approvalStatus;
    private List<Extra> extras;
    private List<Package> packages;
    private List<Group> groups;
    private List<User> users;

    @Data
    @AllArgsConstructor
    public static class Extra {
        private String key;
        private String value;
        private Boolean deleted;

        public static Extra of(@NonNull String key, String value) {
            return new Extra(key, value, null);
        }

        public static Extra deleteOf(@NonNull String key) {
            return new Extra(key, null, true);
        }
    }

    @Data
    @AllArgsConstructor
    public static class Package {
        private UUID id;
        private String name;
        private Capacity capacity;

        public static Package of(@NonNull UUID id, @NonNull Capacity capacity) {
            return new Package(id, null, capacity);
        }

        public static Package of(@NonNull String name, @NonNull Capacity capacity) {
            return new Package(null, name, capacity);
        }
    }

    @Data
    @AllArgsConstructor
    public static class Group {
        private UUID id;
        private String name;
        private Capacity capacity;

        public static Group of(@NonNull UUID id, @NonNull Capacity capacity) {
            return new Group(id, null, capacity);
        }

        public static Group of(@NonNull String name, @NonNull Capacity capacity) {
            return new Group(null, name, capacity);
        }
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private UUID id;
        private String name;
        private Capacity capacity;

        public static User of(@NonNull UUID id, @NonNull Capacity capacity) {
            return new User(id, null, capacity);
        }

        public static User of(@NonNull String name, @NonNull Capacity capacity) {
            return new User(null, name, capacity);
        }
    }
}
