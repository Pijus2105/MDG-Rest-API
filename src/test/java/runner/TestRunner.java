package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"stepDefinition", "hooks"},
    tags = "@Smoke",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}