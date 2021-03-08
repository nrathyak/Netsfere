package com.infinite.netsfere.automationtool.modules.android.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.GroupCallElements;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.android.pages.NewConversationPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ScreensharePage;
import com.infinite.netsfere.automationtool.modules.android.pages.VideoCallPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VideoCallTestCases {

	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	ChatPage chatPage;
	GroupCallElements groupCall;
	VideoCallPage videoCall;
	
	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		chatPage = new ChatPage();
		groupCall = new GroupCallElements();
		videoCall = new VideoCallPage();
	}
	
	@Test
	public void initiateVideoCall() {
		chatPage.clickOnVideoCallButton();
		videoCall.clickOnVideoCallButton();
		videoCall.viewVideoCallScreen();
	}
	
	@Test
	public void endVideoCall() {
		videoCall.endVideoCall();
		groupCall.clickOnEndGroupCall();
		Utils.veryShortSleep();
		String placeHolderMessage = chatPage.getLastPlaceholderMessage();
//		Assert.assertEquals(placeHolderMessage, Config.getInstance().getAndroidUserDisplayName() + " "
//				+"has ended a video call");
		Assert.assertTrue(placeHolderMessage.contains("has ended a video"));
	}
	
	@Test
	public void initiateOneToOneVideoCall() {
		chatPage.clickOnVideoCallButton();
		videoCall.viewVideoCallScreen();
	}
	
	@Test
	public void endOneToOneVideoCall() {
		videoCall.endVideoCall();
		groupCall.clickOnEndGroupVideoCall();
		Utils.veryShortSleep();
		String placeHolderMessage = chatPage.getLastPlaceholderMessage();
//		Assert.assertEquals(placeHolderMessage, Config.getInstance().getAndroidUserDisplayName() + " "
//				+"has ended a video call");
		Assert.assertTrue(placeHolderMessage.contains("has ended a video"));
	}
	
}
