package com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BrowserUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
    }

    public void enterText(By locator, String text) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ele.clear();
        ele.sendKeys(text);
    }

    public void clickOn(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
