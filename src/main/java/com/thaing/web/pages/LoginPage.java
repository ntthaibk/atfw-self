package com.thaing.web.pages;

import com.google.inject.Inject;
import com.thaing.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginToAspireLabel;

    @Inject
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginLabelDisplayedCorrectly() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginToAspireLabel));
        loginToAspireLabel.sendKeys("abcdxyz");
        LogUtils.info("Just Test");
    }
}
