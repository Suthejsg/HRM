package com.hrm.PFM;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Logtest extends BaseTest {
	
	@BeforeSuite
	public void bs()
	{
		logger=Logger.getLogger(this.getClass().getName());
	}
	
	
	@Test
	public void checkLogs()
	{
		
		logger.info("Start");
		logger.warn("No Body");
	}

}