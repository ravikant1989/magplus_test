package com.magplus;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.magplus.Driverutil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Magplus_Login extends Pajeobject{
	
	//WebDriver driver;
	ChromeDriver driver;
	public static ExtentTest test;
  @Test(priority=1)
  public void Mag_login() throws IOException {
	  
	  try {
			System.out.println("@Test case 1:");
			test = report.startTest("Test-01 : _Magplus_Login", "Login into magplus");
			driver = Driverutil.getBrowser();
			System.out.println("Login Test case running");
			driver.get(url);
			driver.findElement(By.id("auth_key")).sendKeys(user);
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.className("btn")).click();
			test.log(LogStatus.INFO, "User logged In Sucessfully: " + url);
			report.endTest(test);
			report.flush();
			//driver.close();
	  

	  
  }
	  
	  catch (Exception e) {

			File srcfile1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(
					path+"login.png"));
			test.log(
					LogStatus.FAIL,
					"User unable to logged In : "
							+ test.addScreenCapture(path+"login.png")+e.toString());
			report.endTest(test);
			report.flush();


		}
}
  
  
  /*@Test(priority=2)
  public void Download_plugin() throws IOException {
	  
	  //String ar[]={"CC 2017","CC 2015","CC 2014","CC","CS 6","CS 5.5","CS 5","CS 4"};
	  try {			FileUtils.deleteDirectory(new File("C://Users//tyagi.ravi//Downloads"));

		  
			System.out.println("@ Test case 2:");
			test = report.startTest("Test-02 : Download", "Download all Version of Designd tool");
			driver = Driverutil.getBrowser();
			System.out.println("Downloading plugin Test case running");
		  
		  int x=driver.findElements(By.xpath("//select[@id='cs_version']//option")).size();
		  System.out.println("Value in x : "+x);
		  for(int i=1; i<=x-8; i++){
			  System.out.println("Working on element "+i);
		  new Select(driver.findElement(By.id("cs_version"))).selectByIndex(i);
		  
		    driver.findElement(By.id("osMac")).click();
			driver.findElement(By.id("download-designd-tools-submit-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("osWin")).click();
			driver.findElement(By.id("download-designd-tools-submit-button")).click();
			Thread.sleep(10000);
			
			
			
			
//			WebElement we=driver.findElement(By.xpath("//select[@id='cs_version']/option["+i+"]"));
//			String option=we.getText();
//			
//			new Select(driver.findElement(By.id("cs_version"))).selectByVisibleText(option);
//			System.out.println("option selected: "+option);
//			
			
		}
		  
		Thread.sleep(10000);
		
		  
			test.log(LogStatus.INFO, "User Download Sucessfully: " + url);
			report.endTest(test);
			report.flush();
	  
  }
	  catch (Exception e) {

			File srcfile1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(srcfile1, new File(
					//path+"download.png"));
			test.log(
					LogStatus.FAIL,
					"User unable to downlaod : "
							+ test.addScreenCapture(path+"downlaod.png")+e.toString());
			report.endTest(test);
			report.flush();


		}
}
  */
  }
