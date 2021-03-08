package com.infinite.netsfere.automationtool.modules.android.pages;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChatPage implements BasePage {

	private static final String ID_MESSAGE_STATUS_ICON = "message_status_imageview";
	//private static final String ID_CHAT_LIST_VIEW = "chat_list_view";
	
	private static final String ID_CHAT_LIST_VIEW = "chat_box";
	
	
	private static final String ID_MESSAGE_CONTENT_TEXTVIEW = "message_content_textview";
	
	 private static Logger log = LogManager.getLogger(ChatPage.class.getName());


	AndroidDriver<AndroidElement> driver;
	WebDriverWait shortWait;
	WebDriverWait mediumWait;
	WebDriverWait longWait;
	String user1 = Config.getInstance().getWebUserDisplayName();
	ConversationsPage convPage;
	HDOneToOneCallElements hdCall;

	public ChatPage() {
		convPage = new ConversationsPage();
		driver = DriverManager.getAndroidDriver();
		shortWait = Utils.getShortWait(driver);
		mediumWait = Utils.getMediumWait(driver);
		longWait = Utils.getLongWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		hdCall = new HDOneToOneCallElements();
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/more_menu']")
	public WebElement moreMenuButton;


	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.infinite.netsfere:id/button_details']")
	public WebElement chatDetailsButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.infinite.netsfere:id/send_message_edittext']")
	public WebElement messageTextBox;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/send_button']")
	public WebElement sendMessageButton;
	
	                         

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/" + ID_MESSAGE_STATUS_ICON
			+ "' and @content-desc='Sent']")
	public WebElement messageSentIcon;

	/*@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id='" + Constants.androidPackageName
			+ ":id/" + ID_CHAT_LIST_VIEW + "']")
	public WebElement chatListView;*/
	
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/message_status_imageview' and @content-desc='Read']")
	public WebElement readStatus;
	
	
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/message_box_layout' and @index='0']")
	public WebElement chatListView;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/leave_conversation_button']")
	public WebElement leaveFromChat;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/send_message_edittext' and @index='0']")
	public WebElement streamlineConversationTextBox;

	// Broadcast Live buttons
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/broadcast_netstream_text' and @index='0']")
	public WebElement channelLiveButton;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/more_menu_netstream_item' and @index='1']")
	public WebElement conversationLiveButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/broadcast_netstream_text' and @index='0']")
	public WebElement broadcastLiveButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/placeholder_message_textview' and @index='0']")
	public WebElement endBroadcastLivePlaceholder;
		
		
	/*
	 * Add attachment to the Conversation WebElements
	 */
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/insert_attachment_button' and @index='0']")
	public WebElement insertAttachmentButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose From Cloud Storage' and @index='4']")
	public WebElement chooseFromCloudButton;
	
	/*
	 * Quick reply elements and Share location
	 */
	
	@AndroidFindBy(id="com.infinite.netsfere:id/quick_reply_list")
	public WebElement quickReplyDialogueBox;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/quick_reply_button']")
	public WebElement quickReplyButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public WebElement firstQuickReply;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/message_status_imageview']")
	public WebElement quickReplySentStatus;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/attach_location_button' and @text='Share Location']")
	public WebElement shareLocationLink;


	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message' and @text='Allow NetSfere to access this device's location?']")
	public WebElement allowLocationPopUp;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
	public WebElement allowButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_done' and @index='0']")
	public WebElement selectLocation;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/location_other_item']")
	public WebElement otherLocation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_search']")
	public WebElement searchLocation;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/search_src_text' and @text='Search…']")
	public WebElement enterLocationTextBox;
	
	
	/*
	 * Call Button
	 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/menu_call_item']")
	public WebElement callButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/live_call_return_button']")
	public WebElement returnToCallButton;
	
	/*
	 * Placeholder 
	 */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/placeholder_message_textview']")
	public WebElement placeholderForConversation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/number_of_participants_textView']")
	public WebElement usersCount;
	
	/*
	 * create Poll button
	 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/poll_button']")
	public WebElement createPollButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/poll_notification_title_textView']")
	public WebElement activePoll;
	
	//conversation/channel's title
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	public WebElement chatPageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/read_only_text' and @index='0']")
	public WebElement readOnlyAccessText;
	
	/*
	 * Meeting icon
	 */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/more_menu_meeting_item' and @index='2']")
	public WebElement moreMenuMeeting;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/menu_meeting']")
	public WebElement scheduleMeetingButton;
	
	/*
	 * Changes as per 4.2 clients
	 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Tap here to view details']")
	public WebElement tapToViewDetails;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/live_call_return_button']")
	public WebElement tapToReturnToCall;
	
	/*
	 * Message forward elements
	 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/forwarded_message_digest_textView']")
	public WebElement forwardedTab;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']")
	public WebElement forwardedFirstConversation;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/action_send_fab']")
	public WebElement sendButton;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/message_box_layout']")
	public WebElement messageBox;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/chat_box']")
	public WebElement imageBox;
	/*
	 * Allow pop ups as per 5.0 clients
	 */
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	public WebElement allowPopUpButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']")
	public WebElement permissionVideoMessage;
	
	/*
	 * Video call elements
	 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/menu_video_item']")
	public WebElement videoCallButton;
	
	
	/*
	 * Box and dracoon account
	 */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/account_integration' and @text='BOX']")
	public WebElement addBoxAccount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/account_integration' and @text='DRACOON']")
	public WebElement addDracoonAccount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/account_name' and @text='murali.tallapudi@infinite.com']")
	public WebElement dracoonAccount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/file_name' and @text='netsfere_attachments']")
	public WebElement dracoonAttachment;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/file_name' and @text='results7.pdf']")
	public WebElement dracoonPdfFile;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/send_button']")
	public WebElement sendCloudAttachmentButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/account_name' and @text='convergenceinfinite@gmail.com']")
	public WebElement boxAccount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/file_name' and @text='Test']")
	public WebElement boxAttachment;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/file_name' and @text='DOCFile.doc']")
	public WebElement boxDocFile;
	
	public void clickTapToReturnToCall()
	{
		tapToReturnToCall.click();
	}
	public void clickMeetingIcon(){
		moreMenuMeeting.click();
	}
	public void clickMoreMenu() {
		moreMenuButton.click();
	}
	
	public void clickOnTapToView() {
		tapToViewDetails.click();
	}

	public void clickLeavefromChat() {
		leaveFromChat.click();
	}
	public void clickDetailsButton() {
		chatDetailsButton.click();
	}
	
	public void clickOnScheduleMeeting() {
		scheduleMeetingButton.click();
	}

	public String sendTextMessage() {
		String message = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()) + " "
				+ Config.getInstance().getMessageFromAndroid();
		messageTextBox.clear();
		messageTextBox.sendKeys(message);
		sendMessageButton.click();
		return message;
	}

	public WebElement getLastMessageView() {
		// Get message rows from chat list view
		List<WebElement> messageRows = chatListView.findElements(By.className("android.widget.RelativeLayout"));
		// Get last message from the list
		WebElement lastMessage = messageRows.get(messageRows.size() - 1);
		return lastMessage;		
	}

	public void waitTillMessageSent(WebElement messageElement) {
		longWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(messageElement,
				By.xpath("//android.widget.ImageView[@resource-id='" + Constants.androidPackageName + ":id/"
						+ ID_MESSAGE_STATUS_ICON + "' and @content-desc='Sent']")));
	}
	
	public String getMessageContent(WebElement messageElement) {
		WebElement lastMessageContent = messageElement.findElement(By.xpath("//android.widget.TextView[@resource-id='"
				+ Constants.androidPackageName + ":id/" + ID_MESSAGE_CONTENT_TEXTVIEW + "']"));
		return lastMessageContent.getText();
	}
	
	public boolean isMessageSentIconPresent(WebElement messageElement) {
		try {
			messageElement.findElement(By.xpath("//android.widget.ImageView[@resource-id='"
					+ Constants.androidPackageName + ":id/" + ID_MESSAGE_STATUS_ICON + "' and @content-desc='Sent']"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void clickQuickReplyButton(){		
		quickReplyButton.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[@index=0]")));
	}
	public void sendFirstQuickReplyMessage()
	{
		firstQuickReply.click();
	}
	public void clickSendMessageButton()
	{
		sendMessageButton.click();
	}
	
	/* Live broadcast methods */ 
	public void clickOnChannelLiveButton() {
		channelLiveButton.click();
	}
	
	public void clickOnConversationLiveButton() {
		conversationLiveButton.click();
	}

	public void clickBroadcastLiveButton() {
		broadcastLiveButton.click();
	}
	
	public void addLocationLink(){
		insertAttachmentButton.click();
		shareLocationLink.click();
		try{
//			shortWait.until(ExpectedConditions.visibilityOf(allowLocationPopUp));
			Utils.veryShortSleep();
			if(allowLocationPopUp.isDisplayed()) {
			allowButton.click();
			}
		}
//		catch(TimeoutException e){
		catch(Exception e){
		log.error("Allow pop up is not coming");
		}
		finally{
		selectLocation.click();
		//Utils.shortSleep();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/message_status_imageview']")));
		//sendLocationButton.click();
		}
		
	}

	public void clickOnInsertAttachment() {
		insertAttachmentButton.click();
	}
	public void clickOnCallButton() {
		callButton.click();
	}
	
	public void clickOnCreatePoll() {
		createPollButton.click();
	}
	
	public void clickOnActivePoll() {
		activePoll.click();
	}
	public void streamlineMessageTextbox(String message) 
	{
		streamlineConversationTextBox.click();
		streamlineConversationTextBox.sendKeys(message);
	}
	
	public String getLastPlaceholderMessage() {
		List<AndroidElement> placeholderTextRows = driver.findElements(By.xpath(
				"//android.widget.TextView[@resource-id='com.infinite.netsfere:id/placeholder_message_textview']"));
		int lastElement = placeholderTextRows.size() - 1;
		String s = placeholderTextRows.get(lastElement).getText();
		String s1 = s.substring(2, s.length()-10);
		return s1;
	
	}
	
	//###### This is to assert the participant count for 1-1 Conversation
	public void participantCount1_1Conv(){
		String users = usersCount.getText();
		String[] usrArr = users.split(" ");
		String st = "";
		st = st+usrArr[0];
		int count = Integer.parseInt(st);
		if(count==1){
			Utils.navigateBack(driver);
			Utils.veryShortSleep();
			convPage.firstCreatedConversation.click();
		}
	}
	
	
	//###### This is to assert the participant count for group Conversation
	public void participantCountGroupConv(){
		String users = usersCount.getText();
		String[] usrArr = users.split(" ");
		String st = "";
		st = st+usrArr[0];
		int count = Integer.parseInt(st);
		if(count<=2){
			Utils.navigateBack(driver);
			Utils.veryShortSleep();
			convPage.firstCreatedConversation.click();
		}
	}
	
	public void participantCountGuest(){
		String users = usersCount.getText();
		String[] usrArr = users.split(" ");
		String st = "";
		st = st+usrArr[0];
		int count = Integer.parseInt(st);
//		if(count==1){
//			Utils.navigateBack(driver);
//			Utils.veryShortSleep();
//			convPage.firstCreatedGuestConversation.click();
//		}
	}
	
	public void clickOnFirstForwardConversation() {
		forwardedFirstConversation.click();
	}
	
	public void clickOnMultipleConversations() throws InterruptedException {
		List<AndroidElement> conversations = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_name_text']"));
		
		for(int i = 1;i<=5;i++) {
			Thread.sleep(3000);
			mediumWait.until(ExpectedConditions.visibilityOf(conversations.get(i)));
//			Thread.sleep(2000);
//			mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.CheckBox[@resource-id='com.infinite.netsfere:id/checkbox_selected_conversation']")));
			conversations.get(i).click();
		}
	}
	
	public void clickOnForwardMessageSendButton() {
		sendButton.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/forwarded_message_digest_textView']")));
	}
	
	public void clickOnChooseFromCloudStorage() {
		chooseFromCloudButton.click();
	}
	
	public void clickOnAddBoxAccount() {
		addBoxAccount.click();
	}
	
	public void clickOnAddDracoonAccount() {
		addDracoonAccount.click();
	}
	
	public void clickOnDracoonAccount() {
        dracoonAccount.click();
	}
	
	public void clickOnDracoonAttachment() {
		dracoonAttachment.click();
	}
	
	public void clickOnDracoonPdfFile() {
		dracoonPdfFile.click();
	}
	
	public void clickOnAttachmentSendButton() {
		sendCloudAttachmentButton.click();
	}
	
	public void clickOnBoxAccount() {
		boxAccount.click();
	}
	
	public void clickOnBoxAttachment() {
		boxAttachment.click();
	}
	
	public void clickOnBoxDocFile() {
		boxDocFile.click();
	}
	
	public void clickOnVideoCallButton() {
		videoCallButton.click();
		try {
			try {
				if (hdCall.callPopUp1.isDisplayed()) {
					hdCall.allowButton.click();
				}
			} catch (Exception e) {
				System.out.println("No such element found");
			}
			if (permissionVideoMessage.isDisplayed()) {
				allowPopUpButton.click();
			}

			try {
				if (hdCall.callPopUp2.isDisplayed()) {
					allowButton.click();
				}
			} catch (Exception e) {
				System.out.println("No such element found");
			}
		} catch (Exception e) {
			System.out.println("No Such element present");
		}
	}
	
	
	public void clickOnVideoCallButtonToForward() throws InterruptedException {
		videoCallButton.click();
		Thread.sleep(3000);
	}

	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_CHAT_SCREEN
		return driver.currentActivity().equals(Constants.ACTIVITY_CHAT_SCREEN);
	}

	public void navigateTo() throws Exception {
		// Doing nothing, because this is a chat page which is linked
		// with a particular conversation, which is not known at this point.
	}
}