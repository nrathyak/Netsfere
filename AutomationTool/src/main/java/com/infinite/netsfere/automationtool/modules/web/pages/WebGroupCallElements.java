package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebGroupCallElements {
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebDriver secondDriver;
	WebDriverWait webWait1;
	WebHdOneToOneCallElements hdCall;
	
	public WebGroupCallElements() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
//		this.secondDriver = DriverManager.getSecondWebDriver();
		webwait = Utils.getLongWait(driver);
//		webWait1 = Utils.getLongWait(secondDriver);
		webio = new WebIoOperations();
		hdCall = new WebHdOneToOneCallElements();
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Select Ring Participants')]")
	public WebElement groupCallParticipants;
	
	@FindBy(xpath="//button[@title='Place call']")
	public WebElement placeGroupCall;
	
	@FindBy(xpath="//span[contains(text(),'Group Call')]")
	public WebElement groupCall;
	
	@FindBy(xpath="//div[@class='table-view']//..//button[@title='End call']")
	public WebElement endGroupCall;
	
	@FindBy(xpath="//div[contains(text(),'Ending the group call')]")
	public WebElement endGroupCallPopUp;
	
	@FindBy(xpath="//span[contains(text(),'End Group Call')]")
	public WebElement endGroupCallConfirm;
	
	@FindBy(xpath="//span[contains(text(),'has ended a group call.')]")
	public WebElement groupCallEnded;
	
	@FindBy(xpath="//div[contains(text(),'Tap to go to call')]")
	public WebElement returnToCall;
	
	@FindBy(xpath="//div[contains(text(),'Incoming call...')]")
	public WebElement groupIncomingCall;
	
	@FindBy(xpath="//div[@class='table-view']//..//button[@title='End call']")
	public WebElement leaveGroupCall;
	
	@FindBy(xpath="//span[contains(text(),'has started a group call.')]")
	public WebElement startedGroupCallPlaceholder;

	
//	@FindBy(xpath="//button[@title='Accept']")
//	public WebElement acceptCall;
	
	
	@FindBy(xpath="//span[text()='Mute all']")
	public WebElement muteAllButton;
	
	@FindBy(xpath="//span[@class='icon ion-android-person-add']")
	public WebElement addUser;
	
	@FindBy(xpath="//div[@class='scrollbox']//div[text()='Contacts']")
	public WebElement dynamicContacts;
	

	@FindBy(xpath="//span[text()='Group Call']/../../..//input[@type='text']")
	public WebElement searchDynamicContact;
	
	@FindBy(xpath="//div[text()='Search results']/../..//div[@class='scrollbox']/div[2]")
	public WebElement firstDynamicContact;
	
	@FindBy(xpath="//span[text()='Call']")
	public WebElement callButton;
	
	@FindBy(xpath="//span[text()='Ring all']")
	public WebElement ringAll;
	
	/*
	 * Screenshare elements
	 */
	
	@FindBy(xpath="//span[@title='Share Screen']")
	public WebElement screenShare;
	
	@FindBy(xpath="//button[text()='Stop Sharing']")
	public WebElement stopSharing;
	
	@FindBy(xpath="//span[@title='PRESENTING']")
	public WebElement presenting;
	
	@FindBy(xpath="//span[@title='Stop Screen Share']")
	public WebElement stopSharingIcon;
	
	@FindBy(xpath="//img[@alt='Exit']")
	public WebElement leaveScreenshare;
	
	@FindBy(xpath="//span[text()='Deselect All']")
	public WebElement deselectButton;
	
	@FindBy(xpath = "//span[text()='Select Ring Participants']/../../..//div[@class='table-view']/div[1]/div")
	public WebElement selectParticipantDuringCall;
	
	/*
	 * group call status
	 */
	
	@FindBy(xpath="//span[text()='declined']")
	public WebElement declinedStatus;
	
	@FindBy(xpath="//span[text()='locating']")
	public WebElement locatingStatus;
	
	@FindBy(xpath="//span[text()='connected']")
	public WebElement connectedStatus;
	
	@FindBy(xpath="//span[text()='talking']")
	public WebElement talkingStatus;
	
	@FindBy(xpath="//span[text()='disconnected']")
	public WebElement disconnectedStatus;
	
	@FindBy(xpath="//span[text()='no answer']")
	public WebElement noanswerStatus;
	
	@FindBy(xpath="//span[text()='not called']")
	public WebElement notcalledStatus;
	
	@FindBy(xpath="//button[@title='Audio On']//..//button[@title='End call']//span[@class='icon ion-android-call']")
	public WebElement topBarEndCall;
	
	public void clickOnMuteAll()
	{
		muteAllButton.click();
	}
	
		
	public void isAtSelectParticipantsPage() {
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Select Ring Participants')]")));
	}
	
	public void clickOnPlaceCallButton() throws InterruptedException {
//		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Place call']")));
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Place call']"))); 
		placeGroupCall.click();
	}
	
	public void isAtGroupCallPage() throws InterruptedException {
//		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Group Call')]")));
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'connected')]")));
	}
	
	public void clickOnEndGroupCall() throws InterruptedException {
		Utils.veryShortSleep();
		endGroupCall.click();
		if(endGroupCallPopUp.isDisplayed()) {
			Thread.sleep(2000);
			endGroupCallConfirm.click();
		}
		Utils.shortSleep();
	}
	
	
	
	
	public void acceptFromSecondUser(WebDriver secondDriver) {
		webWait1 = Utils.getLongWait(secondDriver);
		webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming call...')]")));
		secondDriver.findElement(By.xpath("//button[@title='Accept']")).click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Tap to go to call')]")));
//		secondDriver.findElement(By.xpath("//div[contains(text(),'Tap to go to call')]")).click();
//		Utils.shortSleep();		
	}
	
	
	public void clickOnGroupCall() {
		Utils.veryShortSleep();
		returnToCall.click();
	}
	
	public void leaveGroupCallFromSecondUser(WebDriver secondDriver) throws InterruptedException {
		secondDriver.findElement(By.xpath("//button[@title='Audio On']//..//button[@title='End call']//span[@class='icon ion-android-call']")).click();
		Thread.sleep(3000);
	}
	
	public void rejoinGroupCallFromSecondUser(WebDriver secondDriver) {
		webWait1 = Utils.getLongWait(secondDriver);
		Utils.veryShortSleep();
		secondDriver.findElement(By.xpath("//span[@class='icon ion-navicon-round']/../../../../div[@class='table-view']/div[3]//*[name()='svg']")).click();
		secondDriver.findElement(By.xpath("//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[1]/span/../button//*[name()='svg']")).click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Tap to go to call')]")));
	}
	
	public void closeBrowser() {
		secondDriver.quit();
	}
	
	public void addDynamicUser(String user) throws InterruptedException {
		addUser.click();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='scrollbox']//div[text()='Contacts']")));
		searchDynamicContact.sendKeys(user);
		webio.ActionsSpaceAndBackspace();
		Utils.veryShortSleep();
		firstDynamicContact.click();
		Utils.veryShortSleep();
		callButton.click();
		Utils.veryShortSleep();
	}
	
	public void initiateScreenshare() {
		Utils.veryShortSleep();
		screenShare.click();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Stop Sharing']")));
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='PRESENTING']")));
	}
	
	public void stopScreenShare() {
		stopSharing.click();
		webwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@title='PRESENTING']")));
	}
	
	public void viewScreenshare() {
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Exit']")));
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='PRESENTING']")));
		Utils.veryShortSleep();
	}
	
	public void endScreenshare() {
		webwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Exit']")));
	}
	
	public void clickOnDeselectParticipants() {
		Utils.veryShortSleep();
		deselectButton.click();
		selectParticipantDuringCall.click();
	}
	
	public void joinScreenshareFromSecondWebUser(WebDriver secondDriver) {
		webWait1 = Utils.getLongWait(secondDriver);
		webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Exit']")));
		webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='PRESENTING']")));
		Utils.veryShortSleep();
	}
	
	public void endCall() {
		try {
		if(returnToCall.isDisplayed()) {
			returnToCall.click();
		}
		topBarEndCall.click();
		try {
			if(endGroupCallPopUp.isDisplayed()) {
				Thread.sleep(2000);
				endGroupCallConfirm.click();
			}
		}catch(Exception e) {
			System.out.println("No such element");
		}
		Utils.veryShortSleep();
	}catch(Exception e) {
		System.out.println("No ongoing call");
	}
}
	
	public void endCallFromSecondWebUser(WebDriver secondDriver) {
		try {
			Thread.sleep(3000);
			if(secondDriver.findElement(By.xpath("//div[contains(text(),'Tap to go to call')]")).isDisplayed()) {
				secondDriver.findElement(By.xpath("//button[@title='Audio On']//..//button[@title='End call']//span[@class='icon ion-android-call']")).click();
				Thread.sleep(3000);
			}
		}catch(Exception e) {
			System.out.println("No ongoing call");
		}
	}
	
}
