package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeaveConversationPage {
	
	 private static Logger log = LogManager.getLogger(LeaveConversationPage.class.getName());
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	public LeaveConversationPage(){
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		
	}

	
	
	@AndroidFindBy(uiAutomator = "text(\"Leave Conversation\")")
	public WebElement leavepopup;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @index='1']")
	public WebElement leaveconfirm;
	
	
	/*
	 * transfer ownership and destroy conversation elements
	 */
	
//	@AndroidFindBy(uiAutomator = "text(\"Transfer Ownership\")")
//	public WebElement transfertext;
//	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Leave Conversation' and @index='1']")
	public WebElement transfertext;
	
	@AndroidFindBy(uiAutomator = "text(\"Leave conversation after transfer\")")
	public WebElement leaveandtransfer;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/transfer_ownership_button']")
	public WebElement transferowner;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/destroy_conversation_button']")
	public WebElement destroyconversation;
	
	@AndroidFindBy(uiAutomator = "text(\"Change Owner\")")
	public WebElement changeownerpopup;

	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @index='1']")
	public WebElement confirmchangeowner;

	@AndroidFindBy(uiAutomator = "text(\"Destroy Conversation\")")
	public WebElement destroyconversationpopup;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @index='1']")
	public WebElement destroyconfirm;

	
	public void transferOwnershipWithoutLeavingConversation() {
		if(transfertext.isDisplayed())
		{
			if(leaveandtransfer.isEnabled())
			{
				leaveandtransfer.click();
				transferowner.click();
				if(changeownerpopup.isDisplayed())
				{
					confirmchangeowner.click();
				}
			}
		}
		Utils.veryShortSleep();
	}
	
	public void destroyParticularConversation()
	{
		
		if(transfertext.isDisplayed())
		{
			destroyconversation.click();
			if(destroyconversationpopup.isDisplayed())
			{
				destroyconfirm.click();
			}
		}
		
	}
	
	public void transferOwnershipAsOwner() {
		
		if(transfertext.isDisplayed())
		{
			if(leaveandtransfer.isEnabled())
			{
				transferowner.click();
				if(leavepopup.isDisplayed())
				{
					leaveconfirm.click();
					log.info("Conversation owner transferred ownership and left the conversation");
				}
			}
		}
		
	}
	
	
	public void leaveConversation() {
		
		if(leavepopup.isDisplayed())
		{
			leaveconfirm.click();
			log.info("Conversation left as a participant");
		}
	}

}
