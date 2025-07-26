package com.ui.tests;

import com.ui.constants.TravelMode;
import com.ui.pages.BusBookingPage;
import org.testng.annotations.Test;

public final class BusBookPageTest extends TestBase {

    @Test
    public void validateUserNavigateBusBooPage() {
        homePage.login(env);
        BusBookingPage page = (BusBookingPage) homePage.goToTravelModeBookingSection(TravelMode.BUS);
        page.searchBusAsPerGivenData("Shahada", "Pune");
    }
}
