package com.ui.pages;

import com.ui.constants.Env;
import com.ui.constants.TravelMode;
import com.utils.BrowserUtils;
import com.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage {
    private BrowserUtils bUtils;

    private static final By EMAIL_FIELD_LOCATOR = By.id("mobile-number");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Login')]");
    private static final By PASS_FIELD_LOCATOR = By.id("pass");
    private static final By TRAVEL_MODE_TAB_LIST = By.xpath("//button[contains(@class,'MuiButtonBase')]");
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        bUtils = new BrowserUtils(driver);
        this.driver = driver;
    }

    public void login(Env env) {
        bUtils.enterText(EMAIL_FIELD_LOCATOR, TestUtils.getValueFromConfigFile(env, "EMAIL"));
        bUtils.clickOn(LOGIN_BUTTON_LOCATOR);
        bUtils.enterText(PASS_FIELD_LOCATOR, TestUtils.getValueFromConfigFile(env, "PASS"));
        bUtils.clickOn(LOGIN_BUTTON_LOCATOR);

    }

    public Object goToTravelModeBookingSection(TravelMode travelMode) {
        switch (travelMode.toString().toLowerCase()) {
            case "bus":
                bUtils.clickOnEleFromListOfEle(TRAVEL_MODE_TAB_LIST, "Bus");
                return new BusBookingPage(driver);
            case "flights":
                bUtils.clickOnEleFromListOfEle(TRAVEL_MODE_TAB_LIST, "Flights");
                return new FlightBookingPage(driver);
            case "trains":
                bUtils.clickOnEleFromListOfEle(TRAVEL_MODE_TAB_LIST, "Trains");
                return new TrainBookingPage(driver);
            case "cabs":
                bUtils.clickOnEleFromListOfEle(TRAVEL_MODE_TAB_LIST, "Cabs");
                return new CabBookingPage(driver);
            default:
                return null;
        }
    }
}
