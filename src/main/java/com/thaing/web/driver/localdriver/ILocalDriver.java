package com.thaing.web.driver.localdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface ILocalDriver {
    WebDriver createDriver(DesiredCapabilities desiredCapabilities);
}
