package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.model.Package;
import minek.ckan.v3.model.*;
import minek.ckan.v3.model.enums.ResourceViewType;
import minek.ckan.v3.model.enums.State;
import minek.ckan.v3.service.command.create.*;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CreateServiceTest extends BaseTest {

    @Test
    void packageCreate() throws IOException {
        //noinspection ArraysAsListWithZeroOrOneArgument
        Call<Package> b = datasetService().packageCreate(
                PackageCreate.builder("mine-k-asdqwe1q2w3ez", "mine-k-asdqwe1q2w3e", false)
                        .author("test-author")
                        .authorEmail("test-author@test.com")
                        .maintainer("test-maintainer")
                        .maintainerEmail("test-maintainer@test.com")
                        .licenseId("odc-odbl")
                        .notes("test-notes")
                        .version("test-version")
                        .state(State.active)
                        .ownerOrg(UUID.fromString("9dbbdacc-51d1-4f6b-ae61-3e38963bbac3")) // mine-k
                        .groups(Arrays.asList(
                                PackageCreate.Group.of(UUID.fromString("e5a22d53-3330-4b7c-9b41-dfd5500fc23a"))
                        ))
                        .extras(Arrays.asList(
                                PackageCreate.Extra.of("key111", "value111"),
                                PackageCreate.Extra.of("key222", "value222")
                        ))
                        .tags(Arrays.asList(TagCreate.of("test")))
                        .resources(Arrays.asList(
                                ResourceCreate.builder().url("http://test.com").name("test").build(),
                                ResourceCreate.builder().url("http://test.com2").name("test2").build()
                        ))
                        .build()
        );
        Response<Package> execute = b.execute();
        Package body = execute.body();
        System.out.println();
    }

    @Test
    void resourceCreate1() throws IOException {
        File file = new File("d:\\123.txt");

        UUID id = UUID.fromString("758244c9-b948-4658-9424-0f7e1304ea36");

        Call<Resource> upload_test = datasetService().resourceCreate(
                ResourceCreate.builder()
                        .packageId(id)
                        .name("upload-test")
                        .build()
        );
        Response<Resource> execute = upload_test.execute();
        Resource body = execute.body();
        System.out.println();
    }

    @Test
    void resourceCreate2() throws IOException {
        File file = new File("d:\\123.txt");

        UUID id = UUID.fromString("758244c9-b948-4658-9424-0f7e1304ea36");

        Call<Resource> upload_test = datasetService().resourceCreate(
                ResourceCreate.builder()
                        .packageId(id)
                        .name("123.txt")
                        .build(),
                file
        );
        Response<Resource> execute = upload_test.execute();
        Resource body = execute.body();
        System.out.println();
    }

    @Test
    void resourceViewCreate() throws IOException {
        Call<ResourceView> upload_test = datasetService().resourceViewCreate(
                ResourceViewCreate.builder()
                        .resourceId(UUID.fromString("d6ec1145-5b93-4a37-aaeb-51d7c4198527"))
                        .title("test-resource-view-title")
                        .description("test-resource-description")
                        .viewType(ResourceViewType.text_view)
                        .build()
        );
        Response<ResourceView> execute = upload_test.execute();
        ResourceView body = execute.body();
        System.out.println();
    }

    @Test
    void resourceCreateDefaultResourceViews() throws IOException {
        UUID resourceId = UUID.fromString("d6ec1145-5b93-4a37-aaeb-51d7c4198527");
        Resource resource = datasetService().resourceShow(resourceId, false).execute().body();

        Call<List<ResourceView>> upload_test = datasetService().resourceCreateDefaultResourceViews(
                ResourceCreateDefaultResourceViewsCreate.of(
                        resource,
                        false
                )
        );

        Response<List<ResourceView>> execute = upload_test.execute();
        List<ResourceView> body = execute.body();
        System.out.println();
    }

    @Test
    void packageCreateDefaultResourceViews() throws IOException {
        Package package_ = datasetService().packageShow("mine-k-asdqwe1q2w3ez", false).execute().body();

        Call<List<ResourceView>> upload_test = datasetService().packageCreateDefaultResourceViews(
                PackageCreateDefaultResourceViewsCreate.of(
                        package_,
                        false
                )
        );

        Response<List<ResourceView>> execute = upload_test.execute();
        List<ResourceView> body = execute.body();
        System.out.println();
    }

    @Test
    void ratingCreate() throws IOException {
        Call<Rating> upload_test = datasetService().ratingCreate(
                RatingCreate.of("mine-k-asdqwe1q2w3ez", 5)
        );
        Response<Rating> execute = upload_test.execute();
        Rating body = execute.body();
        System.out.println();
    }

    @Test
    void followGroup() throws IOException {
        Call<Follower> upload_test = groupService().followGroup(
                FollowGroup.of("asdasdasdasda")
        );
        Response<Follower> execute = upload_test.execute();
        Follower body = execute.body();
        System.out.println();
    }
}
