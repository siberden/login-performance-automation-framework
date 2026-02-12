package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

    // Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By productsTitle = By.className("title");

    // Opens the application
    public void open() {
        driver.get(ConfigReader.get("url"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    }

    // Standard login (functional)
    public void login(String user, String pass) {

        var userField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(username)
        );
        userField.sendKeys(user);

        var passField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        );
        passField.sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }


    // Login + UI performance measurement
    public long loginWithPerformance() {

        long startTime = System.currentTimeMillis();

        open();
        login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle));

        return System.currentTimeMillis() - startTime;
    }

    public boolean isOnProductsPage() {
        return wait.until(
                ExpectedConditions.urlContains("inventory")
        );
    }

}
