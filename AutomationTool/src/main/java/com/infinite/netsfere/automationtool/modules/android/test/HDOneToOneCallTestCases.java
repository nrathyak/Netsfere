package com.infinite.netsfere.automationtool.modules.android.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.BottomNavigationBar;
import com.infinite.netsfere.automationtool.modules.android.pages.CallDetailsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.CallLogPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactDetailsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HDOneToOneCallTestCases extends BaseTestCases {

	ConversationsPage conversationsPage;
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	ConversationTestCases conv_page_android;
	ChatPage chatPage;
	HDOneToOneCallElements hdCallOneToOne;
	ContactsPage contactPage;
	ContactDetailsPage contactDetails;
	CallLogPage callLogPage;
	CallDetailsPage callDetailsPage;
	private static Logger log = LogManager.getLogger(HDOneToOneCallTestCases.class.getName());


	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		conversationsPage = new ConversationsPage();
		conv_page_android = new ConversationTestCases();
		conv_page_android.init();
		chatPage = new ChatPage();
		hdCallOneToOne = new HDOneToOneCallElements();
		contactPage = new ContactsPage();
		contactDetails = new ContactDetailsPage();
		callDetailsPage = new CallDetailsPage();
		callLogPage = new CallLogPage();
		
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void initiateOneToOneCallFromOneToOneConversation() throws Exception {
		conv_page_android.createConversationWithTitle();
		Utils.shortSleep();
		chatPage.clickOnCallButton();
		hdCallOneToOne.allowAccessToInitateCall();
		hdCallOneToOne.waitTillCallRings();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
	}

	@Test
	@NavigateTo(HDOneToOneCallElements.class)
	public void declineIncomingCall() {
		hdCallOneToOne.declineCall();
		Utils.shortSleep();
		log.info(driver.currentActivity());
		Assert.assertNotEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
		
	}

	@Test
	@NavigateTo(HDOneToOneCallElements.class)
	public void disconnectCall() {
		hdCallOneToOne.disconnectOngoingCall();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);
	}

	
	
	@Test
	@NavigateTo(ContactsPage.class)
	public void initiateCallFromContacts() throws Exception {
		try {
			BottomNavigationBar.getInstance().navigateToContactsPage();
			contactPage.searchForAndSelect(Config.getInstance().getWebUserDisplayName());
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		contactDetails.clickOnCallFromContactsButton();
		hdCallOneToOne.allowAccessToInitateCall();
		hdCallOneToOne.waitTillCallRings();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
		Utils.navigateBack(driver);
		Utils.veryShortSleep();
		Utils.navigateBack(driver);
		callLogPage.clickOnBackButton();
		
		
		
        
	}

	@Test
	@NavigateTo(CallLogPage.class)
	public void initiateCallFromCallLogs() {
		try {
			BottomNavigationBar.getInstance().navigateToCallLogsPage();
			callLogPage.clickOnNewCallButton();
			callLogPage.searchContactIncallLogsAndInitiateCall();
			hdCallOneToOne.allowAccessToInitateCall();
			hdCallOneToOne.waitTillCallRings();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
	}

	@Test
	@NavigateTo(HDOneToOneCallElements.class)
	public void endOngoingCall() {
		hdCallOneToOne.endOngoingCall();
		Utils.shortSleep();
		}
	
	
	
	
		
	@Test
	@NavigateTo(CallLogPage.class)
	public void deleteMultipleCallLogs() {
		try {
			BottomNavigationBar.getInstance().navigateToCallLogsPage();
			callLogPage.deleteMultipeCallLogs();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
	}

	@Test
	public void deleteAllCallLogs() {
		try {
//			BottomNavigationBar.getInstance().navigateToCallLogsPage();
			callLogPage.deleteAllCallLogs();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
		Assert.assertEquals(true, callLogPage.noCalls.getText().equals("No Calls"));
	}

	@Test
	public void receivedMissedCallNotification() throws InterruptedException {
		callLogPage.openNotificationsInAndroidAndValidateMissedCall();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);

	}

	@Test
	public void receivesIncomingHDCall() {
		Utils.shortSleep();
		driver.openNotifications();
		Utils.veryShortSleep();
		hdCallOneToOne.incomingAudioCallNotification();
		try {
		    
			mediumWait.until(ExpectedConditions.visibilityOf(hdCallOneToOne.incomingCall));
	
			Assert.assertEquals(true, hdCallOneToOne.incomingCall.getText().contains("Incoming Audio Call…"));
	}catch(Exception e) {
		log.error("Call UI not found");
	}
	}
	

	@Test
	public void callEnded() {
		Assert.assertNotEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
		Utils.navigateBack(driver);
		//Utils.navigateBack(driver);
	
		callLogPage.clickOnBackButton();
		
		try {
			BottomNavigationBar.getInstance().navigateToConversationsPage();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
	}

	@Test
	@NavigateTo(ConversationsPage.class)
	public void netsfereUserMakesHDCallToGuest() throws Exception {
		conv_page_android.androidNetsfereUserCreateConvWithActivatedGuestUser();
		Utils.shortSleep();
		chatPage.clickOnCallButton();
		hdCallOneToOne.allowAccessToInitateCall();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);

	}

	@Test
	public void guestUserMakesHDCallToNetsfereUser() {
		conv_page_android.androidGuestUserCreateConvWithNetsfereUsere();
		Utils.shortSleep();
		chatPage.clickOnCallButton();
		hdCallOneToOne.allowAccessToInitateCall();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
	}

	@Test
	public void acceptIncomingCall() {
		hdCallOneToOne.receiveCall();
		Assert.assertEquals(true, hdCallOneToOne.inCall.getText().equals("In Call"));

	}
	
	@Test
	public void incomingHDCallAssertion() {
		Assert.assertEquals(true ,hdCallOneToOne.incomingCall.getText().contains("Incoming Audio Call…"));
	}

	@Test
	public void clearAllAndroidNotifications() {
		callLogPage.clearALlNotification();
	}
	
	@Test
	@NavigateTo(CallLogPage.class)
	public void initiateOneToOneCallFromExistingCallLogs() throws Exception {
		callLogPage.searchFor(Config.getInstance().getWebUserDisplayName());
		Utils.shortSleep();
		callLogPage.clickOnFirstCallButtonInTheList();
		hdCallOneToOne.waitTillCallRings();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
	}
	
	@Test
	public void sendMessageDuringTheCall() throws Exception {
		
//		chatPage.clickOnCallButton();
		hdCallOneToOne.clickOnMessageButtonWhileOnCall();
		Utils.veryShortSleep();
		//Assert.assertEquals(true, hdCallOneToOne.returnToCall.getText().contains("Tap to return to call"));
		chatPage.clickQuickReplyButton();
		chatPage.sendFirstQuickReplyMessage();
		chatPage.clickSendMessageButton();
		Utils.veryShortSleep();
		Assert.assertEquals(true, chatPage.isMessageSentIconPresent(chatPage.messageSentIcon));
		driver.navigate().back();
		chatPage.clickTapToReturnToCall();
	
	}
	
	
	
	@Test
	@NavigateTo(CallLogPage.class)
	public void searchMissedCallLogFromMissedCallTab() throws Exception {
		callLogPage.clickOnMissedCallTab();
		callLogPage.checkIfNoCallLogsPresentAndSearchForContact(Config.getInstance().getWebUserDisplayName());
		//callLogPage.clickOnFirstMissedCall();
		Assert.assertEquals(true, callDetailsPage.callDetailsPage.getText().contains("Call Details"));
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		BottomNavigationBar.getInstance().navigateToConversationsPage();
	}
}
