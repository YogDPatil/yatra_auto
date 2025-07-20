package com.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
    }
}
