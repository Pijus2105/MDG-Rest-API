package pages;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Login;
import utils.ApiUtils;
import utils.TokenManager;

public class LoginPage {

    private Response response;
    private String token;
    private String workspacePath;

    public void prepareCredentials() {
        RestAssured.useRelaxedHTTPSValidation();
        System.out.println("Login credentials ready");
    }

    public void performLogin() {
        String baseUrl = ConfigurationReader.get("baseUrl");
        response = ApiUtils.postRequest(
                baseUrl + Endpoints.LOGIN,
                Login.createLoginPayload(),
                null
        );
        ApiUtils.printResponse(response);
    }

    public void assertStatusCode(int expectedStatus) {
        assertEquals(response.getStatusCode(), expectedStatus,
                "Expected HTTP status " + expectedStatus
                + " but got " + response.getStatusCode());
    }

    public void assertTokenIsValid() throws Exception {
        token = response.jsonPath().getString("data");
        assertNotNull(token, "Token should not be null");
        String[] parts      = token.split("\\.");
        String rawPayload   = new String(Base64.getUrlDecoder().decode(parts[1]));
        ObjectMapper mapper = new ObjectMapper();
        @SuppressWarnings("unchecked")
        Map<String, Object> payloadMap =
                mapper.readValue(rawPayload, Map.class);

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> permissions =
                (List<Map<String, Object>>) payloadMap.get("Permission");

        workspacePath = permissions.get(0).get("path").toString();
        TokenManager.setToken(token);
        TokenManager.setWorkspacePath(workspacePath);

        System.out.println("TOKEN     : " + token);
    }

    public void assertWorkspacePathExists() {
        assertNotNull(TokenManager.getWorkspacePath(),
                "Workspace path should not be null");
        System.out.println("WORKSPACE : " + TokenManager.getWorkspacePath());
    }
   
    public Response getResponse()      { return response;       }
    public String   getToken()         { return token;          }
    public String   getWorkspacePath() { return workspacePath;  }
}