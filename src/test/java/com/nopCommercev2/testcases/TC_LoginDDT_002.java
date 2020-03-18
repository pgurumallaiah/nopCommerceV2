package com.nopCommercev2.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageobjects.LoginPage;
import com.nopCommercev2.utilities.XLUtils;

public class TC_LoginDDT_002 extends Baseclass
{

@Test(dataProvider="Logindata")
public void loginTest(String user,String pwd) throws InterruptedException
{
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setusername(username);
		logger.info("User provided"); //logger msg
		
		lp.setpassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clicklogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clicklogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} 
		else {
			
//			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
	


@DataProvider(name="Logindata")
public String[][] getData() throws IOException
{
	
	

	 String path=System.getProperty("user.dir")+"/src/test/java/com/copCommercev2/testData/LoginData.xlsx";
	 int rownum=XLUtils.getRowCount(path, "Sheet1");
	 int colcount=XLUtils.getCellCount(path, "Sheet1",1);
	 
	 String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;

}
}