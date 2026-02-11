package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Path to feature files
        features = "src/test/resources/features",

        // Step definitions and hooks packages
        glue = {"stepdefinitions", "hooks"},

        // Reporting plugins
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        },

        // Improves console output readability
        monochrome = true

        // Tags can be added here to control test execution
        // Example: tags = "@smoke or @performance"
)
public class TestRunner {
}
