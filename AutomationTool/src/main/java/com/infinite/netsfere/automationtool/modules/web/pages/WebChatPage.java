package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;

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

import io.appium.java_client.android.AndroidElement;

public class WebChatPage {
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;

	public WebChatPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();

	}

	@FindBy(xpath = "//textarea[@class='namegenTextLong' and @placeholder='Type Message Here...']")
	public WebElement conversationTextBox;

	@FindBy(xpath = "//textarea[@class='namegenTextLong' and @placeholder='Send Message to Create Conversation...']")
	public WebElement streamlineConversationTextBox;

	@FindBy(xpath = "//span[@class='fa fa-paper-plane']")
	public WebElement sendMessageButton;

	@FindBy(xpath = "//span[@class='icon ion-plus-circled']")
	public WebElement addattachmentButton;

//	@FindBy(xpath="//div[div[div[a/img[contains(@src, 'https://maps.googleapis.com')]]]]/div[2]/div/div/span")
//	public WebElement sentButtonForLocation;

	@FindBy(xpath = "//div[div[div[a/img[contains(@src, 'https://maps.googleapis.com')]]]]/div")
	public WebElement sentButtonForLocation;
	/*
	 * Group conversation related Webelements
	 */

//	@FindBy(xpath = "//span[normalize-space(text())='joined this conversation.']")
	@FindBy(xpath="//div[contains(text(),'Conversation created')]//..//span[contains(text(),'joined this conversation')]")
	public WebElement joiningPlaceHolder;

//	@FindBy(xpath = "//span[normalize-space(text())='left this conversation.']")
	@FindBy(xpath="//div[contains(text(),'Conversation created')]//..//span[contains(text(),'left this conversation')]")
	public WebElement removePlaceholder;

	@FindBy(xpath = "//div[contains(text(),'Conversation created')]//..//div//div//div//span[contains(text(),'is the new owner')]")
	public WebElement newOwner;

	/*
	 * elements of broadcast live
	 */
	@FindBy(xpath = "//span[@class='icon ion-ios-videocam-outline']")
	public WebElement liveButton;

	@FindBy(xpath = "//span[text()='Broadcast LIVE']")
	public WebElement broadcastLiveButton;

	@FindBy(xpath = "//span[text()='View LIVE broadcast']")
	public WebElement viewLiveBroadcastButton;

	@FindBy(xpath = "//div[contains(text(),'Conversation created')]/../div/div/div/span")
	public WebElement endBroadcastLivePlaceholder;

	/*
	 * Quick reply
	 */
	@FindBy(xpath = "//span[@title='Quick Reply']")
	public WebElement quickReplyIcon;

	@FindBy(xpath = "//span[contains(text(),'Welcome to NetSfere')]")
	public WebElement netcChatText;

	@FindBy(xpath="//div[@class='mainDiv']//div/div[3]/div[3]/div[3]")
	public WebElement iconTextQuickReply;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[3]//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span")
	public WebElement quickmessageText;

	/*
	 * Meeting Icon in Conversation Page
	 */
	@FindBy(xpath = "//div[@class='mainDiv']//div[2]/button[2]/div[@class='click-ripple']")
	public WebElement create_meeting;

	@FindBy(xpath = "//button[@title='Make Call']")
	public WebElement makeCallButton;

	@FindBy(xpath = "//div[contains(text(),'Conversation created')]")
	public WebElement conversationCreatedPage;

	/*
	 * Guest pop up
	 */

	@FindBy(xpath = "//div[text()='Customize Your Invitation to Guest']")
	public String guestPopUpText;

	@FindBy(xpath = "//button/span[text()='Send']")
	public WebElement sendInvitationButton;

	@FindBy(xpath = "//span[@class='fa fa-check' and @title ='Sent']")
	public WebElement sentMark;

