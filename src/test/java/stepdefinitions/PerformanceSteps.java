package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
import utils.PerformanceContext;

import static org.junit.Assert.assertTrue;

public class PerformanceSteps {

    private LoginPage loginPage;

    @When("user logs in via UI")
    public void user_logs_in_via_ui() {

        loginPage = new LoginPage();

        PerformanceContext.startUiTimer();

        loginPage.open();

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    @Then("products page should be displayed within {int} ms")
    public void products_page_should_be_displayed_within_ms(int maxDuration) {

        assertTrue(
                "User is not on products page",
                loginPage.isOnProductsPage()
        );

        PerformanceContext.endUiTimer();

        long uiDuration = PerformanceContext.getUiDuration();
        System.out.println("UI login duration: " + uiDuration + " ms");

        assertTrue(
                "UI login too slow: " + uiDuration + " ms",
                uiDuration < maxDuration
        );
    }
}
