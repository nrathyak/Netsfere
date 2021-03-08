package com.infinite.netsfere.automationtool.modules.ios.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ChatDetailsPage {
	
	IOSDriver<IOSElement> IosDriver;
	String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static Logger log = LogManager.getLogger(ChatDetailsPage.class.getName());
	
	public ChatDetailsPage() throws InterruptedException, IOException {
		IosDriver = DriverManager.getIOSDriver();
		WebDriverWait mediumWait;
		WebDriverWait shortWait;		
		mediumWait = Utils.getMediumWait(IosDriver);
		shortWait = Utils.getShortWait(IosDriver);
		PageFactory.initElements(new AppiumFieldDecorator(IosDriver), this);
	}
	
		
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	public WebElement backButton;
	
	//XCUIElementTypeOther[@name="Details"]
	//XCUIElementTypeButton[@name="Done"]
	//XCUIElementTypeButton[@name="NETS_ConvAvatarButton"]
	//XCUIElementTypeButton[@name="NETS_FavButton"]
	//XCUIElementTypeButton[@name="NETS_LeaveButton"]
	//XCUIElementTypeButton[@name="NETS_MuteButton"]
	//XCUIElementTypeStaticText[@name="Edit Participants"]
	
	
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='NETS_ComposeChatView']")
	public WebElement composeChatView;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_ComposeChatAttachmentButton']")
	public WebElement attachmentButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Type Message Here...']")
	public WebElement  messageTextBox;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_ComposeChatQuickReplyButton']")
	public WebElement quickReplyButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_ComposeChatSendButton']")
	public WebElement messageSendButton;
		
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name , 'Created on ')]")
	public WebElement chatCreatedDatelabelText;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='meeting calender plus']")
	public WebElement meetingsButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_CallButton']")
	public WebElement callButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='netsfereLiveInactive']")
	public WebElement liveButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='NETS_NavBarTitleText']")
	public WebElement conversationTitleTextLabel;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='NETS_NavbarPromptText']")
	public WebElement editconversationTitleTextButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeCell[@name='NEST_ChatMsgSentOuterStack']")
	public List<WebElement>  sentMessageChatbubble;
	
	
	public WebElement getComposeChatMessageView() {
		return composeChatView;
	}
	
	public WebElement getBackButton() {
		return backButton;
	}
	
	public WebElement getAttachmentButton() {
		return attachmentButton;
	}
	
	public WebElement getMessageTextBox() {
		return messageTextBox;
	}
	
	public WebElement getQuickReplyButton() {
		return quickReplyButton;
	}
	
	public WebElement getMessageSendButton() {
		return messageSendButton;
	}
	
	public WebElement getChatCreatedDatelabelText() {
		return chatCreatedDatelabelText;
	}
	
	public WebElement getMeetingsButton() {
		return meetingsButton;
	}
	
	public WebElement getCallButton() {
		return callButton;
	}
	
	public WebElement getLiveButton() {
		return liveButton;
	}
	
	public WebElement getConversationTitleTextLabel() {
		return conversationTitleTextLabel;
	}
	
	public WebElement getEditconversationTitleTextButton() {
		return editconversationTitleTextButton;
	}
	
	public List<WebElement> getSentMessageChatbubble() {
		return sentMessageChatbubble;
	}
	
		
	public boolean isAt() {		
		try {
			if(getComposeChatMessageView().isEnabled()) {
				return true;
			} else {
				return false;
			}
		}catch ( NoSuchElementException e)  {
			log.error("ERROR :  Not in Chat page ");
			return false;
		}
	}
	
	public void selectQuickReplyToSend() {
		getQuickReplyButton().click();
	}
	
	public void clickAttachmentbutton() {
		getAttachmentButton().click();
	}	
	
	public void typeChatMessage(String message) {
		getMessageTextBox().clear();
		getMessageTextBox().sendKeys(message);
		
	}
	public void sendChatMessage(String message) {
		getMessageSendButton().click();
	}
	
	public void clickAttachmentIcon(String message) {
		attachmentButton.click();
	}
	
	
	
}
	