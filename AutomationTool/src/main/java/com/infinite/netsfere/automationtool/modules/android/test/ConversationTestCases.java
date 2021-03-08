package com.infinite.netsfere.automationtool.modules.android.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.BottomNavigationBar;
import com.infinite.netsfere.automationtool.modules.android.pages.BoxPage;
import com.infinite.netsfere.automationtool.modules.android.pages.BroadcastLivePage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationDetailsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.DracoonPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ExportConversationPage;
import com.infinite.netsfere.automationtool.modules.android.pages.LeaveConversationPage;
import com.infinite.netsfere.automationtool.modules.android.pages.NewConversationPage;
import com.infinite.netsfere.automationtool.modules.android.pages.SendAttachmentFromDeviceNexus5X;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.AndroidIoOperations;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ConversationTestCases extends BaseTestCases {

	ConversationsPage conversationsPage;
	NewConversationPage newConversationPage;
	ChatPage chatPage;
	ConversationDetailsPage conversationDetailsPage;
	ExportConversationPage exportconversationPage;
	LeaveConversationPage leaveConvoPage;
	SendAttachmentFromDeviceNexus5X sendAttachmentFromDevice;
	BroadcastLivePage broadcastLivePage;
	ChannelTestCase channel;
	DracoonPage dracoon;
	BoxPage box;
	BottomNavigationBar bottomBar;
	
	 private static Logger log = LogManager.getLogger(ConversationTestCases.class.getName());


	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;

	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		conversationsPage = new ConversationsPage();
		newConversationPage = new NewConversationPage();
		chatPage = new ChatPage();
		conversationDetailsPage = new ConversationDetailsPage();
		exportconversationPage = new ExportConversationPage();
		leaveConvoPage = new LeaveConversationPage();
		sendAttachmentFromDevice = new SendAttachmentFromDeviceNexus5X();
		broadcastLivePage = new BroadcastLivePage();
		channel = new ChannelTestCase();
		dracoon = new DracoonPage();
		box = new BoxPage();
		bottomBar = new BottomNavigationBar();
	}
	
	@Test
	public void launchApp() {
		if(!(driver.currentActivity().contains("netsfere"))) {
			driver.launchApp();			
		}
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void createConversationWithoutTitle() {
		try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.selectUser(Config.getInstance().getWebUserDisplayName());
			newConversationPage.clickOnCreateButton();
			Utils.shortSleep();
			//chatPage.participantCount1_1Conv();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		} catch (Exception e) {
			Assert.fail("Unable to create conversation without title");
		}
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void createConversationWithTitle() throws Exception {
//		try {
			conversationsPage.clickOnNewConversationFab();
			Utils.veryShortSleep();
			newConversationPage.selectUser(Config.getInstance().getWebUserDisplayName());
			String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			conversationDetailsPage.enterConversationTitleWithParticipant("New" + conversationTitle);
			conversationDetailsPage.clickOnCreateButton();
			Utils.shortSleep();
//			chatPage.participantCount1_1Conv();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
//		} catch (Exception e) {
//			Assert.fail("Unable to create conversation with title");
//		}
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public String createOneToOneConversation() {
		return createConversation(false);
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public String createGroupConversation() {
		return createConversation(true);
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void createGroupConversationWithTitle(String webUser , String iosUser) throws Exception {
		Utils.shortSleep();
		//try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.selectUser(webUser);
			newConversationPage.selectUser(iosUser);
			String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			conversationDetailsPage.enterConversationTitleWithParticipant("Group" + conversationTitle);
			conversationDetailsPage.clickOnCreateButton();
			Utils.veryShortSleep();
//			chatPage.participantCountGroupConv();
//		} catch (Exception e) {
//			Assert.fail("Unable to create group conversation with title", e);
//		}
		
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);

	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void createGroupConversationWithoutTitle(String webUser , String iosUser) throws Exception {
		//try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.selectUser(webUser);
			newConversationPage.selectUser(iosUser);
			Utils.veryShortSleep();
			conversationDetailsPage.clickOnCreateButton();
			Utils.veryShortSleep();
//			chatPage.participantCountGroupConv();
//		} catch (Exception e) {
//			Assert.fail("Unable to create group conversation with title", e);
//		}
		
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);

	}
	
	@Test(dependsOnMethods={"createConversationWithTitle"})
	@NavigateTo(ConversationsPage.class)
	public void addParticipantInConversation() throws Exception {
		createConversationWithTitle();
//		chatPage.clickMoreMenu();
//		chatPage.clickDetailsButton();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getIosUserDisplayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		Utils.veryShortSleep();
		conversationDetailsPage.clickOnSaveButton();
		//chatPage.participantCountGroupConv();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("joined this conversation"));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}

	@Test(dependsOnMethods={"createConversationWithTitle"})
	@NavigateTo(ConversationsPage.class)
	public void removeParticipant() throws Exception {
		createConversationWithTitle();
//		chatPage.clickMoreMenu();
//		Utils.veryShortSleep();
//		chatPage.clickDetailsButton();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		Utils.veryShortSleep();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getWebUserDisplayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		conversationDetailsPage.clickOnSaveButton();
		Utils.shortSleep();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("left this conversation"));

	}

	@Test(dependsOnMethods={"createConversationWithTitle"})
	@NavigateTo(ConversationsPage.class)
	public void updateExistingConversationTitleFromChatScreen() {
//		chatPage.clickMoreMenu();
//		chatPage.clickDetailsButton();
		chatPage.clickOnTapToView();
		String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		conversationDetailsPage.enterConversationTitle(conversationTitle);
		conversationDetailsPage.clickOnSaveButton();
		Utils.shortSleep();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}

	@Test(dependsOnMethods={"createConversationWithTitle"})
	@NavigateTo(ConversationsPage.class)
	public void sendMessageFromChatScreen() {
		String sentMessage = chatPage.sendTextMessage();
		Utils.shortSleep();
		// Get last message from the list
		WebElement lastMessage = chatPage.getLastMessageView();
		// Wait until message status icon turns in to sent icon
//		chatPage.waitTillMessageSent(lastMessage);
		Utils.shortSleep();
		chatPage.isMessageSentIconPresent(lastMessage);
		// Get the last message content
		String lastMessageContent = chatPage.getMessageContent(lastMessage);
		// Check both message content and message status are matching
//		Assert.assertTrue(sentMessage.equals(lastMessageContent) && chatPage.isMessageSentIconPresent(lastMessage));
		Assert.assertTrue(chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		Utils.navigateToHomeScreen(driver);
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void searchForRandomConversationAndOpen() {
		String searchString = new SimpleDateFormat("yyyy").format(new java.util.Date());
		try {
			conversationsPage.searchFor(searchString);
			Utils.veryShortSleep();
			conversationsPage.clickOnFirstListItem();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
//		driver.navigate().back();
		Utils.veryShortSleep();
		Utils.navigateBack(driver);
		Utils.navigateBack(driver);
//		Utils.navigateBack(driver);
		driver.navigate().back();

	}

	@Test
	@Parameters("title")
	@NavigateTo(ConversationsPage.class)
	public void searchForParticularConversationAndOpen(String title) {
		try {
			conversationsPage.searchFor(title);
			conversationsPage.clickOnFirstListItem();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		AndroidIoOperations.getInstance().hideKeyboard();
	}

	
	@Test(dependsOnMethods={"createConversationWithoutTitle"})
	@NavigateTo(ConversationsPage.class)
	public void exportFirstConversation() throws Exception {
//		try {
			streamlinedConversationByClickingCreateButton();
			driver.navigate().back();
			conversationsPage.longPressonFirstConversationAndExport();
			exportconversationPage.exportEmailConversation();
			conversationsPage.waitTillEmailSent();
//		} catch (Exception e) {
//			Assert.fail(e.getMessage(), e);
//		}

	}

	@Test(dependsOnMethods={"createConversationWithoutTitle"})
	@NavigateTo(ConversationsPage.class)
	public void leaveConversationAsParticipantFromChatPage() {
		try{
			createOneToOneConversation();
//			chatPage.clickMoreMenu();
//			chatPage.clickLeavefromChat();
			chatPage.clickOnTapToView();
			conversationDetailsPage.clickOnLeaveButton();
			leaveConvoPage.transferOwnershipWithoutLeavingConversation();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CONVERSATION_DETAILS_PAGE);
//			chatPage.clickMoreMenu();
//			chatPage.clickLeavefromChat();
			conversationDetailsPage.clickOnLeaveButton();
			leaveConvoPage.leaveConversation();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);
		}
		catch (Exception e) {
			Assert.fail("No conversations on list", e.getCause());
		}
	}

	@Test(dependsOnMethods={"createGroupConversationWithTitle"})
	@NavigateTo(ConversationsPage.class)
	public void sendQuickReply() throws Exception {
//	try{

			createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(), Config.getInstance().getIosUserDisplayName());
			Utils.veryShortSleep();
			chatPage.clickQuickReplyButton();
			chatPage.sendFirstQuickReplyMessage();
			chatPage.clickSendMessageButton();
			Utils.veryShortSleep();
			Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
//		}catch (Exception e) {
//			Assert.fail("Unable to send quick reply", e.getCause());
//		}
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void muteConversation() throws Exception {
		createOneToOneConversation();
		driver.navigate().back();
		conversationsPage.muteConversation();	
		
	}
	
	@Test (dependsOnMethods={"muteConversation"})
	@NavigateTo(ConversationsPage.class)
	public void unMuteConversation() throws Exception {
//		createGroupConversationWithTitle();
		conversationsPage.unMuteConversation();		
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void favoriteConversation() throws Exception {
		createConversationWithTitle();
		driver.navigate().back();
		conversationsPage.favoriteConversation();		
	}
	

	@Test(dependsOnMethods={"favoriteConversation"})
	@NavigateTo(ConversationsPage.class)
	public void unFavoriteConversation() throws Exception {
//		createGroupConversationWithTitle();
		conversationsPage.unFavoriteConversation();		
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void sendMyLocation() throws Exception {
		//try{
			createConversationWithTitle();
			chatPage.addLocationLink();
			Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
//			Utils.navigateToHomeScreen(driver);
//		}catch (Exception e) {
//			Assert.fail("Unable to send location", e.getCause());
//		}
//		Utils.navigateToHomeScreen(driver);
	}
	

	@Test
	@NavigateTo(ConversationsPage.class)
	public void leaveConversationAsParticipantFromConversationPage() throws Exception {
		String title = createOneToOneConversation();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		Utils.navigateToHomeScreen(driver);
//		try {
			conversationsPage.searchFor(title);
			conversationsPage.longPressonFirstListItem();
			conversationsPage.clickOnLeaveConversation();
			leaveConvoPage.transferOwnershipWithoutLeavingConversation();
			conversationsPage.searchFor(title);
			conversationsPage.longPressonFirstListItem();
			conversationsPage.clickOnLeaveConversation();
			leaveConvoPage.leaveConversation();
			Utils.navigateBack(driver);
			validateThatDeletedConversationDoesNotExist(title);
//		} catch (Exception e) {
//			Assert.fail(e.getMessage());
//		}
		Utils.veryShortSleep();
		driver.navigate().back();
//		driver.navigate().back();
//		Utils.navigateBack(driver);

	}

	@Test
	@NavigateTo(ConversationsPage.class)
	private void validateThatDeletedConversationDoesNotExist(String title) throws Exception {
		conversationsPage.searchFor(title);
		try {
			Assert.assertEquals(true, conversationsPage.firstConversation.isDisplayed());
			Assert.fail();
		} catch (NoSuchElementException e) {
			// First conversation element shouldn't be visible, so it should
			// come here
			log.info("Destroyed conversation is not visible");
		}
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void transferOwnershipAndLeaveConversation() {
		String title = createGroupConversation();
//		chatPage.clickMoreMenu();
//		chatPage.clickLeavefromChat();
		chatPage.clickOnTapToView();
		conversationDetailsPage.clickOnLeaveButton();
		leaveConvoPage.transferOwnershipAsOwner();
		try {
			validateThatDeletedConversationDoesNotExist(title);
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
//		driver.navigate().back();
		Utils.veryShortSleep();
		driver.navigate().back();
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void destroyConversationAsOwner() {

		String title = createGroupConversation();
//		chatPage.clickMoreMenu();
//		chatPage.clickLeavefromChat();
		chatPage.clickOnTapToView();
		conversationDetailsPage.clickOnLeaveButton();
		Utils.veryShortSleep();
		leaveConvoPage.destroyParticularConversation();
		Utils.veryShortSleep();
		try {
			validateThatDeletedConversationDoesNotExist(title);
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Utils.navigateBack(driver);
		Utils.veryShortSleep();
		Utils.navigateBack(driver);

	}

	@Test(dependsOnMethods={"createOneToOneConversation"})
	@NavigateTo(ConversationsPage.class)
	public void sendImageFromNexus5X() {
		try{
			createOneToOneConversation();
			chatPage.clickOnInsertAttachment();
			sendAttachmentFromDevice.clickOnAttachPhoto();
			sendAttachmentFromDevice.sendImageFromDevice();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		}catch (Exception e) {
			Assert.fail("Unable to send Image from device", e.getCause());
		}
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void createConversationWithANewGuestUser() {
		try {
			conversationsPage.clickOnNewConversationFab();
			String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			newConversationPage.inviteGuestUser("guest" + randomDate + "@nrathya.netsferetest.org");
			conversationDetailsPage.clickOnCreateButton();
			conversationDetailsPage.inviteGuestMessageButtonClick();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}

		Utils.shortSleep();
		chatPage.clickOnTapToView();
		chatPage.participantCountGuest();
		Utils.navigateToHomeScreen(driver);
		Assert.assertEquals(true, conversationsPage.guestBadge.isDisplayed());
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void sendingMessageToWebGuestUser() {
		try {
			conversationsPage.clickOnNewConversationFab();
			String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			newConversationPage.inviteGuestUser("guest" + randomDate + "@nrathya.netsferetest.org");
			conversationDetailsPage.clickOnCreateButton();
			conversationDetailsPage.inviteGuestMessageButtonClick();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Utils.shortSleep();
		chatPage.clickOnTapToView();
		chatPage.participantCountGuest();
		Utils.navigateBack(driver);
		chatPage.sendTextMessage();
		chatPage.waitTillMessageSent(chatPage.messageSentIcon);
		Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		Utils.navigateToHomeScreen(driver);

	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void guestUserSendingMessageToNetsfereUser() {
		try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.inviteGuestUser(Config.getInstance().getWebUserEmail());
			conversationDetailsPage.clickOnCreateButton();
			Utils.shortSleep();
			chatPage.participantCountGuest();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		chatPage.sendTextMessage();
		chatPage.waitTillMessageSent(chatPage.messageSentIcon);
		Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		Utils.navigateToHomeScreen(driver);
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void androidNetsfereUserCreateConvWithActivatedGuestUser() throws Exception {
//		try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.inviteGuestUser(Config.getInstance().getGuestUser());
			conversationDetailsPage.clickOnCreateButton();
//		} catch (Exception e) {
//			Assert.fail(e.getMessage(), e);
//		}
		Utils.shortSleep();
		chatPage.clickOnTapToView();
		chatPage.participantCountGuest();
		Utils.navigateBack(driver);
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);

	}
	
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void addGuestToExistingConv() throws InterruptedException {
		createConversationWithoutTitle();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getGuestDisplayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		Utils.veryShortSleep();
		conversationDetailsPage.clickOnSaveButton();
		//chatPage.participantCountGroupConv();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("joined this conversation"));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}
	
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void removeGuestFromConversation() throws Exception {
		androidNetsfereUserCreateConvWithActivatedGuestUser();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		Utils.veryShortSleep();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getGuestDisplayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		conversationDetailsPage.clickOnSaveButton();
		Utils.shortSleep();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("left this conversation"));

	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void destroyConversationWithGuest() throws Exception {
		androidNetsfereUserCreateConvWithActivatedGuestUser();
		chatPage.clickOnTapToView();
		conversationDetailsPage.clickOnLeaveButton();
		Utils.veryShortSleep();
		leaveConvoPage.destroyParticularConversation();
		Utils.shortSleep();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);
//		try {
//			validateThatDeletedConversationDoesNotExist(title);
//		} catch (Exception e) {
//			Assert.fail(e.getMessage(), e);
//		}
//		Utils.navigateBack(driver);
//		Utils.veryShortSleep();
	}
	

	@Test
	@NavigateTo(ConversationsPage.class)
	public void androidGuestUserCreateConvWithNetsfereUsere() {
		try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.inviteGuestUser(Config.getInstance().getWebUserEmail());
			conversationDetailsPage.clickOnCreateButton();
			Utils.shortSleep();
			chatPage.participantCountGuest();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}
	//guest location	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void sendLocationToGuestInAConversation() throws Exception
	{
		conversationsPage.clickOnNewConversationFab();
		String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		newConversationPage.inviteGuestUser("guest" + randomDate + "@nrathya.netsferetest.org");
		conversationDetailsPage.clickOnCreateButton();
		conversationDetailsPage.inviteGuestMessageButtonClick();
		Utils.shortSleep();
		sendMyLocation();
		chatPage.waitTillMessageSent(chatPage.messageSentIcon);
		Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
	}
	@Test
	@NavigateTo(ConversationsPage.class)
	public void guestUserSendLocationInAConversation() throws Exception
	{
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.inviteGuestUser(Config.getInstance().getWebUserEmail());
			conversationDetailsPage.clickOnCreateButton();
			sendMyLocation();
			chatPage.waitTillMessageSent(chatPage.messageSentIcon);
			Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
	}
	
	
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void streamlinedConversationByClickingCreateButton() {
		try {
			conversationsPage.clickOnNewConversationFab();
			newConversationPage.selectUser(Config.getInstance().getWebUserDisplayName());
			chatPage.streamlineMessageTextbox(Config.getInstance().getMessageFromAndroid());
			newConversationPage.clickOnCreateButton();
			Utils.shortSleep();
			Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		} catch (Exception e) {
			Assert.fail("Unable to send message in conversation using create buton");
		}
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void streamlinedConversationByClickingSendButton() throws Exception {
		//try {
			conversationsPage.clickOnNewConversationFab();
			Utils.veryShortSleep();
			newConversationPage.selectUser(Config.getInstance().getWebUserDisplayName());
			chatPage.streamlineMessageTextbox(Config.getInstance().getMessageFromAndroid());
		    chatPage.clickSendMessageButton();
			Utils.shortSleep();
			Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		/*} catch (Exception e) {
			Assert.fail("Unable to send message in conversation using Send button");
		}*/
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void startLiveFromConversation() {
			createOneToOneConversation();
			chatPage.clickOnConversationLiveButton();
			chatPage.clickBroadcastLiveButton();
			mediumWait.until(ExpectedConditions.visibilityOf(broadcastLivePage.liveLabelOnBroadcastLive));
			Assert.assertEquals(true, broadcastLivePage.liveLabelOnBroadcastLive.isDisplayed());		
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void validateBadgeCountInConversation() {
//		try {
			if(conversationsPage.validateUnreadBadgeCount()!=null) {
				log.info("Unread message present in the conversation");
			}
//		}catch(NoSuchElementException e) {
//			log.error("No Unread message in the conversation");
//		}
	}
	
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void validateUnreadBadgeCountInUnreadTab() {
		
		String messageCount = conversationsPage.validateUnreadBadgeCount();
		conversationsPage.navigateToUnreadTab();
		conversationsPage.clickOnUnreadMessage();
		Utils.navigateToHomeScreen(driver);
		String messageCount1 = conversationsPage.validateUnreadBadgeCount();
		Assert.assertNotSame(messageCount, messageCount1);
		conversationsPage.navigateToAllTab();
	}
	
	/*
	 * Assertion test cases
	 */
	
	public void withoutTitleAssertion(){
		Assert.assertEquals("Now", conversationsPage.conversationTime.getText());
//		Assert.assertEquals(Config.getInstance().getWebUserDisplayName(), conversationsPage.ownerNameAsDefaultTitle.getText());
	}
	
	public void conversationWithTitleAssertion() throws InterruptedException{
		driver.navigate().back();
		Utils.veryShortSleep();
		Assert.assertEquals(true, conversationsPage.conversationTime.getText().contains("Now"));
	}
	
	public void addParticipantAssertion() throws InterruptedException{
		driver.navigate().back();
		conversationsPage.ownerNameAsDefaultTitle.click();
		Thread.sleep(1000);
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("joined this conversation."));
		driver.navigate().back();
		
	}
	
	public void webGuestSendingMessageAssertion(){
		List<AndroidElement> lst = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.infinite.netsfere:id/conversation_list']/android.widget.RelativeLayout"));
		log.info(lst.size());
		lst.get(1).click();
		Utils.veryShortSleep();
		Assert.assertEquals(Config.getInstance().getGuestMessage(), conversationsPage.messageFromWebGuest.getText());
		driver.navigate().back();
	}
	
	public void updateTitleAssertion() throws InterruptedException{
		driver.navigate().back();
		Thread.sleep(2000);
		Assert.assertEquals(true ,conversationsPage.ClickfirstConversationTitleInAllTab().getText().contains("2021"));
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void androidUserAsAParticipantUnableToEditParticipantsInConversation(){
		Utils.navigateToHomeScreen(driver);
		conversationsPage.clickOnFirstConversation();
//		chatPage.clickMoreMenu();
//		chatPage.clickDetailsButton();
		chatPage.clickOnTapToView();
		Assert.assertEquals(false, newConversationPage.editParticipantTextPresent());
		driver.navigate().back();
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void androidUserAsAParticipantCannotChangeTitleInConversation(){
		Utils.navigateToHomeScreen(driver);
		conversationsPage.clickOnFirstConversation();
//		chatPage.clickMoreMenu();
//		chatPage.clickDetailsButton();
		chatPage.clickOnTapToView();
		Assert.assertEquals(false, newConversationPage.saveItemAfterChanges());
	}
	
	@Test
	public void forwardMessageToAConversation() throws InterruptedException {
		Utils.longPressElement(chatPage.messageBox);
		chatPage.clickOnVideoCallButtonToForward();
		Utils.veryShortSleep();
		chatPage.clickOnFirstForwardConversation();
		chatPage.clickOnForwardMessageSendButton();
		Assert.assertEquals(true, chatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	public void forwardAttachmentToAConversation() throws InterruptedException {
		Utils.longPressElement(chatPage.imageBox);
		Thread.sleep(3000);
		chatPage.clickOnVideoCallButtonToForward();
		Utils.veryShortSleep();
		chatPage.clickOnFirstForwardConversation();
		chatPage.clickOnForwardMessageSendButton();
		Assert.assertEquals(true, chatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	public void forwardMessageToMultipleConversation() throws InterruptedException {
		Utils.longPressElement(chatPage.messageBox);
		chatPage.clickOnVideoCallButtonToForward();
		Utils.veryShortSleep();
		chatPage.clickOnMultipleConversations();
		chatPage.clickOnForwardMessageSendButton();
		Assert.assertEquals(true, chatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void assertFirstConversationForwardedMessage() throws Exception {
		Utils.navigateToHomeScreen(driver);
		bottomBar.navigateToConversationsPage();
		conversationsPage.clickOnFirstConversation();
		Assert.assertEquals(true, chatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	public void inlineReply() {
		Utils.navigateToHomeScreen(driver);
		conversationsPage.clickOnFirstConversation();
		Utils.longPressElement(chatPage.messageBox);
		chatPage.clickOnCallButton();
		chatPage.sendTextMessage();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.readStatus));
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void sendAttachmentFromDracoon() throws Exception {
		createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(), Config.getInstance().getIosUserDisplayName());
		chatPage.clickOnInsertAttachment();
		chatPage.clickOnChooseFromCloudStorage();
		try {
			Thread.sleep(3000);
			if(chatPage.dracoonAccount.isDisplayed()) {
				chatPage.clickOnDracoonAccount();
				mediumWait.until(ExpectedConditions.visibilityOf(chatPage.dracoonAttachment));
				chatPage.clickOnDracoonAttachment();
				mediumWait.until(ExpectedConditions.visibilityOf(chatPage.dracoonPdfFile));
				chatPage.clickOnDracoonPdfFile();
				mediumWait.until(ExpectedConditions.visibilityOf(chatPage.sendCloudAttachmentButton));
				chatPage.clickOnAttachmentSendButton();
				chatPage.waitTillMessageSent(chatPage.messageSentIcon);
				
			}
		}catch(Exception e) {
		mediumWait.until(ExpectedConditions.visibilityOf((chatPage.addDracoonAccount)));
		chatPage.clickOnAddDracoonAccount();
		mediumWait.until(ExpectedConditions.visibilityOf((dracoon.usernameText)));
		dracoon.loginToDracoon(Config.getInstance().getDracoonUsername(), Config.getInstance().getDracoonPassword());
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.dracoonAccount));
		chatPage.clickOnDracoonAccount();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.dracoonAttachment));
		chatPage.clickOnDracoonAttachment();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.dracoonPdfFile));
		chatPage.clickOnDracoonPdfFile();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.sendCloudAttachmentButton));
		chatPage.clickOnAttachmentSendButton();
		chatPage.waitTillMessageSent(chatPage.messageSentIcon);
		}
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void sendAttachmentFromBox() throws Exception {
		createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(), Config.getInstance().getIosUserDisplayName());
		chatPage.clickOnInsertAttachment();
		chatPage.clickOnChooseFromCloudStorage();
		try {
			Thread.sleep(3000);
			if(chatPage.boxAccount.isDisplayed()) {
				chatPage.clickOnBoxAccount();
				mediumWait.until(ExpectedConditions.visibilityOf(chatPage.boxAttachment));
				chatPage.clickOnBoxAttachment();
				mediumWait.until(ExpectedConditions.visibilityOf(chatPage.boxDocFile));
				chatPage.clickOnBoxDocFile();
				mediumWait.until(ExpectedConditions.visibilityOf(chatPage.sendCloudAttachmentButton));
				chatPage.clickOnAttachmentSendButton();
				chatPage.waitTillMessageSent(chatPage.messageSentIcon);
			}
		}catch(Exception e) {
		mediumWait.until(ExpectedConditions.visibilityOf((chatPage.addBoxAccount)));
		chatPage.clickOnAddBoxAccount();
		mediumWait.until(ExpectedConditions.visibilityOf((box.boxPage)));
		box.loginToBox(Config.getInstance().getBoxEmail(), Config.getInstance().getBoxPassword());
		mediumWait.until(ExpectedConditions.visibilityOf(box.grantAccessToBox));
		box.clickOnGrantAccessButton();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.boxAccount));
		chatPage.clickOnBoxAccount();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.boxAttachment));
		chatPage.clickOnBoxAttachment();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.boxDocFile));
		chatPage.clickOnBoxDocFile();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.sendCloudAttachmentButton));
		chatPage.clickOnAttachmentSendButton();
		chatPage.waitTillMessageSent(chatPage.messageSentIcon);
		}
		
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void createSelfConversation() throws Exception {
		conversationsPage.clickOnNewConversationFab();
		newConversationPage.clickOnCreateButton();
		Utils.shortSleep();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void addParticipantToSelfConversation() throws Exception {
		createSelfConversation();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getWebUserDisplayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		Utils.veryShortSleep();
		conversationDetailsPage.clickOnSaveButton();
		//chatPage.participantCountGroupConv();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("joined this conversation"));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void addMultipleParticipantsToAConversation() throws InterruptedException {
		createOneToOneConversation();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getIosUserDisplayName());
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getSecondWebUserDisPlayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		Utils.veryShortSleep();
		conversationDetailsPage.clickOnSaveButton();
		//chatPage.participantCountGroupConv();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("joined this conversation"));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void addParticipantToAGroupConversation() throws InterruptedException {
		createGroupConversation();
		chatPage.clickOnTapToView();
		conversationDetailsPage.editParticipant();
		newConversationPage.actionSearchEditParticipants(Config.getInstance().getSecondWebUserDisPlayName());
		Utils.veryShortSleep();
		newConversationPage.saveButtonNewDetailPage();
		Utils.veryShortSleep();
		conversationDetailsPage.clickOnSaveButton();
		//chatPage.participantCountGroupConv();
		Assert.assertEquals(true, chatPage.placeholderForConversation.getText().contains("joined this conversation"));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}
	
	// Helper methods
	@NavigateTo(ConversationsPage.class)
	private String createConversation(boolean isGroup) {
		try {
			conversationsPage.clickOnNewConversationFab();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Utils.shortSleep();
		newConversationPage.selectUser(Config.getInstance().getWebUserDisplayName());
		if (isGroup) {
			newConversationPage.selectUser(Config.getInstance().getIosUserDisplayName());
		}
		String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss"+"a").format(new java.util.Date());
		conversationDetailsPage.enterConversationTitleWithParticipant(conversationTitle);
		conversationDetailsPage.clickOnCreateButton();
		Utils.veryShortSleep();
		//chatPage.participantCountGroupConv();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		return conversationTitle;
	}
	
	

	
	

	
	
	
	

}