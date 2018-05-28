package com.hrm.utility;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestInvokedListener implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		
		System.out.println("The prioriry is "+method.getTestMethod().getPriority());
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult result) {
		
		System.out.println("The prioriry is "+method.getTestMethod().getPriority());
		System.out.println("BeforeTestCongiguration is "+method.getTestMethod().isBeforeTestConfiguration());
		
	}

}
