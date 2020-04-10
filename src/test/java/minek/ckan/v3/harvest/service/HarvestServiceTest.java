package minek.ckan.v3.harvest.service;

import minek.ckan.v3.BaseTest;
import minek.ckan.v3.harvest.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

class HarvestServiceTest extends BaseTest {

    @Test
    void harvestSourceList() throws IOException {
        List<HarvestSource> body = harvestService().harvestSourceList(true).execute().body();
        System.out.println(body);
    }

    @Test
    void harvestSourceShow() throws IOException {
        String body = harvestService().harvestSourceShow(
                UUID.fromString("c2411380-96b8-42f3-9a52-dc468215608b")
        ).execute().body();
        System.out.println(body);
    }

    @Test
    void harvestSourceShowStatus() throws IOException {
        HarvestSourceShowStatus body = harvestService().harvestSourceShowStatus(
                UUID.fromString("c2411380-96b8-42f3-9a52-dc468215608b")
        ).execute().body();
        System.out.println(body);
    }

    @Test
    void harvestJobShow() throws IOException {
        HarvestJob body = harvestService().harvestJobShow(
                UUID.fromString("aaaca367-61b9-4973-b9f9-4d5aafb99494")
        ).execute().body();
        System.out.println(body);
    }

    @Test
    void harvestJobList() throws IOException {
        List<HarvestJob> body = harvestService().harvestJobList(
                UUID.fromString("c2411380-96b8-42f3-9a52-dc468215608b")
        ).execute().body();
        System.out.println(body);
    }

    @Test
    void harvestLogList() throws IOException {
        List<HarvestLog> body = harvestService().harvestLogList().execute().body();
        System.out.println(body);
    }

    @Test
    void harvestersInfoShow() throws IOException {
        List<HarvesterInfo> body = harvestService().harvestersInfoShow().execute().body();
        System.out.println(body);
    }

    @Test
    void harvestObjectList() throws IOException {
        List<UUID> body = harvestService().harvestObjectList(
                UUID.fromString("c2411380-96b8-42f3-9a52-dc468215608b"), false
        ).execute().body();
        System.out.println(body);
    }
}