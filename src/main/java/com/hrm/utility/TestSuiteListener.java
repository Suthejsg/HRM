package com.hrm.utility;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;

import com.hrm.PFM.BaseTest;

public class TestSuiteListener implements ISuiteListener{

	@Override
	public void onFinish(ISuite suite) {
		
		//System.out.println("The level of Log is " +logger.getLevel());
		//logger.info("Getting host name");
		String hostname=suite.getHost();
		System.out.println("Hostname is "+hostname);
		//logger.info("Hostname is "+hostname);
		List<ITestNGMethod> methods=suite.getAllMethods();
		System.out.println("Total methods is "+methods.size());
		
		
		for(ITestNGMethod method:methods)
		{
			boolean b=method.isTest();
			String name=method.getMethodName();
			
			if (b==false)
				System.out.println("The following method "+name+" is not test");
			else
				System.out.println("The following method "+name+" is a test");
		}
		
	}

	@Override
	public void onStart(ISuite suite) {
		
		//logger.info("Getting All the keys");
		Map<String,ISuiteResult> resultmap=suite.getResults();
		
		Set<String> keys=resultmap.keySet();
		
		Iterator it=keys.iterator();
		
		while(it.hasNext())
		{
			String key=(String)it.next();
			System.out.println("The Key name is "+key);
			System.out.println("The result of the key is " +resultmap.get(key));
		}
				
		
		
	}
	
	

}
