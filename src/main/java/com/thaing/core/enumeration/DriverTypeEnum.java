package com.thaing.core.enumeration;

import com.thaing.web.driver.localdriver.ChromeDriverManager;
import com.thaing.web.driver.localdriver.FirefoxDriverManager;

public enum DriverTypeEnum {
    CHROME("Chrome", ChromeDriverManager.class),
    FIREFOX("Firefox", FirefoxDriverManager.class);

    private String driverName;

    @SuppressWarnings("rawtypes")
    private Class className;

    @SuppressWarnings("rawtypes")
    DriverTypeEnum(String driverName, Class className) {
        this.driverName = driverName;
        this.className = className;

    }

    public static DriverTypeEnum getDriverTypeByDriverName(String driverName) {

        for (DriverTypeEnum type : DriverTypeEnum.values()) {
            if (driverName.equalsIgnoreCase(type.driverName)) {
                return type;
            }
        }
        throw new IllegalArgumentException(String.format("There's no driver of type [%s] is supported", driverName));
    }


    @SuppressWarnings("unchecked")
    public static <T> Class<T> getDriverClassByDriverName(String driverName) {
        for (DriverTypeEnum type : DriverTypeEnum.values()) {
            if (driverName.equalsIgnoreCase(type.driverName)) {
                return type.className;
            }
        }
        throw new IllegalArgumentException(String.format("There's no driver of type [%s] is supported", driverName));
    }
}
