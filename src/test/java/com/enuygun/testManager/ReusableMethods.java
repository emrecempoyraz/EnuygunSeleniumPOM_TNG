package com.enuygun.testManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    private final WebDriver driver ;

    public ReusableMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTo (WebElement element, long waitTimeInSeconds) {
        WebDriverWait wait = getWait(waitTimeInSeconds);
        WebElement elements;
        elements = wait.until(ExpectedConditions.elementToBeClickable(element));
        elements.click();
    }

    public void sendKeysTo (WebElement element , String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    private WebDriverWait getWait (long waitTimeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
    }

    public static ExpectedCondition <WebElement> waitForElement (WebElement element) {
        return ExpectedConditions.visibilityOf(element);
    }

}
