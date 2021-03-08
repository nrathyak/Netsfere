package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebVideoCallPage {
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebDriver secondDriver;
	WebDriverWait webWait1;
	WebHdOneToOneCallElements hdCall;
	
	public WebVideoCallPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
//		this.secondDriver = DriverManager.getSecondWebDriver();
		webwait = Utils.getLongWait(driver);
//		webWait1 = Utils.getLongWait(secondDriver);
		webio = new WebIoOperations();
		hdCall = new WebHdOneToOneCallElements();
		
	}
	
	@FindBy(xpath="//span[text()='You']")
	public WebElement selfVideo;
	
	@FindBy(xpath="//button[@title='Place call']")
	public WebElement placeVideoCallButton;
	
	@FindBy(xpath="//button[@title='End call']//span[@class='icon ion-android-call']")
	public WebElement endVideoCallButton;
	
	@FindBy(xpath="//span[text()='End Video Call']")
	public WebElement endVideoCallConfirmButton;
	

	
	
	public void waitForVideoScreen() {
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='You']")));
	}
	
	public void clickOnPlaceVideoCall() {
		Utils.veryShortSleep();
		placeVideoCallButton.click();
	}
	
	 public void clickOnEndVideoCallButton() {
		 endVideoCallButton.click();
		 webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='End Video Call']")));
		 endVideoCallConfirmButton.click();
		 
	 }
	 
	 public void waitForVideoCallUI() {
		 webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming call...')]")));
	 }
	 
	 public void endOneToOneVideoCall() {
		 endVideoCallButton.click();
	 }
}
