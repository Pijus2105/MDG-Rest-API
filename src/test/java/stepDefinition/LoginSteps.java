package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("user has valid login credentials")
    public void userHasValidCredentials() {
        loginPage.prepareCredentials();
    }

    @When("user sends login POST request")
    public void sendLoginRequest() {
        loginPage.performLogin();
    }

    @Then("login response status should be {int}")
    public void verifyStatusCode(int expectedStatus) {
        loginPage.assertStatusCode(expectedStatus);
    }

    @Then("response should contain valid token")
    public void verifyToken() throws Exception {
        loginPage.assertTokenIsValid();
    }

    @Then("response should contain workspace path")
    public void verifyWorkspacePath() {
        loginPage.assertWorkspacePathExists();
    }
}