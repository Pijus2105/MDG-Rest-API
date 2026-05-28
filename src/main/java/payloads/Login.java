package payloads;

import pojo.LoginRequest;

public class Login {
    
     public static LoginRequest createLoginPayload() {
        return new LoginRequest("plan-sell@yopmail.com", "Abc@1234");
    }
}
