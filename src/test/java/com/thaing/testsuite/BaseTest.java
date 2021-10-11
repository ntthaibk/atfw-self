package com.thaing.testsuite;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thaing.core.di.ServiceInjection;
import com.thaing.core.module.WebDriverModule;
import com.thaing.web.driver.DriverFactory;
import com.thaing.web.driver.DriverManager;
import com.thaing.web.pages.LoginPage;
import com.thaing.web.pages.RegisterPage;
import com.thaing.web.wait.Wait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends ServiceInjection {
    @BeforeTest
    @Parameters({"browserName"})
    public void initInjector(@Optional("chrome") String browserName) {
        Injector injector = Guice.createInjector(new WebDriverModule());
        driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
        DriverManager.setDriver(driver);
        //TODO: consider another place for injector
        loginPage = injector.getInstance(LoginPage.class);
        wait = injector.getInstance(Wait.class);
        registerPage = injector.getInstance(RegisterPage.class);


    }


    @AfterTest
    public void afterTest() {
        DriverManager.quit();
    }

}
