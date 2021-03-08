package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.android.test.ConversationTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.GroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.HDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.LoginTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.VideoCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.test.EmailSending;
import com.infinite.netsfere.automationtool.modules.web.test.WebConversationTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebGroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebHDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebLoginTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebVideoCallTestCases;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GuestLiveServerSanity extends BaseAndroidSuite{
	
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
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 25)
	public void loginFromSecondWebGuestUser() {
		webGroupCall.init();
		webLoginTestCases.loginWithSecondWebUser(Config.getInstance().getGuestUser(),
				Config.getInstance().getAndroidUserPassword());
	}
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 26)
	public void webInitiatesOneToOneCallToGuestUser() throws Exception {
		webHDCall.netsfereUserMakesHDCallGuestUser();
//		webGroupCall.receivesGroupCall();
		webHDCall.acceptOneToOneCallFromSecondUser();
//		androidHdCall.incomingHDCallAssertion();
		webHDCall.endOngoingCallWeb();

	}

	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 27)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiatesOneToOneCallToGuestUser() throws Exception {
		androidHdCall.netsfereUserMakesHDCallToGuest();
		webHDCall.acceptOneToOneCallFromSecondUser();
//		webHDCall.incomingCallWebAssertion();
		androidHdCall.endOngoingCall();
	}
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 28)
	public void webInitiatesOneToOneCallWIthGuestUserAndGuestRejects() throws Exception {
		webHDCall.netsfereUserMakesHDCallGuestUser();
//		webGroupCall.receivesGroupCall();
		webHDCall.rejectIncomingOneToOneCallFromSecondUser();
//		androidHdCall.incomingHDCallAssertion();

	}
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 29)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiatesOneToOneCallToGuestUserAndGuestRejects() throws Exception {
		androidHdCall.netsfereUserMakesHDCallToGuest();
		webHDCall.rejectIncomingOneToOneCallFromSecondUser();
//		webHDCall.incomingCallWebAssertion();
	}
	

	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 30)
	@NavigateTo(WebConversationsPage.class)
	public void webMakesAGroupCallToGuestUser() throws InterruptedException {
		conv.groupConversationGuestUserWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.endGroupCall();
	}

	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 31)
	 @NavigateTo(ConversationsPage.class)
	public void androidMakesAGroupCallToGuestUser() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.endGroupCall();
	}
	
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 32)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiatesAGroupCallWithGuestANdGuestRejoinsTheCall() throws InterruptedException {
		conv.groupConversationGuestUserWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.leaveOngoingGroupCallFromSecondUser();
		webGroupCall.disconnectedStatusAssertion();
		webGroupCall.secondUserRejoinsGroupCall();
		webGroupCall.endGroupCall();

	}
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 33)
	@NavigateTo(ConversationsPage.class)
	public void AndroidInitiatesAGroupCallWithGuestANdGuestRejoinsTheCall() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		webGroupCall.leaveOngoingGroupCallFromSecondUser();
		androidGroupCall.validateDisconnectedStatus();
		webGroupCall.secondUserRejoinsGroupCall();
		androidGroupCall.endGroupCall();

	}
	
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 34)
	@NavigateTo(WebConversationsPage.class)
	public void webAddGuestUserDynamicallyDuringCall() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.locatingStatusAssertion();
		webGroupCall.addDynamicUser(Config.getInstance().getGuestDisplayName());
		webGroupCall.acceptGroupCallFromSecondUser();
		webGroupCall.endGroupCall();
	}
	
	@Test(groups = { Constants.GUEST_LIVE_CASES }, priority = 35)
	@NavigateTo(ConversationsPage.class)
	public void androidAddGuestUserDynamicallyDuringCall() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		androidGroupCall.validateLocatingStatus();
		androidGroupCall.addDynamicUser(Config.getInstance().getGuestDisplayName());
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.endGroupCall();
		
	}
	
	@Test(groups = { Constants.SCREENSHARE}, priority = 221)
	@NavigateTo(WebConversationsPage.class)
	public void initiateScreenshareFromWeb() throws InterruptedException
	{
		conv.groupConversationGuestUserWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
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
				Config.getInstance().getGuestDisplayName());
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

	
	@AfterMethod(groups = { Constants.GUEST_LIVE_CASES  }  , alwaysRun = false )
	public void endCall(ITestResult result) throws InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
		webGroupCall.endOrDisconnectGroupCall();
		webGroupCall.endOrDisconnectCallFromSecondUser();
		androidGroupCall.endOrDisconnectGroupCall();
		}
	}

}
