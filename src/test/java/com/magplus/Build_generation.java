package com.magplus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Build_generation extends Pajeobject{
	ChromeDriver driver;
	public static ExtentTest test;
	@Test(priority = 1)
	public void iOSbuild() throws IOException {
		try {
			System.out.println("@Test Case 8:");
			test = report.startTest("Test-08 : iOS Build Generate", "Generate iOS Build");
			driver = Driverutil.getBrowser();
			driver.manage().window().maximize();
			System.out.println("iOS Build Generate Test case running");
			driver.get(P_url);
			driver.findElement(By.id("auth_key")).sendKeys(P_user);
			driver.findElement(By.id("password")).sendKeys(P_pass);
			driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block btn-signin']")).click();
			driver.findElement(By.xpath("//a[@href='#test']")).click();
			driver.findElement(By.xpath("//h4[@title='Testingapp3-live']")).click();
			String str=driver.findElement(By.xpath("//div/div[2]/p[text()='Testingapp3-live']")).getText();
			if (str.equals("Testingapp3-live"))
			{
				driver.findElement(By.linkText("Apps")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("generate_build_button_for_brough_superior")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@class='btn btn-success modal-button']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.INFO, "Generate the build: " + url);
				report.endTest(test);
				report.flush();
}
			else
			{
				System.out.println("Brand not found");
				test.log(LogStatus.FAIL, "Unable to generate the build : ");
			}
		}
		catch (Exception e) {
			File srcfile1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(path + "iOS_Build_generate.png"));
			test.log(LogStatus.FAIL,
					"Unable to generate the build : " + test.addScreenCapture(path + "iOS_Build_generate.png") + e.toString());
			report.endTest(test);
			report.flush();
		}
		}
	@Test(priority = 2)
	public void androidbuild() throws IOException {
		try {
			System.out.println("@Test Case 9:");
			test = report.startTest("Test-09 : Android Build Generate", "Generate Android Build");
			driver = Driverutil.getBrowser();
			driver.findElement(By.linkText("Apps")).click();
			driver.findElement(By.xpath("//*[@id='android_app']/div[2]/ul/li[2]/a")).click();
			//driver.findElement(By.xpath("//*[@id='android_app']")).click();
			driver.findElement(By.xpath("//div/p/a[@id='generate_build_button_google_play']")).click();
			System.out.println("Android build test case running");
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Android app generated");
			report.endTest(test);
			report.flush();
		
	}
		catch (Exception e) {
			File srcfile1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(path + "android_build.png"));
			test.log(LogStatus.FAIL,
					"Unable to generate the build : " + test.addScreenCapture(path + "android_build.png") + e.toString());
			report.endTest(test);
			report.flush();
		}
	}
}

