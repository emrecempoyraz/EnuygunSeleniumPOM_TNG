package com.enuygun.pageObjects;

import com.enuygun.testManager.ConfigReader;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement cookiesLocator;

    @FindBy(css = "#OriginInput")
    private WebElement originLocator;

    @FindBy(css = "#DestinationInput")
    private WebElement destinationLocator;

    @FindBy(xpath = "//li[@data-section-index='0'][1]")
    private WebElement firstSuggestionOrigin;

    @FindBy(xpath = "//div//input[@inputname='origin']")
    private WebElement originSelectedText;

    @FindBy(xpath = "//li[@data-section-index='0'][1]")
    private WebElement firstSuggestionDestination;

    @FindBy(xpath = "//div//input[@inputname='destination']")
    private WebElement firstSuggestionDestinationText;

    @FindBy(css = "#DepartureDate")
    private WebElement departureDate;

    @FindBy(css = "[aria-disabled='false'] [class='CalendarDay__content']")
    private List<WebElement> calenderGeneral;

    @FindBy(xpath = "//label[@for='ReturnDate']")
    private WebElement returnDateInput;

    @FindBy(xpath = "//div[@class='D_FSF__col departureDate__col ']")
    private WebElement departureDateSelected;

    @FindBy(xpath = "//div[@class='D_FSF__col returnDate__col ']")
    private WebElement returnDateSelected;

    @FindBy(css = "button[data-testid='formSubmitButton']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[text()='Tahmini Toplam Fiyat: ']")
    private WebElement expectedTotalCostText;

    @FindBy(css = "#transitFilter")
    private WebElement directFilter;



    public void acceptCookies() {
        core.clickTo(cookiesLocator,3);
    }


    public void selectOrigin () {
        core.clickTo(originLocator,3);
        core.sendKeysTo(originLocator, ConfigReader.getProperty("origin"));
        core.clickTo(firstSuggestionOrigin,3);
    }

    public boolean isOriginSelected () {
        String actualValue = originSelectedText.getAttribute("value");
        return actualValue.contains(ConfigReader.getProperty("origin"));

    }

    public void selectDestination () {
        core.clickTo(destinationLocator,3);
        core.sendKeysTo(destinationLocator, ConfigReader.getProperty("destination"));
        core.clickTo(firstSuggestionDestination,3);
    }

    public boolean isDestinationSelected() {
        String actualValue = firstSuggestionDestinationText.getAttribute("value");
        return actualValue.contains(ConfigReader.getProperty("destination"));
    }

    public void selectDepartureDate() {
        core.clickTo(departureDate,2);
        calenderGeneral.get(0 + IData.DEPARTURE_DAY).click();
    }

    public void selectReturnDate () {
        core.clickTo(returnDateInput,2);
        calenderGeneral.get(0 + IData.RETURN_DAY).click();
    }

    public Boolean isDepartureDaySelected () {
        return departureDateSelected.isEnabled();
    }

    public Boolean isReturnDaySelected () {
        return returnDateSelected.isEnabled();
    }

    public void submitFlightInfo () {
        core.clickTo(submitButton,2);
    }

    public boolean isFormSubmitted () {
        String actualText = expectedTotalCostText.getText();
        String expectedText = "Tahmini Toplam Fiyat: ";
        return actualText.contains(expectedText);
    }

    public void clickDirectFlightCheckBox () {
        core.clickTo(directFilter,2);
    }

    public boolean isDirectFlightsSelected (boolean isDirect) {
        if (isDirect){
            directFilter.click();
        }
        return isDirect;
    }




}
