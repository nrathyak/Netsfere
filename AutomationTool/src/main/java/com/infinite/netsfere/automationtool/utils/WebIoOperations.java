package com.infinite.netsfere.automationtool.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class WebIoOperations {
	
	WebDriver driver = DriverManager.getWebDriver();
	boolean flag;
	public void ThreadWait() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	public void WaitForPageToLoad()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void WaitForLinkPresent(String linkName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 220);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkName)));
	}
	public void WaitForXpathPresent(String wbXpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 220);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(wbXpath)));
	}
	
	public void Select(WebElement selwb, String value)
	{
		Select sel = new Select(selwb);
		sel.selectByVisibleText(value);
	}
	public void Select(WebElement selwb , int index)
	{
		Select sel = new Select(selwb);
		sel.selectByIndex(index);
	}
	public void ActionsSpaceAndBackspace() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.sendKeys(Keys.SPACE).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
	}
	
	
	public void mouseMovementToAnyELement( WebElement MoveToOverWebElement)
	{
		Actions act = new Actions(driver);
		act.moveToElement(MoveToOverWebElement).click(MoveToOverWebElement);
//		act.click(MoveToOverWebElement);
	}
	
	public void refreshWindow(){
		driver.navigate().refresh();
	}
	
	public void spacebar(){
		Actions act = new Actions(driver);
		act.sendKeys(Keys.SPACE).perform();
	}
	public void Action()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void ActionEsc()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}
	public void ActionLast()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.END).perform();
	}
	
	public static void clearText(WebElement textField)
	{
		textField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		textField.sendKeys(Keys.BACK_SPACE);
	}
	
	
	
	public void AutoItAuthonticationPopUp() throws IOException
	{
		Runtime.getRuntime().exec("C:\\Users\\Sanjay\\Desktop\\file11.exe");
	}
	public void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
	public void selectDropDown(String path)
	{
		WebElement dropdown = driver.findElement(By.xpath(path));
		Select sel = new Select(dropdown);
		List<WebElement> dropdown1 = sel.getOptions();
		for(WebElement option : dropdown1)
		{
			if(option.getText().equals("Not Available"))
				{
					break;
				}
			else
				{
					option.click();
				}
			
		}
	}
	public void scrollDownToElement(WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void scrollUpForLanding()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
	}
	
	public void scrollToThePageEnd()
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	}
	public void pageUp()
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).perform();
	}
	
	public void SwitchWindow(WebDriver driver)
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		      
//		         driver.close(); //closing child window
//		         driver.switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
		
		
//		
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		while(it.hasNext()){
//			if(windows_id.equals("0")){
//				String window1 = it.next();
//				driver.switchTo().window(window1);
//			}else
//				if(windows_id.equals("1")){
//				String window2 = it.next();
//				driver.switchTo().window(window2);
//			}else if (windows_id.equals("2")){
//				String window3 = it.next();
//				driver.switchTo().window(window3);
//			}
//			
//		}	
		
	}
	
	public void SwitchWindowBack(String windows_id)
	{
		/*
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		      
//		         driver.close(); //closing child window
//		         driver.switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
		
		*/
//		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()){
			if(windows_id.equals("0")){
				String window1 = it.next();
				driver.switchTo().window(window1);
			}else
				if(windows_id.equals("1")){
				String window2 = it.next();
				driver.switchTo().window(window2);
			}else if (windows_id.equals("2")){
				String window3 = it.next();
				driver.switchTo().window(window3);
			}
			
		}	
		
	}
	
	
	public void mouseDownMovement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, -1);
		actions.click(element);
		
		
	}
	
	public void mouseHover(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.build().perform();
	}
		
}
