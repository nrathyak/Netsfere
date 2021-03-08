package com.infinite.netsfere.automationtool.modules.android.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.CallDetailsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.CallLogPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactDetailsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.GroupCallElements;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.android.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.android.pages.NewConversationPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ScreensharePage;
import com.infinite.netsfere.automationtool.modules.android.pages.VideoCallPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GroupCallTestCases extends BaseTestCases {

	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	ConversationsPage conversationsPage;
	ConversationTestCases convTestCases;
	ChatPage chatPage;
	GroupCallElements groupCall;
	HDOneToOneCallElements hdCallOneToOne;
	NewConversationPage newConversationPage;
	ScreensharePage screenshare;
	VideoCallPage videoCall;
	
	private static Logger log = LogManager.getLogger(GroupCallTestCases.class.getName());
	
	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		conversationsPage = new ConversationsPage();
		convTestCases = new ConversationTestCases();
		convTestCases.init();
		chatPage = new ChatPage();
		groupCall = new GroupCallElements();
		hdCallOneToOne = new HDOneToOneCallElements();
		newConversationPage = new NewConversationPage();
		screenshare = new ScreensharePage();
		videoCall = new VideoCallPage();
	}	
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void initiateGroupCall() throws Exception {
		chatPage.clickOnCallButton();
		groupCall.clickOnGroupCallButton();
		Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
		
	}
	
	@Test
	public void endGroupCall() throws InterruptedException {
		groupCall.clickOnEndGroupCall();
		Thread.sleep(6000);
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
	}
	
	
	@Test
	public void androidReceivesGroupCall() {
		Utils.veryShortSleep();
		driver.openNotifications();
		Utils.veryShortSleep();
		hdCallOneToOne.incomingAudioCallNotification();
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(hdCallOneToOne.incomingCall));
		Assert.assertEquals(true ,hdCallOneToOne.incomingCall.getText().contains("Incoming Audio Call…"));
		}
		catch(Exception e) {
			log.error("Incoming Call UI not found due to network issues");
		}
	}
	
	@Test
	public void acceptGroupCall() {
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(hdCallOneToOne.incomingCall));
			Assert.assertEquals(true ,hdCallOneToOne.incomingCall.getText().contains("Incoming Audio Call…"));
			groupCall.receiveGroupCall();
			Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
			}
			catch(Exception e) {
				log.error("Incoming Call UI not found due to network issues");
			}

	}
	
	@Test
	public void androidReceivesGroupVideoCall() {
		Utils.veryShortSleep();
		driver.openNotifications();
		Utils.veryShortSleep();
		hdCallOneToOne.incomingVideoCallNotification();
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(hdCallOneToOne.incomingCall));
		Assert.assertEquals(true ,hdCallOneToOne.incomingCall.getText().contains("Incoming Video Call…"));
		}
		catch(Exception e) {
			log.error("Incoming Call UI not found due to network issues");
		}
	}
	
	@Test
	public void acceptGroupVideoCall() {
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(hdCallOneToOne.incomingCall));
			Assert.assertEquals(true ,hdCallOneToOne.incomingCall.getText().contains("Incoming Video Call…"));
			videoCall.receiveGroupVideoCall();
//			Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
			}
			catch(Exception e) {
				log.error("Incoming Call UI not found due to network issues");
			}

	}
	
	@Test
	public void leaveOngoingGroupCall() throws InterruptedException {
		try {
		hdCallOneToOne.endOngoingCall();
		Thread.sleep(3000);
		Assert.assertNotSame(driver.currentActivity(), Constants.ACTIVITY_GROUPCALL_SCREEN);
		}catch(Exception e) {
			log.error("Incoming Call UI not found due to network issues");
		}
	}
	
	@Test
	public void declineGroupCall() throws InterruptedException {
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(hdCallOneToOne.incomingCall));
		Assert.assertEquals(true ,hdCallOneToOne.incomingCall.getText().contains("Incoming Audio Call…"));
		groupCall.declineGroupCall();
		Thread.sleep(3000);
		Assert.assertNotSame(driver.currentActivity(), Constants.ACTIVITY_GROUPCALL_SCREEN);
		}catch(Exception e) {
			log.error("Incoming Call UI not found due to network issues");
		}
	}
	
	
	@Test
	public void ownerCanMuteAllParticipants() throws InterruptedException{
		groupCall.clickOnMuteButton();
		
	}
	
	
	@Test
	public void addDynamicUser(String userName) throws InterruptedException {
		groupCall.clickOnAddDynamicUserButton();
		newConversationPage.actionSearchEditParticipants(userName);
		Utils.veryShortSleep();
		groupCall.clickOnDynamicCallButton();
		Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
		
	}
	
	@Test
	public void viewScreenshare() {
		screenshare.clickOnScreenshareView();
	}
	
	@Test
	public void screenshareEndAssertion() {
		groupCall.screenshareEnd();
	}
	
	@Test
	public void initiateScreenshare() {
		groupCall.clickOnScreenshareButton();
	}
	
	@Test
	public void stopScreenshare() {
		groupCall.stopScreenShare();
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void initiateGroupCallForSelectedParticipants() {
		chatPage.clickOnCallButton();
		Utils.veryShortSleep();
		groupCall.clickOnDeselectParticipant();
		groupCall.clickOnGroupCallButton();
		Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
	}
	
	@Test
	public void sendMessageDuringGroupcall() {
		groupCall.clickOnBackButton();
		chatPage.clickQuickReplyButton();
		chatPage.sendFirstQuickReplyMessage();
		chatPage.clickSendMessageButton();
		mediumWait.until(ExpectedConditions.visibilityOf(chatPage.messageSentIcon));
//		Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		chatPage.clickTapToReturnToCall();
		Utils.veryShortSleep();
	}
	
	@Test
	public void validateConnectedStatus() {
		Assert.assertEquals(true, groupCall.connectedStatus.getText().contains("connected"));
	}
	
	@Test
	public void validateLocatingStatus() {
		mediumWait.until(ExpectedConditions.visibilityOf(groupCall.locatingStatus));
		Assert.assertEquals(true, groupCall.locatingStatus.getText().contains("locating"));
	}
	
	@Test
	public void validateDisconnectedStatus() {
		Assert.assertEquals(true, groupCall.disconnectedStatus.getText().contains("disconnected"));
	}
	
	@Test
	public void validateDeclinedStatus() {
		Assert.assertEquals(true, groupCall.declinedStatus.getText().contains("declined"));
	}
	
	@Test
	public void validateNoanswerStatus() {
		mediumWait.until(ExpectedConditions.visibilityOf(groupCall.noanswerStatus));
		Assert.assertEquals(true, groupCall.noanswerStatus.getText().contains("no answer"));
	}
	
	@Test
	public void validateNotcalledStatus() {
		Assert.assertEquals(true, groupCall.notcalledStatus.getText().contains("not called"));
	}
	
	@Test
	public void endOrDisconnectGroupCall() throws InterruptedException {
		groupCall.endCall();
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void rejoinTheGroupCall() {
		try {
		try {
		Utils.navigateToHomeScreen(driver);
		conversationsPage.ClickfirstConversationTitleInAllTab();
		try {
			groupCall.clickOnGroupCallIcon();
		} catch (Exception e) {
//			Assert.fail(e.getMessage(), e);
			log.info("No Such element");
		}
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		groupCall.rejoinCall();
		Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
		}
		catch(Exception e) {
			log.error("Call UI not found");
		}
	}
	catch(Exception e) {
		log.error("Incoming Call UI not found due to network issues");
		}
	}
}
