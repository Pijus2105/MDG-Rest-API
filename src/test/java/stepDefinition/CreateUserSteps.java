package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import config.ConfigurationReader;
import endpoints.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pages.UserPage;
import payloads.CreateUser;
import utils.ApiUtils;
import utils.TokenManager;

public class CreateUserSteps  {

    private final UserPage up = new UserPage();


    // ─── Background Step ──────────────────────────────────────────────────────
    @Given("the user is logged in and token is available")
    public void theUserIsLoggedInAndTokenIsAvailableStep() {
       up.theUserIsLoggedInAndTokenIsAvailable();
    }

    // ─── Action Step ──────────────────────────────────────────────────────────
    @When("the user sends a POST request to create a new user")
    public void theUserSendsPostRequestToCreateNewUserStep() {
       up.theUserSendsPostRequestToCreateNewUser();
    }

    // ─── Assertion Steps ──────────────────────────────────────────────────────
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBeStep(int expectedStatusCode) {
        up.theResponseStatusCodeShouldBe(expectedStatusCode);
    }

   
}
