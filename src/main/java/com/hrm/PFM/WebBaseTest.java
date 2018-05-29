package com.hrm.PFM;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.hrm.PFM.CommonTab.MainTab;
import com.hrm.utility.TestUtility;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.hrm.utility.ExtentReporter.class)
public class WebBaseTest extends BaseTest {
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		extent.addSystemInfo("Application", "HRM Application");
		extent.addSystemInfo("Browser", prop.getProperty("browserName"));
		extent.addSystemInfo("Operating System", "Windows version 10");
		extent.addSystemInfo("Host", "SSG");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		browserInitialization();
		maintab=new MainTab(driver,getlogger(MainTab.class.getName()),getExtentReports(("user.dir")+"/Extent_Reports/"+"HRMExtent.html"),getExtentLog());
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		extentLog.log(LogStatus.INFO,"In BeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		extentLog.log(LogStatus.INFO, "In After Method");
		if(result.getStatus()==result.FAILURE)
		{
			extentLog.log(LogStatus.FAIL, "Test Case Failed"+result.getName());
			extentLog.log(LogStatus.FAIL, "Test Case Failed"+result.getThrowable());
			extentLog.log(LogStatus.FAIL, TestUtility.takeScreenShot(driver));
		}
		
		
		if(result.getStatus()==result.SUCCESS)
		{
			extentLog.log(LogStatus.PASS, "Test Case executed Successfully"+result.getName());
		}
		
		
		if(result.getStatus()==result.SKIP)
		{
			extentLog.log(LogStatus.SKIP, "Test Case skipped"+result.getName());
			extentLog.log(LogStatus.SKIP, "Test Case skipped"+result.getThrowable());
		}
		
	}
	
	@AfterTest
	public void afterTest() throws IOException
	{
		driver.close();
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}
	
	
	@AfterSuite
	public void afterSuite()
	{
		extent.flush();
		extent.close();
		driver.quit();

		
	}

}
