package com.thaing.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IDriver {
    WebDriver createInstance(String browser, DesiredCapabilities desiredCapabilities);
}
