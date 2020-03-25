package minek.ckan.v3;

import minek.ckan.v3.enums.*;
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
        Call<List<UUID>> b = action().revisionList(null, LocalDateTime.of(2020, 3, 24, 0, 0, 0), Sort.of(RevisionListSortField.time, Sort.Direction.asc));
        Response<List<UUID>> execute = b.execute();
        List<UUID> body = execute.body();
        System.out.println();
    }

    @Test
    void packageRevisionList() throws IOException {
        Call<List<PackageRevision>> b = action().packageRevisionList(UUID.fromString("020ef7ec-dd66-4e35-9ee6-4d525262dece"));
        Response<List<PackageRevision>> execute = b.execute();
        List<PackageRevision> body = execute.body();
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
        Call<List<Group>> b = action().groupList(Sort.desc(GroupListSortField.name), 10, 20, null, true, true, true, true,true);
        Response<List<Group>> execute = b.execute();
        List<Group> body = execute.body();
        System.out.println();
    }

}