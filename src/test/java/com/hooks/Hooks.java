package com.hooks;

import Base.DriverUtilites;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

public class Hooks {

    @Before
    public void setUp() {
        DriverUtilites.setDriver();
        System.out.println("Driver is set up");
    }
    @After
    public void tearDown() {
        DriverUtilites.closeDriver();
        System.out.println("Driver is quit");
    }
    @AfterStep
    public void takeScreenshot(Scenario scenario) {

        String screenshotName =
                scenario.getName() + "_"
                        + System.currentTimeMillis();

        scenario.attach(
                ScreenshotUtils.captureScreenshot(),
                "image/png",
                screenshotName
        );
    }
}
