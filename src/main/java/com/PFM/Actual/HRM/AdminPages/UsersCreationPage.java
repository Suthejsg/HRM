package com.PFM.Actual.HRM.AdminPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PFM.Actual.HRM.Base.BaseTest;

public class UsersCreationPage extends BaseTest {
	
/*------------------------------User Search------------------------------------*/
	
	@FindBy(id="searchBtn")
	WebElement userSearchButton;
	
	@FindBy(id="resetBtn")
	WebElement resetButton;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement userSearchUsernametextbox;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement userSearchUserRoleDropDown;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement userSearchEmpnametextbox;
	
	@FindBy(id="searchSystemUser_status")
	WebElement userSearchStatusDropdown;
	
/*--------------------------------User Creation Results Table-------------------------------------*/	
	@FindBy(xpath="//table[@id='resultTable']//thead")
	List<WebElement> tableHeaders;
	
	@FindBy(xpath="//table[@id='resultTable']//tbody")
	List<WebElement> tablebody;
	
/*----------------------------------User Creation Buttons-------------------------------------------*/
	
		
	@FindBy(css="input[id='btnAdd']")
	WebElement userAddButton;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement userdeleteButton;
	
/*--------------------------------------User Creation-------------------------------------*/

	
	@FindBy(id="systemUser_userType")
	WebElement userroleSelect;
	
	@FindBy(id="systemUser_status")
	WebElement statusSelect;
	
	@FindBy(className="formInputText ac_input")
	WebElement employeeNameTextBox;
	
	@FindBy(id="systemUser_userName")
	WebElement userNameTextBox;
	
	@FindBy(id="systemUser_password")
	WebElement passwordTextBox;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement confirmpasswordTextBox;
	
	@FindBy(xpath="//form[@id='frmSystemUser']//p//input[@id='btnSave']")
	WebElement btnSave;
	
	@FindBy(xpath="//form[@id='frmSystemUser']//p//input[@id='btnCancel']")
	WebElement btnCancel;
	
	
	public UsersCreationPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void userCreation(String role,String employeename,String username,String password,String status)
	{
		
		logger.info("Creating the user");
		userAddButton.click();
		
		
		Select selectuserRole=new Select(userroleSelect);
		selectuserRole.selectByIndex(0);
		employeeNameTextBox.clear();
		employeeNameTextBox.sendKeys(employeename);
		
		userNameTextBox.clear();
		userNameTextBox.sendKeys(username);
		
		Select selectStatus=new Select(statusSelect);
		selectStatus.selectByIndex(0);
		
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		
		confirmpasswordTextBox.clear();
		confirmpasswordTextBox.sendKeys(password);
		
		btnSave.click();
		logger.info("user created successfully");
	}
	
	
	public boolean verifyCreatedUser(String employeename)
	{
		logger.info("veryfying the created user");
		boolean flag=false;
		for(WebElement element:tablebody)
		{
			if(element.findElement(By.xpath("//tr//a[text()='"+employeename+"']")).isDisplayed())
			flag=true;
			break;
				
		}
		logger.info("User verified successfully");
		return flag;
		
	}


	public boolean searchByUsername(String username)
	{
		logger.info("search the created username");
		boolean flag=false;
		userSearchUsernametextbox.clear();
		userSearchUsernametextbox.sendKeys(username);
		userSearchButton.click();
		
		for(WebElement element:tablebody)
		{
			if(element.findElement(By.xpath("//tr//a[text()='"+username+"']")).isDisplayed())
			flag=true;
			break;
				
		}
		logger.info("User searched successfully");
		return flag;
		
		
	}

}
