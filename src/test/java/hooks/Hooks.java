package hooks;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Login;
import utils.ApiUtils;
import utils.TokenManager;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Hooks {

    private static boolean tokenGenerated = false;

    @Before
    public void generateToken() throws Exception {

        // Generate token only once
        if (tokenGenerated) return;

        String baseUrl = ConfigurationReader.get("baseUrl");
        RestAssured.useRelaxedHTTPSValidation();

        Response response = ApiUtils.postRequest(
                baseUrl + Endpoints.LOGIN,
                Login.createLoginPayload(),
                null
        );

        // Extract token
        String token = response.jsonPath().getString("data");

        // Decode JWT to get workspace path
        String[] parts   = token.split("\\.");
        String payload   = new String(Base64.getUrlDecoder().decode(parts[1]));

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> payloadMap = mapper.readValue(payload, Map.class);

        List<Map<String, Object>> permissions =
                (List<Map<String, Object>>) payloadMap.get("Permission");

        String workspacePath = permissions.get(0).get("path").toString();

        // Store in TokenManager
        TokenManager.setToken(token);
        TokenManager.setWorkspacePath(workspacePath);

        tokenGenerated = true;

        System.out.println("TOKEN       : " + token);
        System.out.println("WORKSPACE   : " + workspacePath);
        System.out.println("Token Generated in Hooks @Before");
    }
}