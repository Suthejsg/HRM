package Tesng.Listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestInvokedListener implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("The prioriry is "+method.getTestMethod().getPriority());
		
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("The prioriry is "+method.getTestMethod().getPriority());
		System.out.println("BeforeTestCongiguration is "+method.getTestMethod().isBeforeTestConfiguration());
		
	}

	

}
