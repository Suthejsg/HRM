package com.hrm.pages.Jobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.PFM.BaseTest;

public class JobTitlePage extends BaseTest {
	
	/*----------------------------------Job Title Creation Buttons-------------------------------------------*/
	
	
	@FindBy(css="input[id='btnAdd']")
	WebElement jobTitleAddButton;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement jobTitleDeleteButton;

	/*--------------------------------------Job Creation---------------------------------------------------*/
	
	@FindBy(id="jobTitle_jobTitle")
	WebElement jobTitleTextbox;
	
	@FindBy(id="jobTitle_jobDescription")
	WebElement jobDescriptionTextbox;
	
	@FindBy(id="jobTitle_note")
	WebElement jobNoteTextbox;
	
	@FindBy(xpath="//form[@id='frmSystemUser']//p//input[@id='btnSave']")
	WebElement btnSave;
	
	@FindBy(xpath="//form[@id='frmSystemUser']//p//input[@id='btnCancel']")
	WebElement btnCancel;
	
	/*--------------------------------Job Title Creation Results Table-------------------------------------*/	
	@FindBy(xpath="//table[@id='resultTable']//thead")
	WebElement tableHeaders;
	
	@FindBy(xpath="//table[@id='resultTable']//tbody")
	WebElement tablebody;
	
	public JobTitlePage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void jobTitleCreation(String jobTitle,String jobDescription,String jobNote)
	{
		logger.info("Creating job Title");
		
		jobTitleTextbox.clear();
		jobTitleTextbox.sendKeys(jobTitle);
		
		jobDescriptionTextbox.clear();
		jobDescriptionTextbox.sendKeys(jobDescription);
		
		jobNoteTextbox.clear();
		jobNoteTextbox.sendKeys(jobNote);
		
		btnSave.click();
		
		logger.info("job Title created successfully");
	}
	
	
	public boolean verifyCreatedJobTitle(String jobTitle)
	{
		logger.info("verifying job Title");
		if(tablebody.findElement(By.xpath("//tr//a[text()='"+jobTitle+"']")).isDisplayed())
			return true;
		else
		{
			logger.info("Job Title verified successfully");
			return false;
		}
	}

}
