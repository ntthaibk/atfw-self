package com.thaing.core.di;

import com.google.inject.Inject;
import com.thaing.web.pages.LoginPage;
import com.thaing.web.wait.Wait;
import org.openqa.selenium.WebDriver;

public class ServiceInjection {

    @Inject
    protected WebDriver driver;

    @Inject
    protected LoginPage loginPage;

    @Inject
    protected Wait wait;

}
