package payloads;

import org.json.JSONObject;

import autoGenearator.EmailGenerator;

public class CreateUser {
    
    public static String createUser(){
        JSONObject payload = new JSONObject();
        payload.put("email", EmailGenerator.getNextEmail());
        payload.put("role", "c84de1ae-2df7-434e-a2f8-0a3886bba9f2");

        return payload.toString();
    }
}
