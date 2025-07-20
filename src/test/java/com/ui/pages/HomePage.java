package com.ui.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public final class HomePage extends BrowserUtils {

    private WebDriver driver;

    private static final By EMAIL_FIELD_LOCATOR = By.id("mobile-number");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Login')]");
    private static final By PASS_FIELD_LOCATOR = By.id("pass");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void login() {
        enterText(EMAIL_FIELD_LOCATOR, "yogeshpatil.om23@gmail.com");
        clickOn(LOGIN_BUTTON_LOCATOR);
        enterText(PASS_FIELD_LOCATOR, "Testing@123");
        clickOn(LOGIN_BUTTON_LOCATOR);
    }
}
