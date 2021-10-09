package com.thaing.web.driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    @Getter
    @Setter
    private WebDriver driver;

    public void quitDriver() {
        driver.quit();
    }


}
