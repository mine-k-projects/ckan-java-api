package minek.ckan.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import minek.ckan.v3.model.enums.FolloweeType;

/**
 * type = dataset ? dict
 */
@Data
public abstract class Followee<T> {
    @JsonProperty("display_name")
    private String displayName;
    private FolloweeType type;
    private T dict;

    // type에 따라 3가지 형태를 가진다.
    // type = dataset ? Package
    // User(type = user), Group(User array)(type = group or organization)

    public static FolloweeUser of(String displayName, FolloweeType type, User dict) {
        final FolloweeUser followee = new FolloweeUser();
        followee.setDisplayName(displayName);
        followee.setType(type);
        followee.setDict(dict);
        return followee;
    }

    public static FolloweePackage of(String displayName, FolloweeType type, Package dict) {
        final FolloweePackage followee = new FolloweePackage();
        followee.setDisplayName(displayName);
        followee.setType(type);
        followee.setDict(dict);
        return followee;
    }

    public static FolloweeGroup of(String displayName, FolloweeType type, Group dict) {
        final FolloweeGroup followee = new FolloweeGroup();
        followee.setDisplayName(displayName);
        followee.setType(type);
        followee.setDict(dict);
        return followee;
    }

    public static class FolloweeUser extends Followee<User> {
        private FolloweeUser() {
        }
    }

    public static class FolloweePackage extends Followee<Package> {
        private FolloweePackage() {
        }
    }

    public static class FolloweeGroup extends Followee<Group> {
        private FolloweeGroup() {
        }
    }
}
