package com.thaing.core.di;

import com.google.inject.Inject;
import com.thaing.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class ServiceInjection {

    @Inject
    protected WebDriver driver;

    @Inject
    protected LoginPage loginPage;

}
