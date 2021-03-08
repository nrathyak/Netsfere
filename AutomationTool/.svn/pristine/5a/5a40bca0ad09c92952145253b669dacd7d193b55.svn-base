package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.asserts.AssertionWeb;
import com.infinite.netsfere.automationtool.asserts.AssertionsAndroid;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.android.test.ChannelTestCase;
import com.infinite.netsfere.automationtool.modules.android.test.ContactTest;
import com.infinite.netsfere.automationtool.modules.android.test.ConversationTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.GroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.HDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.LoginTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.MeetingTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.QuickPollTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.SettingTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.SignUpTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.VideoCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.test.ContactsTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.EmailSending;
import com.infinite.netsfere.automationtool.modules.web.test.SettingsTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.SignUpTestCase;
import com.infinite.netsfere.automationtool.modules.web.test.WebChannelTestcases;
import com.infinite.netsfere.automationtool.modules.web.test.WebConversationTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebGroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebHDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebLoginTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebMeetingTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebQuickPollTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebVideoCallTestCases;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class LiveServerSanity extends BaseAndroidSuite {
	
	ExtentReports report;
	ExtentTest logger;
	EmailSending email;
	LoginTestCases androidLoginTestCases;
	WebLoginTestCases webLoginTestCases;
	WebHDOneToOneCallTestCases webHDCall;
	HDOneToOneCallTestCases androidHdCall;
	WebGroupCallTestCases webGroupCall;
	GroupCallTestCases androidGroupCall;
	WebVideoCallTestCases webVideoCall;
	VideoCallTestCases androidVideoCall;
	WebConversationTestCases conv;
	ConversationTestCases conv_page_android;
	
	@BeforeClass(alwaysRun = true)
	public void LoadProperties() throws IOException, InterruptedException {
		email = new EmailSending();
		androidLoginTestCases = new LoginTestCases();
		androidLoginTestCases.init();
		conv_page_android = new ConversationTestCases();
		conv_page_android.init();
		webLoginTestCases = new WebLoginTestCases();
		webLoginTestCases.init();
		conv = new WebConversationTestCases();
		conv.init();
		webHDCall = new WebHDOneToOneCallTestCases();
		webHDCall.init();
		androidHdCall = new HDOneToOneCallTestCases();
		androidHdCall.init();
		webGroupCall = new WebGroupCallTestCases();
		androidGroupCall = new GroupCallTestCases();
		androidGroupCall.init();

	}

	@Test(groups = { Constants.GROUP_LOGIN }, priority = 19)
	public void loginToWeb() throws Exception {
		webLoginTestCases.login();
	}

	@Test(groups = { Constants.GROUP_LOGIN }, priority = 20)
	@NavigateTo(IntroPage.class)
	public void loginToAndroid() throws IOException, InterruptedException {
		androidLoginTestCases.goToLoginScreen();
		androidLoginTestCases.loginWithValidCredentials(Config.getInstance().getAndroidUserEamil(),
				Config.getInstance().getAndroidUserPassword());
	}
	
	@Test(groups = { Constants.GROUP_HD_CALL, Constants.DYNAMIC_GROUPCALL , Constants.SCREENSHARE }, priority = 202)
	public void loginFromSecondWebUser() {
		webGroupCall.init();
		webLoginTestCases.loginWithSecondWebUser(Config.getInstance().getIosUserEamil(),
				Config.getInstance().getIosUserPassword());
	}

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 203)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiateAGroupCallAndParticipantsAccept() throws IOException, InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.endGroupCall();
	}
	
	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 204)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiatesAGroupCallAndParticipantsAccept() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.endGroupCall();

	}

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 205)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiatesAGroupCallAndAndroidRejectsTheCall() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.declineGroupCall();
		webGroupCall.declinedStatusAssertion();
		webGroupCall.acceptGroupCallFromSecondUser();
		webGroupCall.endGroupCall();

	}

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 206)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiatesAGroupCallAndWebRejectsTheCall() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.declineGroupCall();
		androidGroupCall.validateDeclinedStatus();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.endGroupCall();

	}
	
	
	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 208)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiatesAGroupCallAndAndroidANdWebRejoinsTheCall() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		androidGroupCall.leaveOngoingGroupCall();
		webGroupCall.disconnectedStatusAssertion();
		androidGroupCall.rejoinTheGroupCall();
		webGroupCall.leaveOngoingGroupCallFromSecondUser();
		webGroupCall.disconnectedStatusAssertion();
		webGroupCall.secondUserRejoinsGroupCall();
		webGroupCall.endGroupCall();

	}
	
	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 210)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiatesaGroupCallforSelectedparticipantsinConversation() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCallWithSelectedParticipants();
		webGroupCall.notcalledStatusAssertion();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.endGroupCall();
	}
	
	
	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 212)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiateaGroupCallforSelectedparticipantsinConversation() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCallForSelectedParticipants();
		androidGroupCall.validateNotcalledStatus();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		androidGroupCall.endGroupCall();
	}
	
	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 214)
	@NavigateTo(WebConversationsPage.class)
	public void webSendMessageInConversationwhileinGroupCall() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.waitTillNoAnswerByparticipants();
		conv.composeMessageInAConversation();
		webGroupCall.endGroupCall();
	}
	
	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 216)
	@NavigateTo(ConversationsPage.class)
	public void androidSendMessageInConversationwhileinGroupCall() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		androidGroupCall.validateNoanswerStatus();
		androidGroupCall.sendMessageDuringGroupcall();
		androidGroupCall.endGroupCall();
		
	}
	
	
	@Test(groups = { Constants.DYNAMIC_GROUPCALL }, priority = 217)
	@NavigateTo(WebConversationsPage.class)
	public void webAddUserDynamicallyDuringCall() throws InterruptedException {
//		loginFromSecondWebUser();
		conv.groupConversationGuestUserWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		webGroupCall.initiateGroupCall();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.locatingStatusAssertion();
		webGroupCall.addDynamicUser(Config.getInstance().getIosUserDisplayName());
		webGroupCall.acceptGroupCallFromSecondUser();
		webGroupCall.endGroupCall();
	}
	
	@Test(groups = { Constants.DYNAMIC_GROUPCALL }, priority = 218)
	@NavigateTo(ConversationsPage.class)
	public void androidAddUserDynamicallyDuringCall() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		androidGroupCall.validateLocatingStatus();
		androidGroupCall.addDynamicUser(Config.getInstance().getIosUserDisplayName());
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.endGroupCall();
		
	}
	
	
	@Test(groups = { Constants.SCREENSHARE}, priority = 221)
	@NavigateTo(WebConversationsPage.class)
	public void initiateScreenshareFromWeb() throws InterruptedException
	{
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.initiateScreenShare();
		androidGroupCall.viewScreenshare();
		webGroupCall.waitTillNoAnswerByparticipants();
		webGroupCall.secondWebUserJoinsScreenShare();
		webGroupCall.stopScreenshare();
		androidGroupCall.screenshareEndAssertion();
		webGroupCall.endGroupCall();
	}
	
	@Test(groups = { Constants.SCREENSHARE}, priority = 222)
	@NavigateTo(ConversationsPage.class)
	public void initiateScreenshareFromAndroid() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		androidGroupCall.initiateScreenshare();
		webGroupCall.viewScreenshareAssertion();
		webGroupCall.waitTillNoAnswerByparticipants();
		webGroupCall.secondWebUserJoinsScreenShare();
		androidGroupCall.stopScreenshare();
		webGroupCall.endScreenshareAssertion();
		androidGroupCall.endGroupCall();
		
	}
	
	
	@AfterMethod(groups = { Constants.GROUP_HD_CALL , Constants.DYNAMIC_GROUPCALL , Constants.SCREENSHARE }  , alwaysRun = false )
	public void endCall(ITestResult result) throws InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
		webGroupCall.endOrDisconnectGroupCall();
		webGroupCall.endOrDisconnectCallFromSecondUser();
		androidGroupCall.endOrDisconnectGroupCall();
		}
	}

}
