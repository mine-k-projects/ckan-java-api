package minek.ckan.v3;

import minek.ckan.v3.enums.GroupListSortField;
import minek.ckan.v3.enums.RevisionListSortField;
import minek.ckan.v3.enums.Role;
import minek.ckan.v3.sort.BlankSpaceSort;
import minek.ckan.v3.sort.Sort;
import minek.ckan.v3.sort.UnderscoreSort;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class ActionGetServiceTest extends BaseTest {

    @Test
    void siteRead() throws IOException {
        Call<Boolean> b = action().siteRead();
        Response<Boolean> execute = b.execute();
        Boolean body = execute.body();
        System.out.println();
    }

    @Test
    void packageList() throws IOException {
        Call<List<String>> b = action().packageList();
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void currentPackageListWithResources() throws IOException {
        Call<List<Package>> b = action().currentPackageListWithResources();
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void currentPackageListWithResourcesPaging() throws IOException {
        Call<List<Package>> b = action().currentPackageListWithResources(0, 1);
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void revisionList() throws IOException {
        Call<List<UUID>> b = action().revisionList();
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

    @Test
    void revisionList2() throws IOException {
        Call<List<UUID>> b = action().revisionList(
                null,
                LocalDateTime.of(2020, 3, 24, 0, 0, 0),
                UnderscoreSort.of(RevisionListSortField.time, Sort.Direction.asc)
        );
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

    @Test
    void packageRevisionList() throws IOException {
        Call<List<Revision>> b = action().packageRevisionList(UUID.fromString("020ef7ec-dd66-4e35-9ee6-4d525262dece"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void memberList() throws IOException {
        Call<List<Member>> b = action().memberList(UUID.fromString("e5a22d53-3330-4b7c-9b41-dfd5500fc23a"));
        Response<List<Member>> execute = b.execute();
        List<Member> body = execute.body();
        System.out.println();
    }

    @Test
    void groupNameList() throws IOException {
        Call<List<String>> b = action().groupNameList(null, null, null, null);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void groupList() throws IOException {
        Call<List<Group>> b = action().groupList(
                BlankSpaceSort.of(GroupListSortField.name, Sort.Direction.desc),
                10,
                20,
                null,
                true,
                true,
                true,
                true,
                true);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

    @Test
    void groupListAuthz() throws IOException {
        Call<List<Group>> b = action().groupListAuthz(null, null);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationListForUser() throws IOException {
        Call<List<Group>> b = action().organizationListForUser(null, Role.Member.manage_group, null);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

    @Test
    void groupRevisionList() throws IOException {
        Call<List<Revision>> b = action().groupRevisionList(UUID.fromString("e5a22d53-3330-4b7c-9b41-dfd5500fc23a"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationRevisionList() throws IOException {
        Call<List<Revision>> b = action().organizationRevisionList(UUID.fromString("9dbbdacc-51d1-4f6b-ae61-3e38963bbac3"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void licenseList() throws IOException {
        Call<List<License>> b = action().licenseList();
        Response<List<License>> execute = b.execute();
        List<License> body = execute.body();
        System.out.println();
    }

    @Test
    void tagNameList() throws IOException {
        Call<List<String>> b = action().tagNameList(null, null);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void tagList() throws IOException {
        Call<List<Tag>> b = action().tagList(null, null);
        Response<List<Tag>> execute = b.execute();
        List<Tag> body = execute.body();
        System.out.println();
    }

    @Test
    void packageShow() throws IOException {
        Call<Package> b = action().packageShow("020ef7ec-dd66-4e35-9ee6-4d525262dece", true);
        Response<Package> execute = b.execute();
        Package body = execute.body();
        System.out.println();
    }

    @Test
    void resourceShow() throws IOException {
        Call<Resource> b = action().resourceShow(UUID.fromString("68e80539-c230-460c-aaaa-ff8cdf9fd347"), true);
        Response<Resource> execute = b.execute();
        Resource body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewShow() throws IOException {
        Call<ResourceView> b = action().resourceViewShow(UUID.fromString("b3d08ae1-d9b9-44bc-aeca-0b6f83141abd"));
        Response<ResourceView> execute = b.execute();
        ResourceView body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewList() throws IOException {
        Call<List<ResourceView>> b = action().resourceViewList(UUID.fromString("68e80539-c230-460c-aaaa-ff8cdf9fd347"));
        Response<List<ResourceView>> execute = b.execute();
        List<ResourceView> body = execute.body();
        System.out.println();
    }

    @Test
    void revisionShow() throws IOException {
        Call<Revision> b = action().revisionShow(UUID.fromString("4df1cb61-f0c9-4981-b3e2-717ed57e6ead"));
        Response<Revision> execute = b.execute();
        Revision body = execute.body();
        System.out.println();
    }

    @Test
    void groupShow() throws IOException {
        Call<Group> b = action().groupShow("2aa1fb99-27f9-4b0b-93df-de3793dbfe6c", true);
        Response<Group> execute = b.execute();
        Group body = execute.body();
        System.out.println();
    }

    @Test
    void organizationShow() throws IOException {
        Call<Group> b = action().organizationShow("9dbbdacc-51d1-4f6b-ae61-3e38963bbac3", true);
        Response<Group> execute = b.execute();
        Group body = execute.body();
        System.out.println();
    }

    @Test
    void groupPackageShow() throws IOException {
        Call<List<Package>> b = action().groupPackageShow("2aa1fb99-27f9-4b0b-93df-de3793dbfe6c", 10);
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void tagShow() throws IOException {
        Call<Tag> b = action().tagShow("0f0d9b61-b103-486c-bbd7-bec98bfcf406", null, true);
        Response<Tag> execute = b.execute();
        Tag body = execute.body();
        System.out.println();
    }

    @Test
    void userShow() throws IOException {
        Call<User> b = action().userShow("allbegray", true, true, true);
        Response<User> execute = b.execute();
        User body = execute.body();
        System.out.println();
    }

    @Test
    void packageAutocomplete() throws IOException {
        Call<List<PackageAutocomplete>> b = action().packageAutocomplete("test", 10);
        Response<List<PackageAutocomplete>> execute = b.execute();
        List<PackageAutocomplete> body = execute.body();
        System.out.println();
    }

    @Test
    void formatAutocomplete() throws IOException {
        Call<List<String>> b = action().formatAutocomplete("csv", 10);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void userAutocomplete() throws IOException {
        Call<List<UserAutocomplete>> b = action().userAutocomplete("te", 10);
        Response<List<UserAutocomplete>> execute = b.execute();
        List<UserAutocomplete> body = execute.body();
        System.out.println();
    }

    @Test
    void groupAutocomplete() throws IOException {
        Call<List<GroupAutocomplete>> b = action().groupAutocomplete("te", 10);
        Response<List<GroupAutocomplete>> execute = b.execute();
        List<GroupAutocomplete> body = execute.body();
        System.out.println();
    }

    @Test
    void packageSearch() throws IOException {
        Call<PackageSearch> b = action().packageSearch(
                "test",
                "tags:test",
                null,
                100,
                0,
                null,
                null,
                null,
                "[\"tags\"]",
                true,
                true,
                true);
        Response<PackageSearch> execute = b.execute();
        PackageSearch body = execute.body();
        System.out.println();
    }

    @Test
    void resourceSearch() throws IOException {
        Call<ResourceSearch> b = action().resourceSearch(
                "name:test",
                null,
                null,
                0,
                10);
        Response<ResourceSearch> execute = b.execute();
        ResourceSearch body = execute.body();
        System.out.println();
    }

    @Test
    void tagSearch() throws IOException {
        Call<TagSearch> b = action().tagSearch(
                "test",
                null,
                null,
                0,
                10);
        Response<TagSearch> execute = b.execute();
        TagSearch body = execute.body();
        System.out.println();
    }

    @Test
    void tagAutocomplete() throws IOException {
        Call<List<String>> b = action().tagAutocomplete(
                "test",
                null,
                null,
                0,
                10);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void statusShow() throws IOException {
        Call<SiteStatus> b = action().statusShow();
        Response<SiteStatus> execute = b.execute();
        SiteStatus body = execute.body();
        System.out.println();
    }

    @Test
    void userActivityList() throws IOException {
        Call<List<Activity>> b = action().userActivityList("allbegray", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void packageActivityList() throws IOException {
        Call<List<Activity>> b = action().packageActivityList("test", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void groupActivityList() throws IOException {
        Call<List<Activity>> b = action().groupActivityList("test", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationActivityList() throws IOException {
        Call<List<Activity>> b = action().organizationActivityList("mine-k", 0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void recentlyChangedPackagesActivityList() throws IOException {
        Call<List<Activity>> b = action().recentlyChangedPackagesActivityList(0, 10);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void activityDetailList_package() throws IOException {
        Call<List<Activity>> b = action().activityDetailList(UUID.fromString("4d094867-5311-4b9c-b1ce-9c5d94a26af0"));
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void activityDetailList_resources() throws IOException {
        Call<List<Activity>> b = action().activityDetailList(UUID.fromString("cac31002-ca56-4a7f-96cb-ffe8ce2e1263"));
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println();
    }

    @Test
    void userActivityListHtml() throws IOException {
        Call<String> b = action().userActivityListHtml("allbegray", 0, 10);
        Response<String> execute = b.execute();
        String body = execute.body();
        System.out.println(body);
    }

    @Test
    void organizationFolloweeList() throws IOException {
        Call<List<Group>> b = action().organizationFolloweeList("allbegray");
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println(body);
    }

    @Test
    void dashboardActivityList() throws IOException {
        Call<List<Activity>> b = action().dashboardActivityList(0, 100);
        Response<List<Activity>> execute = b.execute();
        List<Activity> body = execute.body();
        System.out.println(body);
    }


}