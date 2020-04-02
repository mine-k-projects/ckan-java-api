package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.model.Package;
import minek.ckan.v3.model.*;
import minek.ckan.v3.service.command.get.PackageSearchQuery;
import minek.ckan.v3.service.command.get.ResourceSearchQuery;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DatasetServiceTest extends BaseTest {

    @Test
    void packageList() throws IOException {
        Call<List<String>> b = datasetService().packageList();
        Response<List<String>> execute = b.execute();
        List<String> body = execute.body();
        System.out.println();
    }

    @Test
    void currentPackageListWithResources() throws IOException {
        Call<List<Package>> b = datasetService().currentPackageListWithResources();
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void currentPackageListWithResourcesPaging() throws IOException {
        Call<List<Package>> b = datasetService().currentPackageListWithResources(0, 1);
        Response<List<Package>> execute = b.execute();
        List<Package> body = execute.body();
        System.out.println();
    }

    @Test
    void packageRelationshipsList() throws IOException {
        final List<String> packageIdList = datasetService().packageList().execute().body();
        assert packageIdList != null;
        if (packageIdList.size() < 2)
            return;

        List<PackageRelationship> relationshipsList = datasetService().packageRelationshipsList(packageIdList.get(0), packageIdList.get(1)).execute().body();
        System.out.println();
    }

    @Test
    void packageShow() throws IOException {
        Call<Package> b = datasetService().packageShow("020ef7ec-dd66-4e35-9ee6-4d525262dece", true);
        Response<Package> execute = b.execute();
        Package body = execute.body();
        System.out.println();
    }

    @Test
    void resourceShow() throws IOException {
        Call<Resource> b = datasetService().resourceShow(UUID.fromString("68e80539-c230-460c-aaaa-ff8cdf9fd347"), true);
        Response<Resource> execute = b.execute();
        Resource body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewShow() throws IOException {
        Call<ResourceView> b = datasetService().resourceViewShow(UUID.fromString("b3d08ae1-d9b9-44bc-aeca-0b6f83141abd"));
        Response<ResourceView> execute = b.execute();
        ResourceView body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewList() throws IOException {
        Call<List<ResourceView>> b = datasetService().resourceViewList(UUID.fromString("68e80539-c230-460c-aaaa-ff8cdf9fd347"));
        Response<List<ResourceView>> execute = b.execute();
        List<ResourceView> body = execute.body();
        System.out.println();
    }

    @Test
    void packageSearch() throws IOException {
        PackageSearchQuery query = new PackageSearchQuery();
        query.setSolrQuery("test");
        query.setFilterQuery("tags", "test");
        query.setRows(100);
        query.setStart(0);
        query.setFacetField(Arrays.asList("tags", "type"));

        Call<PackageSearch> b = datasetService().packageSearch(query);
        Response<PackageSearch> execute = b.execute();
        PackageSearch body = execute.body();
        System.out.println();
    }

    @Test
    void resourceSearch() throws IOException {
        ResourceSearchQuery query = new ResourceSearchQuery();
        query.setQuery(ResourceSearchQuery.ResourceColumn.name, "test");
        query.setOffset(0);
        query.setLimit(10);

        Call<ResourceSearch> b = datasetService().resourceSearch(query);
        Response<ResourceSearch> execute = b.execute();
        ResourceSearch body = execute.body();
        System.out.println();
    }

}
