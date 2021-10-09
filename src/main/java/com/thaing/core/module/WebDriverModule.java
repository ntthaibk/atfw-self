package com.thaing.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.thaing.web.driver.DriverManager;
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
        return new DriverManager().getDriver();
    }
}
