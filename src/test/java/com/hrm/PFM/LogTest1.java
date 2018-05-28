package com.hrm.PFM;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.Assert;


@Listeners({com.hrm.utility.TestSuiteListener.class,com.hrm.utility.TestListener.class,com.hrm.utility.TestInvokedListener.class})
public class LogTest1 extends BaseTest {
	
	
	
	
	@Test(testName="Demo",retryAnalyzer = com.hrm.utility.RetryListener.class,dataProviderClass=com.hrm.utility.Datautil.class,dataProvider="getData",invocationCount=10)
	public void checkLogs(HashMap<String,List<String>> maps)
	{
		System.out.println("The colums are "+maps.keySet().size());
		logger.info("Test");
		Assert.assertTrue(1==1,"Assert Condition");
	}
	
	
	
	@Test(testName="Demo1",retryAnalyzer = com.hrm.utility.RetryListener.class, dataProviderClass=com.hrm.utility.Datautil.class,dataProvider="getData")
	public void checkLogs1(HashMap<String,List<String>> maps)
	{
		System.out.println("The colums are "+maps.keySet().size());
		logger.info("Test1");
		Assert.assertFalse(1==1,"Assert false Condition");
	}

	public void sampleMethod()
	{
		System.out.println("This is not test method");
	}
}
