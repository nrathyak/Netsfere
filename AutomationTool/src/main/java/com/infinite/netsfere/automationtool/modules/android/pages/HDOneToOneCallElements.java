package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HDOneToOneCallElements {
	
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	 private static Logger log = LogManager.getLogger(HDOneToOneCallElements.class.getName());


	public HDOneToOneCallElements() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "text(\"Allow NetSfere to make and manage phone calls?\")")
	public WebElement callPopUp1;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	public WebElement allowButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
	public WebElement denyButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Allow NetSfere to record audio?\")")
	public WebElement callPopUp2;
	
	@AndroidFindBy(uiAutomator = "text(\"Calling…\")")
	public WebElement calling;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label' and @text='Ringing…']")
	public WebElement ringing;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_hangup']")
	public WebElement endCallButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_answer']")
	public WebElement callAnswerButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/action0' and @text='ACCEPT']")
//	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Accept']")
	public WebElement callAcceptButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_decline']")
	public WebElement callDeclineButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label']")
	public WebElement incomingCall;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text' and @index='1']")                  
	public WebElement incomingCallNotification;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label' and @text='In Call']")
	public WebElement inCall;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_message']")
	public WebElement messageButtonFromCall;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/live_call_return_button']")
	public WebElement returnToCall;
	
	
	public void incomingAudioCallNotification()
	{
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='android:id/text' and @text='Incoming Audio Call…']")));
		incomingCallNotification.click();
		
	}
	
	public void incomingGroupCallNotification()
	{
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='android:id/text' and @index='1']")));
		incomingCallNotification.click();
		
	}
	
	public void incomingVideoCallNotification()
	{
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='android:id/text' and @text='Incoming Video Call…']")));
		incomingCallNotification.click();
		
	}
	
	
	public void callAcceptButton()
	{
	callAcceptButton.click();
	Utils.veryShortSleep();
	
	}
	
	
	
	
	public void allowAccessToInitateCall() {
		try {
		if(callPopUp1.isDisplayed()) {
			allowButton.click();
			if(callPopUp2.isDisplayed()) {
				allowButton.click();
			}
		}
		}catch(Exception e) {
			log.error("No pop ups displayed");
		}
		waitTillCallRings();
	}
	
	
	public void receiveCall() {
//		if(incomingCall.isDisplayed()) {
			callAnswerButton.click();
//			}
		waitUntillInCall();
	}
	
	
	public void declineCall() {
		
		if(incomingCall.isDisplayed()) {
			
			callDeclineButton.click();
		}
		Utils.shortSleep();
	}
	
	public void disconnectOngoingCall() {
		
		if(inCall.isDisplayed()) {
			endCallButton.click();
		}
		Utils.shortSleep();
	}
	
	public void endOngoingCall() {
		endCallButton.click();
	}
	public void waitTillCallRings() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label' and @text='Ringing…']")));
	}
	
	public void waitUntillInCall() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label' and @text='In Call']")));
	}
	
	public void clickOnMessageButtonWhileOnCall() {
		messageButtonFromCall.click();
	}
	
	
	
	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_MAIN_SCREEN and page title is equal to PAGE_TITLE
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_CALL_SCREEN);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in call screen");
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// Navigate to home screen first
//		Utils.navigateToHomeScreen(driver);
		// Click on conversations icon in bottom navigation bar
//		BottomNavigationBar.getInstance().navigateToConversationsPage();
	}
	
}
