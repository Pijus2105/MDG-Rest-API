package tests;

import org.testng.annotations.Test;

import config.ConfigurationReader;
import endpoints.Endpoints;
import payloads.New_User;
import utils.ApiUtils;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class NewUserTests {

    @Test
    public void testCreateuser() {
        String baseUrl = ConfigurationReader.get("baseUrl");
        String token = ConfigurationReader.get("token");

        Response response = ApiUtils.postRequest(
            baseUrl + Endpoints.CREATE_NEW_USER, New_User.createUserPayload(), token
        );

        //System.out.println("Response:");
        System.out.println(response.prettyPrint());

        assertEquals(response.getStatusCode(), 201, "Expected status code 201 Created");
    }
}
