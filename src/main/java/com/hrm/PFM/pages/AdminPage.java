package com.hrm.PFM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.PFM.BaseTest;
import com.hrm.pages.Admin.UsersCreationPage;
import com.hrm.pages.Jobs.EmploymentStatusPage;
import com.hrm.pages.Jobs.JobCategoriesPage;
import com.hrm.pages.Jobs.PayGradesPage;
import com.hrm.pages.Jobs.WorkShiftspage;

public class AdminPage extends BaseTest {
	
	/*******************Users*******************************/
	@FindBy(linkText="User Management")
	WebElement usermanagementDropdown;
	
	@FindBy(xpath="//a[text()='User Management']/..//a[text()='Users']")
	WebElement users;
	
	/*************************** Jobs****************************/
	
	@FindBy(linkText="Job")
	WebElement jobdropdown;
	
	@FindBy(linkText="Job Titles")
	WebElement jobTitles;
	
	@FindBy(linkText="Pay Grades")
	WebElement payGrades;
	
	@FindBy(linkText="Employment Status")
	WebElement employmentStatus;
	
	@FindBy(linkText="Job Categories")
	WebElement jobCategories;

	@FindBy(linkText="Work Shifts")
	WebElement workShifts;
		
	
	public AdminPage()
	{
		super();
		PageFactory.initElements(driver,this);
	}
	

	public UsersCreationPage openUsersCreationPage()
	{
		
		logger.info("Opening User Creation Page");
		UsersCreationPage usercreationPage=new UsersCreationPage();
		Actions action=new Actions(driver);
		action.moveToElement(usermanagementDropdown);
		action.click(users);
		action.build().perform();
		logger.info("User Creation Page opened successfully");
		return usercreationPage;
		
	}
	
	
	public JobTitlePage openjobTitlePage()
	{
		
		logger.info("Opening Job Title Page");
		JobTitlePage jobTitleCreationPage=new JobTitlePage();
		Actions action=new Actions(driver);
		action.moveToElement(jobdropdown);
		action.click(jobTitles);
		logger.info("Job Title Page opened successfully");
		return jobTitleCreationPage;
		
	}
	
	
	public PayGradesPage openPayGradesPage()
	{
		
		logger.info("Opening Pay Grades Page");
		PayGradesPage payGradesPage=new PayGradesPage();
		Actions action=new Actions(driver);
		action.moveToElement(jobdropdown);
		action.click(payGrades);
		logger.info("Pay Grades Page opened successfully");
		return payGradesPage;
		
	}
	
	public EmploymentStatusPage openEmploementStatusPage()
	{
		
		logger.info("Opening Employment Status Page");
		EmploymentStatusPage emplymentstatusPage=new EmploymentStatusPage();
		Actions action=new Actions(driver);
		action.moveToElement(jobdropdown);
		action.click(employmentStatus);
		logger.info("Employment Status Page opened successfully");
		return emplymentstatusPage;
		
	}
	
	public JobCategoriesPage openJobCategoriesPage()
	{
		
		logger.info("Opening Job Categories Page");
		JobCategoriesPage jobCategoriesPage=new JobCategoriesPage();
		Actions action=new Actions(driver);
		action.moveToElement(jobdropdown);
		action.click(jobCategories);
		logger.info("Job Categories Page opened successfully");
		return jobCategoriesPage;
		
	}
	
	
	public WorkShiftspage openWorkShiftsPage()
	{
		
		logger.info("Opening Work Shifts Page");
		WorkShiftspage workshiftsPage=new WorkShiftspage();
		Actions action=new Actions(driver);
		action.moveToElement(jobdropdown);
		action.click(workShifts);
		logger.info("Work Shifts Page successfully");
		return workshiftsPage;
		
	}
	
	


}
