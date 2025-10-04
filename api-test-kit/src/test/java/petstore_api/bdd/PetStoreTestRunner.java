package petstore_api.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/petstore_api/bdd/features",
        glue = "petstore_api.bdds.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class PetStoreTestRunner {
}