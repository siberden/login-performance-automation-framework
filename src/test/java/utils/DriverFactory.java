package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Holds a single WebDriver instance per test execution
    private static WebDriver driver;

    // Returns an existing WebDriver instance or creates a new one if needed
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Browser configuration
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Properly quits the WebDriver and resets the instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
