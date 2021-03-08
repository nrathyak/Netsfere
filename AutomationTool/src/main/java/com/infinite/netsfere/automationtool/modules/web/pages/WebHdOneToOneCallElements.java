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

public class WebHdOneToOneCallElements {

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebDriver secondDriver;
	WebDriverWait webWait1;
	
	public WebHdOneToOneCallElements() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Ringing...')]")
	public WebElement callRinging;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	public WebElement endCallButton;
	
	@FindBy(xpath="//span[contains(text(),'NetSfere HD Voice')]")
	public WebElement hdCallUI;
	
	@FindBy(xpath="//span[contains(text(),'Incoming call...')]")
	public WebElement incomingCall;
	
	@FindBy(xpath="//button[@title='Accept']")
	public WebElement acceptCall;
	
	@FindBy(xpath="//button[@title='Decline']")
	public WebElement declineCall;
	
	@FindBy(xpath="//button[@title='End Call']")
	public WebElement endOngoingCall;
	
	@FindBy(xpath="//span[@class='icon ion-chevron-down']")
	public WebElement downArrowClick;
	
	@FindBy(xpath="//span[contains(text(),'In call')]")
	public WebElement inCall;
	
	@FindBy(xpath="//button[@title='Cancel']")
	public WebElement endCall;
	
	
	
	@FindBy(xpath="//button[@title='Mute']")
	public WebElement muteButton;
	
	@FindBy(xpath="//div[text()='Call Muted']")
	public WebElement callMuteTitle;
	
	
	
	@FindBy(xpath="//button[@title='Unmute']")
	public WebElement unMuteButton;
	
	
	@FindBy(xpath="//button[@title='Volume on']")
	public WebElement volumeOnButton;
	
	@FindBy(xpath="//button[@title='Volume off']")
	public WebElement volumeOffButton;
	
	public void muteCall()
	{
		muteButton.click();
		Utils.veryShortSleep();
		//Assert.assertTrue(unMuteButton.isDisplayed());
	}
	public void unMuteCall() {
		unMuteButton.click();
		Utils.veryShortSleep();
		

	}
	public void volumeOnDuringCall() {
		volumeOnButton.click();
		Utils.veryShortSleep();
		
		
	}
	public void volumeOffDuringCall(){ 
		volumeOffButton.click();
		Utils.veryShortSleep();
	}	
	
	//**************
	
	@FindBy(xpath="//span[contains(text(),'Incoming call...')]")
	public WebElement incomingcall;
	
	@FindBy(xpath="//span[@class='icon ion-chevron-up']")
	public WebElement upArrowClick;
	
	public void waitUntilCallRings() {
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Ringing...')]")));
	}
	
	public void acceptIncomingCall() {
//		if(incomingCall.isDisplayed()) {
			acceptCall.click();
//		}
	}
	
	public void declineIncomingCall() {
//		if(incomingCall.isDisplayed()) {
			declineCall.click();
//		}
			Utils.veryShortSleep();
	}
	
	public void endOngoingCall() {
		endOngoingCall.click();
	}
	
	public void endCall() {
		endCall.click();
	}
	
	public void acceptOneToOneCallFromSecondUser(WebDriver secondDriver) {
		webWait1 = Utils.getLongWait(secondDriver);
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Incoming call...')]")));
		secondDriver.findElement(By.xpath("//button[@title='Accept']")).click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'In call')]")));
		
	}
	
	public void rejectOneToOneCallFromSecondUser(WebDriver secondDriver) {
		webWait1 = Utils.getLongWait(secondDriver);
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Incoming call...')]")));
		secondDriver.findElement(By.xpath("//button[@title='Decline']")).click();
	}
	
	
	public void clickOnUpArrowDuringCall() {
		upArrowClick.click();
	}
	
	public void clickOnDownArrowDuringCall() {
		downArrowClick.click();
		Utils.veryShortSleep();
	}
	public void navigateToCallLogAndClickOnFirstCallLog() {
		
	}
	
}
