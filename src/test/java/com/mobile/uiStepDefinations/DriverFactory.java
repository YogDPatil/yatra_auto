package com.mobile.uiStepDefinations;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;

public class DriverFactory {
    private static DriverFactory instance;
    private static ThreadLocal<AndroidDriver> thlcApmDriver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public static void setUpAppiumDriver() {
        try {
            if (getDriver() == null) {
                UiAutomator2Options opt = new UiAutomator2Options();
                opt.setPlatformName("android");
                opt.setAutomationName("UiAutomator2");
                opt.setApp(System.getProperty("user.dir") + "/src/test/resources/mobileApp/meesho.apk");
                opt.setDeviceName("Pixel 9");
//            appiumDriver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), opt);
                thlcApmDriver.set(new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), opt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver getDriver() {
        return thlcApmDriver.get();
    }

    public static void quiteDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    public void temp() {
        instance = new DriverFactory();
    }


}
