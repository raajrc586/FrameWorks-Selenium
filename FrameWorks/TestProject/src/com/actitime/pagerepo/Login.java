package com.actitime.pagerepo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.actitime.genericutils.GenericLib;

import bsh.commands.dir;
public class Login
{
	
	WebDriver driver;
	@FindBy(id="username")
	private WebElement user_name;
	@FindBy(name="pwd")
	private WebElement password;
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement logged_in_check;
	@FindBy(id="loginButton")
	private WebElement login_btn;
	@FindBy(id="licenseLink")
	private WebElement lisence_link;  
	
	
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login()
	{
//		String user = GenericLib.getExcelData("login_details", 1, 0);
		user_name.sendKeys(GenericLib.getExcelData("login_details", 1, 0));
		password.sendKeys(GenericLib.getExcelData("login_details", 1, 1));
		logged_in_check.click();
		login_btn.click();
	}
	
	
	
}
