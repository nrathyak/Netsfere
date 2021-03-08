
package com.infinite.netsfere.automationtool.modules.web.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebAttachmentFromDevicePage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebAttachmentPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebBroadcastLivePage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChannelsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebNavigationBar;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

public class WebChannelTestcases extends BaseTestCases {

	WebDriverWait webWait;
	WebDriver driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	WebChannelsPage channel;
	WebAttachmentFromDevicePage webAttachmentPage;
	WebNavigationBar webNavigation;
	WebChatPage chatPage;
	WebBroadcastLivePage broadcastPage;
	WebAttachmentPage webAttachment;
	WebConversationTestCases conv;
	
	
	private static Logger log = LogManager.getLogger(WebChannelTestcases.class.getName());

	@BeforeClass
	public void init() {
		driver = DriverManager.getWebDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		channel = new WebChannelsPage();
		webAttachmentPage = new WebAttachmentFromDevicePage();
		webNavigation = new WebNavigationBar();
		chatPage = new WebChatPage();
		broadcastPage = new WebBroadcastLivePage();
		webAttachment= new WebAttachmentPage();

	}

	@Test
	@NavigateTo(WebChannelsPage.class)
	public void searchAndSelectChannelAndCancel() throws Exception {
		//try {
			channel.searchForAndSelect(Config.getInstance().getChannelWeb());
			Assert.assertEquals(true, channel.channelTitle.getText().equals(Config.getInstance().getChannelWeb()));

			/*}
		
		catch (Exception e) {
			log.error("Unable to select a channel in web");
			Assert.assertFalse(true);
		}*/
	}

	@Test
	@NavigateTo(WebChannelsPage.class)
	public void sendQuickReply() {
		try {
			Utils.veryShortSleep();
			channel.searchForAndSelect(Config.getInstance().getChannelWeb());
			chatPage.clickQuickReply();
			String s1 = channel.messageSentStatusAssertion();
			Utils.shortSleep();
			Assert.assertEquals(s1, channel.messageStatusSent.getAttribute("title"));	

			// TODO:need to assert 
		} catch (Exception e) {
			log.error("Unable to send Quick reply from web channel");
			Assert.assertFalse(true);
		}
	}

	@Test
	@NavigateTo(WebChannelsPage.class)
	public void sendMessage() {
		searchAndSelectChannel();
//		try {
			Utils.veryShortSleep();
			chatPage.messageTextbox(Config.getInstance().getMessageFromChannel());
			chatPage.sendMessageButton();
			Utils.shortSleep();
			String s1 = channel.messageSentStatusAssertion();
//			Assert.assertEquals(s1, channel.messageStatusSent.getAttribute("title"));
			// TODO:need to assert
//		} catch (Exception e) {
//			log.error("Unable to send text message from web channel");
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebChannelsPage.class)
	public void sendPNGInChannel() throws FindFailed {
		searchAndSelectChannel();
//		try {
			Utils.veryShortSleep();
			webAttachment.sendAttachmentFromDevice("PNG", "png");
			mediumWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='close']")));
			String s1 = channel.messageSentStatusAssertion();
			Utils.shortSleep();
			Assert.assertEquals(s1, channel.messageStatusSent.getAttribute("title"));
			
//		} catch (Exception e) {
//			log.error("Unable to send PNG file from web channel");
//			Assert.assertFalse(true);
//		}

	}
	
	@Test
	@NavigateTo(WebChannelsPage.class)
	public void sendPDFInChannel() throws FindFailed {
		searchAndSelectChannel();
//		try {
			Utils.veryShortSleep();
			//chatPage.sendAttachmentButton();
			webAttachment.sendAttachmentFromDevice("PDFFile", "pdf");
			mediumWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='close']")));
			String s1 = channel.messageSentStatusAssertion();
			Utils.shortSleep();
			Assert.assertEquals(s1, channel.messageStatusSent.getAttribute("title"));
			
//		} catch (Exception e) {
//			log.error("Unable to send PDF file from web channel");
//			Assert.assertFalse(true);
//		}

	}
	
	
	
	
	@Test
	@NavigateTo(WebChannelsPage.class)
	public void sendLocationInChannel(){
		try{
		searchAndSelectChannel();
		webAttachmentPage.shareMyLocationLink();
		Assert.assertEquals(true, chatPage.sentButtonForLocation.isDisplayed());
		}
		catch(Exception e)
		{
			log.error("Unable to send location in channel");
			Assert.assertFalse(true);
		}
		
		
	}
	
	@Test
	@NavigateTo(WebChannelsPage.class)
	public void startBroadcastLive() throws InterruptedException {
		searchAndSelectChannel();
		Thread.sleep(2000);
		channel.clickOnMoreOptions();
		Thread.sleep(2000);
		chatPage.clickOnBroadcastLiveButton();
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(broadcastPage.liveLabelOnBroadcastLive));
		} catch (Exception e) {
			log.error("Timeout happen when waiting for LIVE button");
			Assert.fail();
		}
		Assert.assertEquals(true, broadcastPage.liveLabelOnBroadcastLive.isDisplayed());
	}

	@Test(dependsOnMethods = { "startBroadcastLive" })
	public void endBroadcastLive() {
		broadcastPage.clickOnEndBroadcastLiveButton();
		Utils.shortSleep();
		String placeHolderMessage = chatPage.getLastPlaceholderMessage();
//		Assert.assertEquals(placeHolderMessage,Config.getInstance().getWebUserDisplayName() + " " + Config.getInstance().getTextChannelPlaceholder());
		Assert.assertTrue(placeHolderMessage.contains("ended the NetSfere LIVE broadcast"));
	}

	@Test
	@NavigateTo(WebChannelsPage.class)
	public void unableToSendMessageInReadonlyChannelOnWeb() throws Exception {
		channel.searchForAndSelect(Config.getInstance().getChannelAndroid());
		Assert.assertEquals(true, chatPage.readOnlyAccessText.isDisplayed());

	}
	
	@Test
	@NavigateTo(WebChannelsPage.class)
	public void quickReplyAssertionChannel(){
		channel.recentChannel.click();
		Utils.shortSleep();
		Assert.assertEquals("Hello!", chatPage.quickReplyMessage.getText());
		driver.navigate().back();
		}

	@Test
	@NavigateTo(WebChannelsPage.class)
	public void webSendMessagesDuringLIVE() throws InterruptedException{
		searchAndSelectChannel();
		startBroadcastLive();
		chatPage.messageTextbox(Config.getInstance().getMessageFromChannel());
		chatPage.sendMessageButton();
		endBroadcastLive();
	}
	
	
	/*
	 * Helper methods
	 */
	
	public void searchAndSelectChannel() {
		try {
			channel.searchForAndSelect(Config.getInstance().getChannelWeb());
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		
		
	}

}
