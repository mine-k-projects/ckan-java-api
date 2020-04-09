package minek.ckan.v3.datastore.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.datastore.model.DatastoreCreateResult;
import minek.ckan.v3.datastore.model.DatastoreInfo;
import minek.ckan.v3.datastore.model.DatastoreUpsertResult;
import minek.ckan.v3.datastore.model.Field;
import minek.ckan.v3.datastore.model.enums.Method;
import minek.ckan.v3.datastore.service.command.create.DatastoreCreate;
import minek.ckan.v3.datastore.service.command.create.DatastoreUpsert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class DatastoreServiceTest extends BaseTest {

    @Test
    void datastoreCreate() throws IOException {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("hahaha1", "vtest111111111");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("hahaha1", "vtest2222222222");

        DatastoreCreate dataStoreCreate = new DatastoreCreate();
        dataStoreCreate.setForce(true);
        dataStoreCreate.setResource_id("9e323c0a-b40b-4bf7-a200-2b423f158120");
        dataStoreCreate.setFields(Arrays.asList(
                Field.of("hahaha1"),
                Field.of("asdfsadf"),
                Field.of("0.0"),
                Field.of("field1")
        ));
        dataStoreCreate.setRecords(Arrays.asList(map1, map2));

        DatastoreCreateResult body = dataStoreService().datastoreCreate(dataStoreCreate).execute().body();
        System.out.println(body);
    }

    @Test
    void datastoreRunTriggers() throws IOException {
        Integer body = dataStoreService().datastoreRunTriggers(
                UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120")
        ).execute().body();
        System.out.println(body);
    }

    @Test
    void datastoreUpsert() throws IOException {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("hahaha1", "aaaaaaaaaaa");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("hahaha1", "bbbbbbb");

        DatastoreUpsert dataStoreUpsert = new DatastoreUpsert();
        dataStoreUpsert.setMethod(Method.insert);
        dataStoreUpsert.setForce(true);
        dataStoreUpsert.setResourceId(UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120"));
        dataStoreUpsert.setRecords(Arrays.asList(map1, map2));

        DatastoreUpsertResult body = dataStoreService().datastoreUpsert(dataStoreUpsert).execute().body();
        System.out.println(body);
    }

    @Test
    void datastoreInfo() throws IOException {
        DatastoreInfo body = dataStoreService().datastoreInfo(
                UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120")
        ).execute().body();
        System.out.println(body);
    }


}