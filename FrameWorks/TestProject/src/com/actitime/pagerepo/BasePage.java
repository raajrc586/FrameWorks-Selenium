package com.actitime.pagerepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage 
{

	WebDriver driver ;
	@FindBy(xpath="//div[text()='Time-Track']")
	private WebElement time_track_tab;
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement tasks_tab;
	@FindBy(xpath="//div[text()='Users']")
	private WebElement users_tab;
	@FindBy(id="logoutLink")
	private WebElement logout_link;
	public BasePage(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
public	void click_tasks()
	{
		tasks_tab.click();
	}
public void click_users()
	{
		users_tab.click();
	}
public void logout()
	{
		logout_link.click();
		String expected ="Please identify yourself";
		String actual = driver.findElement(By.id("headerContainer")).getText();
		Assert.assertEquals(actual, expected);
	}
}










