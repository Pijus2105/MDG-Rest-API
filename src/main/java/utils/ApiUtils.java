package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiUtils {

    public static Response postRequest(String endpoint, String payload, String token) {
        return given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(payload).when().post(endpoint).then().extract().response();
    }
}
