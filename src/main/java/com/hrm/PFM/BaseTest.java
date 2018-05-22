package com.hrm.PFM;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	
	public BaseTest()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/hrm/PFM/Config/Config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void testStart(String Testname)
	{
		String browserName=prop.getProperty("browserName");
		String implicitTimeOut=prop.getProperty("IMPLICIT_TIMEOUT");
		long it=Long.parseLong(implicitTimeOut);
		String pageLoadTimeOut=prop.getProperty("PAGE_LOAD_TIMEOUT");
		long pt=Long.parseLong(pageLoadTimeOut);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("start-maximized");
			driver=new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(it, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pt, TimeUnit.SECONDS);
		}
		
		else if(browserName.equals("mozilla"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
				
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(it, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(pt, TimeUnit.SECONDS);
			}
		
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(it, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pt, TimeUnit.SECONDS);
		}
		
	}

}
