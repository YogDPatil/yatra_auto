package com.ui.tests;

import com.ui.pages.HomePage;
import org.testng.annotations.Test;

public final class HomePageTest extends TestBase {

    private HomePage homePage;

    @Test
    public void openApp() {
        homePage = new HomePage(driver);
        homePage.login(env);
    }
}
