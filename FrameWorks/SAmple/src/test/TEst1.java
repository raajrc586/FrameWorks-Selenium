package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TEst1 
{
	@Test(dataProvider="student", priority=1)
	public void t2(String name, String roll_no)
	{
		System.out.print(name+"\t");
		System.out.print(roll_no+"\n");
	}
	@Test(priority=2)
	public void t3()
	{
		System.out.println("Running t3 method");
	}

	@DataProvider(name="student")
	public Object[][] t1()
	{
		Object [][] obj = new Object[4][2];
		obj[0][0] = "Ram";
		obj[0][1] = "001";
		obj[1][0] = "Sam";
		obj[1][1] = "002";
		obj[2][0] = "Kalyan";
		obj[2][1] = "003";
		return obj;
	}
	
	
}
