package com.thaing.core.di;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;

public class ServiceInjection {

    @Inject
    protected WebDriver driver;

}
