package com.thaing.web.wait;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {

    final WebDriverWait webDriverWait;

    WebDriver driver;

    @Inject
    public Wait(WebDriver driver) {
        this.webDriverWait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public void waitForElementDisplay(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsDisplay(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForElementEnabled(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }

    public void waitForElementClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoad() {
        ExpectedCondition<Boolean> javaScriptLoad = webDriver ->
                ((JavascriptExecutor) (webDriver)).executeScript("return document.readyState").equals("complete");
        webDriverWait.until(javaScriptLoad);
    }
}
