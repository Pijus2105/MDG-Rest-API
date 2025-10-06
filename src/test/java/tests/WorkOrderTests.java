package tests;

import org.testng.annotations.Test;

import config.ConfigurationReader;
import endpoints.Endpoints;
import payloads.WO_COO;
import utils.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class WorkOrderTests {

    @Test
    public void testCreateWorkOrder() {
        String baseUrl = ConfigurationReader.get("baseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        String token = ConfigurationReader.get("token");

        Response response = ApiUtils.postRequest(
            baseUrl + Endpoints.CREATE_WORK_ORDER, WO_COO.createWorkOrderPayload(), token
        );

       // System.out.println("Response:");
        System.out.println(response.prettyPrint());

        assertEquals(response.getStatusCode(), 201, "Expected status code 201 Created");
    }
}
