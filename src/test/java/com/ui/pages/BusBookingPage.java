package com.ui.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class BusBookingPage {

    private WebDriver driver;
    private BrowserUtils bUtils;

    private static final By DEPART_FROM_LOCATOR = By.xpath("//div[contains(@aria-label,'Depart From')]");
    private static final By DEPART_FROM_INPUT_FIELD_LOCATOR = By.xpath("//div[contains(@aria-label,'Depart From')]//following-sibling::div//input");

    public BusBookingPage(WebDriver driver) {
        this.driver = driver;
        bUtils = new BrowserUtils(driver);
    }

    public void searchBusAsPerGivenData(String departFrom, String goingTo) {
        bUtils.clickOn(DEPART_FROM_LOCATOR);
        bUtils.enterText(DEPART_FROM_INPUT_FIELD_LOCATOR, departFrom);
    }
}
