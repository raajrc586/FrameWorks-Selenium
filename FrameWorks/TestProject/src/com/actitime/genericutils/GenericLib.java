package com.actitime.genericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import bsh.commands.dir;

public class GenericLib 
{
	static String parent;
	static String child;
	
	public static void selectDDLByIndex(WebElement element, int index)
	{
		Select sct = new Select(element);
		sct.selectByIndex(index);
	}
	public static void selectDDLByValue(WebElement element, String value)
	{
		Select sct = new Select(element);
		sct.selectByValue(value);
	}
	
	public static void selectDDLByVisibleText(WebElement element, String text)
	{
		Select sct = new Select(element);
		sct.selectByVisibleText(text);
	}
	public static boolean checkDDLforMultiple(WebElement element)
	{
		Select sct = new Select(element);
		boolean status = sct.isMultiple();
		return status;
	}
	public static void deselectDDLAll(WebElement element)
	{
		Select sct = new Select(element);
		sct.deselectAll();
	}
	
	public static void alertAccept(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void alertDisMiss(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static String alertText(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String str = alt.getText();
		return str;
	}
	
	public static void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public static void contextClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public static void switchToChildWindow(WebDriver driver)
	{
		Set<String> st = driver.getWindowHandles();
		Iterator<String> it = st.iterator();
		 parent = it.next();
		child = it.next();
		driver.switchTo().window(child);
	}
	public static void switchToParentWindow(WebDriver driver)
	{
		driver.close();
		driver.switchTo().window(parent);
	}
	
	public static String getExcelData(String sheet_name, int row_no, int cell_no)
	{
		try
		{
			FileInputStream file = new FileInputStream("./excel_lib/Sample.xlsx");
			Workbook wb = WorkbookFactory.create(file);
			Sheet st =  wb.getSheet(sheet_name);
			Row r = st.getRow(row_no);
			Cell c = r.getCell(cell_no);
			String str = c.getStringCellValue();
			return str;
		}
		catch(Exception e)
		{
			return " ";
		}
		
	}
	public static void storeDatatoExcel(String sheet_name, int row_no, int cell_no, String data)
	{
		try
		{
			FileInputStream file = new FileInputStream("./excel_lib/Sample.xlsx");
			Workbook wb = WorkbookFactory.create(file);
			Sheet st =  wb.getSheet(sheet_name);
			Row r = st.getRow(row_no);
			Cell c = r.getCell(cell_no);
			c.setCellValue(data);
			FileOutputStream fileto = new FileOutputStream("./excel_lib/Sample.xlsx");
			wb.write(fileto);
		}
		catch(Exception e)
		{
			
		}
		
	}
	public static int  getRowNumnber(String sheet_name)
	{
		try
		{
			FileInputStream file = new FileInputStream("./excel_lib/Sample.xlsx");
			Workbook wb = WorkbookFactory.create(file);
			Sheet st =  wb.getSheet(sheet_name);
			int row_no = st.getLastRowNum();
			return row_no;
		}
		catch(Exception e)
		{
			return -1;
		}
		
	}
	public static int  getlastCellNumber(String sheet_name, int row_no)
	{
		try
		{
			FileInputStream file = new FileInputStream("./excel_lib/Sample.xlsx");
			Workbook wb = WorkbookFactory.create(file);
			Sheet st =  wb.getSheet(sheet_name);
			Row r = st.getRow(row_no);
			int cell_no = r.getLastCellNum();
			return cell_no;
		}
		catch(Exception e)
		{
			return -1;
		}
		
	}
}
