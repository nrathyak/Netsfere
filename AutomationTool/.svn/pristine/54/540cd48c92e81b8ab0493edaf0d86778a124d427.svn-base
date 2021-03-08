package com.infinite.netsfere.automationtool.modules.android.test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.BottomNavigationBar;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.GroupCallElements;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.android.pages.MeetingPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebMeetingPage;
import com.infinite.netsfere.automationtool.utils.AndroidIoOperations;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MeetingTestCases extends BaseTestCases {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait longWait;
	MeetingPage meet;
	ConversationTestCases conv;
	ChatPage chatPage;
	BottomNavigationBar bottomNavigator;
	HDOneToOneCallElements hdCallOneToOne;
	GroupCallElements groupCall;
	WebDriverWait androidWait;

	@BeforeClass
	public void init() {
		meet = new MeetingPage();
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		longWait = Utils.getLongWait(driver);
		conv = new ConversationTestCases();
		conv.init();
		chatPage = new ChatPage();
		bottomNavigator = BottomNavigationBar.getInstance();
		hdCallOneToOne = new HDOneToOneCallElements();
		androidWait = Utils.getLongWait(driver);
		groupCall = new GroupCallElements();
	}
	
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void createMeetingForLiveFromConversationPage(){
		//try{
			conv.createConversationWithoutTitle();
			chatPage.clickMoreMenu();
			chatPage.clickOnScheduleMeeting();
			meet.createMeetingAfterSelectContact();
			Utils.veryShortSleep();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MEETING_DETAILS_SCREEN);
//			Utils.navigateBack(driver);
//			Utils.navigateBack(driver);
			Utils.navigateToHomeScreen(driver);
			
		/*}
		catch (Exception e) {
			Assert.fail("Unable to create meeting from conversation page");
		}*/
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void createMeetingForHDCallFromConversationPage(){
		try{
			conv.createConversationWithoutTitle();
			chatPage.clickMoreMenu();
			chatPage.clickOnScheduleMeeting();
			meet.clickService();
			meet.serviceSelect(1);
			meet.createMeetingAfterSelectContact();
		}
		catch (Exception e) {
			Assert.fail("Unable to create meeting from conversation page");
		}
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void createMeetingForHDGroupCallFromConversationPage(){
		try{
			conv.createGroupConversation();
			chatPage.clickMoreMenu();
			chatPage.clickOnScheduleMeeting();
			meet.clickService();
			meet.serviceSelect(2);
			meet.createMeetingAfterSelectContact();
		}
		catch (Exception e) {
			Assert.fail("Unable to create meeting from conversation page");
		}
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void createMeetingForOthersFromConversationPage(){
		try{
			conv.createConversationWithoutTitle();
			chatPage.clickMoreMenu();
			chatPage.clickOnScheduleMeeting();
			meet.clickService();
			meet.serviceSelect(3);
			meet.createMeetingAfterSelectContact();
		}
		catch (Exception e) {
			Assert.fail("Unable to create meeting from conversation page");
		}
	}
	@Test
	@NavigateTo(MeetingPage.class)
	public void createMeetingForLiveFromMeetingPage() throws Exception{
		try{
//			meet.clickMeetingPageIcon();
			bottomNavigator.navigateToMeetingsPage();
			meet.clickNewMeetingFab();
//			AndroidIoOperations.hideKeyboard();
			meet.clickAddConctactIcon();
			meet.searchSelectContactForMeeting(Config.getInstance().getWebUserDisplayName());
			meet.saveMeetingAfterSelectContact();
			meet.editMeetingTitle(Config.getInstance().getMeetingTitle());
			meet.editMeetingDescription(Config.getInstance().getMeetingDescription());
			meet.clickService();
			meet.serviceSelect(0);
			meet.createMeetingAfterSelectContact();
			Utils.veryShortSleep();
			
		}
		catch (Exception e) {
			Assert.fail("Unable to create live meeting from meeting page");
		}
		
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void createMeetingForHDCallFromMeetingPage(){
		try{
			meet.clickMeetingPageIcon();
			meet.clickNewMeetingFab();
			meet.editMeetingTitle(Config.getInstance().getMeetingTitle());
			meet.editMeetingDescription(Config.getInstance().getMeetingDescription());
			meet.clickService();
			meet.serviceSelect(1);
			meet.editMeetingLocation(Config.getInstance().getMeetingLocation());
			meet.clickAddConctactIcon();
			meet.searchSelectContactForMeeting(Config.getInstance().getWebUserDisplayName());
			meet.saveMeetingAfterSelectContact();
			meet.createMeetingAfterSelectContact();
		}
		catch (Exception e) {
			Assert.fail("Unable to create HD call meeting from meeting page");
		}
		
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void createMeetingForHDGroupCallFromMeetingPage(){
		try{
			meet.clickMeetingPageIcon();
			meet.clickNewMeetingFab();
			meet.editMeetingTitle(Config.getInstance().getMeetingTitle());
			meet.editMeetingDescription(Config.getInstance().getMeetingDescription());
			meet.clickService();
			meet.serviceSelect(2);
			meet.editMeetingLocation(Config.getInstance().getMeetingLocation());
			meet.clickAddConctactIcon();
			meet.searchSelectContactForMeeting(Config.getInstance().getWebUserDisplayName());
			Utils.veryShortSleep();
			meet.searchSelectContactForMeeting(Config.getInstance().getIosUserDisplayName());
			meet.saveMeetingAfterSelectContact();
			meet.createMeetingAfterSelectContact();
		}
		catch (Exception e) {
			Assert.fail("Unable to create group call meeting from meeting page");
		}
		
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void createMeetingForOthersFromMeetingPage(){
		try{
			meet.clickMeetingPageIcon();
			meet.clickNewMeetingFab();
			meet.editMeetingTitle(Config.getInstance().getMeetingTitle());
			meet.editMeetingDescription(Config.getInstance().getMeetingDescription());
			meet.clickService();
			meet.serviceSelect(3);
			meet.editMeetingLocation(Config.getInstance().getMeetingLocation());
			meet.clickAddConctactIcon();
			meet.searchSelectContactForMeeting(Config.getInstance().getWebUserDisplayName());
			meet.saveMeetingAfterSelectContact();
			meet.createMeetingAfterSelectContact();
			Utils.navigateBack(driver);
		}
		catch (Exception e) {
			Assert.fail("Unable to create other meeting from meeting page");
		}
		
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void createDefaultTitleLiveMeeting(){
		try{
			meet.clickNewMeetingFab();
			meet.clickAddConctactIcon();
			meet.searchSelectContactForMeeting(Config.getInstance().getWebUserDisplayName());
			meet.saveMeetingAfterSelectContact();
			meet.clickService();
			meet.serviceSelect(0);
			meet.createMeetingAfterSelectContact();
			Utils.navigateBack(driver);
		}
		catch (Exception e) {
			Assert.fail("Unable to create default title live meeting from meeting page");
		}
		
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void startMeeting() throws Exception{
		try{
			createMeetingForLiveFromMeetingPage();
			meet.startMeeting();
			androidWait.until(ExpectedConditions.visibilityOf(meet.stopLiveMeetingButton));
			Assert.assertEquals(Config.getInstance().getLiveMeetingBadge(), meet.liveMeetingBadge.getText());
			Utils.veryShortSleep();
		}
		catch (Exception e) {
			Assert.fail("Unable to start meeting");
		}
	}
	
	@Test(dependsOnMethods={"startMeeting"})
	public void stopMeeting(){
			meet.stopLiveMeeting();
			Utils.veryShortSleep();
			Assert.assertEquals(Config.getInstance().getDoneMeetingBadge(), meet.doneStatusBadge.getText());

	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void start1_1CallMeeting(){
		try{
			createMeetingForHDCallFromMeetingPage();
			meet.startMeeting();
			hdCallOneToOne.waitTillCallRings();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
//			Utils.shortSleep();
		}
		catch (Exception e) {
			Assert.fail("Unable to start meeting");
		}
	}
	
	@Test(dependsOnMethods={"start1_1CallMeeting"})
	public void stop1_1CallMeeting(){
			hdCallOneToOne.endOngoingCall();
			meet.endMeetingConfirmation();
			Utils.shortSleep();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);

	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void startGroupCallMeeting(){
		try{
			createMeetingForHDGroupCallFromMeetingPage();
			meet.startMeetingForGroup();
			Assert.assertEquals(driver.currentActivity(),Constants.ACTIVITY_GROUPCALL_SCREEN);
			Utils.shortSleep();
		}
		catch (Exception e) {
//			System.out.println("Unable to start meeting");
			Assert.fail("Unable to start meeting");
		}
	}
	
	@Test(dependsOnMethods={"startGroupCallMeeting"})
	public void stopGroupCallMeeting(){
			groupCall.clickOnEndGroupCall();
			Utils.veryShortSleep();
			meet.endMeetingConfirmation();
			Utils.veryShortSleep();
			Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);

	}
	
	@Test(dependsOnMethods={"createDefaultTitleLiveMeeting"})
	public void cancelMeeting(){
		try{
			meet.cancelMeeting();
			Utils.navigateBack(driver);
			Assert.assertEquals(Config.getInstance().getCancelledMeetingBadge(), meet.cancelledStatusBadge.getText());
		}
		catch (Exception e) {
			Assert.fail("Unable to cancel meeting");
			
		}
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void androidDeleteMeetingFromTheMeetingList() throws Exception{
		startMeeting();
		stopMeeting();
		String oldMeetingTitle = meet.recentCreatedMeetingTitle.get(0).getText();
		Utils.longPressElement(meet.recentMeeting);
		Utils.veryShortSleep();
		meet.clickDeleteIcon();
		Utils.veryShortSleep();
		Assert.assertNotSame(oldMeetingTitle, meet.recentCreatedMeetingTitle.get(0).getText());
	}
	
	
	@Test
	public void androidReceivesMOM(){
		meet.clickRecentMeeting();
		Assert.assertEquals(true, meet.meetingMOM.getText().contains("This is an invitation for a  meeting created using NetSfere's Meeting Scheduler:"));
	}
	
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void acceptMeeting(){
		try{
			meet.clickRecentMeeting();
			meet.clickAcceptButton();
			Utils.navigateBack(driver);
		}catch (Exception e) {
			Assert.fail("Accept Button is not present");
		}
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void tentativeMeeting(){
		try{
			meet.clickRecentMeeting();
			meet.clickTentativeButton();
			Assert.assertFalse(meet.tentativeButton.isEnabled());
			Utils.navigateBack(driver);
		}catch (Exception e) {
			Assert.fail("Tentative Button is not present");
		}
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void rejectMeeting(){
		try{
			meet.clickRecentMeeting();
			meet.clickRejectButton();
			Assert.assertFalse(meet.rejectButton.isEnabled());
			Utils.navigateBack(driver);
		}catch (Exception e) {
			Assert.fail("Reject Button is not present");
		}
	}
	
	@Test
	public void navgigateToCOnversation(){
		try{
			bottomNavigator.navigateToConversationsPage();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void meetingDoneAssertion() throws Exception
	{
		//createMeetingForLiveFromMeetingPage();
		startMeeting();
		stopMeeting();
		String s1 = meet.doneStatusAssertion();
		
		Utils.shortSleep();
		Assert.assertEquals(s1, Config.getInstance().getDoneMeetingBadge());
	}
	
	@Test
	@NavigateTo(MeetingPage.class)
	public void meetingCancelAssertion() throws Exception
	{
		createMeetingForLiveFromMeetingPage();
		startMeeting();
		cancelMeeting();
		String s2 =meet.cancellledStatusAssertion();
		Utils.shortSleep();
		Assert.assertEquals(s2, Config.getInstance().getCancelledMeetingBadge());	
	}
	@Test
	@NavigateTo(MeetingPage.class)
	public void meetingStartedAssertion() throws Exception
	{
		createMeetingForLiveFromMeetingPage();
		startMeeting();
		String s3=meet.startedStatusAssertion();
		Utils.shortSleep();
		Assert.assertEquals(s3, Config.getInstance().getStartedMeetingBadge());
		stopMeeting();
		
	}
	
	

}
