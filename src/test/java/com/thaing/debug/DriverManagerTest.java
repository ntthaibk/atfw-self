package com.thaing.debug;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thaing.core.di.ServiceInjection;
import com.thaing.core.module.WebDriverModule;
import com.thaing.dto.data.RegisterData;
import com.thaing.listener.TestListener;
import com.thaing.utils.ObjectMapperUtils;
import com.thaing.web.driver.DriverFactory;
import com.thaing.web.driver.DriverManager;
import com.thaing.web.pages.LoginPage;
import com.thaing.web.pages.RegisterPage;
import com.thaing.web.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class DriverManagerTest extends ServiceInjection {
    @Test
    @Parameters("browserName")
    public void initDriverBasedOnBrowserName(@Optional("chrome") String browserName) {
        WebDriver driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
        DriverManager.setDriver(driver);
        Injector injector = Guice.createInjector(new WebDriverModule());
        loginPage = injector.getInstance(LoginPage.class);
        registerPage = injector.getInstance(RegisterPage.class);
        wait = injector.getInstance(Wait.class);
        driver.get("https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/login");
        loginPage.clickOnRegisterButton();
        RegisterData data = ObjectMapperUtils.fromJsonFile("registerData", RegisterData.class);
        registerPage.setRegisterCredentials(data);
        registerPage.setOtp(data);
        registerPage.verifyAccountRegisteredSuccessfully();
    }
}
