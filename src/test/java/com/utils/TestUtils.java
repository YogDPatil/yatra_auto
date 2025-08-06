package com.utils;

import com.constants.ConfigKey;
import com.ui.constants.Env;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestUtils {

    private WebDriver driver;

    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static String getValueFromConfigFile(Env env, ConfigKey key) {
        FileInputStream fis;
        Properties properties;
        String configKey = String.valueOf(key);
        try {
            fis = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/config/" + env.toString().toLowerCase() + "_config.properties"));
            properties = new Properties();
            properties.load(fis);
            return properties.getProperty(configKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
