package com.thaing.testsuite;

import com.thaing.dto.data.RegisterData;
import com.thaing.listener.TestListener;
import com.thaing.utils.ObjectMapperUtils;
import com.thaing.utils.PropertyUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class RegistrationTest extends BaseTest {

    @Test
    public void registrationSuccessfully() {
        RegisterData data = ObjectMapperUtils.fromJsonFile("registerData", RegisterData.class);
        driver.get(PropertyUtils.getInstance().getAutHomePage());
        loginPage.clickOnRegisterButton();
        registerPage.setRegisterCredentials(data);
        registerPage.setOtp(data);
        registerPage.verifyAccountRegisteredSuccessfully();
    }

}
