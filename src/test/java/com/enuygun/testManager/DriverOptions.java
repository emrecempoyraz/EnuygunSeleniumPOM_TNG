package com.enuygun.testManager;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverOptions {

    public ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-extensions");
        options.addArguments("disable-popup-blocking");
        return options;
    }
}
