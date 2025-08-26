package com.mobile.uiStepDefinations;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class CucumberHooks {
    private AppiumDriver apmDriver;

    @Before
    public void initDriver() {
        DriverFactory.setUpAppiumDriver();
        apmDriver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quiteDriver();
    }
}
