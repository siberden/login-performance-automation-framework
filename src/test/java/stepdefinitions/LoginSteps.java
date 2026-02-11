package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigReader;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.open();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    @Then("user should see products page")
    public void user_should_see_products_page() {
        assertTrue(loginPage.isOnProductsPage());
    }
}
