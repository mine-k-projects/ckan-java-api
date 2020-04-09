package minek.ckan.v3.basic.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.basic.model.Group;
import minek.ckan.v3.basic.model.Package;
import minek.ckan.v3.basic.model.User;
import minek.ckan.v3.basic.model.enums.GroupType;
import minek.ckan.v3.basic.model.enums.Role;
import minek.ckan.v3.basic.service.command.create.GroupCreate;
import minek.ckan.v3.basic.service.command.get.GroupListQuery;
import minek.ckan.v3.basic.service.command.get.GroupNameListQuery;
import minek.ckan.v3.basic.service.command.get.GroupSortField;
import minek.ckan.v3.basic.service.command.get.OrganizationNameListQuery;
import minek.ckan.v3.basic.service.command.get.sort.Direction;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GroupServiceTest extends BaseTest {

    @Test
    void groupCreate() throws IOException {
        GroupCreate groupCreate = GroupCreate.builder()
                .name("test-group")
                .type(GroupType.group)
                .build();

        Call<Group> b = groupService().groupCreate(groupCreate);
        Response<Group> execute = b.execute();
        Group body = execute.body();
        System.out.println();
    }

    @Test
    void groupFollowerCount() throws IOException {
        Call<Integer> b = groupService().groupFollowerCount("test-group");
        Response<Integer> execute = b.execute();
        Integer body = execute.body();
        System.out.println();
    }

    @Test
    void groupFollowerList() throws IOException {
        Call<List<User>> b = groupService().groupFollowerList("test-group");
        Response<List<User>> execute = b.execute();
        List<User> body = execute.body();
        System.out.println();
    }

    @Test
    void groupNameList() throws IOException {
        GroupNameListQuery query = new GroupNameListQuery();

        Call<List<String>> b = groupService().groupNameList(query);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void groupNameList2() throws IOException {
        GroupNameListQuery query = new GroupNameListQuery();
        query.setGroups(Arrays.asList("wine", "miso123"));

        Call<List<String>> b = groupService().groupNameList(query);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void groupList() throws IOException {
        GroupListQuery query = new GroupListQuery();
        query.setSort(GroupSortField.name, Direction.desc);
        query.setOffset(0);
        query.setLimit(20);

        Call<List<Group>> b = groupService().groupList(query);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

    @Test
    void groupListAuthz() throws IOException {
        Call<List<Group>> b = groupService().groupListAuthz(null, null);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationNameList() throws IOException {
        OrganizationNameListQuery query = new OrganizationNameListQuery();
        query.setOrganizations(Arrays.asList("misoinfo", "hahaha"));

        Call<List<String>> b = groupService().organizationNameList(query);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void organizationListForUser() throws IOException {
        Call<List<Group>> b = groupService().organizationListForUser(null, Role.Permission.manage_group, null);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

    @Test
    void groupShow() throws IOException {
        Call<Group> b = groupService().groupShow("2aa1fb99-27f9-4b0b-93df-de3793dbfe6c", true);
        Response<Group> execute = b.execute();
        Group body = execute.body();
        System.out.println();
    }

    @Test
    void organizationShow() throws IOException {
        Call<Group> b = groupService().organizationShow("9dbbdacc-51d1-4f6b-ae61-3e38963bbac3", true);
        Response<Group> execute = b.execute();
        Group body = execute.body();
        System.out.println();
    }

    @Test
    void groupPackageShow() throws IOException {
        Call<List<Package>> b = groupService().groupPackageShow("2aa1fb99-27f9-4b0b-93df-de3793dbfe6c", 10);
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

}
