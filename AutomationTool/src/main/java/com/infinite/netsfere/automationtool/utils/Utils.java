package com.infinite.netsfere.automationtool.utils;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Utils {

	private static final int shortWaitTime = 12;
	private static final int mediumWaitTime = 130;
	private static final int longWaitTime = 300;
	private static final int veryShortWaitTime = 8;
	
	public static WebDriverWait getVeryShortWait(WebDriver driver) {
		return new WebDriverWait(driver, veryShortWaitTime);
	}
	
	static AndroidDriver<AndroidElement> driver ;
	static IOSDriver<IOSElement> IosDriver;
	static AndroidDriver<AndroidElement> secondDriver ;
	
	public Utils(){
		driver = DriverManager.getAndroidDriver();
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	public static WebDriverWait getShortWait(WebDriver driver) {
		return new WebDriverWait(driver, shortWaitTime);
	}
	
	public static WebDriverWait getMediumWait(WebDriver driver) {
		return new WebDriverWait(driver, mediumWaitTime);
	}
	
	public static WebDriverWait getLongWait(WebDriver driver) {
		return new WebDriverWait(driver, longWaitTime);
	}

	public static void veryShortSleep() {		
		sleep(veryShortWaitTime * 1000);		
	}
	
	public static void shortSleep() {		
		sleep(shortWaitTime * 1000);		
	}
	
	public static void mediumSleep() {		
		sleep(mediumWaitTime * 1000);		
	}
	
	public static void longSleep() {		
		sleep(longWaitTime * 1000);		
	}

	
	private static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void navigateToHomeScreen(AndroidDriver<AndroidElement> driver) {
		if (driver == null) {
			return;
		}			
		while (!driver.currentActivity().equals(Constants.ACTIVITY_MAIN_SCREEN)) {
			driver.navigate().back();			
		}		
	}

	public static void navigateBack(AndroidDriver<AndroidElement> driver) {
		driver.navigate().back();
	}
	
	public static void longPressElement(WebElement el)
	{
		TouchAction taction = new TouchAction(DriverManager.getAndroidDriver());
		Duration press = Duration.ofMillis(1000);
		WaitOptions press_wait = WaitOptions.waitOptions(press);
		PointOption<ElementOption> P1 = ElementOption.element(el);	
		taction.longPress(P1).waitAction(press_wait).release().perform();
	}
	
	public static boolean isMacOS() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.indexOf("mac") >= 0;
	}

	public  static void scrolldown(IOSDriver<IOSElement> IosDriver) {
		JavascriptExecutor js = (JavascriptExecutor) IosDriver;
		HashMap scrollObject = new HashMap();		
		scrollObject.put("direction", "up");
		js.executeScript("mobile: scroll", scrollObject);
		Utils.shortSleep();	
	}


}