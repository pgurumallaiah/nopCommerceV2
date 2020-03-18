package com.nopCommercev2.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageobjects.Addcustomerpage;
import com.nopCommerce.pageobjects.LoginPage;
import com.nopCommerce.pageobjects.SearchCustomerPage;

public class TC_SearchCustomerByName_005 extends Baseclass
{
	
	@Test(priority=1)
	public void searchCustomerbyName() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		//Login
		LoginPage lp=new com.nopCommerce.pageobjects.LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicklogin();
		
		//Goto Search Page
		Addcustomerpage addcust=new Addcustomerpage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
			
		//Provide FirstName and LastName in Search Page
			
		SearchCustomerPage serachcust=new SearchCustomerPage(driver);
		serachcust.setFirstName("Victoria");
		serachcust.setLastName("Terces");	
		
		serachcust.clickSearch();
		
		Thread.sleep(5000);
		
		//validation
		
		WebElement table=driver.findElement(By.xpath("//*[@id='customers-grid']//table[@role='grid']"));
		
		int rows=table.findElements(By.xpath("//tbody/tr")).size();
		int cols=table.findElements(By.xpath("//tbody/tr/td")).size();
				
		boolean flag=false;
		
		for(int i=1;i<=rows;i++)
		{
			String name=table.findElement(By.xpath("//tbody/tr["+i+"]/td[3]")).getText();
					
			String names[]=name.split(" ");
						
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
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