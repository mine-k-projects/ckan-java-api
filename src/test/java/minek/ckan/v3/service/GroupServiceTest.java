package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.Group;
import minek.ckan.v3.Package;
import minek.ckan.v3.enums.GroupListSortField;
import minek.ckan.v3.enums.Role;
import minek.ckan.v3.sort.BlankSpaceSort;
import minek.ckan.v3.sort.Sort;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class GroupServiceTest extends BaseTest {

    @Test
    void groupNameList() throws IOException {
        Call<List<String>> b = groupService().groupNameList(null, null, null, null);
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void groupList() throws IOException {
        Call<List<Group>> b = groupService().groupList(
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
        Call<List<Group>> b = groupService().groupListAuthz(null, null);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
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
