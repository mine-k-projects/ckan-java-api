package minek.ckan.v3.service;

import minek.ckan.v3.Package;
import minek.ckan.v3.*;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PackageServiceTest extends BaseTest {

    @Test
    void packageList() throws IOException {
        Call<List<String>> b = packageService().packageList();
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void currentPackageListWithResources() throws IOException {
        Call<List<Package>> b = packageService().currentPackageListWithResources();
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void currentPackageListWithResourcesPaging() throws IOException {
        Call<List<Package>> b = packageService().currentPackageListWithResources(0, 1);
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void packageRevisionList() throws IOException {
        Call<List<Revision>> b = packageService().packageRevisionList(UUID.fromString("020ef7ec-dd66-4e35-9ee6-4d525262dece"));
        Response<List<Revision>> execute = b.execute();
        List<Revision> body = execute.body();
        System.out.println();
    }

    @Test
    void packageShow() throws IOException {
        Call<Package> b = packageService().packageShow("020ef7ec-dd66-4e35-9ee6-4d525262dece", true);
        Response<Package> execute = b.execute();
        Package body = execute.body();
        System.out.println();
    }

    @Test
    void resourceShow() throws IOException {
        Call<Resource> b = packageService().resourceShow(UUID.fromString("68e80539-c230-460c-aaaa-ff8cdf9fd347"), true);
        Response<Resource> execute = b.execute();
        Resource body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewShow() throws IOException {
        Call<ResourceView> b = packageService().resourceViewShow(UUID.fromString("b3d08ae1-d9b9-44bc-aeca-0b6f83141abd"));
        Response<ResourceView> execute = b.execute();
        ResourceView body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewList() throws IOException {
        Call<List<ResourceView>> b = packageService().resourceViewList(UUID.fromString("68e80539-c230-460c-aaaa-ff8cdf9fd347"));
        Response<List<ResourceView>> execute = b.execute();
        List<ResourceView> body = execute.body();
        System.out.println();
    }

    @Test
    void packageSearch() throws IOException {
        Call<PackageSearch> b = packageService().packageSearch(
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
        Call<ResourceSearch> b = packageService().resourceSearch(
                "name:test",
                null,
                null,
                0,
                10);
        Response<ResourceSearch> execute = b.execute();
        ResourceSearch body = execute.body();
        System.out.println();
    }

}
