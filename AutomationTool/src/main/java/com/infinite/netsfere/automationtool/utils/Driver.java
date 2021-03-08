package com.infinite.netsfere.automationtool.utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Driver extends AndroidBase
{
	
	public static WebDriver driver;
	public static AndroidDriver<AndroidElement> androiddriver;
	public static WebDriver getDriver()
	{
		if(Constants.browser.equals("firefox"))
		{
			
			
			System.setProperty("webdriver.gecko.driver", "D:/geckodriver-v0.20.1-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(Constants.browser.equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-notifications");
			System.setProperty("webdriver.chrome.driver", "D:/Netsfere_4.0.0/AutomationTool/resources/chromedriver.exe");
			driver = new ChromeDriver(options);
			
			
		}
	
		return driver;
	}
}
