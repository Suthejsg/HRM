package com.hrm.PFM.CommonTab;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTab {
	
	
	WebDriver cdriver=null;
	Logger log=null;
	
	@FindBy(xpath="//a//b[contains(text(),'Admin')]")
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
	
	public MainTab(WebDriver driver,Logger logger)
	{
		log.info("Inside Main Tab Constructor");
		cdriver=driver;
		log=logger;
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void openAdminTab()
	{
		log.info("Inside Admin Tab opening Admin Tab and veryfying Admin tab is open");
		Admin.click();
		WebDriverWait wait=new WebDriverWait(cdriver,30);
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='menu']//li//b[contains(text(),'Admin')]/../../..//li"),"class", "current"));
		
	}
	
	
	public void openPIMTab()
	{
		log.info("Inside PIM Tab opening Admin Tab and veryfying PIM tab is open");
		PIM.click();
		WebDriverWait wait=new WebDriverWait(cdriver,30);
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='menu']//li//b[contains(text(),'PIM')]/../../..//li"),"class", "current"));
	}
	
	
	

}
