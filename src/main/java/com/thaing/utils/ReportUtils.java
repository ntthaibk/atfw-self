package com.thaing.utils;

import com.thaing.core.constant.EnvironmentConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

public class ReportUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportUtils.class);

    private static final String REPORT_PATH = System.getProperty("user.dir") + File.separator + "TestReport";
    private static final DateTimeFormatter SIMPLE_DATE = DateTimeFormatter.ofPattern("dd_MM_yyyy-HH_mm_ss");
    private static final String REPORT_FILE_NAME = String.format("Test-Automaton-Report-%s.html", SIMPLE_DATE.format(now()));
    private static final String REPORT_FILE_LOC = REPORT_PATH + File.separator + REPORT_FILE_NAME;


    private ReportUtils() {
        throw new IllegalStateException(EnvironmentConstant.UTILITY_CLASS_EXCEPTION);
    }

    public static String getReportFileLocation() {
        createReportPath();
        return REPORT_FILE_LOC;
    }

    private static void createReportPath() {
        File testDirectory = new File(ReportUtils.REPORT_PATH);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                LOGGER.info(String.format("Directory [%s] is created!", ReportUtils.REPORT_PATH));
            } else {
                LOGGER.info(String.format("Directory [%s] created failed", ReportUtils.REPORT_PATH));
            }
        } else {
            LOGGER.warn(String.format("Directory [%s] is already exist!", ReportUtils.REPORT_PATH));
        }
    }


}
