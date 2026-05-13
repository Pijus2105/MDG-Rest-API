package pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.CreateUser;
import utils.ApiUtils;
import utils.TokenManager;

public class UserPage {

    private Response response;

    public void theUserIsLoggedInAndTokenIsAvailable() {
        assertNotNull(TokenManager.getToken(), "Token should not be null");
        System.out.println("TOKEN USED IN CREATE USER: " + TokenManager.getToken());
    }

     public void theUserSendsPostRequestToCreateNewUser() {
        String customerbaseUrl = ConfigurationReader.get("customerbaseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        String token = TokenManager.getToken();

        response = ApiUtils.postRequest(
                customerbaseUrl + Endpoints.CREATE_USER,
                CreateUser.createUserPayload(),
                token
        );

        System.out.println(response.prettyPrint());
        System.out.println("Create URL: " + customerbaseUrl + Endpoints.CREATE_USER);
    }

     public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(response.getStatusCode(), expectedStatusCode,
                "Expected status code " + expectedStatusCode
                + " but got " + response.getStatusCode());
    }

}
