package com.infinite.netsfere.automationtool.modules.ios.test;


import java.io.IOException;
//import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.ios.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.ios.pages.NewConversationPage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.modules.ios.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.ios.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.ios.pages.LoginPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class ConversationTestCases {
	
	ConversationsPage conversationsPage;
	NewConversationPage newConversationPage;
	ChatPage chatPage;
	IOSDriver<IOSElement> IosDriver;
	WebDriverWait veryShortWait;
	WebDriverWait shortWait;
	WebDriverWait mediumWait;
	WebDriverWait longWait;
	TouchAction act;
	
	private static Logger log = LogManager.getLogger(ConversationTestCases.class.getName());


	@BeforeClass
	public void init() throws InterruptedException, IOException {		
		conversationsPage = new ConversationsPage();
		newConversationPage = new NewConversationPage();
		chatPage = new ChatPage();
		IosDriver = DriverManager.getIOSDriver();
		veryShortWait = Utils.getVeryShortWait(IosDriver);
		shortWait = Utils.getShortWait(IosDriver);
		mediumWait = Utils.getMediumWait(IosDriver);
		longWait = Utils.getLongWait(IosDriver);
		act = new TouchAction(IosDriver);
		
	}

	@Test
	public void scrollDownConversationList() {
		Utils.scrolldown(IosDriver);		
		// Need to rethink how to assert?.
	}
	
	@Test
	public void searchConversation(String searchString) {
		Utils.scrolldown(IosDriver);		
		try {
			Assert.assertEquals(conversationsPage.getConversationsSearchBar().isEnabled(), true);
			conversationsPage.fillTextConversationsSearchBar(searchString);
		} catch (NoSuchElementException e) {
			Assert.fail("ERROR :  Unbale to Find Conversation Search feild ");
			log.error("ERROR :  Unbale to Find Conversation Search feild ");
		}
	}
	
	@Test	
	public WebElement getNetcConversation() {	
		
		if(conversationsPage.ConversationList.isEmpty()) {
			return null;
		} else {
			return conversationsPage.ConversationList.get(0);
		}
	}
	@Test
	public WebElement getFirstConversation() {		
		if(conversationsPage.ConversationList.isEmpty()) {
			return null;
		} else {
			return conversationsPage.ConversationList.get(1);
		}
	}
	@Test
	public WebElement getSecondConversation() {
		
		if(conversationsPage.ConversationList.isEmpty()) {
			return null;
		} else {
			return conversationsPage.ConversationList.get(2);
		}

	}
	@Test
	public WebElement getThirdConversation() {		
		if(conversationsPage.ConversationList.isEmpty()) {
			return null;
		} else {
			return conversationsPage.ConversationList.get(3);
		}

	}
	@Test
	public WebElement getLastConversation() {		
		if(conversationsPage.ConversationList.isEmpty()) {
			return null;
		} else {
			return conversationsPage.ConversationList.get(conversationsPage.ConversationList.size()-1);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void gotoNetc() {
		getNetcConversation().click();
	}
	
		
	@Test
	public void gotoFirstConversation() {
		getFirstConversation().click();
	}
	
	
	@Test
	public void cancelConversationSearch() {
		conversationsPage.cancelConversationSearch();
	}
	
	@Test
	public void clearConversationSearchText() {
		conversationsPage.clearConversationSearchText();
	}
	
	@Test
	public void createnewSelfConversation() throws Exception {
		createConversation(null);
	}
	
	@Test	
	public void createnewConversationWithParticipants() throws Exception {
		String participants[] = new String[3];
		participants[0] = Config.getInstance().getAndroidUserDisplayName();
		participants[1] = Config.getInstance().getWebUserDisplayName();
		participants[2] = Config.getInstance().getSecondWebUserDisPlayName();		
			createConversation(participants);		
	}
	
	private void createConversation(String[] userNames) throws Exception {
		conversationsPage.clickNewConversationButton();
		Utils.shortSleep();
		if (userNames != null) {
			for (String userName : userNames) {
				newConversationPage.selectParticipant(userName);
			}
		}
		newConversationPage.clickOnCreateButton();
	}
	
	@Test
	public void sendMessage() {
		chatPage.sendChatMessage("Hello from IOS Device");		
	}
	
	@Test 
	public void chatDetails() {
		chatPage.editconversationTitleTextButton.click();
	}
	
	
		
}