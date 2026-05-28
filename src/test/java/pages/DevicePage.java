package pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.CreateDevice;
import utils.ApiUtils;
import utils.TokenManager;

public class DevicePage {

        private Response response;

public void theDeviceIsLoggedInAndTokenIsAvailable() {
        assertNotNull(TokenManager.getToken(), "Token should not be null");
        System.out.println("TOKEN USED IN CREATE USER: " + TokenManager.getToken());
    }

     public void theDeviceSendsPostRequestToCreateNewDevice() {
        String trackerbaseUrl = ConfigurationReader.get("trackerbaseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        String token = TokenManager.getToken();

        response = ApiUtils.postRequest(
                trackerbaseUrl + Endpoints.CREATE_DEVICE,
                CreateDevice.createDevicePayload(),
                token
        );

        System.out.println(response.prettyPrint());
        System.out.println("Create URL: " + trackerbaseUrl + Endpoints.CREATE_DEVICE);
    }

     public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(response.getStatusCode(), expectedStatusCode,
                "Expected status code " + expectedStatusCode
                + " but got " + response.getStatusCode());
    }
}
