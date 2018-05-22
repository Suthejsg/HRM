package com.hrm.PFM;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LogTest1 extends BaseTest {
	
	@BeforeSuite
	public void bs()
	{
		logger=Logger.getLogger(this.getClass().getName());
	}
	
	
	@Test
	public void checkLogs()
	{
		
		testStart("Vtest");
		
	}

}
