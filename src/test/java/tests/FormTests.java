package tests;

import org.testng.annotations.Test;
import config.ConfigurationReader;
import endpoints.Endpoints;
import payloads.Form;
import utils.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

public class FormTests {

     @Test
    public void testForm() {
        String baseUrl = ConfigurationReader.get("baseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        String token = ConfigurationReader.get("token");

        Response response = ApiUtils.postRequest(baseUrl + Endpoints.CREATE_FORM, Form.createFormPayload(),
                token);

       // System.out.println("Response:");
        System.out.println(response.prettyPrint());

        assertEquals(response.getStatusCode(), 201, "Expected status code 201 Created");
    }
    
}
