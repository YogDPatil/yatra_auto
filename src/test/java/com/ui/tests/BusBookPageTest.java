package com.ui.tests;

import org.testng.annotations.Test;

public final class BusBookPageTest extends TestBase {

    @Test
    public void validateUserNavigateBusBooPage() {
        homePage.login(env);
        homePage.goToBusBookingSection();
    }
}
