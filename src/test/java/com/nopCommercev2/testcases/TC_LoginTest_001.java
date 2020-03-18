package com.nopCommercev2.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageobjects.LoginPage;


public class TC_LoginTest_001 extends Baseclass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
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
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration1")) {
			lp.clicklogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} else {
			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
	
	
}
