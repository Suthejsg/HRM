package com.hrm.PFM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.PFM.BaseTest;

public class AdminPage extends BaseTest {
	
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
	WebElement userManagementDropdown;
	
	@FindBy(linkText="Users")
	WebElement userCreationOption;
	
	
	@FindBy(id="menu_admin_Job")
	WebElement jobDropdown;
	
	@FindBy(linkText="Job Titles")
	WebElement jobTitleCreationOption;	
	
	@FindBy(id="systemUser_userType")
	Select userroleSelect;
	
	@FindBy(id="systemUser_status")
	Select statusSelect;
	
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

	
	
	
	public AdminPage()
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void createUser(String userRole,String employeename,String username,String status,String password,String cpassword)
	{
		userroleSelect.selectByValue(userRole);
		employeeNameTextBox.clear();
		employeeNameTextBox.sendKeys(employeename);
		userNameTextBox.clear();
		userNameTextBox.sendKeys(username);
		userroleSelect.selectByValue(status);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		confirmpasswordTextBox.clear();
		confirmpasswordTextBox.sendKeys(cpassword);
		btnSave.click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='menu']//li//b[contains(text(),'Admin')]/../../..//li"),"class", "current"));
	}
	
	public boolean verifyCreatedUser(String userName)
	{
		
		boolean b=driver.findElement(By.xpath("//table[@id='resultTable']//tbody//tr//td//a[text()='"+ userName+"']")).isDisplayed();
		return b;
	}

}
