package com.nopCommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

public WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using ="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using ="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how = How.ID, using ="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how = How.ID, using ="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how = How.ID, using ="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
		
	@FindBy(how = How.XPATH, using ="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtcustomerRoles;
	
	
	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstitemAdministrators;
	
	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstitemGuests;
	
	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;

	@FindBy(how = How.ID, using ="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using ="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setDOBMonth(String month)
	{
		drpdobMonth.sendKeys(month);
	}
	
	public void setDOBDate(String date)
	{
		drpdobDay.sendKeys(date);
	}
	
	public void setCompany(String company)
	{
		txtCompany.sendKeys(company);
	}
	
	public void setCustomerRoles(String role) 
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		txtcustomerRoles.click();
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		
		switch(role)
		{
		case "Administrators":
			js.executeScript("arguments[0].click();", lstitemAdministrators); break;
		case "Guests":
			js.executeScript("arguments[0].click();", lstitemGuests); break;
		case "Registered":
			js.executeScript("arguments[0].click();", lstitemRegistered); break;
		case "Vendors":
			js.executeScript("arguments[0].click();", lstitemVendors); break;
		default:
			js.executeScript("arguments[0].click();", lstitemGuests);
		}
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
	
}
