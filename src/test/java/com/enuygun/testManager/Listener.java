package com.enuygun.testManager;

import jdk.jfr.Description;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        Test test = method.getAnnotation(Test.class);
        Description description = method.getAnnotation(Description.class);

        String testName = test.testName();
        String testDescription = test.description();

        Log.pass(testName + " test is starting.");
        Log.pass(testDescription);
        Log.pass("Description = " + description.value());
    }

    @Override
    public void onStart(ITestContext context) {
        Log.pass(context.getStartDate() + " -> start date.");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }


}
