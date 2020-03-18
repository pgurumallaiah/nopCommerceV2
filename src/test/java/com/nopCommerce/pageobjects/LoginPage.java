package com.nopCommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		 
	}
	
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;
	
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnlogin;
	
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement lnklogout;
	
	public void setusername(String uname){
		txtemail.sendKeys(uname);	
	}
	
	
	public void setpassword(String pwd){
		txtpassword.sendKeys(pwd);	
	}
	
	public void clicklogin(){
		btnlogin.click();
	}
	
	
	public void clicklogout(){
		lnklogout.click();
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
