package com.thaing.web.pages;

import com.thaing.core.di.ServiceInjection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends ServiceInjection {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
