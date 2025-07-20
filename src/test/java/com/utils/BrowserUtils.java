package com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    public void clickOnEleFromListOfEle(By locator, String eleText) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).stream().filter(ele -> ele.getText().contains(eleText)).findFirst().ifPresent(ele -> ele.click());
    }


    public List<WebElement> getElementList(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
