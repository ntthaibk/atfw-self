package com.thaing.web.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginToAspireLabel;

    @Inject
    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginLabelDisplayedCorrectly() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginToAspireLabel));
        loginToAspireLabel.sendKeys("abcdxyz");
    }
}
