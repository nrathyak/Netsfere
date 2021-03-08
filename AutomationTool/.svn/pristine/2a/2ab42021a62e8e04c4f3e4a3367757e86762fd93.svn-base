package com.infinite.netsfere.automationtool.modules.ios.pages;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSFindBySet;
import io.appium.java_client.pagefactory.iOSFindBys;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.WaitOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class ConversationsPage {
	
	IOSDriver<IOSElement> IosDriver;
	WebDriverWait IosWaitMedium;
	WebDriverWait IosWaitShort;
	String microPhoneAcessPopUp = "//XCUIElementTypeAlert[@name='“NetSfere” Would Like to Access the Microphone']";
	String  notificationsAccessPopUp = "//XCUIElementTypeAlert[@name='“NetSfere” Would Like to Send You Notifications']";
	private static Logger log = LogManager.getLogger(ConversationsPage.class.getName());

	
	public ConversationsPage() throws InterruptedException, IOException {
		IosDriver = DriverManager.getIOSDriver();		
		PageFactory.initElements(new AppiumFieldDecorator(IosDriver), this);
		IosWaitMedium = Utils.getMediumWait(IosDriver);
		IosWaitShort = Utils.getShortWait(IosDriver);
	}	

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Conversations']")
	public WebElement conversationsButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Calls']")
	public WebElement callsButton;		
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Contacts']")
	public WebElement contactsButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Broadcast']")
	public WebElement broadcastButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Meetings']")
	public WebElement meetingsButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Conversations']")
	public WebElement conversationsHeaderView;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	public WebElement allConversationsTabButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Unread']")
	public WebElement unreadConversationsTabButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Favorite']")
	public WebElement favoriteConversationsTabButton;		
	
	@iOSFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search']")
	public WebElement conversationSearchTextBox;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='AddConversationButton']")
	public WebElement newConversationButton;	

	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Conversations']")
	public WebElement conversationnavigationBar;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_ConvViewSettingButton']")
	public WebElement settingsButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Conversations']")
	public WebElement conversationLabel;	
	

	@iOSFindBy(xpath = "//XCUIElementTypeCell[@name='NETS_ConvCellStackView']")
	public List<WebElement> ConversationList;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Clear text']")
	public WebElement clearConversationSearchTextbutton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	public WebElement cancelConversationSearchbutton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeAlert[@name='“NetSfere” Would Like to Access the Microphone']")
	public WebElement allowMicrophoneAcessPopUp ;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Don’t Allow']")
	public WebElement doNotAllowMicrophoneAceessButton ;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	public WebElement  allowMicrophoneAccessButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeAlert[@name='“NetSfere” Would Like to Send You Notifications']")
	public WebElement allowNotificationsPopUp ;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
	public WebElement  allowNotificationsButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Don’t Allow']")
	public WebElement  doNotAllowNotificationsButton;
	
		
	public WebElement getConversationsButton() {
		return conversationsButton;
	}
		
	public void clickConversationsButton() {
		conversationsButton.click();
	}
	
	public WebElement getCallsButton() {
		return callsButton;
	}
	
	public void clickCallsButton() {
		callsButton.click();
	}

	public WebElement getContactsButton() {
		return contactsButton;
	}
	
	public void clickContactsButton() {
		contactsButton.click();
	}
	public WebElement getBroadcastButton() {
		return broadcastButton;
	}
	
	public void clickBroadcastButton() {
		broadcastButton.click();
	}
	
	public WebElement getMeetingsButton() {
		return meetingsButton;
	}
	
	public void clickMeetingsButton() {
		meetingsButton.click();
	}
	public WebElement getConversationsHeaderView() {
		return conversationsHeaderView;
	}
	public WebElement getAllConversationsTabButton() {
		return allConversationsTabButton;
	}
	
	public void clickAllConversationsTabButton() {
		allConversationsTabButton.click();
	}
	public WebElement getUnreadConversationsTabButton() {
		return unreadConversationsTabButton;
	}
	
	public void clickUnreadConversationsTabButton() {
		unreadConversationsTabButton.click();
	}
	public WebElement getFavoriteConversationsTabButton() {
		return favoriteConversationsTabButton;
	}
	
	public void clickFavoriteConversationsTabButton() {
		favoriteConversationsTabButton.click();
	}
	public WebElement getConversationsSearchBar() {
		return conversationSearchTextBox;
	}
	
	public void fillTextConversationsSearchBar(String s) {
		
		conversationSearchTextBox.clear();
		conversationSearchTextBox.sendKeys(s);
	}
	public WebElement getNewConversationButton() {
		return newConversationButton;
	}
	
	public void clickNewConversationButton() {
		newConversationButton.click();
	}
	public WebElement getConversationsNavigationbar() {
		return conversationnavigationBar;
	}
	public WebElement getSettingButton() {
		return settingsButton;
	}
	
	public void clickSettingsButton() {
		settingsButton.click();
	}
	public WebElement getConversationlabel() {
		return conversationLabel;
	}
	public String getConversationlabelText() {
		return conversationLabel.getText();
	}	
	
	public void clearConversationSearchText() {
		clearConversationSearchTextbutton.click();
	}
	
	public void cancelConversationSearch() {
		cancelConversationSearchbutton.click();
	}
	
	public List<WebElement> getConversationList() {
		return ConversationList;
	}
	
	public WebElement getAllowNotificationsPopUp() {
		return allowNotificationsPopUp;
	}
	
	public WebElement getAllowNotificationsButton() {
		return allowNotificationsButton;
	}
	
	public void clickAllowNotificationsButton() {
		allowNotificationsButton.click();
	}
	public void waitForAllowNotificationsPopUpAndAllow() {
		try {			
			IosWaitShort.until(ExpectedConditions.presenceOfElementLocated(By.xpath(notificationsAccessPopUp)));
			allowNotificationsButton.click();	
		} catch (Exception e ) {
			log.error("No PopUp for Allow Notifications....");
		}
	}
	public void waitForAllowNotificationsPopUpAndDoNotAllow() {
		try {
			IosWaitShort.until(ExpectedConditions.visibilityOf(allowNotificationsPopUp));
			doNotAllowNotificationsButton.click();
		}catch (NoSuchElementException e ) {
			log.error("No PopUp for Allow Notifications....");
		}
	}
	
	public void waitForAllowMicrophoneAccessPopUpAndAllow() {
		try {
			IosWaitShort.until(ExpectedConditions.presenceOfElementLocated(By.xpath(microPhoneAcessPopUp)));
			allowMicrophoneAccessButton.click();
		} catch (Exception e ) {
			log.error("No PopUp for Microphone access....");
		}
	}
	
	public void waitForAllowMicrophoneAccessPopUpAndDoNotAllow() {
		try {
//			IosWaitShort.until(ExpectedConditions.visibilityOf(allowMicrophoneAcessPopUp));
			doNotAllowMicrophoneAceessButton.click();
		} catch (NoSuchElementException e ) {
			log.error("No PopUp for Microphone access....");
		}
	
	}
	
	public boolean isAt() {
		try {
			if(getConversationsHeaderView().isEnabled()) {
				return true;
			} else {
				return false;
			}
		}catch ( NoSuchElementException e)  {
			log.error("ERROR :  Not in Conversation page ");
			return false;
		}
	}
	
	// TO-Do
	// conversation actions need to be implimented. 
	// like swipe left  & right swipe to favorite/mute/leave/email conversations.
	
	
		
	
}
