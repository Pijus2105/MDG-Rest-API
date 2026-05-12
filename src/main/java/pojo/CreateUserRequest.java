package pojo;


public class CreateUserRequest {

    private String emailId;
    private String role;

    public CreateUserRequest() {

    }

    public CreateUserRequest(String emailId, String role) {
        this.emailId = emailId;
        this.role = role;
    }

    public String getEmail() {
        return emailId;
    }

    public String getRole() {
        return role;
    }
     public void setEmail(String emailId) {
        this.emailId = emailId;
     }

     public void setRole(String role){
        this.role = role;
     }
}
