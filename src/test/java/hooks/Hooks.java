package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.PerformanceContext;

public class Hooks {

    private long scenarioStart;

    @Before
    public void setUp(Scenario scenario) {
        scenarioStart = System.currentTimeMillis();
        DriverFactory.getDriver();
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        long scenarioDuration = System.currentTimeMillis() - scenarioStart;
        System.out.println("Scenario total duration: " + scenarioDuration + " ms");

        if (scenario.getSourceTagNames().contains("@performance")) {

            Long apiDuration = PerformanceContext.getApiDuration();
            Long uiDuration = PerformanceContext.getUiDuration();

            if (apiDuration != null) {
                System.out.println("API duration: " + apiDuration + " ms");
            }

            if (uiDuration != null) {
                System.out.println("UI duration: " + uiDuration + " ms");
            }
        }

        PerformanceContext.clear();
        DriverFactory.quitDriver();
    }
}
