package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.CreateUser;
import utils.ApiUtils;
import utils.TokenManager;

public class CreateUserTests extends BaseTest {

    @Test
    public void testCreateUser(){
        String customerbaseUrl = ConfigurationReader.get("customerbaseUrl");
        RestAssured.useRelaxedHTTPSValidation();
                String token = TokenManager.getToken();
System.out.println("TOKEN USED IN CREATE USER: " + token);

        Response response = ApiUtils.postRequest(customerbaseUrl + Endpoints.CREATE_USER, CreateUser.createUserPayload(), token);
        System.out.println(response.prettyPrint());
        System.out.println("Create URL: " + customerbaseUrl + Endpoints.CREATE_USER);

        assertEquals(response.getStatusCode(), 201, "Expected status code 201 Created");
    }
    
}
