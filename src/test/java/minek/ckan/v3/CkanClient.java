package minek.ckan.v3;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class CkanClient {
    private final String ckanUrl;
    private final String authorizationToken;

    public CkanClient(String ckanUrl, String authorizationToken) {
        this.ckanUrl = ckanUrl;
        this.authorizationToken = authorizationToken;
    }

    public void createResource(String filePath, String packageId) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String uploadFileUrl = ckanUrl + "/api/action/resource_create";
            HttpPost httpPostRequest = new HttpPost(uploadFileUrl);
            httpPostRequest.setHeader("Authorization", authorizationToken);

            HttpEntity mpEntity = MultipartEntityBuilder.create().addBinaryBody("upload", new File(filePath))
                    .addTextBody("package_id", packageId).addTextBody("url", "").build();

            httpPostRequest.setEntity(mpEntity);

            HttpResponse response = httpClient.execute(httpPostRequest);

            if (response.getStatusLine().getStatusCode() < 200 || response.getStatusLine().getStatusCode() >= 300) {
                throw new RuntimeException("failed to add the file to CKAN storage. response status line from "
                        + uploadFileUrl + " was: " + response.getStatusLine());
            }

            HttpEntity responseEntity = response.getEntity();
            System.out.println(responseEntity.toString());
        } catch (IOException e) {
            // log error
        }
    }

    public void updateResource(String filePath, String resourceId) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String uploadFileUrl = ckanUrl + "/api/action/resource_update";
            HttpPost httpPostRequest = new HttpPost(uploadFileUrl);
            httpPostRequest.setHeader("Authorization", authorizationToken);

            HttpEntity mpEntity = MultipartEntityBuilder.create().addBinaryBody("upload", new File(filePath))
                    .addTextBody("id", resourceId).build();

            httpPostRequest.setEntity(mpEntity);

            HttpResponse response = httpClient.execute(httpPostRequest);

            if (response.getStatusLine().getStatusCode() < 200 || response.getStatusLine().getStatusCode() >= 300) {
                throw new RuntimeException("failed to add the file to CKAN storage. response status line from "
                        + uploadFileUrl + " was: " + response.getStatusLine());
            }

            HttpEntity responseEntity = response.getEntity();
            System.out.println(responseEntity.toString());
        } catch (IOException e) {
            // log error
        }
    }
}