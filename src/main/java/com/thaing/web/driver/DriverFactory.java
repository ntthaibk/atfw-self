package com.thaing.web.driver;

import com.thaing.web.driver.localdriver.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createInstance(String browser, DesiredCapabilities desiredCapabilities) {
        WebDriver webdriver;
        webdriver = new LocalDriverManager().createInstance(browser, desiredCapabilities);
        return webdriver;
    }
}
