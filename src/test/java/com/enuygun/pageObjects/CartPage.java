package com.enuygun.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "#continue-button")
    private WebElement eMailSection;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage () {
        String actualURL = driver.getCurrentUrl();
        return actualURL.contains("https://www.enuygun.com/ucak-bileti/rezervasyon/");

    }
}
