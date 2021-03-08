package com.infinite.netsfere.automationtool.modules.web.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.android.pages.BottomNavigationBar;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebCallLogsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebContactsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebHdOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebNavigationBar;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.modules.web.test.WebConversationTestCases;

public class WebHDOneToOneCallTestCases {

	WebConversationsPage webconv; 
	WebDriverWait webWait;
	WebDriver driver ;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	WebConversationTestCases webConvTestCases;
	WebHdOneToOneCallElements hdOneToOneCall;
	WebContactsPage contactsPage;
	WebCallLogsPage callLogsPage;
	WebNavigationBar webNavigationBar;
	WebChatPage webChatPage;
	WebDriver secondDriver;
	 private static Logger log = LogManager.getLogger(WebHDOneToOneCallTestCases.class.getName());
	
	@BeforeClass
	public void init(){
		driver = DriverManager.getWebDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		webconv = new WebConversationsPage();
		webConvTestCases = new WebConversationTestCases();
		webConvTestCases.init();
		hdOneToOneCall = new WebHdOneToOneCallElements();
		contactsPage = new WebContactsPage();
		callLogsPage = new WebCallLogsPage();
		webNavigationBar = new WebNavigationBar();
		webChatPage = new WebChatPage();
	}
	
	@Test
	public void initiateOneToOneCallFromOneToOneConversationWeb() throws InterruptedException {
		try{
			webConvTestCases.createConversationWebWithTitle();
			log.debug("");
			webChatPage.clickOnCallButton();
			hdOneToOneCall.waitUntilCallRings();
			Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
		}
		catch(Exception e){
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void endOngoingCallWeb() {
		try{
			hdOneToOneCall.endOngoingCall();
			Utils.shortSleep();
		}
		catch(Exception e){
			Assert.assertFalse(true);
		}

	}
	
	@Test
	public void acceptIncomingCallWeb() throws InterruptedException {
		mediumWait.until(ExpectedConditions.visibilityOf(hdOneToOneCall.incomingCall));
		hdOneToOneCall.acceptIncomingCall();
		Thread.sleep(4000);
		Assert.assertEquals(true, hdOneToOneCall.inCall.getText().contains("In call"));
	}
	
	@Test
	public void acceptOneToOneCallFromSecondUser() {
		secondDriver= DriverManager.getSecondWebDriver();
		hdOneToOneCall.acceptOneToOneCallFromSecondUser(secondDriver);
		Assert.assertEquals(true, secondDriver.findElement(By.xpath("//span[contains(text(),'In call')]")).getText().contains("In call"));
	}
	
	@Test
	public void rejectIncomingOneToOneCallFromSecondUser() {
		secondDriver= DriverManager.getSecondWebDriver();
		hdOneToOneCall.rejectOneToOneCallFromSecondUser(secondDriver);
		Utils.veryShortSleep();
	}
	
	@Test
	public void declineIncomingCall() {
		Utils.veryShortSleep();
		hdOneToOneCall.declineIncomingCall();
		
	}
	
	@Test
	public void receivesIncomingCall() throws InterruptedException {
		mediumWait.until(ExpectedConditions.visibilityOf(hdOneToOneCall.incomingCall));
		Assert.assertEquals(true, hdOneToOneCall.incomingCall.getText().contains("Incoming call..."));
	}
	
	@Test
	public void initiateCallFromContacts() throws Exception {
		try {
		Utils.veryShortSleep();
		webNavigationBar.navigateToContactsage();
		contactsPage.searchForAndSelect(Config.getInstance().getAndroidUserDisplayName());
		contactsPage.callFromContact();
		Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
		}catch(Exception e) {
			log.error("Unable to initiate Call");
			Assert.fail();
		}
	}
	
	@Test
	public void initiateCallFromCallLogs() throws InterruptedException {
		try {
		webNavigationBar.navigateToCallLogsPage();
		callLogsPage.clickOnMakeCallButton();
		callLogsPage.selectContactFromCallLogsAndClick();
		//added
		hdOneToOneCall.waitUntilCallRings();
		Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
		}catch(Exception e) {
			Assert.assertNotEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
		}
	}
	
	@Test
	public void endUnansweredCall() throws InterruptedException {
		hdOneToOneCall.endCall();
		Utils.shortSleep();
		webNavigationBar.navigateToConversationsPage();
	}
	
	@Test
	public void deleteMultipleCallLogs() throws InterruptedException {
		webNavigationBar.navigateToCallLogsPage();
		callLogsPage.clickOnMoreOptions();
		callLogsPage.clickOnDeleteAllOption();
//		callLogsPage.checkIfCallLogsPresent();
		callLogsPage.deleteMultipleCallLogs();	
	}
	
	@Test
	public void deleteAllCallLogs() throws InterruptedException {
		webNavigationBar.navigateToCallLogsPage();
		callLogsPage.clickOnMoreOptions();
		callLogsPage.clickOnDeleteAllOption();
		callLogsPage.deleteAllCallLogs();
		Thread.sleep(2000);
		Assert.assertEquals(true, callLogsPage.noCallHistory.getText().equals("No Call History"));
	}
	
	@Test
	public void netsfereUserMakesHDCallGuestUser() throws InterruptedException{
		webConvTestCases.netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
		webChatPage.clickOnCallButton();
		hdOneToOneCall.waitUntilCallRings();
		Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
	}
	
	@Test
	public void guestUserMakesHDCallNetsfereUser() throws InterruptedException{
		webConvTestCases.guestUserCreateConversationWithNetsfereUser();
		webChatPage.clickOnCallButton();
		hdOneToOneCall.waitUntilCallRings();
		Utils.shortSleep();
		Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
	}
	
	@Test
	@NavigateTo(WebCallLogsPage.class)
	public void initiateCallFromExistingCallLogs() throws Exception {
		callLogsPage.searchForAndSelect(Config.getInstance().getAndroidUserDisplayName());
		callLogsPage.clickOnFirstCallLogButton();
		hdOneToOneCall.waitUntilCallRings();
		Utils.shortSleep();
		
		Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendMessageDuringTheCall() throws InterruptedException {
		
		hdOneToOneCall.clickOnUpArrowDuringCall();
		webChatPage.clickQuickReply();
		Assert.assertEquals(Config.getInstance().getKeyMessageSentStatus(), webChatPage.sentMark.getAttribute("title"));
		hdOneToOneCall.clickOnDownArrowDuringCall();
		
	}
	
	@Test
	@NavigateTo(WebCallLogsPage.class)
	public void searchMissedCallFromMissedCallTab() throws Exception {
		callLogsPage.clickOnMissedCallTab();
		callLogsPage.enterContactInMissedCallSearchTab(Config.getInstance().getAndroidUserDisplayName());
		Assert.assertEquals(true, callLogsPage.missedCall.getText().contains("Missed Call"));
		webNavigationBar.navigateToConversationsPage();
		
	}
	
	@Test
	public void incomingCallWebAssertion() throws InterruptedException {
		Utils.shortSleep();
		Assert.assertEquals(true, hdOneToOneCall.incomingcall.getText().equals("Incoming call..."));
	}
	
	@Test
	public void inCallWebAssertion() {
		Utils.shortSleep();
		Assert.assertEquals(true, hdOneToOneCall.inCall.getText().contains("In call"));
	}
	
	@Test
	public void declinedCallAssertion() throws InterruptedException  {
		webNavigationBar.navigateToCallLogsPage();
		Thread.sleep(2000);
		Assert.assertEquals(true, callLogsPage.declinedCall.getText().equals("Declined Call"));
	}
	
	@Test
	public void deleteCallLogsAssertion() {
		Assert.assertEquals(true, callLogsPage.noCallHistory.getText().equals("No Call History"));
	}
	
	@Test
	public void muteCall() throws Exception {		
		hdOneToOneCall.muteCall();
		Assert.assertEquals(true, hdOneToOneCall.callMuteTitle.getText().contains("Call Muted"));
	}
	@Test(dependsOnMethods = { "muteCall" })
	public void unMuteCall() throws Exception {
		hdOneToOneCall.unMuteCall();
		Assert.assertTrue(hdOneToOneCall.muteButton.isDisplayed());
	}
	@Test
	public void toggleSpeaker()
	{
		hdOneToOneCall.volumeOnDuringCall();
		Assert.assertTrue(hdOneToOneCall.volumeOffButton.isDisplayed());
		hdOneToOneCall.volumeOffDuringCall();
		Assert.assertTrue(hdOneToOneCall.volumeOnButton.isDisplayed());
		
	}
	
	
}
