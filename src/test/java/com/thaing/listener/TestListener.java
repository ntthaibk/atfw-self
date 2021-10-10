package com.thaing.listener;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.thaing.utils.report.ExtendReportManager;
import com.thaing.utils.report.ExtendReportTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtendReportTestManager.startTest(result.getMethod().getMethodName());
        ExtendReportTestManager.getTest().info(result.getMethod().getMethodName() + " test executions started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendReportTestManager.getTest().log(Status.PASS,
                MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendReportTestManager.getTest().log(Status.FAIL,
                MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtendReportTestManager.endTest();
        ExtendReportManager.getInstance().flush();
    }
}
