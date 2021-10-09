package com.thaing.web.pages;

import com.thaing.core.di.ServiceInjection;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends ServiceInjection {

    BasePage() {
        PageFactory.initElements(driver, this);
    }
}
