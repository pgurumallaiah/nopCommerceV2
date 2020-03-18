package com.nopCommercev2.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.nopCommercev2.utilities.Readconfig;

public class Baseclass {
	
	Readconfig config=new Readconfig();
	public String baseURL=config.getapplicationurl();
	public String username=config.getuseremail();
	public String password=config.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("nopCommercev2");
		PropertyConfigurator.configure("log4j.properties");
	
		if(br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", config.chromepath());
			driver = new ChromeDriver();
		}
		
		
	}
//		else if(br.equals("Firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", config.Firefoxpath());
//			driver = new FirefoxDriver();
//		}
//		else if(br.equals("ie"))
//			System.setProperty("webdriver.ie.driver", config.iepath());
//		 driver = new InternetExplorerDriver();
//			
//		
//		}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
	
		System.out.println("Screenshot taken");
	}
	
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		
	}
	
	
	public static String randomestring() {
		String generatedString1 =RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	
	
	
	
	
}
