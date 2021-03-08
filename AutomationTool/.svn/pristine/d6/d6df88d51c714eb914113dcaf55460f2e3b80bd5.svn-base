package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.asserts.AssertionWeb;
import com.infinite.netsfere.automationtool.asserts.AssertionsAndroid;
import com.infinite.netsfere.automationtool.modules.android.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.android.test.ChannelTestCase;
import com.infinite.netsfere.automationtool.modules.android.test.ContactTest;
import com.infinite.netsfere.automationtool.modules.android.test.ConversationTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.GroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.HDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.LoginTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.MeetingTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.QuickPollTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.ContactsTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.EmailSending;
import com.infinite.netsfere.automationtool.modules.web.test.WebChannelTestcases;
import com.infinite.netsfere.automationtool.modules.web.test.WebConversationTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebGroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebHDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebLoginTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebMeetingTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebQuickPollTestCases;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WebSanity extends BaseWebSuite {
	
	ExtentReports report;
	ExtentTest logger;
	EmailSending email;
	WebConversationTestCases conv;
	LoginTestCases android_login;
	WebLoginTestCases login_func;
	ConversationTestCases conv_page_android;
	AssertionsAndroid androidAssert;
	AssertionWeb webAssert;
	WebHDOneToOneCallTestCases webHDCall;
	HDOneToOneCallTestCases androidHdCall;
	ContactsTestCases cont;
	ContactTest androidCont;
	WebGroupCallTestCases webGroupCall;
	GroupCallTestCases androidGroupCall;
	WebChannelTestcases webChannel;
	ChannelTestCase androidChannel;
	WebQuickPollTestCases webQuickPoll;
	QuickPollTestCases androidQuickPoll;
	WebMeetingTestCases webMeeting;
	MeetingTestCases androidMeeting;

	@BeforeClass(alwaysRun = true)
	public void LoadProperties() throws IOException, InterruptedException {

		email = new EmailSending();
		conv = new WebConversationTestCases();
		android_login = new LoginTestCases();
		android_login.init();
		conv_page_android = new ConversationTestCases();
		conv_page_android.init();
		login_func = new WebLoginTestCases();
		login_func.init();
		conv = new WebConversationTestCases();
		conv.init();
		androidAssert = new AssertionsAndroid();
		webAssert = new AssertionWeb();
		webHDCall = new WebHDOneToOneCallTestCases();
		webHDCall.init();
		androidHdCall = new HDOneToOneCallTestCases();
		androidHdCall.init();
		cont = new ContactsTestCases();
		cont.init();
		androidCont = new ContactTest();
		androidCont.init();
		webGroupCall = new WebGroupCallTestCases();
		androidGroupCall = new GroupCallTestCases();
		androidGroupCall.init();
		webChannel = new WebChannelTestcases();
		webChannel.init();
		androidChannel = new ChannelTestCase();
		androidChannel.init();
		webQuickPoll = new WebQuickPollTestCases();
		webQuickPoll.init();
		androidQuickPoll = new QuickPollTestCases();
		androidQuickPoll.init();
		webMeeting = new WebMeetingTestCases();
		webMeeting.init();
		androidMeeting = new MeetingTestCases();
		androidMeeting.init();

	}

//	@BeforeMethod
	public void setUp() {
		conv_page_android.launchApp();
	}
	

	@Test(groups = { Constants.GROUP_LOGIN }, priority = 1)
	public void loginToWeb() throws Exception {

		login_func.login();
	}

	@Test(groups = { Constants.GROUP_LOGIN }, priority = 2)
	@NavigateTo(IntroPage.class)
	public void loginToAndroid() throws IOException, InterruptedException {
		android_login.goToLoginScreen();
		android_login.loginWithValidCredentials(Config.getInstance().getAndroidUserEamil(),
				Config.getInstance().getAndroidUserPassword());
	}
	

}
