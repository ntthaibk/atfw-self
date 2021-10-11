package com.thaing.dto.data;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.DecimalFormat;
import java.util.Random;

@Data
@NoArgsConstructor
public class RegisterData {
    @Expose
    private String userName;

    @Expose
    private String emailAddress;

    @Expose
    private String phoneNumber;

    @Expose
    private String referralSource;
    @Expose
    private String otpCode;

    public String getPhoneNumber() {
        Random rand = new Random();
        int num = rand.nextInt(999999999);
        DecimalFormat df = new DecimalFormat("000000000");
        this.phoneNumber = df.format(num);
        return this.phoneNumber;
    }

    public String getEmailAddress() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return String.format("%s@gmail.com", generatedString);
    }


}
