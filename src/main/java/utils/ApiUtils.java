package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class ApiUtils {

   public static Response postRequest(String url, Object body, String token) {

    if (token != null) {
       return RestAssured
            .given()
            .header("Authorization", token)   // no Bearer
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

}
