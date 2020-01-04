package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Testbase {

	 public static WebDriver driver;
	 public static Properties prop;
	  
	 public Testbase() {
		try { 
		 prop= new Properties();
		 FileInputStream fis=new FileInputStream("/Users/703177683MB/eclipse-workspace/connectblotter/src/main/java/com/qa/config/config.properties");
		 prop.load(fis);
	 } 
	 catch (IOException e) {
		 e.getMessage();
	 }
}
public static void initializeDriver()
{
	
    String browserName=prop.getProperty("browser");
    
    if(browserName.equals("chrome"))
    {
    	System.setProperty("chromedriver", "usr/local/bin");
	    driver= new ChromeDriver();
	}
    
    else if (browserName.equals("firefox"))
    {
	    driver= new FirefoxDriver();
    }
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
    
    driver.get(prop.getProperty("url"));
    byte[] decodePassword = Base64.decodeBase64(prop.getProperty("password"));
	System.out.println(decodePassword);
	
    
    
}



public void getScreenshot(String result) throws IOException{

	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}

}
