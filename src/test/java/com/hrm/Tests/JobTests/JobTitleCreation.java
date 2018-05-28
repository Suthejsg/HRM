package com.hrm.Tests.JobTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.PFM.WebBaseTest;
import com.hrm.PFM.pages.AdminPage;
import com.hrm.PFM.pages.LoginPage;
import com.hrm.pages.Admin.UsersCreationPage;
import com.hrm.utility.TestUtility;
import com.relevantcodes.extentreports.LogStatus;

public class JobTitleCreation extends WebBaseTest {
	
	
	
	@Test(priority=1)
	public void login()
	{
		extentLog.log(LogStatus.INFO, "Logging into hrm application");
		LoginPage loginpage=new LoginPage();
		loginpage.Login("Admin", "admin");
		Assert.assertTrue(driver.getTitle().equals("OrangeHRM"), "Login Successfull");
			
	}
	
	@Test(priority=2)
	public void createJobTitle()
	{
		extentLog.log(LogStatus.INFO, "Creating the User Login");
		AdminPage adminpage=maintab.openAdminTab();
		extentLog.log(LogStatus.INFO, "Admin Page Opened");
		try {
			extentLog.log(LogStatus.INFO, TestUtility.takeScreenShot(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UsersCreationPage usercreationPage=adminpage.openUsersCreationPage();
		usercreationPage.userCreation("Admin", "Hannah Flores", "empUser1", "empuser1", "Enabled");
		
		Assert.assertTrue(usercreationPage.verifyCreatedUser("Hannah Flores"),"User Created Successfully");
	}

}
