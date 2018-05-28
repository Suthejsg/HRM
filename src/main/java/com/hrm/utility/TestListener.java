package com.hrm.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrm.PFM.BaseTest;

public class TestListener implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test name is "+result.getTestName());
		System.out.println("The test name is "+result.getStatus());
		System.out.println("The time of the test is "+result.getStartMillis());
		System.out.println("The instance name is "+result.getInstanceName());
		System.out.println("The instance name is "+result.getInstanceName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("The test name is "+result.getTestName());
		System.out.println("The time of the test is "+result.getStartMillis());
		System.out.println("The instance name is "+result.getInstanceName());
		System.out.println("The instance name is "+result.getInstanceName());
		
		
	}

}
