package com.thaing.web.driver.localdriver;

import com.thaing.web.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@NoArgsConstructor
public class LocalDriverManager implements IDriver {
    @Override
    public WebDriver createInstance(String browser, DesiredCapabilities desiredCapabilities) {
        WebDriver driver;
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        WebDriverManager.getInstance(driverManagerType).setup();
        switch (driverManagerType) {
            case CHROME:
                driver = new ChromeDriverManager().createDriver(desiredCapabilities);
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver(desiredCapabilities);
                break;
            default:
                throw new IllegalArgumentException("Not supported browser");
        }
        return driver;
    }
}
