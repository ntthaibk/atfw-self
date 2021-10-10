package com.thaing.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.thaing.web.driver.DriverManager;
import com.thaing.web.wait.Wait;
import org.openqa.selenium.WebDriver;

public class WebDriverModule extends AbstractModule {

    @Override
    protected void configure() {
        /*
        No binding needed since we just need to provide the WebDriver instance
         */
    }

    @Provides
    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @Provides
    public Wait getWait() {
        return new Wait(DriverManager.getDriver());
    }
}
