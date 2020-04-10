package minek.ckan.v3.datastore.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.datastore.model.DatastoreSearchResult;
import minek.ckan.v3.datastore.model.enums.RecordsFormat;
import minek.ckan.v3.datastore.service.command.DatastoreSearch;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

class DatastoreSearchTest extends BaseTest {

    @Test
    void datastoreSearch_csv() throws IOException {
        DatastoreSearch datastoreSearch = DatastoreSearch.builder()
                .resourceId(UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120"))
                .recordsFormat(RecordsFormat.csv)
                .build();

        DatastoreSearchResult body = dataStoreService().datastoreSearch(datastoreSearch).execute().body();
        System.out.println(body);
    }

    @Test
    void datastoreSearch_tsv() throws IOException {
        DatastoreSearch datastoreSearch = DatastoreSearch.builder()
                .resourceId(UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120"))
                .recordsFormat(RecordsFormat.tsv)
                .build();

        DatastoreSearchResult body = dataStoreService().datastoreSearch(datastoreSearch).execute().body();
        System.out.println(body);
    }

    @Test
    void datastoreSearch_lists() throws IOException {
        DatastoreSearch datastoreSearch = DatastoreSearch.builder()
                .resourceId(UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120"))
                .fields(Arrays.asList("hahaha1", "_id"))
                .recordsFormat(RecordsFormat.lists)
                .build();

        DatastoreSearchResult body = dataStoreService().datastoreSearch(datastoreSearch).execute().body();
        System.out.println(body);
    }

    @Test
    void datastoreSearch_objects() throws IOException {
        DatastoreSearch datastoreSearch = DatastoreSearch.builder()
                .resourceId(UUID.fromString("9e323c0a-b40b-4bf7-a200-2b423f158120"))
                .includeTotal(true)
                .distinct(true)
                .plain(true)
                .recordsFormat(RecordsFormat.objects)
                .build();

        DatastoreSearchResult body = dataStoreService().datastoreSearch(datastoreSearch).execute().body();
        System.out.println(body);
    }

}