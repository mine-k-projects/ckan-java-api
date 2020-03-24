package minek.ckan.v3;

import minek.ckan.v3.enums.Sort;
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
        Call<List<UUID>> b = action().revisionList(null, LocalDateTime.of(2020, 3, 24, 0, 0, 0), Sort.time_desc);
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


}