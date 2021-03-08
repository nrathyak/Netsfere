package com.infinite.netsfere.automationtool.utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidIoOperations {
	static AndroidDriver<AndroidElement> driver ;
	private static AndroidIoOperations instance;
	public static AndroidIoOperations getInstance() {
		if (instance == null) {
			instance = new AndroidIoOperations();
		}
		return instance;
	}
	public AndroidIoOperations(){
		driver = DriverManager.getAndroidDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void longPressElement(WebElement we)
	{
		TouchAction taction = new TouchAction(DriverManager.getAndroidDriver());
		Duration time = Duration.ofMillis(1000);
		WaitOptions pressWait = WaitOptions.waitOptions(time);
		PointOption<ElementOption> pointOption = ElementOption.element(we);	
		taction.longPress(pointOption).waitAction(pressWait).release().perform();
	}
	
	public void scrollToElement(WebElement recId , WebElement txt ,AndroidDriver<AndroidElement> driver) {
		if(recId!=null && txt!=null){
			MobileElement makeTextLocator = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+".resourceId("+recId+")).scrollIntoView("+"new UiSelector().text("+txt+"));");
			makeTextLocator.click();
		}else if(recId==null && txt!=null){
			MobileElement makeTextLocator = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable.scrollIntoView("+"new UiSelector().text("+txt+"));");
			makeTextLocator.click();
		}else if(recId!=null && txt==null){
			MobileElement makeTextLocator = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable.scrollIntoView("+"new UiSelector().resourceId("+recId+"));");
			makeTextLocator.click();
		}
		
	}
	
	
	public void hideKeyboard(){

		DriverManager.getAndroidDriver().hideKeyboard();
	}
	
	public void scrollBottomToTop(){
		TouchAction ts = new TouchAction(DriverManager.getAndroidDriver());
		Dimension size = driver.manage().window().getSize();
		// Find swipe start and end point from screen’s with and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		// Swipe from Bottom to Top.
		ts.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();
	}
	
	public static void scrollTopToBottom(){
		TouchAction ts = new TouchAction(DriverManager.getAndroidDriver());
		Dimension size = driver.manage().window().getSize();
		// Find swipe start and end point from screen’s with and height.
		// Find start y point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		// Find end y point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		// Swipe from Bottom to Top.
//		ts.longPress(PointOption.point(startx, endy)).moveTo(PointOption.point(startx, starty)).release().perform();
		
		ts.press(PointOption.point(0,starty))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
		.moveTo(PointOption.point(0, endy))
		.release()
		.perform();
	}
	
	public static void scrollDown(String ele) {
		DriverManager.getAndroidDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ele+"\").instance(0))").click();
	
	}
	
	public static void scroll() {
		AndroidTouchAction action =  new AndroidTouchAction(DriverManager.getAndroidDriver());
		PointOption p1= new PointOption();
		Dimension dimensions = DriverManager.getAndroidDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
		action.press(PointOption.point(0,h1))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
		.moveTo(PointOption.point(0, h2))
		.release().perform();
		}
	
	
}
