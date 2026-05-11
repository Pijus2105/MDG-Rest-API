package payloads;

import frame.CreateUserRequest;

import autoGenearator.EmailGenerator;

public class CreateUser {
    
    

        public static CreateUserRequest createUserPayload() {
             return new CreateUserRequest(EmailGenerator.getNextEmail(), "b61ef850-4f77-46b5-8680-c83dabe87127");
        }
    }

