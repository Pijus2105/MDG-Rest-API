package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DevicePage;

public class CreateDeviceSteps {

    private final DevicePage dp = new DevicePage();

    @Given("the user is logged in and token is available for device")
    public void theDeviceIsLoggedInAndTokenIsAvailable() {
        dp.theDeviceIsLoggedInAndTokenIsAvailable();
    }

    @When("the user sends a POST request to create a new device")
    public void theusersendsaPOSTrequesttocreateanewdeviceStep() {
        dp.theDeviceSendsPostRequestToCreateNewDevice();
    }

    @Then("the device response status code should be {int}")
    public void theDeviceResponseStatusCodeShouldBeStep(int expectedStatusCode) {
        dp.theResponseStatusCodeShouldBe(expectedStatusCode);
    }
}
