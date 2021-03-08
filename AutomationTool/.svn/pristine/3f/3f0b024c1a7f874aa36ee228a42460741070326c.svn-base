package com.infinite.netsfere.automationtool.modules.web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChannelsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebGroupCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebHdOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebMeetingPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebNavigationBar;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

public class WebMeetingTestCases extends BaseTestCases {

	WebDriver driver;
	WebDriverWait webWait;
	WebMeetingPage webMeeting;
	WebChannelsPage webChannel;
	WebConversationTestCases webConv;
	WebConversationsPage webConvPage;
	WebNavigationBar webNavigator;
	WebChatPage webChat;
	WebHdOneToOneCallElements hdOneToOneCall;
	WebGroupCallElements groupCall;

	@BeforeClass
	public void init() {
		driver = DriverManager.getWebDriver();
		webWait = Utils.getLongWait(driver);
		webMeeting = new WebMeetingPage();
		webChannel = new WebChannelsPage();
		webConv = new WebConversationTestCases();
		webConv.init();
		webConvPage = new WebConversationsPage();
		webNavigator = new WebNavigationBar();
		webChat = new WebChatPage();
		hdOneToOneCall = new WebHdOneToOneCallElements();
		groupCall = new WebGroupCallElements();
	}

	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createMeetingForLiveFromConversation() throws Exception {
		//try {
			webConv.createConversationWebWithTitle();
			webChat.clickOnMoreOptions();
			webChat.clickOnScheduleMeeting();
			Utils.veryShortSleep();
			webMeeting.createMeeting();

		/*} catch (Exception e) {
			Assert.fail("Unable to create Meeting from Conversation page");
		}*/
	}

	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createMeetingForHDCallFromConversation() throws Exception {
		try {
			webConv.createConversationWebWithTitle();
			webChat.clickOnMoreOptions();
			webChat.clickOnScheduleMeeting();
			webMeeting.meetingTypeSelect(1);
			webMeeting.createMeeting();

		} catch (Exception e) {
			Assert.fail("Unable to create Meeting for HD call from Conversation page");
		}
	}

	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createMeetingForHDGroupCallFromConversation() throws InterruptedException {
		try {
			webConv.groupConversationWithoutTitle();
			webChat.clickOnMoreOptions();
			webChat.clickOnScheduleMeeting();
			webMeeting.meetingTypeSelect(2);
			webMeeting.createMeeting();

		} catch (Exception e) {
			Assert.fail("Unable to create Meeting for HD group call from Conversation page");
		}
	}

	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createMeetingForOthersFromConversation() throws InterruptedException {
		try {
			webConv.createConversationWithoutTitle();
			webChat.clickOnMoreOptions();
			webChat.clickOnScheduleMeeting();
			webMeeting.meetingTypeSelect(3);
			webMeeting.createMeeting();

		} catch (Exception e) {
			Assert.fail("Unable to create Meeting for Others from Conversation page");
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void createMeetingForLiveFromMeetingPage() throws InterruptedException {
		try {
			webMeeting.createNewMeetingIcon();
			webMeeting.meetingTitleTextBox(Config.getInstance().getMeetingTitle());
			webMeeting.meetingDescriptionTextBox(Config.getInstance().getMeetingDescription());
			webMeeting.meetingTypeSelect(0);
			webMeeting.meetingLocationTextBox(Config.getInstance().getMeetingLocation());
			webMeeting.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			webMeeting.createMeeting();

		} catch (Exception e) {
			Assert.fail("Unable to create Live Meeting from meeting Page");
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void createMeetingForHDCallFromMeetingPage() {
		try {
			webMeeting.createNewMeetingIcon();
			webMeeting.meetingTitleTextBox(Config.getInstance().getMeetingTitle());
			webMeeting.meetingDescriptionTextBox(Config.getInstance().getMeetingDescription());
			webMeeting.meetingTypeSelect(1);
			webMeeting.meetingLocationTextBox(Config.getInstance().getMeetingLocation());
			webMeeting.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			webMeeting.createMeeting();

		} catch (Exception e) {
			Assert.fail("Unable to create HD call Meeting from meeting Page");
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void createMeetingForGroupCallFromMeetingPage() throws InterruptedException {
//		try {
			webMeeting.createNewMeetingIcon();
			webMeeting.meetingTitleTextBox(Config.getInstance().getMeetingTitle());
			webMeeting.meetingDescriptionTextBox(Config.getInstance().getMeetingDescription());
			webMeeting.meetingTypeSelect(2);
			webMeeting.meetingLocationTextBox(Config.getInstance().getMeetingLocation());
			webMeeting.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			webMeeting.searchAndSelectContact(Config.getInstance().getIosUserDisplayName());
			webMeeting.createMeeting();

//		} catch (Exception e) {
//			Assert.fail("Unable to create Group call Meeting from meeting Page");
//		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void createMeetingForOthersFromMeetingPage() {
		try {
			webMeeting.createNewMeetingIcon();
			webMeeting.meetingTitleTextBox(Config.getInstance().getMeetingTitle());
			webMeeting.meetingDescriptionTextBox(Config.getInstance().getMeetingDescription());
			webMeeting.meetingTypeSelect(3);
			webMeeting.meetingLocationTextBox(Config.getInstance().getMeetingLocation());
			webMeeting.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			webMeeting.createMeeting();

		} catch (Exception e) {
			Assert.fail("Unable to create Others Meeting from meeting Page");
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void startMeetingForLive() throws InterruptedException {
		try {
			createMeetingForLiveFromMeetingPage();
			webMeeting.startMeeting();
			Assert.assertEquals(Config.getInstance().getLiveMeetingBadge(), webMeeting.liveLabelInMeeting.getText());
			Utils.shortSleep();
		} catch (Exception e) {
			Assert.fail("Unable to start meeting");
		}
	}

	@Test(dependsOnMethods = { "startMeetingForLive" })
	public void stopMeetingForLive() {
		try {
			webMeeting.stopMeeting();
			Utils.shortSleep();
			String placeHolderMessage = webChat.getLastPlaceholderMessage();
			Assert.assertEquals(placeHolderMessage, Config.getInstance().getWebUserDisplayName() + " "
					+ Config.getInstance().getTextChannelPlaceholder());
		} catch (Exception e) {
			Assert.fail("Unable to stop meeting");
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void startMeetingFor1_1Call() {
		createMeetingForHDCallFromMeetingPage();
		Utils.veryShortSleep();
		webMeeting.startMeetingForCall();
		hdOneToOneCall.waitUntilCallRings();
		Assert.assertEquals(true, hdOneToOneCall.callRinging.getText().equals("Ringing..."));

	}

	/*
	 * End main meeting
	 */
	@Test(dependsOnMethods = { "startMeetingFor1_1Call" })
	public void stopMeetingFor1_1Call() {
		try {

			hdOneToOneCall.endOngoingCall();
			Utils.veryShortSleep();
			webMeeting.stopHDCallMeeting();
//                                            String placeHolderMessage = webChat.getLastPlaceholderMessage();
//                                            Assert.assertEquals(placeHolderMessage,Config.getInstance().getWebUserDisplayName() + " " + Config.getInstance().getTextChannelPlaceholder());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void startMeetingForGroupCall() throws InterruptedException {
		createMeetingForGroupCallFromMeetingPage();
		webMeeting.startMeetingForCall();
		Utils.shortSleep();
		webMeeting.clickingOnParticipant();
		groupCall.clickOnPlaceCallButton();
		groupCall.isAtGroupCallPage();
		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
		Utils.veryShortSleep();

	}

	@Test(dependsOnMethods = { "startMeetingForGroupCall" })
	public void stopMeetingForGroupCall() {
		try {
			Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
			groupCall.clickOnEndGroupCall();
			webMeeting.stopHDCallMeeting();
//         String placeHolderMessage = webChat.getLastPlaceholderMessage();
//        Assert.assertEquals(placeHolderMessage,Config.getInstance().getWebUserDisplayName() + " " + Config.getInstance().getTextChannelPlaceholder());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test(dependsOnMethods = { "createMeetingForOthersFromConversation" })
	public void cancelMeeting() {
		try {
			webMeeting.cancelMeeting();
			Utils.shortSleep();
			Assert.assertEquals(Config.getInstance().getCancelledMeetingText(),
					webMeeting.cancelledMeetingText.getAttribute("placeholder"));
		} catch (Exception e) {
			Assert.fail("Unable to cancel Meeting");
		}
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void webDeleteMeetingFromList() throws InterruptedException {
		startMeetingForLive();
		stopMeetingForLive();
		webMeeting.clickRecentMeeting();
		String oldMeetingTitle = webMeeting.meetingTitle.getText();
		webMeeting.clickDeleteIcon();
		Utils.veryShortSleep();
		Assert.assertNotSame(oldMeetingTitle, webMeeting.meetingTitle.getText());
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void webReceivesMOM() {
		Assert.assertEquals(webMeeting.meetingMOM.getText(), Config.getInstance().getMeetingMOM());
	}

	@Test(dependsOnMethods = { "createMeetingForOthersFromConversation" })
	@NavigateTo(WebMeetingPage.class)
	public void acceptMeeting() {
		webMeeting.clickRecentMeeting();
		webMeeting.clickAcceptButton();
		Utils.shortSleep();
	}

	@Test(dependsOnMethods = { "createMeetingForOthersFromConversation" })
	@NavigateTo(WebMeetingPage.class)
	public void rejectMeeting() {
		webMeeting.clickRecentMeeting();
		webMeeting.clickRejectButton();
	}

	@Test(dependsOnMethods = { "createMeetingForOthersFromConversation" })
	@NavigateTo(WebMeetingPage.class)
	public void tentativeMeeting() {
		webMeeting.clickRecentMeeting();
		webMeeting.clickTentativeButton();
	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void meetingDoneAssertion() throws InterruptedException {

		startMeetingForLive();
		Utils.veryShortSleep();
		stopMeetingForLive();
		String meetingDoneStatus = webMeeting.doneStatusAssertion();
		Utils.shortSleep();
		Assert.assertEquals(meetingDoneStatus, Config.getInstance().getDoneMeetingBadge());

	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void meetingCancelAssertion() throws InterruptedException {
		createMeetingForLiveFromMeetingPage();
		Utils.shortSleep();
		cancelMeeting();
		String meetingCancelStatus = webMeeting.cancelStatusAssertion();
		Utils.shortSleep();
		Assert.assertEquals(meetingCancelStatus, Config.getInstance().getCanceledMeetingBadge());

	}

	@Test
	@NavigateTo(WebMeetingPage.class)
	public void meetingStartedAssertion() throws InterruptedException {
		startMeetingForLive();
		String meetingStartedStatus = webMeeting.startedStatusAssertion();
		Utils.shortSleep();
		Assert.assertEquals(meetingStartedStatus, Config.getInstance().getStartedMeetingBadge());
		stopMeetingForLive();

	}

}
