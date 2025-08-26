package com.mobile.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class DriverFactory {
    private AppiumDriver appiumDriver;

    public void initDriver() {
        try {
            UiAutomator2Options opt = new UiAutomator2Options();
            opt.setPlatformName("android");
            opt.setAutomationName("UiAutomator2");
            opt.setApp(System.getProperty("user.dir") + "/src/test/resources/mobileApp/meesho.apk");
            opt.setDeviceName("Pixel 9");
            appiumDriver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), opt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
