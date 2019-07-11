package com.magplus;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;

public class Pajeobject {
   static String url ;
   static String user;
   static String pass;
   static String path;
   static String P_url;
   static String P_user;
   static String P_pass;
   public static ExtentReports report;
   
	
@BeforeSuite
public void Parameters() throws FileNotFoundException, IOException {
	  Properties prop=new Properties();
	  prop.load(new FileInputStream("src//test//resources//url.properties"));
	  url=(prop.getProperty("url"));
	  user=(prop.getProperty("User"));
	  pass=(prop.getProperty("Pass"));
	  path=(prop.getProperty("path"));
	  P_url=(prop.getProperty("P_url"));
	  P_user=(prop.getProperty("P_user"));
	  P_pass=(prop.getProperty("P_pass"));
	  System.setProperty("webdriver.chrome.driver", "chromedriver//chromedriver.exe");
	  //WebDriver driver = Driverutil.getBrowser();
	  ChromeDriver driver = Driverutil.getBrowser();
	  //JavascriptExecutor jse = (JavascriptExecutor) driver;
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  report = new ExtentReports("Extentreport//report.html", true);
	  
	  
	  System.out.println("Browser launch sucessfully");
}


@AfterSuite()
public void closebrowser() throws InterruptedException {
	Driverutil.closeBrowser();
	System.out
			.println("Closed the browser.................................Ends here test suit");
}
@AfterTest()
public void closeb()
{
	Driverutil.closeBrowser();
	
}
}
