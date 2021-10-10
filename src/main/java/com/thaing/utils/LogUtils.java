package com.thaing.utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.thaing.utils.report.ExtendReportTestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {


    private static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);

    private LogUtils() {
    }

    public static void info(String message) {
        LOGGER.info(message);
        ExtendReportTestManager.getTest().log(Status.INFO, message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
        ExtendReportTestManager.getTest().log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.BLACK));
    }


}
