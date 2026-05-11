package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.CreateDevicePayload;
import utils.ApiUtils;
import utils.TokenManager;

public class CreateDeviceTests extends BaseTest {

    @Test
    public void testCreateDevice() {

        String trackerbaseUrl = ConfigurationReader.get("trackerbaseUrl");

        RestAssured.useRelaxedHTTPSValidation();

        // ✅ Fetch token same like CreateUser
        String token = TokenManager.getToken();
        System.out.println("TOKEN USED IN CREATE DEVICE: " + token);

        // ✅ Hit API
        Response response = ApiUtils.postRequest(
                trackerbaseUrl + Endpoints.CREATE_DEVICE,
                CreateDevicePayload.createDevice(),
                token
        );

        System.out.println(response.prettyPrint());
        System.out.println("Create Device URL: " + trackerbaseUrl + Endpoints.CREATE_DEVICE);

        // ✅ Assertion
        assertEquals(response.getStatusCode(), 201, "Expected status code 201 Created");
    }
}