//	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[4]/div/button")
//	public WebElement sendAttachmentButton;

	@FindBy(xpath = "//span[@class='icon ion-plus-circled']")
	public WebElement addAttachmentButton;

	/*
	 * QuickPoll elements
	 */
	@FindBy(xpath = "//span[contains(text(),'Active Poll')]")
	public WebElement activePoll;

	@FindBy(xpath = "//div[contains(text(),'Click or tap to see more detail')]")
	public WebElement concludedPoll;

	@FindBy(xpath = "//div[contains(text(),'Conversation created')]//..//span[contains(text(),' has started a poll.')]")
	public WebElement pollStarted;

	@FindBy(xpath = "//span[contains(text(),'Change vote')]")
	public WebElement changeVoteButton;

	// read only access
	@FindBy(xpath = "//textarea[@class='namegenTextLong' and @placeholder='Your organization administrator has restricted you from sending messages in this channel.']")
	public WebElement readOnlyAccessText;

	// **********
	@FindBy(xpath = "//span[contains(text(),'2021')]")
	public WebElement modifiedTitle;

	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span")
	public WebElement messageFromAndroid;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[3]//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span")
	public WebElement quickReplyMessage;

	// message forwarding
	@FindBy(xpath = "//span[@class='fa fa-share']")
	public WebElement messageForwardArrow;

	@FindBy(xpath = "//span[text()='Forward']")
	public WebElement forwardButton;

	@FindBy(xpath = "//div/div[2]//input[@type='text']")
	public WebElement searchAndSelect;

	@FindBy(xpath = "//div[text()='Select Conversations']/../div[@class='table-view']//div[text()='Welcome to NetSfere']")
	public WebElement welcomeToNetsfereConversation;
	
	@FindBy(xpath="//div[text()='Select Conversations']/..//div[@class='table-view']/div[2]/div/div[2]/div[3]")
	public WebElement forwardConversation;
	
	@FindBy(xpath="//div[text()=' Forwarded...']")
	public WebElement forwardedTab;
	
	/*
	 * Inline reply elements
	 */
	@FindBy(xpath="//span[@class='fa fa-reply']")
	public WebElement inlineReply;
	
	/*
	 * 5.0 client changes
	 */
	
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[1]/span/../div/div[1]/../button[1]/div[2]//*[name()='svg']")
	public WebElement moreOptions;
	
	@FindBy(xpath="//span[text()='Schedule Meeting']")
	public WebElement scheduleMeetingButton;
	
	@FindBy(xpath="//span[@class='icon ion-ios-videocam-outline']")
	public WebElement videoCallButton;
	
	@FindBy(xpath="//span[text()='close']")
	public WebElement closeButton;
	
	
	public void clickOnMessageForwardArrow() {
		messageForwardArrow.click();
		Utils.veryShortSleep();
	}

	public void searchBar(String string) {
		searchAndSelect.click();
	}

	public void messageForwardButton() {
		forwardButton.click();
	}

	public void clickwelcomeToNetsfereConversation() {
		welcomeToNetsfereConversation.click();
	}

	public void guestPopUp() throws InterruptedException {
		Thread.sleep(3000);
		try {
		sendInvitationButton.click();
		}catch(Exception e) {
			System.out.println("No such element found");
		}
		webwait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Conversation created')]")));
	}

	public void messageTextbox(String message) {
		conversationTextBox.sendKeys(message);
	}

	public void streamlineMessageTextbox(String message) {
		streamlineConversationTextBox.sendKeys(message);
	}

	public void sendAttachmentButton() {
		addAttachmentButton.click();
	}

	public void sendMessageButton() {
		sendMessageButton.click();
	}

	public void clickQuickReply() throws InterruptedException {

		quickReplyIcon.click();
		iconTextQuickReply.click();
		Thread.sleep(5000);

	}

	public void addButtonClick() {
		addattachmentButton.click();
	}

	public void clickOnCallButton() {
		makeCallButton.click();
	}
	/*
	 * Broadcast Live methods
	 */

	public void clickOnLiveButton() {
		liveButton.click();
	}

	public void clickOnBroadcastLiveButton() {
		broadcastLiveButton.click();
	}

	public String getLastPlaceholderMessage() {

		List<WebElement> placeholderTextRows = driver.findElements(By.xpath(
				"//div[@class='mainDiv']//div//div//div//div//div//div//div//div//div//div[@class='table-view']//div//div//div//span"));
		int lastElement = placeholderTextRows.size() - 1;
		String placeholderMessage = placeholderTextRows.get(lastElement).getText();
		String s1 = placeholderMessage.substring(0, placeholderMessage.length()-12);
		return s1;

	}
	
	public void clickOnFirstConversationAndForward() {
		forwardConversation.click();
		forwardButton.click();
		webwait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[text()=' Forwarded...']")));
	}
	
	public void clickOnMultipleConversationAndForward() {
		List<WebElement> conversations = driver.findElements(By.xpath("//div[@id='rightColumn']//div[@class='scrollbox']//div[@class='table-view']/div"));
		for(int i=1;i<=5; i++) {
			conversations.get(i).click();
		}
		Utils.veryShortSleep();
		forwardButton.click();
		webwait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[text()=' Forwarded...']")));
	}
	
	public void clickOnReplyButton() {
		inlineReply.click();
	}
	
	public void clickOnMoreOptions() {
		moreOptions.click();
	}
	
	public void clickOnScheduleMeeting() {
		scheduleMeetingButton.click();
	}
	
	public void clickOnVideoCallButton() {
		videoCallButton.click();
	}
	
}
