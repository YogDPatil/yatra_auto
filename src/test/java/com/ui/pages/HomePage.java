package com.ui.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtils {

    private static final By EMAIL_FIELD_LOCATOR = By.id("mobile-number");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Login')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        enterText(EMAIL_FIELD_LOCATOR, "yogeshpatil.om23@gmail.com");
        clickOn(LOGIN_BUTTON_LOCATOR);
    }
}
