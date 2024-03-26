package com.enuygun.testMain;

import com.enuygun.pageObjects.CartPage;
import com.enuygun.pageObjects.FlightListsPage;
import com.enuygun.pageObjects.HomePage;
import com.enuygun.testManager.DriverCross;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    HomePage homePage ;
    FlightListsPage flightListsPage;
    CartPage cartPage;

    protected WebDriver driver ;

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverCross.getDriver(browser);
        homePage = new HomePage(driver);
        flightListsPage = new FlightListsPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterTest
    public void tearDown () {
        DriverCross.closeDriver();
    }
}
