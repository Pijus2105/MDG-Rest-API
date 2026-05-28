package base;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Login;

import org.testng.annotations.BeforeSuite;
import utils.ApiUtils;
import utils.TokenManager;

public class BaseTest {

    @BeforeSuite
    public void generateToken() {

        String baseUrl = ConfigurationReader.get("baseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        Response response = ApiUtils.postRequest(
                baseUrl + Endpoints.LOGIN,
                Login.createLoginPayload(),
                null
        );

        String token = response.jsonPath().getString("data");

        TokenManager.setToken(token);

        System.out.println("TOKEN GENERATED IN BEFORE SUITE");
    }
}
