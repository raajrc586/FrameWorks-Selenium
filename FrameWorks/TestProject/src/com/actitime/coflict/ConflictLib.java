package com.actitime.coflict;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.genericutils.GenericLib;

public class ConflictLib 
{
	public WebDriver driver;
	@BeforeClass
	public void precondition()
	{
		String bowser_name = GenericLib.getExcelData("configure", 1, 0);
		String url = GenericLib.getExcelData("configure", 1, 1);
		if(bowser_name.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		else if(bowser_name.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver_exe/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(bowser_name.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./driver_exe/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterClass
	public void postcondition()
	{
		driver.quit();
	
	}
	
	
	
}
