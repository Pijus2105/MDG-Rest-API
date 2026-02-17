package payloads;

import org.json.JSONObject;

public class Login {

    public static String createLoginload() {
        JSONObject payload = new JSONObject();
        payload.put("emailId", "automationcustomer@yopmail.com");
        payload.put("password", "Code@1234");

        return payload.toString();

    }

}
