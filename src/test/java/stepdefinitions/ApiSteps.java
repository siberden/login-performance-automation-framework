package stepdefinitions;

import api.LoginApiClient;
import io.cucumber.java.en.Given;
import utils.PerformanceContext;

import static org.junit.Assert.assertTrue;

public class ApiSteps {

    @Given("login API performance is measured")
    public void login_api_performance_is_measured() {

        PerformanceContext.startApiTimer();

        long duration = LoginApiClient.login();

        PerformanceContext.endApiTimer();

        System.out.println("API duration recorded: " + duration + " ms");
    }

    @Given("login API responds within {int} ms")
    public void login_api_responds_within_ms(int maxMs) {

        long duration = LoginApiClient.login();

        System.out.println("API duration recorded: " + duration + " ms");

        assertTrue(
                "API too slow: " + duration + " ms",
                duration < maxMs
        );
    }
}
