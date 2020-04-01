package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DeleteServiceTest extends BaseTest {

    @Test
    public void unfollow_group() throws IOException {
        Void body = groupService().unfollowGroup("mine-k").execute().body();
        System.out.println();
    }
}
