package com.actitime.functional;

import org.testng.annotations.Test;

import sun.rmi.log.LogInputStream;

import com.actitime.coflict.ConflictLib;
import com.actitime.pagerepo.BasePage;
import com.actitime.pagerepo.Login;

public class loginLogoutSC002 extends ConflictLib
{
	@Test
	public void loginLogout() throws InterruptedException
	{
		Login l = new Login(driver);
		l.login();
		BasePage b = new BasePage(driver);
		b.logout();
		
	}
		
}
