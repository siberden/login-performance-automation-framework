package stepdefinitions;

import api.LoginApiClient;
import io.cucumber.java.en.Given;
import utils.PerformanceContext;

import static org.junit.Assert.assertTrue;

public class ApiSteps {

    @Given("login API performance is measured")
    public void login_api_performance_is_measured() {

        PerformanceContext.startApiTimer();

        LoginApiClient.login();

        PerformanceContext.endApiTimer();

        Long duration = PerformanceContext.getApiDuration();

        System.out.println("API duration recorded: " + duration + " ms");
    }

    @Given("login API responds within {int} ms")
    public void login_api_responds_within_ms(int maxMs) {

        Long duration = PerformanceContext.getApiDuration();

        System.out.println("Validating API duration: " + duration + " ms");

        assertTrue(
                "API too slow: " + duration + " ms (limit: " + maxMs + " ms)",
                duration < maxMs
        );
    }
}
