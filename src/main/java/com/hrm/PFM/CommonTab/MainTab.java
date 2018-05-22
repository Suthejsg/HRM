package com.hrm.PFM.CommonTab;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainTab {
	
	
	@FindBy(linkText="Admin")
	WebElement Admin;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIM;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement Leave;
	
	@FindBy(linkText="Recruitment")
	WebElement recruitment;
	
	@FindBy(linkText="Performance")
	WebElement Performance;
	
	@FindBy(xpath="//div[@class='menu']//a[@id='menu_time_viewTimeModule']")
	WebElement Time;
	
	public MainTab(WebDriver driver,Logger logger)
	{
		PageFactory.initElements(driver,this);
	}
	
	

}
