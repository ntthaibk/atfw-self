package com.thaing.web.pages;

import com.google.inject.Inject;
import com.thaing.core.constant.RegisterPageConstant;
import com.thaing.dto.data.RegisterData;
import com.thaing.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    private static final String DROP_DOWN_OPTION = "//div[@class='q-item__label'][text()='%s']";
    private static final String OTP_HIGH_LIGHT_TEXT = "//div[contains(@class,'digit-input__input') and contains(@class,'digit-input__input--highlight')]";
    private static final String LOADING_ICON = "//div[contains(@class,'q-inner-loading')]";
    @FindBy(xpath = "//input[@data-cy='register-person-name']")
    private WebElement registerNameTextBox;
    @FindBy(xpath = "//input[@data-cy='register-person-email']")
    private WebElement registerEmailTextBox;
    @FindBy(xpath = "//input[@data-cy='register-person-phone']")
    private WebElement registerPhoneTextBox;
    @FindBy(xpath = "//input[@data-cy='register-person-heard-about']")
    private WebElement referralSourceDropDown;
    private WebElement referralOption;
    @FindBy(xpath = "//div[@data-cy='register-person-privacy']")
    private WebElement agreeTermCheckBox;
    @FindBy(xpath = "//button//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[contains(@class,'q-inner-loading')]")
    private WebElement loadingIcon;
    @FindBy(xpath = "//p[contains(@class,'screen__content-text')]")
    private WebElement screenContextText;

    @Inject
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setRegisterCredentials(RegisterData data) {
        LogUtils.info("set user credential for registration");
        wait.waitForElementDisplay(registerNameTextBox);
        registerNameTextBox.sendKeys(data.getUserName());
        registerEmailTextBox.sendKeys(data.getEmailAddress());
        wait.waitForElementDisplay(registerPhoneTextBox);
        registerPhoneTextBox.sendKeys(data.getPhoneNumber());
        selectReferralDropDown(data);
        agreeTermCheckBox.click();
        continueButton.click();
    }


    public void setOtp(RegisterData data) {
        LogUtils.info("Set OTP to create User");
        By otpHighLightTextBoxXpath = By.xpath(OTP_HIGH_LIGHT_TEXT);
        By loadingIconXpath = By.xpath(LOADING_ICON);
        wait.waitForElementPresentByLocator(otpHighLightTextBoxXpath);
        wait.waitForElementNotPresent(loadingIconXpath);
        setOtpToTextBox(data, otpHighLightTextBoxXpath);
    }


    public void verifyAccountRegisteredSuccessfully() {
        wait.waitForElementDisplay(screenContextText);
        Assert.assertEquals(screenContextText.getAttribute("innerText").trim(), RegisterPageConstant.REGISTER_SUCCESSFUL);
    }

    private void selectReferralDropDown(RegisterData data) {
        wait.waitForElementEnabled(referralSourceDropDown);
        referralSourceDropDown.click();
        selectDropDownOption(data);
    }

    private void selectDropDownOption(RegisterData data) {
        By referralOptionLocator = By.xpath(String.format(DROP_DOWN_OPTION, data.getReferralSource()));
        wait.waitForElementPresentByLocator(referralOptionLocator);
        referralOption = driver.findElement(referralOptionLocator);
        wait.waitForElementDisplay(referralOption);
        referralOption.click();
    }

    private void setOtpToTextBox(RegisterData data, By otpHighLightTextBoxXpath) {
        for (char otp : data.getOtpCode().toCharArray()) {
            WebElement otpHighLightTextBox = driver.findElement(otpHighLightTextBoxXpath);
            wait.waitForElementClickable(otpHighLightTextBox);
            otpHighLightTextBox.click();
            Actions actions = new Actions(driver);
            actions.click(otpHighLightTextBox).sendKeys(String.valueOf(otp)).build().perform();
        }
    }
}
