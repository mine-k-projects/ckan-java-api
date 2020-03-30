package minek.ckan.v3.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.CkanClient;
import minek.ckan.v3.Package;
import minek.ckan.v3.Resource;
import minek.ckan.v3.create.PackageCreate;
import minek.ckan.v3.create.ResourceCreate;
import minek.ckan.v3.create.TagCreate;
import minek.ckan.v3.enums.State;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class CreateServiceTest extends BaseTest {

    @Test
    void packageCreate() throws IOException {
        //noinspection ArraysAsListWithZeroOrOneArgument
        Call<Package> b = createService().packageCreate(
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

        Call<Resource> upload_test = createService().resourceCreate(
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

        Call<Resource> upload_test = createService().resourceCreate(
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
    void asdsad() {
        CkanClient ckanClient = new CkanClient("https://demo.ckan.org", "ee761722-6d84-44b5-b304-d2c8b24e4ac4");
        ckanClient.createResource("d:\\123.txt", "758244c9-b948-4658-9424-0f7e1304ea36");
        System.out.println();
    }

}
