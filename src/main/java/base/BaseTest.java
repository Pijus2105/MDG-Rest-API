package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import config.ConfigurationReader;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigurationReader.get("baseUrl");
    }
}
