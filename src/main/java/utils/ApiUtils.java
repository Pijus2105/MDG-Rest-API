package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

    // POST with or without token
    public static Response postRequest(String url, Object body, String token) {
        if (token != null) {
            return RestAssured
                    .given()
                    .header("Authorization", token)
                    .header("workspace-path", TokenManager.getWorkspacePath())
                    .header("accept", "*/*")
                    .contentType("application/json")
                    .body(body)
                    .post(url);
        } else {
            return RestAssured
                    .given()
                    .contentType("application/json")
                    .body(body)
                    .post(url);
        }
    }

    // GET with token
    public static Response getRequest(String url) {
        return RestAssured
                .given()
                .header("Authorization", TokenManager.getToken())
                .header("workspace-path", TokenManager.getWorkspacePath())
                .header("accept", "*/*")
                .get(url);
    }

    // Print response details
    public static void printResponse(Response response) {
        System.out.println("Status  : " + response.getStatusCode());
        System.out.println("Time    : " + response.getTime() + "ms");
        System.out.println("Body    : " + response.getBody().asPrettyString());
    }
}