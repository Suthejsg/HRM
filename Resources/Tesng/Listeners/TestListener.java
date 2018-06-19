package Tesng.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.PFM.Actual.HRM.Base.BaseTest;

public class TestListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("The test name is "+result.getTestName());
		System.out.println("The time of the test is "+result.getStartMillis());
		System.out.println("The instance name is "+result.getInstanceName());
		System.out.println("The instance name is "+result.getInstanceName());
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The test name is "+result.getTestName());
		System.out.println("The test name is "+result.getStatus());
		System.out.println("The time of the test is "+result.getStartMillis());
		System.out.println("The instance name is "+result.getInstanceName());
		System.out.println("The instance name is "+result.getInstanceName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
