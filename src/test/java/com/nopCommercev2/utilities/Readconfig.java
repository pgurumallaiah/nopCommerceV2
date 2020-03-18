package com.nopCommercev2.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

Properties prop;	
public Readconfig(){
File src=new File("./Configuration/config.properties");
try
{
FileInputStream fis=new FileInputStream(src);	
prop=new Properties();
prop.load(fis);
}
catch(Exception e)
{
System.out.println("Exceltion is "+e.getMessage());	
}
}

public String getapplicationurl()
{
	String url=prop.getProperty("baseURL");
	return url;
	
}


public String getuseremail()
{
	String username=prop.getProperty("useremail");
	return username;
	
}
public String getPassword()
{
	String password=prop.getProperty("password");
	return password;
	
}


public String chromepath()
{
	String chromepath=prop.getProperty("chromepath");
	return chromepath;
	
}


public String Firefoxpath()
{
	String firefoxpath=prop.getProperty("firefoxpath");
	return firefoxpath;
	
}

public String iepath()
{
	String iepath=prop.getProperty("iepath");
	return iepath;
	
}






}
