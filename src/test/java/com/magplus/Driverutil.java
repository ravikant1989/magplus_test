package com.magplus;

import org.openqa.selenium.chrome.ChromeDriver;

public class Driverutil {

	private static ChromeDriver driver = new ChromeDriver();
	//private static WebDriver driver = new FirefoxDriver();

	public static ChromeDriver getBrowser() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void closeBrowser() {

		if (driver != null){
			driver.close();
			driver = null;
		}
	}
}
