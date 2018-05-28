package com.hrm.PFM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.PFM.BaseTest;

public class JobTitlePage extends BaseTest {
	
	@FindBy(id="jobTitle_jobTitle")
	WebElement jobTitleTextBox;
	
	@FindBy(id="jobTitle_jobDescription")
	WebElement jobDescriptionTextBox;
	
	@FindBy(id="jobTitle_note")
	WebElement jobNoteTextBox;
	
	@FindBy(id="btnSave")
	WebElement jobSaveButton;
	
	public JobTitlePage()
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	
	public void createjobTitle(String jobTitle,String jobDescription,String jobnote)
	{
		logger.info("Creating Job Title");
		logger.info("Entering Job Title");
		jobTitleTextBox.clear();
		jobTitleTextBox.sendKeys(jobTitle);
		
		logger.info("Entering Job Description");
		jobDescriptionTextBox.clear();
		jobDescriptionTextBox.sendKeys(jobDescription);
		
		logger.info("Entering Job Note");
		jobNoteTextBox.clear();
		jobNoteTextBox.sendKeys(jobnote);
		
		logger.info("Clicking on Save button");
		jobSaveButton.click();
		
	}

	public boolean verifyJobTitle(String jobTitle)
	{
		logger.info("Veryfying Job Title");
		boolean b=driver.findElement(By.linkText(jobTitle)).isDisplayed();
		return b;
	}
	
}
