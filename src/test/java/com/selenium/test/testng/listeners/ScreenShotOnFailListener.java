package com.selenium.test.testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Sidelnikov Mikhail on 14.07.15.
 * This listener adds screenshot taking on test failure
 */
public class ScreenShotOnFailListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println();
        System.out.println("Test <" + iTestResult.getName() + "> successful");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println();
        System.out.println("Test <" + iTestResult.getName() + "> failed");
        //WebDriverFactory.takeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
