package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.PerformanceContext;

public class Hooks {

    private long scenarioStart;

    @Before("@ui")
    public void setUpUI(Scenario scenario) {
        scenarioStart = System.currentTimeMillis();
        DriverFactory.getDriver();
        System.out.println("Starting UI scenario: " + scenario.getName());
    }

    @Before("@api")
    public void setUpAPI(Scenario scenario) {
        scenarioStart = System.currentTimeMillis();
        System.out.println("Starting API scenario: " + scenario.getName());
    }

    @After("@ui")
    public void tearDownUI(Scenario scenario) {

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

    @After("@api")
    public void tearDownAPI(Scenario scenario) {

        long scenarioDuration = System.currentTimeMillis() - scenarioStart;
        System.out.println("Scenario total duration: " + scenarioDuration + " ms");

        PerformanceContext.clear();
    }
}
