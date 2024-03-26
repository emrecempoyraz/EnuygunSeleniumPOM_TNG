package com.enuygun.testMain;




import com.enuygun.pageObjects.IData;
import com.enuygun.testManager.ConfigReader;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEnuygun extends BaseTest{

    @Description("ENUYGUNE2ETEST")
    @Test(description = "Selects Origin city on home page",priority = 1)
    void selectOriginCity(){
        driver.get(ConfigReader.getProperty("baseUrl"));
        homePage.acceptCookies();
        homePage.selectOrigin();
        Assert.assertTrue(homePage.isOriginSelected());
    }

    @Description("Selects Destination city on home page")
    @Test(priority = 2,dependsOnMethods = "selectOriginCity")
    void selectDestinationCity() {
        homePage.selectDestination();
        Assert.assertTrue(homePage.isDestinationSelected());
    }

    @Description("Selects departure day from calender")
    @Test(priority = 3,dependsOnMethods = "selectDestinationCity")
    void selectDepartureDateCalender () {
        homePage.selectDepartureDate();
        Assert.assertTrue(homePage.isDepartureDaySelected());
    }

    @Description("Selects return day from calender")
    @Test(priority = 4,dependsOnMethods = "selectDepartureDateCalender")
    void selectReturnDateCalender() {
        homePage.selectReturnDate();
        Assert.assertTrue(homePage.isReturnDaySelected());
    }

    @Description("Selects flight type direct/transit")
    @Test(priority = 5,dependsOnMethods = "selectReturnDateCalender")
    void selectFlightType () {
        homePage.clickDirectFlightCheckBox();
        homePage.isDirectFlightsSelected(IData.isDirect);
    }

    @Description("Submits flight form after selections")
    @Test(priority = 6,dependsOnMethods = "selectReturnDateCalender")
    void submitFlightForm () {
        homePage.submitFlightInfo();
        Assert.assertTrue(homePage.isFormSubmitted());
    }

    @Description("Check direct flights Selected")
    @Test(priority = 7,dependsOnMethods = "submitFlightForm")
    void checkDirectFlightsSelected () {
        Assert.assertTrue(flightListsPage.isDirectFlightsSelected());
    }

    @Description("Selects Departure and Return from same package")
    @Test(priority = 8,dependsOnMethods = "checkDirectFlightsSelected")
    void selectFlightPackage () {
        flightListsPage.selectFlightPackage();
        Assert.assertTrue(flightListsPage.isPackageSelected());
    }

    @Description("Validates cart page is available")
    @Test(priority = 9,dependsOnMethods = "selectFlightPackage")
    void validateCartPage () {
        flightListsPage.goPaymentPage();
        Assert.assertTrue(cartPage.isOnCartPage());
    }

}
