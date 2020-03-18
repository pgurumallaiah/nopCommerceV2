package com.nopCommercev2.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageobjects.Addcustomerpage;
import com.nopCommerce.pageobjects.LoginPage;
import com.nopCommerce.pageobjects.SearchCustomerPage;

public class TC_SearchCustomerByEmail_004 extends Baseclass
{
	
	@Test(priority=1)
	public void searchCustomerbyEmail() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicklogin();
		
		//Goto Search Page
		Addcustomerpage addcust=new Addcustomerpage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
			
		//Provide EMAIL in Search Page
			
		SearchCustomerPage serachcust=new SearchCustomerPage(driver);
		serachcust.setEmail("victoria_victoria@nopCommerce.com");
		
		serachcust.clickSearch();
		
		Thread.sleep(5000);
		
		//validation
		
		WebElement table=driver.findElement(By.xpath("//*[@id='customers-grid']//table[@role='grid']"));
		
		int rows=table.findElements(By.xpath("//tbody/tr")).size();
		int cols=table.findElements(By.xpath("//tbody/tr/td")).size();
		
		System.out.println("Number of rows:"+ rows);
		System.out.println("Number of cols:"+ cols);
		
		boolean flag=false;
		
		for(int i=1;i<=rows;i++)
		{
			String emailid=table.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals("victoria_victoria@nopCommerce.com"))
			{
				Assert.assertTrue(true);
				flag=true;
				break;
			}
		}
		
		if(flag=false)
		{
			Assert.assertTrue(false);
		}
			
	}
	
	
	
}