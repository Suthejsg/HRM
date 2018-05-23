package com.hrm.PFM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.PFM.BaseTest;

public class LoginPage extends BaseTest {
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement usernameTextBox;
	
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement usernameAfterLogin;
	
	
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void Login(String username,String Password)
	{
		usernameTextBox.clear();
		usernameTextBox.sendKeys("Admin");
		passwordTextBox.clear();
		loginButton.click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(usernameAfterLogin, "Welcome "+username));
	}

}
