package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    // Single page object — shared across all steps in this class
    private final LoginPage loginPage = new LoginPage();

    // ─── Given ────────────────────────────────────────────────────────────────

    @Given("user has valid login credentials")
    public void userHasValidCredentials() {
        loginPage.prepareCredentials();
    }

    // ─── When ─────────────────────────────────────────────────────────────────

    @When("user sends login POST request")
    public void sendLoginRequest() {
        loginPage.performLogin();
    }

    // ─── Then ─────────────────────────────────────────────────────────────────

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