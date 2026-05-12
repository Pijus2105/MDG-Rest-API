package stepDefinitions;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Login;
import utils.ApiUtils;
import utils.TokenManager;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.testng.Assert.*;

public class LoginSteps {

    private Response response;
    private String token;
    private String workspacePath;

    @Given("user has valid login credentials")
    public void userHasValidCredentials() {
        RestAssured.useRelaxedHTTPSValidation();
        System.out.println("Login credentials ready");
    }

    @When("user sends login POST request")
    public void sendLoginRequest() {
        String baseUrl = ConfigurationReader.get("baseUrl");

        response = ApiUtils.postRequest(
                baseUrl + Endpoints.LOGIN,
                Login.createLoginPayload(),
                null
        );

        ApiUtils.printResponse(response);
    }

    @Then("login response status should be {int}")
    public void verifyStatusCode(int expectedStatus) {
        assertEquals(response.getStatusCode(), expectedStatus);
    }

    @Then("response should contain valid token")
    public void verifyToken() throws Exception {
        token = response.jsonPath().getString("data");
        assertNotNull(token, "Token should not be null");

        // Decode JWT
        String[] parts   = token.split("\\.");
        String payload   = new String(Base64.getUrlDecoder().decode(parts[1]));

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> payloadMap = mapper.readValue(payload, Map.class);

        List<Map<String, Object>> permissions =
                (List<Map<String, Object>>) payloadMap.get("Permission");

        workspacePath = permissions.get(0).get("path").toString();

        // Store in TokenManager
        TokenManager.setToken(token);
        TokenManager.setWorkspacePath(workspacePath);

        System.out.println("TOKEN     : " + token);
    }

    @Then("response should contain workspace path")
    public void verifyWorkspacePath() {
        assertNotNull(TokenManager.getWorkspacePath());
        System.out.println("WORKSPACE : " + TokenManager.getWorkspacePath());
    }
}