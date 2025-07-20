package com.ui.tests;

import com.ui.constants.Env;
import com.ui.pages.HomePage;
import com.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        env = Env.valueOf(environment.toUpperCase());
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(TestUtils.getValueFromConfigFile(env, "BASE_URL"));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
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
