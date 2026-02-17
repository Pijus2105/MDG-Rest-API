package tests;

import java.util.Base64;

import org.testng.annotations.Test;

import config.ConfigurationReader;
import endpoints.Endpoints;
import payloads.Login;
import utils.ApiUtils;
import utils.TokenManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public class LoginTests {

    @Test
    public void testLogin() {

        String baseUrl = ConfigurationReader.get("baseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        Response response = ApiUtils.postRequest(
                baseUrl + Endpoints.LOGIN,
                Login.createLoginload(),
                null
        );

        // ✅ Extract token
        String token = response.jsonPath().getString("data");

        // Decode JWT payload
        String[] parts = token.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> payloadMap = null;
        try {
            payloadMap = mapper.readValue(payload, Map.class);
        } catch (JsonProcessingException ex) {
            System.getLogger(LoginTests.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

// Extract workspace path
        List<Map<String, Object>> permissions
                = (List<Map<String, Object>>) payloadMap.get("Permission");

        String workspacePath = permissions.get(0).get("path").toString();

        System.out.println("TOKEN: " + token);
        System.out.println("WORKSPACE PATH: " + workspacePath);

        TokenManager.setToken(token);
        TokenManager.setWorkspacePath(workspacePath);

        assertEquals(response.getStatusCode(), 200);
    }
}
