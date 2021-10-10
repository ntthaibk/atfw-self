package com.thaing.unittest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thaing.core.di.ServiceInjection;
import com.thaing.core.module.WebDriverModule;
import com.thaing.web.driver.DriverFactory;
import com.thaing.web.driver.DriverManager;
import com.thaing.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DriverManagerTest extends ServiceInjection {
    @Test
    public void initDriverBasedOnBrowserName() {
        String browserName = "chrome";
        WebDriver driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
        DriverManager.setDriver(driver);
        Injector injector = Guice.createInjector(new WebDriverModule());
        loginPage = injector.getInstance(LoginPage.class);
        driver.get("https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/login");
        loginPage.verifyLoginLabelDisplayedCorrectly();

    }
}
