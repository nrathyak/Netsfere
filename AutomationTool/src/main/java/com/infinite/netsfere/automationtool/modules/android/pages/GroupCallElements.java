package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;

public class GroupCallElements {

	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	HDOneToOneCallElements hdCall;
	ChatPage chatPage;
	
	public GroupCallElements() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		hdCall = new HDOneToOneCallElements();
		chatPage = new ChatPage();
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/ring_message_info']")
	public WebElement numberOfParticipants;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_fab']")
	public WebElement groupCallButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/header_button']")
	public WebElement muteAll;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_hangup']")
	public WebElement endGroupCall;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/alertTitle']")
	public WebElement endGroupCallAlert;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	public WebElement endGroupCallConfirm;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button2']")
	public WebElement cancelGroupCall;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button3']")
	public WebElement leaveGroupCall;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/owner_badge_view']")
	public WebElement ownerBadge;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/conversation_in_progress']")
	public WebElement groupCallIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/participant_status' and @text='connected']")
	public WebElement connectedStatus;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/participant_status' and @text='locating']")
	public WebElement locatingStatus;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/participant_status' and @text='disconnected']")
	public WebElement disconnectedStatus;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/participant_status' and @text='declined']")
	public WebElement declinedStatus;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/participant_status' and @text='no answer']")
	public WebElement noanswerStatus;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/participant_status' and @text='not called']")
	public WebElement notcalledStatus;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/header_button' and @index='2']")
	public WebElement muteAllButton;
	
	/*
	 * DYnamic group call elements
	 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_add_participants']")
	public WebElement addDynamicUserButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/action_fab' and @index='1']")
	public WebElement dynamicCallButton;
	
	// xpath for ScreenSharing
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_screen_share']")
	public WebElement startScreenShareButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/alertTitle']")
	public WebElement startScreenSharePopUpTitle;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")
	public WebElement clickOnOKButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.android.systemui:id/dialog_title']")
	public WebElement alertPopUp;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement startNowButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/presenter_badge' and @text='PRESENTING']")
	public WebElement presentingTab;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@resource-id='com.infinite.netsfere:id/select_all_checkbox']")
	public WebElement deselectAllButton;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='0']")
	public WebElement firstSelectParticipant;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public WebElement backButton;
	
	
	public void clickOnMuteButton()
	{
		muteAllButton.click();
	}
	
	public void clickOnGroupCallButton() {
		Utils.veryShortSleep();
		if(numberOfParticipants.isDisplayed()) {
			groupCallButton.click();
		}
		
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.infinite.netsfere:id/header_button']")));
	}
	
	public void clickOnEndGroupCall() {
		Utils.veryShortSleep();
		endGroupCall.click();
		if(endGroupCallAlert.isDisplayed()) {
			endGroupCallConfirm.click();
		}
	}
	
	public void receiveGroupCall() {
		hdCall.callAnswerButton.click();
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_owner_badge']")));
		Utils.veryShortSleep();
	}
		
	public void declineGroupCall() {
		hdCall.callDeclineButton.click();
	}
	
	public void rejoinCall() {
		chatPage.clickOnCallButton();
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_owner_badge']")));
		Utils.veryShortSleep();
	}
	
	public void clickOnGroupCallIcon() {
		groupCallIcon.click();
	}
	
	public void clickOnAddDynamicUserButton() {
		addDynamicUserButton.click();
	}
	
	public void clickOnDynamicCallButton() {
		dynamicCallButton.click();
	}
	
	public void screenshareEnd() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_screen_share']")));
	}
	
	public void clickOnScreenshareButton() {
		startScreenShareButton.click();
		try {
			Utils.veryShortSleep();
			if(startScreenSharePopUpTitle.isDisplayed()) {
				clickOnOKButton.click();
				
				try {
					if(alertPopUp.isDisplayed()) {
						startNowButton.click();
					}
				}catch(Exception e) {
					System.out.println("No such element found");
				}
			}
		}catch(Exception e) {
			System.out.println("No pop up found");
		}
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/presenter_badge' and @text='PRESENTING']")));
		
	}
	
	
	public void stopScreenShare() {
		startScreenShareButton.click();
		try {
			if (startScreenSharePopUpTitle.isDisplayed()) {
				clickOnOKButton.click();
			}
		} catch (Exception e) {
			System.out.println("No Such element found");
		}
		mediumWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/presenter_badge' and @text='PRESENTING']")));
	}
	
	public void clickOnDeselectParticipant() {
		deselectAllButton.click();
		firstSelectParticipant.click();
	}
	
	public void clickOnBackButton() {
		backButton.click();
	}
	
	public void clickOnEndGroupVideoCall() {
		endGroupCall.click();
	}
	
	public void endCall() throws InterruptedException {
		try {
		if(driver.currentActivity().equals(Constants.ACTIVITY_GROUPCALL_SCREEN)) {
			endGroupCall.click();
			try {
				Thread.sleep(3000);
				if(endGroupCallAlert.isDisplayed()) {
					endGroupCallConfirm.click();
				}
			}catch(Exception e) {
				System.out.println("No such element");
			}
		}
		}
		catch(Exception e) { 
			
			if (hdCall.returnToCall.isDisplayed()) {
			hdCall.returnToCall.click();
			Thread.sleep(3000);
			endGroupCall.click();
			try {
				Thread.sleep(3000);
				if(endGroupCallAlert.isDisplayed()) {
					endGroupCallConfirm.click();
				}
			}catch(Exception e1) {
				System.out.println("No such element");
			}
		}
	}
		
	}
}
