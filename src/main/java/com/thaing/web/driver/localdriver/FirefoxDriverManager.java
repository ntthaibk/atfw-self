package com.thaing.web.driver.localdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager implements ILocalDriver {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        FirefoxOptions options = new FirefoxOptions();
        options.merge(desiredCapabilities);
        return new FirefoxDriver(options);
    }


}
