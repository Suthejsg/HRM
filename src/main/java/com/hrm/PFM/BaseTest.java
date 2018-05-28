package com.hrm.PFM;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LogLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hrm.PFM.CommonTab.MainTab;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentTest extentLog;
	public MainTab maintab;
	
	public BaseTest()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/hrm/PFM/Config/Config.properties");
			prop.load(fis);
			
			maintab=new MainTab(driver,getlogger(MainTab.class.getName()),getExtentReports(("user.dir")+"/Extent_Reports/"+"HRMExtent.html"),getExtentLog());
			logger=getlogger(getClass().getName());
			extent=getExtentReports(("user.dir")+"/Extent_Reports/"+"HRMExtent.html");
			extentLog=extent.startTest("Starting Logs and test");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public ExtentTest getExtentLog() {
		
		extentLog=extent.startTest("Starting Logs and test");
		return extentLog;
	}



	public void browserInitialization()
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
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile firefoxprofile=profile.getProfile("TestSelenium");
				driver=new FirefoxDriver(firefoxprofile);
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
	
	public Logger getlogger(String testCaseName)
	{
		logger=Logger.getLogger(testCaseName);
		logger.setLevel(Level.INFO);
		return logger;
	}
	
	
	public ExtentReports getExtentReports(String path)
	{
		extent=new ExtentReports(path,true);
		return extent;
	}

	
	
	
}
