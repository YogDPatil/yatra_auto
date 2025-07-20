package com.ui.tests;

import com.ui.pages.HomePage;
import org.testng.annotations.Test;

public final class HomePageTest extends TestBase {

    @Test
    public void openApp() {
        homePage.login(env);
    }
}
