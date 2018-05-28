package com.hrm.PFM.CommonTab;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.PFM.pages.AdminPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MainTab {
	
	
	public static WebDriver cdriver=null;
	public static Logger log=null;
	public static ExtentReports ereport;
	public static ExtentTest etest;
	
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	WebElement Admin;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIM;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement Leave;
	
	@FindBy(xpath="//a//b[contains(text(),'Recruitment')]")
	WebElement recruitment;
	
	@FindBy(linkText="//a//b[contains(text(),'Performance')]")
	WebElement Performance;
	
	@FindBy(xpath="//div[@class='menu']//a[@id='menu_time_viewTimeModule']")
	WebElement Time;
	
	public MainTab(WebDriver driver,Logger logger,ExtentReports reports,ExtentTest extentlog)
	{
		cdriver=driver;
		log=logger;
		ereport=reports;
		extentlog=etest;
		log.info("Inside Main Tab Constructor");

		PageFactory.initElements(driver,this);
	}
	
	
	
	public AdminPage openAdminTab()
	{
		log.info("Inside Admin Tab opening Admin Tab and veryfying Admin tab is open");
		Admin.click();
		WebDriverWait wait=new WebDriverWait(cdriver,30);
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='menu']//li//b[contains(text(),'Admin')]/../../..//li"),"class", "current"));
		log.info("Admin Tab opened Successfully");
		AdminPage adminpage=new AdminPage();
		return adminpage;
	}
	
	
	public PIMPage openPIMTab()
	{
		log.info("Inside PIM Tab opening Admin Tab and veryfying PIM tab is open");
		PIM.click();
		WebDriverWait wait=new WebDriverWait(cdriver,30);
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='menu']//li//b[contains(text(),'PIM')]/../../..//li"),"class", "current"));
		log.info("PIM Tab opened Successfully");
		PIMPage pimpage=new PIMPage();
		return pimpage;
	}
	
	
	
	
	

}
