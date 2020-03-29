package minek.ckan.v3.service;

import minek.ckan.v3.*;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class UserServiceTest extends BaseTest {

    @Test
    void memberList() throws IOException {
        Call<List<Member>> b = userService().memberList("e5a22d53-3330-4b7c-9b41-dfd5500fc23a");
        Response<List<Member>> execute = b.execute();
        List<Member> body = execute.body();
        System.out.println();
    }

    @Test
    void userShow() throws IOException {
        Call<User> b = userService().userShow("allbegray", true, true, true);
        Response<User> execute = b.execute();
        User body = execute.body();
        System.out.println();
    }

    @Test
    void organizationFolloweeList() throws IOException {
        Call<List<Group>> b = userService().organizationFolloweeList("allbegray");
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println(body);
    }

    @Test
    void followeeList() throws IOException {
        final User user = userService().userShow("allbegray", true, true, true).execute().body();
        assert user != null;

        final List<Followee> followeeList = userService().followeeList(user.getId()).execute().body();
        assert followeeList != null;

        System.out.println();
    }

}
