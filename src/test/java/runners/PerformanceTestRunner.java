package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@performance",
        plugin = {
                "pretty",
                "html:target/cucumber-performance-report.html",
                "json:target/cucumber-performance.json"
        },
        monochrome = true
)
public class PerformanceTestRunner {
}
