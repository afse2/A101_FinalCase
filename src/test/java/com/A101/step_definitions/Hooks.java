package com.A101.step_definitions;


import com.A101.utilities.Driver;
import com.A101.utilities.Log;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
        Log log = new Log();
    @After
    public void teardownScenario(Scenario scenario) {
        log.endTestCase();

        if (scenario.isFailed()) {
            log.error("Test failed");
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.error("screenshot was taken");
        }
        Driver.quit();

    }

}
