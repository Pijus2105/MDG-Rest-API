package tests;

import org.testng.annotations.Test;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Form;
import payloads.PrivateForm;
import utils.ApiUtils;
import static org.testng.Assert.assertEquals;


public class PrivateFormTests {

     @Test
    public void testPrivateForm() {
        String baseUrl = ConfigurationReader.get("baseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        String token = ConfigurationReader.get("token");

        Response response = ApiUtils.postRequest(baseUrl + Endpoints.CREATE_FORM, PrivateForm.createPrivateFormPayload(),
                token);

       // System.out.println("Response:");
        System.out.println(response.prettyPrint());

        assertEquals(response.getStatusCode(), 201, "Expected status code 201 Created");
    }
    
}
