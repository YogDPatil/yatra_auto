package com.ui.tests;

import com.ui.constants.Env;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> thrdlclDriver = new ThreadLocal<>();

    private DriverFactory() {

    }

    public static void setDriver(String browser, Env env, boolean isRemote, boolean headless) {
        try {
            if (isRemote) {
//                MutableCapabilities caps = new MutableCapabilities();
//                Map<String, Object> bstackOptions = new HashMap<>();
//                caps.setCapability("browserName", browser);
//                caps.setCapability("browserVersion", browserVersion);
//                bstackOptions.put("os", "Windows");
//                bstackOptions.put("osVersion", "10");
//                bstackOptions.put("userName", TestUtils.getValueFromPropertiesFile(env, ConfigConst.BS_USERNAME));
//                bstackOptions.put("accessKey", TestUtils.getValueFromPropertiesFile(env, ConfigConst.BS_ACCESS_KEY));
//                bstackOptions.put("sessionName", method.getName());
//                caps.setCapability("bstack:options", bstackOptions);
//                thrdlclDriver.set(new RemoteWebDriver((new URI(TestUtils.getValueFromPropertiesFile(env, ConfigConst.BS_URL)).toURL(), caps));
            } else {
                if (getDriver() == null) {
                    switch (browser.toLowerCase()) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            ChromeOptions cOpt = new ChromeOptions();
                            if (headless) {
                                cOpt.addArguments("--headless");
                            }
                            thrdlclDriver.set(new ChromeDriver(cOpt));
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            FirefoxOptions fOpt = new FirefoxOptions();
                            if (headless) {
                                fOpt.addArguments("--headless");
                            }
                            thrdlclDriver.set(new FirefoxDriver(fOpt));
                        default:
                            System.out.println("Selected " + browser + " browser is invalid");
                    }
                }
            }
        } catch (Exception e) {

        }

    }

    public static WebDriver getDriver() {
        return thrdlclDriver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
