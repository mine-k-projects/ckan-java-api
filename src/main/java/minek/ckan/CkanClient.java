package minek.ckan;

import minek.ckan.v3.service.*;
import retrofit2.Retrofit;

public class CkanClient {

    private Retrofit retrofit;

    public CkanClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public ActivityService activityService() {
        return retrofit.create(ActivityService.class);
    }

    public AutocompleteService autocompleteService() {
        return retrofit.create(AutocompleteService.class);
    }

    public DatasetService datasetService() {
        return retrofit.create(DatasetService.class);
    }

    public GroupService groupService() {
        return retrofit.create(GroupService.class);
    }

    public MemberService memberService() {
        return retrofit.create(MemberService.class);
    }

    public RevisionService revisionService() {
        return retrofit.create(RevisionService.class);
    }

    public SiteService siteService() {
        return retrofit.create(SiteService.class);
    }

    public TagService tagService() {
        return retrofit.create(TagService.class);
    }

    public UserService userService() {
        return retrofit.create(UserService.class);
    }
}
