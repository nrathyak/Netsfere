package com.infinite.netsfere.automationtool.modules.android.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.annotations.SingleInstance;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.BroadcastLivePage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChannelsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.GenericListPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChannelsPage;
import com.infinite.netsfere.automationtool.suits.BaseAndroidSuite;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class ChannelTestCase extends BaseTestCases {

	@SingleInstance
	public ChannelsPage channelPage;
	@SingleInstance
	public BroadcastLivePage broadcastLivePage;
	ConversationTestCases conv;
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	@SingleInstance
	public ChatPage chatPage;
	private static Logger log = LogManager.getLogger(ChannelTestCase.class.getName());
	@BeforeClass(alwaysRun = true)
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		conv = new ConversationTestCases();
		
	}

	@Test
	@NavigateTo(ChannelsPage.class)
	public void searchAndSelectChannelAndCancel() {
		try {
			channelPage.searchForAndSelect(Config.getInstance().getChannelAndroid());
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Assert.assertEquals(true, chatPage.chatPageTitle.getText().equals(Config.getInstance().getChannelAndroid()));
		Utils.navigateBack(driver);
		Utils.navigateBack(driver);
		Utils.navigateBack(driver);
	}


	@Test
	@NavigateTo(ChannelsPage.class)
	public void sendQuickReply() {
		searchAndSelectChannel();
		//try {
			chatPage.clickQuickReplyButton();
			String quickReplyMessage = chatPage.firstQuickReply.getText();
			chatPage.sendFirstQuickReplyMessage();
			chatPage.clickSendMessageButton();
			Utils.shortSleep();
//			validateTheLastMessage(quickReplyMessage);

		/*} catch (Exception e) {
			if (e instanceof org.openqa.selenium.TimeoutException) {
				log.error("Unable to find quickreply dialogue pop-up");
			}
			log.error("Unable to send Quick reply");
			Assert.fail();
		}*/
	}
	
	
	

	@Test
	@NavigateTo(ChannelsPage.class)
	public void sendMessage() {
		searchAndSelectChannel();
		try {
			String s = chatPage.sendTextMessage();
			validateTheLastMessage(s);
		} catch (Exception e) {
			log.error("Unable to send text message");
			Assert.fail(e.getMessage(), e);
		}
		Utils.navigateBack(driver);
		GenericListPage.clickOnCloseAndBackButton();
	}
	
	@Test
	@NavigateTo(ChannelsPage.class)
	public void sendLocationInChannel() {
		searchAndSelectChannel();
		try{
		chatPage.addLocationLink();
		Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		Utils.navigateToHomeScreen(driver);
		}
		catch(Exception e)
		{
			log.error("unable to send location in channel");
		}
		
		}

	@Test
	@NavigateTo(ChannelsPage.class)
	public void startBroadcastLive() throws InterruptedException {
		searchAndSelectChannel();
		chatPage.clickMoreMenu();
		chatPage.clickOnChannelLiveButton();
//		chatPage.clickBroadcastLiveButton();
		mediumWait.until(ExpectedConditions.visibilityOf(broadcastLivePage.liveLabelOnBroadcastLive));
		Assert.assertEquals(true, broadcastLivePage.liveLabelOnBroadcastLive.isDisplayed());
	}

	@Test(dependsOnMethods = { "startBroadcastLive" })
	public void endBroadcastLive() {
		Utils.shortSleep();
		broadcastLivePage.clickEndBroadcastLive();
		Utils.veryShortSleep();
		String placeHolderMessage = chatPage.getLastPlaceholderMessage();
//		Assert.assertEquals(placeHolderMessage, Config.getInstance().getAndroidUserDisplayName() + " "
//				+ Config.getInstance().getTextChannelPlaceholder());
		Assert.assertTrue(placeHolderMessage.contains("ended the NetSfere LIVE broadcast"));
		Utils.navigateBack(driver);
		GenericListPage.clickOnCloseAndBackButton();
//		Utils.navigateBack(driver);
//		Utils.navigateBack(driver);

	}
	@Test
	@NavigateTo(ChannelsPage.class)
	public void unableToSendMessageInReadOnlyChannel() throws Exception {
		channelPage.searchForAndSelect(Config.getInstance().getChannelWeb());
		Assert.assertEquals(true, chatPage.readOnlyAccessText.isDisplayed());
		Utils.navigateBack(driver);
		Utils.navigateBack(driver);
		Utils.navigateBack(driver);
		
		//Utils.navigateToHomeScreen(driver);
//		Utils.navigateBack(driver);
//		Utils.navigateBack(driver);

	}
	@Test
	@NavigateTo(WebChannelsPage.class)
	public void sendMessagesDuringLIVE() throws InterruptedException{
		searchAndSelectChannel();
		startBroadcastLive();
		sendMessage();
		endBroadcastLive();
	}

	// Helper Methods
	private void validateTheLastMessage(String message) {

		// Get last message from the list
		WebElement lastMessage = chatPage.getLastMessageView();
		// Wait until message status icon turns in to sent icon
//		chatPage.waitTillMessageSent(lastMessage);
		Utils.shortSleep();
		chatPage.isMessageSentIconPresent(lastMessage);
		// Get the last message content
		//String lastMessageContent = chatPage.getMessageContent(lastMessage);
		// Check both message content and message status are matching
		//Assert.assertTrue(message.equals(lastMessageContent) && chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		Assert.assertTrue(chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
	}

	// This method will make sure to be at Channels page
	public void makeSureToBeInChannelsPage() throws Exception {
		
		if (!channelPage.isAt()) {
			channelPage.navigateTo();
		}
	}
	
	public void makeSureToBeInChatPage() throws Exception {
		
		if (!chatPage.isAt()) {
			chatPage.navigateTo();
		}
	}
	
	public void makeSureToBeInBroadcastPage() throws Exception {
				if (!broadcastLivePage.isAt()) {
			broadcastLivePage.navigateTo();
		}
	}

	// This method will make sure to be at Channels page and searches for a
	// channel and selects
	public void searchAndSelectChannel() {
		try {
			channelPage.searchForAndSelect(Config.getInstance().getChannelAndroid());
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
	}

}
