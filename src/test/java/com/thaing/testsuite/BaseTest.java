package com.thaing.testsuite;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thaing.core.di.ServiceInjection;
import com.thaing.core.module.WebDriverModule;
import com.thaing.web.driver.DriverFactory;
import com.thaing.web.driver.DriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest extends ServiceInjection {
    @BeforeTest
    @Parameters({"browserName", "defaultTimeOut"})
    public void initInjector(String browserName, int timeOut) {
        Injector injector = Guice.createInjector(new WebDriverModule());
        driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
        DriverManager.setDriver(driver);

    }


    @AfterTest
    public void afterTest() {
        DriverManager.quit();
    }

}
