package com.thaing.unittest;

import com.thaing.web.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DriverManagerTest {
    @Test
    public void initDriverBasedOnBrowserName() {
        String browserName = "chrome";
        WebDriver driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
        driver.get("https://www.google.com");

    }
}
