package frame;

public class LoginRequest {

    private String emailId;
    private String password;

    // no-arg constructor — Jackson needs this
    public LoginRequest() {}

    // parameterized constructor — you use this
    public LoginRequest(String emailId, String password) {
        this.emailId  = emailId;
        this.password = password;
    }

    // getters
    public String getEmailId()  { return emailId; }
    public String getPassword() { return password; }

    // setters
    public void setEmailId(String emailId)   { this.emailId = emailId; }
    public void setPassword(String password) { this.password = password; }
}