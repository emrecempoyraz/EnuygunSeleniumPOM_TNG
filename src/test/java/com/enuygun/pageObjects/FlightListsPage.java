package com.enuygun.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightListsPage extends BasePage{

    public FlightListsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[@class='checkbox checkbox--active' and @aria-hidden='true'] ")
    private WebElement directFlightsCheckBox;

    @FindBy(css = ".filter-card__title")
    private WebElement filterText;

    @FindBy(css = "#tooltipTarget_0")
    private WebElement submitFlightPackageButton;

    public boolean isDirectFlightsSelected () {
        return directFlightsCheckBox.isEnabled();
    }

    public void selectFlightPackage () {
        driver.findElements(By.cssSelector("[class='roundTrip departure'] [data-booking-provider='"+IData.PROVIDER+"']")).get(0).click();

    }

    public boolean isPackageSelected () {
      return filterText.getText().contains("Sıralanan Uçuş");
    }

    public void goPaymentPage () {
        core.clickTo(submitFlightPackageButton,3);
    }



}
