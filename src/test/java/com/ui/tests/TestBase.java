package com.ui.tests;

import com.ui.constants.Env;
import com.ui.pages.HomePage;
import com.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class TestBase {
    protected WebDriver driver;
    protected Env env;
    protected HomePage homePage;


    @Parameters({"browser", "env"})
    @BeforeMethod(alwaysRun = true)
    public void initialiseDriver(@Optional("chrome") String browser, @Optional("qa") String environment) {
        try {
            env = Env.valueOf(environment.toUpperCase());
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));
            DriverFactory.setDriver(browser, env, isRemote, headless);
            driver = DriverFactory.getDriver();
            driver.get(TestUtils.getValueFromConfigFile(env, "BASE_URL"));
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (driver != null) {
                Thread.sleep(5000);
                driver.quit();
            }
        } catch (InterruptedException ignore) {

        }
    }
}
