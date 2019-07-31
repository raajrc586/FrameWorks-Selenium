package com.actitime.functional;

import org.testng.annotations.Test;

import com.actitime.coflict.ConflictLib;
import com.actitime.pagerepo.Login;

public class LoginSC_001 extends ConflictLib
{
	@Test
	public void loginTC_001()
	{
		Login l = new Login(driver);
		l.login();
	}
}
