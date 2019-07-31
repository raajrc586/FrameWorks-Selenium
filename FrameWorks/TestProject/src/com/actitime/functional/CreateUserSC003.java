package com.actitime.functional;

import org.testng.annotations.Test;

import com.actitime.coflict.ConflictLib;
import com.actitime.pagerepo.Login;
import com.actitime.pagerepo.UsersPage;

public class CreateUserSC003 extends ConflictLib 
{
	@Test 
	public void createUserTC001()
	{
		Login l = new Login(driver);
		l.login();
		UsersPage user = new UsersPage(driver);
		user.click_users();
		user.createUsers(1);
		user.logout();
	}
}
