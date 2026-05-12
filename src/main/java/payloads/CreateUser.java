package payloads;

import autoGenearator.EmailGenerator;
import pojo.CreateUserRequest;

public class CreateUser {
    
    

        public static CreateUserRequest createUserPayload() {
             return new CreateUserRequest(EmailGenerator.getNextEmail(), "22cb1f4a-8511-4053-8663-8558739a1c18");
        }
    }

