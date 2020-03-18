package com.nopCommercev2.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageobjects.Addcustomerpage;
import com.nopCommerce.pageobjects.LoginPage;
import com.nopCommerce.pageobjects.SearchCustomerPage;

public class TC_SearchCustomerByRoles_006 extends Baseclass {

	@Test(priority = 1)
	public void searchCustomerbyRoles() throws IOException, InterruptedException {
		driver.get(baseURL);
		driver.manage().window().maximize();

		// Login
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.clicklogin();

		// Goto Search Page
		Addcustomerpage addcust = new Addcustomerpage(driver);

		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();

		// Provide FirstName and LastName in Search Page

		SearchCustomerPage serachcust = new SearchCustomerPage(driver);
		serachcust.setCustomerRoles("Guests");

		serachcust.clickSearch();

		Thread.sleep(5000);
		
		// validation

		// pager
		WebElement pager = driver.findElement(By.xpath("//*[@id='customers-grid']//div[@data-role='pager']"));
		int pager_links = pager.findElements(By.tagName("li")).size();

		System.out.println("Number of pager links:" + pager_links);
		
		boolean flag = true;

		if (pager_links >= 1) {
			
			int i = 1; 
			do
			{					
				WebElement table = driver.findElement(By.xpath("//*[@id='customers-grid']//table[@role='grid']"));

				int rows = table.findElements(By.xpath("//tbody/tr")).size();
				int cols = table.findElements(By.xpath("//tbody/tr/td")).size();

				System.out.println("Page link-->" + i + "Number rows in a table-->" + rows);
				i++;
				
				for (int r = 1; r <= rows; r++) {
					String Customer_roles = table.findElement(By.xpath("//tbody/tr[" + r + "]/td[4]")).getText();

					if (!Customer_roles.contains("Guests")) {
						Assert.assertTrue(false);
						flag = false;
						break;
					}
					//Thread.sleep(3000);
				}
				
				WebElement link = pager.findElement(By.xpath("//a[contains(text(),'" + i + "')]"));// 2
				link.click();
				Thread.sleep(3000);
			}
			while(i < pager_links);
				
			if (flag = true) {
				Assert.assertTrue(true);
			}

			else {
				System.out.println("No record found");
			}
		}
	}
}
