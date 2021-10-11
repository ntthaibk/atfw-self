package com.thaing.web.pages;

import com.google.inject.Inject;
import com.thaing.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInputTextBox;

    @FindBy(linkText = "Register")
    private WebElement registerButton;


    @Inject
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnRegisterButton() {
        LogUtils.info("Click on Register button");
        wait.waitForElementClickable(registerButton);
        registerButton.click();
    }
}
