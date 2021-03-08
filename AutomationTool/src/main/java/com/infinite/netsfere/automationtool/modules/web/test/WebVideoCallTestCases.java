package com.infinite.netsfere.automationtool.modules.web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebGroupCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebHdOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebVideoCallPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

public class WebVideoCallTestCases {
	
	WebDriver driver ;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	WebGroupCallElements groupCall;
	WebConversationTestCases webConvTestCases;
	WebConversationsPage webconv;
	WebHdOneToOneCallElements hdOneToOneCall;
	WebDriver secondDriver;
	WebChatPage webChatPage;
	WebVideoCallPage videoCall;
	
	
	@BeforeClass
	public void init() {
		driver = DriverManager.getWebDriver();
		secondDriver = DriverManager.getSecondWebDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		groupCall= new WebGroupCallElements();
		webConvTestCases = new WebConversationTestCases();
		webConvTestCases.init();
		webconv = new WebConversationsPage();
		hdOneToOneCall = new WebHdOneToOneCallElements();
		webChatPage = new WebChatPage();
		videoCall = new WebVideoCallPage();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void initiateVideoCall() {
		webChatPage.clickOnVideoCallButton();
		videoCall.clickOnPlaceVideoCall();
		videoCall.waitForVideoScreen();
		
	}
	
	@Test
	public void endVideoCall() {
		videoCall.clickOnEndVideoCallButton();
		Utils.veryShortSleep();
		String placeHolderMessage = webChatPage.getLastPlaceholderMessage();
//		Assert.assertEquals(placeHolderMessage,Config.getInstance().getWebUserDisplayName() + " " +"has ended a video call");
		Assert.assertTrue(placeHolderMessage.contains("has ended a video"));
	}
	
	@Test
	public void acceptVideoCall() {
		videoCall.waitForVideoCallUI();
		hdOneToOneCall.acceptIncomingCall();
		videoCall.waitForVideoScreen();
		Utils.veryShortSleep();
	}
	
	@Test
	public void initiateOneToOneVideoCall(){
		webChatPage.clickOnVideoCallButton();
		videoCall.waitForVideoScreen();
	}
	
	@Test
	public void endOneToOneVideoCall() {
		videoCall.endOneToOneVideoCall();
		Utils.veryShortSleep();
		String placeHolderMessage = webChatPage.getLastPlaceholderMessage();
//		Assert.assertEquals(placeHolderMessage,Config.getInstance().getWebUserDisplayName() + " " +"has ended a video call");
		Assert.assertTrue(placeHolderMessage.contains("has ended a video"));
	}
	

}
