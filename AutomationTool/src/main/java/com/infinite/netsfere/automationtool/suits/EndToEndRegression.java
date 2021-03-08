package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.asserts.AssertionWeb;
import com.infinite.netsfere.automationtool.asserts.AssertionsAndroid;
import com.infinite.netsfere.automationtool.modules.android.pages.CallLogPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChannelsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.android.pages.LoginPage;
import com.infinite.netsfere.automationtool.modules.android.pages.MeetingPage;
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
import com.infinite.netsfere.automationtool.modules.web.pages.WebCallLogsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChannelsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebContactsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebMeetingPage;
import com.infinite.netsfere.automationtool.modules.web.test.ContactsTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.EmailSending;
import com.infinite.netsfere.automationtool.modules.web.test.Screenshot;
import com.infinite.netsfere.automationtool.modules.web.test.SettingsTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.SignUpTestCase;
import com.infinite.netsfere.automationtool.modules.web.test.WebChannelTestcases;
import com.infinite.netsfere.automationtool.modules.web.test.WebConversationTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebGroupCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebHDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebLoginTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebMeetingTestCases;
import com.infinite.netsfere.automationtool.modules.web.test.WebQuickPollTestCases;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.Driver;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EndToEndRegression extends BaseAndroidSuite {

	ExtentReports report;
	ExtentTest logger;
	EmailSending email;
	WebConversationTestCases conv;
	LoginTestCases androidLoginTestCases;
	WebLoginTestCases webLoginTestCases;
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
	SettingsTestCases webSettings;
//	SignUpTestCase webSignUp;
//	SignUpTestCases androidSignUp;
	SettingsTestCases webSettingsTestCases;
	SettingTestCases androidSettingsTestCases;

	@BeforeClass(alwaysRun = true)
	public void LoadProperties() throws IOException, InterruptedException {

		webSettings = new SettingsTestCases();
		email = new EmailSending();
		conv = new WebConversationTestCases();
		androidLoginTestCases = new LoginTestCases();
		androidLoginTestCases.init();
//		webSignUp = new SignUpTestCase();
//		webSignUp.init();
//		androidSignUp = new SignUpTestCases();
//		androidSignUp.init();
		conv_page_android = new ConversationTestCases();
		conv_page_android.init();
		webLoginTestCases = new WebLoginTestCases();
		webLoginTestCases.init();
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
		webSettingsTestCases = new SettingsTestCases();
		webSettingsTestCases.init();
		androidSettingsTestCases = new SettingTestCases();
		androidSettingsTestCases.init();
	}

	// @BeforeMethod
	public void setUp() {
		conv_page_android.launchApp();
	}

	/*@Test(groups = { Constants.SIGN_UP }, priority = 1)
	public void webCreateAccountThroughSignUp() throws Exception {
		webSignUp.signUpOrg();
		webSignUp.activateAdminOrg();
	}
	
	@Test(groups = { Constants.SIGN_UP }, priority = 2)
	public void webCreateAccountAndAddUsersDuringSignup() throws InterruptedException {
		webSignUp.signUpAndAddUser();
		
	}
	
	@Test(groups = { Constants.SIGN_UP}, priority = 2)
	public void webUnableToCreateAccountForExistingUser() throws InterruptedException {
		webSignUp.duplicateOrg();
		webSignUp.closeSignUpDriver();
	}

	@Test(groups = { Constants.SIGN_UP }, priority = 3)
	public void androidCreateAccountThroughSignUp() throws Exception {
		androidSignUp.androidUserCreateAccountThroughSignUp();
	}
	
	@Test(groups = { Constants.SIGN_UP }, priority = 4)
	@NavigateTo(IntroPage.class)
	public void androidUnableToCreateAccountForExistingUser() throws InterruptedException {
		androidSignUp.duplicateOrg();
	}
*/


//	@Test(groups = { Constants.LOGIN_INFO }, priority = 5)
	public void webClickTermsOfServicesAndPrivacyPolicyButton() throws Exception {
		webLoginTestCases.clickTermsOfServicesAndPrivacyPolicyButton();
	}

//	@Test(groups = { Constants.LOGIN_INFO }, priority = 6)
	public void webClickAboutButton() throws Exception {
		webLoginTestCases.clickAboutButton();
	}

//	@Test(groups = { Constants.LOGIN_INFO }, priority = 7)
	public void webClickHelpButton() throws Exception {
		webLoginTestCases.clickHelpButton();
	}

//	@Test(groups = { Constants.LOGIN_INFO }, priority = 8)
	public void resetPasswordInWeb() throws InterruptedException {
		webLoginTestCases.resetPassword("c5@nrathya.netsferetest.org");
		webLoginTestCases.resetPasswordThroughGmail();
	}
/*
	@Test(groups = { Constants.LOGIN_INFO }, priority = 9)
	public void cancelResetPasswordWeb() {
		webLoginTestCases.cancelResetPassword();
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 10)
	public void unableToResetPassword() {
		webLoginTestCases.unableToResetPassword("c5@nrathya.netsferetest.org");
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 11)
	public void androidClickTermsOfServicesAndPrivacyPolicyButton() throws Exception {
		androidLoginTestCases.clickOnTermsOfServiceAndPrivacyPolicyButton();

	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 12)
	@NavigateTo(LoginPage.class)
	public void androidClickOnHelpButton() throws Exception {
		androidLoginTestCases.clickOnHelpButton();
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 13)
	@NavigateTo(LoginPage.class)
	public void androidClickOnVersionInfoButton() throws Exception {
		androidLoginTestCases.clickVersionInfoButton();
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 14)
	@NavigateTo(IntroPage.class)
	public void androidResetPassword() throws InterruptedException {
		androidLoginTestCases.resetPassword("c8@nrathya.netsferetest.org");
		webLoginTestCases.resetPasswordThroughGmail();
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 15)
	@NavigateTo(IntroPage.class)
	public void androidUnableToResetPassword() throws InterruptedException {
		androidLoginTestCases.unableToResetPassword("abc@nrathya.netsferetest.org");
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 16)
	public void loginToWebWithInvalidPassword() throws Exception {
		webLoginTestCases.loginWithInvalidPassword();
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 17)
	public void loginToWebWIthInvalidUserId() throws Exception {
		webLoginTestCases.loginWithInvalidUsername();
	}

	@Test(groups = { Constants.LOGIN_INFO }, priority = 18)
	@NavigateTo(IntroPage.class)
	public void loginToAndroidWithInvalidPassword() throws Exception {
		androidLoginTestCases.goToLoginScreen();
		androidLoginTestCases.loginWithInValidCredentials();
	}
*/
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
/*
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority =21)
	public void webCreate1_1ConversationWithAndroidWithoutTitle() throws Exception {
		conv.createConversationWithoutTitle();
		conv_page_android.withoutTitleAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 22)
	public void androidCreate1_1ConversationwithWebWithoutTitle() {
		conv_page_android.createConversationWithoutTitle();
		conv.webWithoutTitleAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 23)
	public void webModifyDefaultTitle() throws Exception {
		conv.modifyDefaultTitle();
		conv.modifiedTitle();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 24)
//	@NavigateTo(ConversationsPage.class)
	public void androidModifyDefaultTitle() throws InterruptedException {
		conv_page_android.updateExistingConversationTitleFromChatScreen();
		conv_page_android.updateTitleAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 25)
	public void webCreate1_1ConversationWithAndroidWithTitle() throws Exception {
		conv.createConversationWebWithTitle();
		conv_page_android.conversationWithTitleAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 26)
	public void androidCreate1_1ConversationwithWebWithTitle() throws Exception {
		conv_page_android.createConversationWithTitle();
		conv.conversationWithTitle();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 27)
	public void webGroupConversationWithTitle() throws Exception {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		conv_page_android.conversationWithTitleAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 28)
	public void androidGroupConversationWithTitle() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		conv.groupConversationParticipantCountAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 29)
	public void webSendingMessageInStreamlinedConversationUsingCreateButton() {
		conv.streamlinedConversationByClickingCreateButton();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 30)
	@NavigateTo(ConversationsPage.class)
	public void androidSendingMessageInStreamlinedConversationUsingCreateButton() {
		conv_page_android.streamlinedConversationByClickingCreateButton();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 31)
	public void addParticipantInWeb() throws InterruptedException {
		conv.addParticipant();
//		conv_page_android.addParticipantAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 32)
	@NavigateTo(ConversationsPage.class)
	public void addParticipantInAndroid() throws Exception {
		conv_page_android.addParticipantInConversation();
		conv.addParticipantAssertion();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 33)
	public void webRemoveParticipant() throws Exception {
		conv.removeParticipant();

	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 34)
	@NavigateTo(ConversationsPage.class)
	public void androidRemoveParticipant() throws Exception {
		conv_page_android.removeParticipant();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 35)
	public void searchSelectConversationInWeb() throws InterruptedException {
		conv.searchAndSelectConversationWeb();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 36)
	public void searchSelectConversationInAndroid() throws InterruptedException {
		conv_page_android.searchForRandomConversationAndOpen();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 37)
	public void webSendQuickReply() throws InterruptedException {
		conv.sendQuickReply();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 38)
	@NavigateTo(ConversationsPage.class)
	public void androidSendQuickReply() throws Exception {
		conv_page_android.sendQuickReply();
	}
	*/
/*
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 39 , dependsOnMethods = { "webCreate1_1ConversationWithAndroidWithTitle" })
	public void webSendMyLocation() {
		conv.sendMyLocation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 40)
	public void webSendOtherLocation() throws InterruptedException {
		conv.sendOtherLocation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 41)
	public void androidSendLocation() {
		conv_page_android.sendMyLocation();
	}
	


	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 42)
	@NavigateTo(WebConversationsPage.class)
	public void webLeavesConversationAsParticipant() throws InterruptedException {
		conv.leaveConversationAsParticipant();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 43)
	@NavigateTo(ConversationsPage.class)
	public void androidLeavesConversationAsParticipant() throws Exception {
		conv_page_android.leaveConversationAsParticipantFromConversationPage();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 44)
	public void webTransferOwnershipAndLeaveConversation() throws InterruptedException {
		conv.transferOwnershipAndLeaveConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 45)
	public void androidTransferOwnershipAndLeaveConversation() {
		conv_page_android.transferOwnershipAndLeaveConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 46)
	public void webDestroyConversationAsOwner() throws InterruptedException {
		conv.destroyConversationAsOwner();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 47)
	@NavigateTo(ConversationsPage.class)
	public void androidDestroyConversationAsOwner() {
		conv_page_android.destroyConversationAsOwner();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 48)
	@NavigateTo(WebConversationsPage.class)
	public void webExportFirstConversation() {

		conv.exportFirstConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 49)
	@NavigateTo(ConversationsPage.class)
	public void androidExportFirstConversation() throws Exception {
		conv_page_android.exportFirstConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 50)
	public void webSendAttachmentFromDevice() throws InterruptedException, IOException {
		conv.sendAttachmentFromDevice();
	}

	// @Test(groups = { Constants.GROUP_CONVERSATION }, priority = 30)
	public void androidSendAttachmentFromDeviceNexus5X() {
		conv_page_android.sendImageFromNexus5X();
	}

	// @Test(groups = { Constants.GROUP_CONVERSATION }, priority = 31)
	public void webSaveAttachmentToDevice() {
		conv.saveAttachmentToDevice();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 52)
	@NavigateTo(WebConversationsPage.class)
	public void startAndEndLiveFromWebConversation() throws Exception {
		conv.startLiveFromConversation();
		webChannel.endBroadcastLive();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 53)
	@NavigateTo(ConversationsPage.class)
	public void startAndEndLiveFromAndroidConversation() {
		conv_page_android.startLiveFromConversation();
		androidChannel.endBroadcastLive();

	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 54)
	public void webSendingMessageInStreamlinedConversationUsingSendButton() {
		conv.streamlinedConversationByClickingSendButton();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 55)
	@NavigateTo(ConversationsPage.class)
	public void androidSendingMessageInStreamlinedConversationUsingSendButton() throws Exception {
		conv_page_android.streamlinedConversationByClickingSendButton();

	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 56)
	@NavigateTo(WebConversationsPage.class)
	public void webValidateBadgeCountFOrUnreadMessages() throws Exception {
		conv.validateBadgeCountInConversation();
	}

//	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 57)
	@NavigateTo(ConversationsPage.class)
	public void androidValidateBadgeCountForUnreadMessages() {
		conv_page_android.validateBadgeCountInConversation();
	}

//	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 58)
	@NavigateTo(WebConversationsPage.class)
	public void webSendsMessageToAndroidAndValidatesInUnreadTab() throws Exception {
		conv.sendQuickReply();
		conv_page_android.validateUnreadBadgeCountInUnreadTab();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 59)
	@NavigateTo(ConversationsPage.class)
	public void androidSendsMessageToWebAndValidatesInUnreadTab() throws Exception {
		conv_page_android.sendQuickReply();
		conv.validateMessageInUnreadTab();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 60)
	public void androidUnableToAddParticipantInConversationAsParticipant() throws Exception {
		webCreate1_1ConversationWithAndroidWithTitle();
		conv_page_android.androidUserAsAParticipantUnableToEditParticipantsInConversation();

	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 61)
	@NavigateTo(ConversationsPage.class)
	public void webUnableToAddParticipantInConversationAsParticipant() throws Exception {
		androidCreate1_1ConversationwithWebWithTitle();
		conv.webUserAsParticipantUnableToEditParticipantsInConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 62)
	@NavigateTo(WebConversationsPage.class)
	public void androidUnableToEditTitleInConversationAsParticipant() throws Exception {
		webCreate1_1ConversationWithAndroidWithTitle();
		conv_page_android.androidUserAsAParticipantCannotChangeTitleInConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 63)
	@NavigateTo(ConversationsPage.class)
	public void webUnableToEditTitleInConversationAsParticipant() throws Exception {
		androidCreate1_1ConversationwithWebWithTitle();
		conv.webUserAsParticipantUnableToEditTitleInConversation();
	}


*/
	/*
	@Test(groups = { Constants.GUEST }, priority = 72)
	public void webCreateConversationWithANewGuestUser() throws InterruptedException {
		webSignUp.loginToGmail();
		String user = conv.addGuestUserInConversation();
		webSignUp.activateGuestUser(user);
	}

	@Test(groups = { Constants.GUEST }, priority = 73)
	public void androidCreateConversationWithANewGuestUser() throws Exception {
		conv_page_android.createConversationWithANewGuestUser();
	}
*/
	
	/*
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 75)
	@NavigateTo(WebConversationsPage.class)
	public void webCreatesSelfConversation() throws Exception {
		conv.createSelfConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 76)
	@NavigateTo(ConversationsPage.class)
	public void androidCreatesSelfConversation() throws Exception {
		conv_page_android.createSelfConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 77)
	@NavigateTo(WebConversationsPage.class)
	public void webAddParticipantToASelfConversation() throws Exception {
		conv.addParticipantToSelfConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 78)
	@NavigateTo(ConversationsPage.class)
	public void androidAddParticipantToASelfConversation() throws Exception {
		conv_page_android.addParticipantToSelfConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 79)
	@NavigateTo(WebConversationsPage.class)
	public void webAddsMultipleParticipantsToAConversation() throws Exception {
		conv.addMultipleParticipantsToAConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 81)
	@NavigateTo(ConversationsPage.class)
	public void androidAddsMultipleParticipantsToAConversation() throws Exception {
		conv_page_android.addMultipleParticipantsToAConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 82)
	@NavigateTo(WebConversationsPage.class)
	public void webAddParticipantInAGroupConversation() throws Exception {
		conv.addParticipantToAGroupConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 83)
	@NavigateTo(ConversationsPage.class)
	public void androidAddParticipantInAGroupConversation() throws Exception {
		conv_page_android.addParticipantToAGroupConversation();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 85)
	@NavigateTo(WebConversationsPage.class)
	public void webCreatesGroupConversationWithoutTitle() throws Exception {
		conv.groupConversationWithoutTitle();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 86)
	@NavigateTo(ConversationsPage.class)
	public void androidCreatesGroupConversationWithoutTitle() throws Exception {
		conv_page_android.createGroupConversationWithoutTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 89)
	@NavigateTo(WebConversationsPage.class)
	public void webCreatesStreamlineConversationUsingSendButton() throws Exception {
		conv.streamlinedConversationByClickingSendButton();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 90)
	@NavigateTo(ConversationsPage.class)
	public void androidCreatesStreamlineConversationUsingSendButton() throws Exception {
		conv_page_android.streamlinedConversationByClickingSendButton();
	}
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 92)
	@NavigateTo(WebConversationsPage.class)
	public void androidUnableToAddParticipantInConversationAsParticipant() throws Exception {
		conv.createConversationWebWithTitle();
		conv_page_android.androidUserAsAParticipantUnableToEditParticipantsInConversation();

	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 93)
	@NavigateTo(ConversationsPage.class)
	public void webUnableToAddParticipantInConversationAsParticipant() throws Exception {
		conv_page_android.createOneToOneConversation();
		conv.webUserAsParticipantUnableToEditParticipantsInConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 95)
	@NavigateTo(WebConversationsPage.class)
	public void androidUnableToEditTitleInConversationAsParticipant() throws Exception {
		conv.createConversationWebWithTitle();
		conv_page_android.androidUserAsAParticipantCannotChangeTitleInConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 96)
	@NavigateTo(ConversationsPage.class)
	public void webUnableToEditTitleInConversationAsParticipant() throws Exception {
		conv_page_android.createOneToOneConversation();
		conv.webUserAsParticipantUnableToEditTitleInConversation();
	}
	
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 99)
	@NavigateTo(WebConversationsPage.class)
	public void webfavoriteConversationFromConversationDetailsPage() throws Exception {
		conv.favoriteConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 100)
	@NavigateTo(WebConversationsPage.class)
	public void webUnfavoriteConversationFromConversationDetailsPage() throws Exception {
		conv.navigateToRecentConversation();
		conv.unFavoriteConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 101)
	@NavigateTo(ConversationsPage.class)
	public void androidFavoriteConversationFromAllConversationTab() throws Exception {
		conv_page_android.favoriteConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 102)
	@NavigateTo(ConversationsPage.class)
	public void androidUnfavoriteConversationFromAllConversationTab() throws Exception {
		conv_page_android.unFavoriteConversation();
	}
	


	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 105)
	@NavigateTo(WebConversationsPage.class)
	public void webMuteConversationFromConversationDetailsPage() throws Exception {
		// conv.navigateToRecentConversation();
		conv.muteConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 106)
	@NavigateTo(WebConversationsPage.class)
	public void webunMuteConversationFromConversationDetailsPage() throws Exception {
		conv.navigateToRecentConversation();
		conv.unMuteConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 107)
	@NavigateTo(ConversationsPage.class)
	public void androidMuteConversationFromAllConversationTab() throws Exception {
		conv_page_android.muteConversation();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 108)
	@NavigateTo(ConversationsPage.class)
	public void androidUnMuteConversationFromAllConversationsTab() throws Exception {
		conv_page_android.unMuteConversation();
	}
	
	*/
	
	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 109)
	@NavigateTo(WebConversationsPage.class)
	public void webMuteConversationFromAllConversationPage() throws Exception {
		// conv.navigateToRecentConversation();
		conv.favoriteConversationFromAllTab();
	}

	@Test(groups = { Constants.GROUP_CONVERSATION }, priority = 110)
	@NavigateTo(WebConversationsPage.class)
	public void webunMuteConversationFromAllConversationPage() throws Exception {
		conv.navigateToRecentConversation();
		conv.unMuteConversation();
	}
	
	
	@Test(groups = { Constants.GUEST }, priority = 74)
	public void webSendMessageToGuestUser() throws InterruptedException {
		conv.sendingMessageToGuestUser();
		// conv.netsfereUserSendDocumentToGuestUser();
	}

	@Test(groups = { Constants.GUEST }, priority = 75)
	@NavigateTo(ConversationsPage.class)
	public void androidSendMessageToGuestUser() {
		conv_page_android.sendingMessageToWebGuestUser();
	}

	@Test(groups = { Constants.GUEST }, priority = 76)
	public void webSendLocationToGuestUser() throws Exception {
		conv.guestUserSendLocationtoWebInAConversation();
	}

	@Test(groups = { Constants.GUEST }, priority = 77)
	public void androidSendLocationToGuestUser() throws Exception {
		conv_page_android.sendLocationToGuestInAConversation();
	}

	@Test(groups = { Constants.GUEST }, priority = 84)
	public void webInitiatesOneToOneCallToGuestUser() throws Exception {
		webGroupCall.init();
		webLoginTestCases.loginWithSecondWebUser(Config.getInstance().getGuestUser(),
				Config.getInstance().getIosUserPassword());
		webHDCall.netsfereUserMakesHDCallGuestUser();
//		webGroupCall.receivesGroupCall();
		webHDCall.acceptOneToOneCallFromSecondUser();
//		androidHdCall.incomingHDCallAssertion();
		webHDCall.endOngoingCallWeb();

	}

	@Test(groups = { Constants.GUEST }, priority = 86)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiatesOneToOneCallToGuestUser() throws Exception {
		androidHdCall.netsfereUserMakesHDCallToGuest();
		webHDCall.acceptOneToOneCallFromSecondUser();
//		webHDCall.incomingCallWebAssertion();
		androidHdCall.endOngoingCall();
	}

	@Test(groups = { Constants.GUEST }, priority = 88)
	@NavigateTo(WebConversationsPage.class)
	public void webMakesAGroupCallToGuestUser() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getGuestDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.endGroupCall();
	}

	@Test(groups = { Constants.GUEST }, priority = 89)
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
	
	@Test(groups = { Constants.GUEST }, priority = 90)
	@NavigateTo(WebConversationsPage.class)
	public void webCreateConversationWithExistingGuestUser() throws InterruptedException {
		conv.createConversationWithExistingGuestUser();
	}
	
	@Test(groups = { Constants.GUEST }, priority = 91)
	@NavigateTo(ConversationsPage.class)
	public void androidCreateConversationWithExistingGuestUser() throws Exception {
		conv_page_android.androidNetsfereUserCreateConvWithActivatedGuestUser();
	}
	
	@Test(groups = { Constants.GUEST }, priority = 92)
	@NavigateTo(WebConversationsPage.class)
	public void webAddGuestUserToExistingConversation() throws Exception {
		conv.addGuestUserToExistingConversation();
	}
	
	@Test(groups = { Constants.GUEST }, priority = 93)
	@NavigateTo(ConversationsPage.class)
	public void androidAddGuestUserToExistingConversation() throws InterruptedException {
		conv_page_android.addGuestToExistingConv();
	}
	
	@Test(groups = { Constants.GUEST }, priority = 94)
	@NavigateTo(WebConversationsPage.class)
	public void webRemoveGuestFromAConversation() throws Exception {
		conv.removeGuestUserFromExistingConversation();
	}
	
	@Test(groups = { Constants.GUEST }, priority = 95)
	@NavigateTo(ConversationsPage.class)
	public void androidRemoveGuestUserFromAConversation() throws Exception {
		conv_page_android.removeGuestFromConversation();
	}
	
	@Test(groups = { Constants.GUEST }, priority = 96)
	@NavigateTo(WebConversationsPage.class)
	public void webDestroyConversationWithGuest() throws InterruptedException {
		conv.destroyConversationWithGuest();
	}
	
	
	@Test(groups = { Constants.GUEST }, priority = 97)
	@NavigateTo(ConversationsPage.class)
	public void androidDestroyConversationWithGuest() throws Exception {
		conv_page_android.destroyConversationWithGuest();
	}

//	@Test(groups = { Constants.GUEST }, priority = 94)
	/*public void guestSendAttachementToNetsfereUserFromWeb() throws FindFailed, InterruptedException {
		conv.guestUserSendDocumentToNetsfereUser();
	}*/

	@Test(groups = { Constants.GUEST }, priority = 98)
	@NavigateTo(WebContactsPage.class)
	public void guestLabelInWeb() throws Exception {
		cont.guestLabelForGuestContact();
	}

	@Test(groups = { Constants.GUEST }, priority = 99)
	@NavigateTo(ContactsPage.class)
	public void guestLabelInAndroid() throws Exception {
		androidCont.guestLabelForGuestInContact();
	}



	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 100)
	@NavigateTo(WebChannelsPage.class)
	public void webSearchAndSelectChannelAndCancelChannel() throws Exception {
		webChannel.searchAndSelectChannelAndCancel();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 101)
	@NavigateTo(ChannelsPage.class)
	public void androidSearchAndSelectChannelAndCancelChannel() throws Exception {
		androidChannel.searchAndSelectChannelAndCancel();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 102)
	@NavigateTo(WebChannelsPage.class)
	public void webSendQuickReplyAndAndroidReads() throws InterruptedException {
		webChannel.sendQuickReply();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 103)
	@NavigateTo(ChannelsPage.class)
	public void androidSendQuickReplyAndWebReads() throws InterruptedException {
		androidChannel.sendQuickReply();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 104)
	@NavigateTo(WebChannelsPage.class)
	public void webSendLocationInWriteableChannel() throws InterruptedException {
		webChannel.sendLocationInChannel();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 105)
	@NavigateTo(ChannelsPage.class)
	public void androidSendLocationInWriteableChannel() throws InterruptedException {
		androidChannel.sendLocationInChannel();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 106)
	@NavigateTo(WebChannelsPage.class)
	public void webWritesToWriteableChannelAndAndroidReadsTheMessage() {
		webChannel.sendMessage();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 107)
	@NavigateTo(ChannelsPage.class)
	public void androidWritesToWriteableChannelAndWebReadsTheMessage() {
		androidChannel.sendMessage();

	}
/*
	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 108)
	@NavigateTo(WebChannelsPage.class)
	public void webSendAttachmentsToWritableChannAndroidReceive() throws InterruptedException, IOException {
		webChannel.sendAttachmentInChannel();
	}*/

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 109)
	@NavigateTo(WebChannelsPage.class)
	public void webStartBroadcastLiveAndEndBroadcastLive() throws InterruptedException {
		webChannel.startBroadcastLive();
		webChannel.endBroadcastLive();

	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 110)
	@NavigateTo(ChannelsPage.class)
	public void androidStartBroadcastLiveEndBroadcastLive() throws InterruptedException {
		androidChannel.startBroadcastLive();
		androidChannel.endBroadcastLive();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 111)
	@NavigateTo(WebChannelsPage.class)
	public void webCantWriteToAReadableChannel() throws Exception {
		webChannel.unableToSendMessageInReadonlyChannelOnWeb();
	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 112)
	@NavigateTo(ChannelsPage.class)
	public void androidCantWriteToAReadableChannel() throws Exception {
		androidChannel.unableToSendMessageInReadOnlyChannel();
	}
	
	/*@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 113)
	@NavigateTo(ChannelsPage.class)
	public void webSendMessageDuringLIVE() throws Exception {
		webChannel.webSendMessagesDuringLIVE();

	}

	@Test(groups = { Constants.CHANNEL_BROADCAST }, priority = 114)
	@NavigateTo(ChannelsPage.class)
	public void androidSendMessageDuringLIVE() throws Exception {
		webChannel.webSendMessagesDuringLIVE();
	}
	
*/

	
	/*
	 * Meeting Test Cases
	 * 
	 * 
	 */
	
	@Test(groups = { Constants.MEETING }, priority = 121)
	@NavigateTo(WebConversationsPage.class)
	public void webCreatingMeetingFromChatPage() throws Exception {
		webMeeting.createMeetingForLiveFromConversation();
	}

	@Test(groups = { Constants.MEETING }, priority = 122)
	@NavigateTo(MeetingPage.class)
	public void acceptMeetingFromAndroid() throws InterruptedException {
		androidMeeting.acceptMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 123)
	@NavigateTo(ConversationsPage.class)
	public void androidCreatingMeetingForLiveFromChatPage() {
		androidMeeting.createMeetingForLiveFromConversationPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 124)
	@NavigateTo(WebMeetingPage.class)
	public void acceptMeetingFromWeb() {
		webMeeting.acceptMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 125)
	@NavigateTo(WebMeetingPage.class)
	public void webCreatingMeetingForLiveFromMeetingPage() throws InterruptedException {
		webMeeting.createMeetingForLiveFromMeetingPage();
		// androidMeeting.acceptMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 126)
	@NavigateTo(MeetingPage.class)
	public void androidCreatingMeetingForLiveFromMeetingPage() throws Exception {
		androidMeeting.createMeetingForLiveFromMeetingPage();
		// webMeeting.acceptMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 127)
	@NavigateTo(WebMeetingPage.class)
	public void webStartLiveMeeting() throws InterruptedException {
		webMeeting.startMeetingForLive();
	}

	@Test(groups = { Constants.MEETING }, priority = 128)
	public void webStopLiveMeeting() {
		webMeeting.stopMeetingForLive();
	}

	@Test(groups = { Constants.MEETING }, priority = 129)
	@NavigateTo(WebMeetingPage.class)
	public void webStartOneToOneMeeting() throws InterruptedException {
		webMeeting.startMeetingFor1_1Call();
	}

	@Test(groups = { Constants.MEETING }, priority = 130)
	public void webStopOneToOneMeeting() {
		webMeeting.stopMeetingFor1_1Call();
	}

	@Test(groups = { Constants.MEETING }, priority = 131)
	@NavigateTo(WebMeetingPage.class)
	public void webStartGroupCallMeeting() throws InterruptedException {
		webMeeting.startMeetingForGroupCall();
	}

	@Test(groups = { Constants.MEETING }, priority = 132)
	public void webStopGroupCallMeeting() {
		webMeeting.stopMeetingForGroupCall();
	}

	@Test(groups = { Constants.MEETING }, priority = 133)
	@NavigateTo(MeetingPage.class)
	public void androidStartLiveMeeting() throws Exception {
		androidMeeting.startMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 134)
	public void androidStopLiveMeeting() {
		androidMeeting.stopMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 135)
	@NavigateTo(MeetingPage.class)
	public void androidStartOneToOneMeeting() {
		androidMeeting.start1_1CallMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 136)
	public void androidStopOneToOneMeeting() {
		androidMeeting.stop1_1CallMeeting();
	}
/*
	@Test(groups = { Constants.MEETING }, priority = 137)
	@NavigateTo(MeetingPage.class)
	public void androidStartGroupCallMeeting() {
		androidMeeting.startGroupCallMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 138)
	public void androidStopGroupCallMeeting() {
		androidMeeting.stopGroupCallMeeting();
	}
*/
	@Test(groups = { Constants.MEETING }, priority = 139)
	@NavigateTo(WebConversationsPage.class)
	public void webCreateMeetingForOneToOneCallFromConversation() throws Exception {
		webMeeting.createMeetingForHDCallFromConversation();
	}

	@Test(groups = { Constants.MEETING }, priority = 140)
	@NavigateTo(ConversationsPage.class)
	public void androidCreateMeetingForOneToOneCallFromConversation() {
		androidMeeting.createMeetingForHDCallFromConversationPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 141)
	@NavigateTo(WebMeetingPage.class)
	public void webCreateMeetingForOneToOneCallFromMeetingsPage() throws InterruptedException {
		webMeeting.createMeetingForHDCallFromMeetingPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 142)
	@NavigateTo(MeetingPage.class)
	public void androidCreateMeetingForOneToOneCallFromMeetingsPage() {
		androidMeeting.createMeetingForHDCallFromMeetingPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 143)
	@NavigateTo(WebConversationsPage.class)
	public void webCreateMeetingForGroupCallFromConversation() throws InterruptedException {
		webMeeting.createMeetingForHDGroupCallFromConversation();
	}

	@Test(groups = { Constants.MEETING }, priority = 144)
	@NavigateTo(ConversationsPage.class)
	public void androidCreateMeetingForGroupCallFromConversation() {
		androidMeeting.createMeetingForHDGroupCallFromConversationPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 145)
	@NavigateTo(WebMeetingPage.class)
	public void webCreateMeetingForGroupCallFromMeetingsPage() throws InterruptedException {
		webMeeting.createMeetingForGroupCallFromMeetingPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 146)
	@NavigateTo(MeetingPage.class)
	public void androidCreateMeetingForGroupCallFromMeetingsPage() {
		androidMeeting.createMeetingForHDGroupCallFromMeetingPage();
	}
/*
	@Test(groups = { Constants.MEETING }, priority = 147)
	@NavigateTo(WebConversationsPage.class)
	public void webCreateMeetingForOthersFromConversationsPage() throws InterruptedException {
		webMeeting.createMeetingForOthersFromConversation();
	}

	@Test(groups = { Constants.MEETING }, priority = 148)
	@NavigateTo(ConversationsPage.class)
	public void androidCreateMeetingForOthersFromConversationsPage() {
		androidMeeting.createMeetingForOthersFromConversationPage();
	}

	
	@Test(groups = { Constants.MEETING }, priority = 149)
	@NavigateTo(WebMeetingPage.class)
	public void webCreateMeetingForOthersFromMeetingsPage() throws InterruptedException {
		webMeeting.createMeetingForOthersFromMeetingPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 150)
	@NavigateTo(MeetingPage.class)
	public void androidCreateMeetingForOthersFromMeetingsPage() {
		androidMeeting.createMeetingForOthersFromMeetingPage();
	}

	@Test(groups = { Constants.MEETING }, priority = 151)
	@NavigateTo(WebMeetingPage.class)
	public void rejectMeetingFromWeb() throws Exception {
		androidMeeting.createMeetingForLiveFromMeetingPage();
		webMeeting.rejectMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 152)
	@NavigateTo(MeetingPage.class)
	public void rejectMeetingFromAndroid() throws Exception {
		webMeeting.createMeetingForHDCallFromMeetingPage();
		androidMeeting.rejectMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 153)
	@NavigateTo(WebMeetingPage.class)
	public void tentativelyAcceptMeetingFromWeb() throws Exception {
		androidMeeting.createMeetingForLiveFromMeetingPage();
		webMeeting.tentativeMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority =154)
	@NavigateTo(MeetingPage.class)
	public void tentativelyAcceptMeetingFromAndroid() throws Exception {
		webMeeting.createMeetingForHDCallFromMeetingPage();
		androidMeeting.tentativeMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 155)
	@NavigateTo(WebConversationsPage.class)
	public void webCancelMeeting() throws Exception {
		webMeeting.createMeetingForLiveFromConversation();
		webMeeting.cancelMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 156)
	@NavigateTo(MeetingPage.class)
	public void androidCancelMeeting() throws Exception {
		androidMeeting.createMeetingForLiveFromMeetingPage();
		androidMeeting.cancelMeeting();
	}

	@Test(groups = { Constants.MEETING }, priority = 157)
	@NavigateTo(WebMeetingPage.class)
	public void webDeletesMeeting() throws Exception {
		webMeeting.webDeleteMeetingFromList();
	}

	@Test(groups = { Constants.MEETING }, priority = 158)
	@NavigateTo(MeetingPage.class)
	public void androidDeletesMeeting() throws Exception {
		androidMeeting.androidDeleteMeetingFromTheMeetingList();
	}*/

//	@Test(groups = { Constants.MEETING }, priority = 159)
	public void webReceivesMOMAfterMeeting() {
		webMeeting.webReceivesMOM();
	}

//	@Test(groups = { Constants.MEETING }, priority = 160)
	public void androidReceivesMOMAfterMeeting() {
		androidMeeting.androidReceivesMOM();
	}

	/*
	 * Settings regression test cases
	 */

	@Test(groups = { Constants.SETTINGS }, priority = 161)
	public void webChangePassword() throws Exception {
		webSettingsTestCases.webCanChangePassword();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 162)
	public void androidChangePassword() throws Exception {
		androidSettingsTestCases.androidCanChangePassword();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 163)
	public void androidLogoutFromSettingsPage() throws Exception {
		androidSettingsTestCases.androidCanLogoutFromSettingPage();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 164)
	public void androidEnablePopUpNotification() throws Exception {
		androidSettingsTestCases.androidCanEnableNetsferePopNotification();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 165)
	public void androidDisablePopUpNotification() throws Exception {
		androidSettingsTestCases.androidCanDisableNetsferePopNotification();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 166)
	public void androidEnableNetsfereRingtone() throws Exception {
		androidSettingsTestCases.androidCanEnableNetsfereCallRingtone();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 167)
	public void androidDisableNetsfereRingtone() throws Exception {
		androidSettingsTestCases.androidCanDisableNetsfereCallRingtone();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 168)
	public void androidCanEditQuickReply() throws Exception {
		androidSettingsTestCases.androidCanEditQuickReply();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 169)
	public void webCanEditQuickReply() throws Exception {
		webSettingsTestCases.webCanEditQuickReply();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 170)
	public void androidCanConfigureVideoCaptureQuality() throws Exception {
		androidSettingsTestCases.androidCanConfigureVideoCaptureQuality();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 171)
	public void androidCanEditMeetingPointURL() throws Exception {
		androidSettingsTestCases.androidCanEditMeetingPointURL();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 172)
	public void webCanEditMeetingPointURL() throws Exception {
		webSettingsTestCases.webCanEditMeetingPointURL();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 173)
	public void androidCanEditMobileNumber() throws Exception {
		androidSettingsTestCases.androidCanEditMobileNumber();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 174)
	public void webCanNavigateToHelpPage() throws Exception {
		webSettingsTestCases.webCanNavigateToHelpPage();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 175)
	public void webCanNavigateToLegalAndPrivacyPage() throws Exception {
		webSettingsTestCases.webCanNavigateLegalAndPrivatePage();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 176)
	public void androidCanNavigateToLegalAndPrivacyPage() throws Exception {
		androidSettingsTestCases.androidCanNavigateToLegalOrPrivacyPage();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 177)
	public void webCanViewVersionInfo() throws Exception {
		webSettingsTestCases.webCanViewVersionInfo();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 178)
	public void androidCanViewVersionInfo() throws Exception {
		androidSettingsTestCases.androidCanViewVersionInfo();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 179)
	public void androidCanNavigateToOpenSourceLicences() throws Exception {
		androidSettingsTestCases.androidToNavigateToOpenSource();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 180)
	public void webCanViewDeveloperInfo() throws Exception {
		webSettingsTestCases.webCanViewDeveloperInfo();
	}

	@Test(groups = { Constants.SETTINGS }, priority = 181)
	public void androidCanViewDeveloperInfo() throws Exception {
		androidSettingsTestCases.androidCanViewDeveloperInfo();
	}

	/*
	 * Call test cases
	 */

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 182)
	@NavigateTo(ConversationsPage.class)
	public void androidInitiatesOneToOneCallAndWebAccepts() throws Exception {

		androidHdCall.initiateOneToOneCallFromOneToOneConversation();
		webHDCall.receivesIncomingCall();
		webHDCall.acceptIncomingCallWeb();
		androidHdCall.endOngoingCall();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 183)
	@NavigateTo(ContactsPage.class)
	public void androidInitiatesCallAndWebDeclines() throws Exception {
		androidHdCall.initiateCallFromContacts();
		webHDCall.receivesIncomingCall();
		webHDCall.declineIncomingCall();
				
		
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 184)
	@NavigateTo(ConversationsPage.class)
	public void webInitiatesOneToOneCallAndAndroidAccepts() throws InterruptedException {
		webHDCall.initiateOneToOneCallFromOneToOneConversationWeb();
		androidHdCall.receivesIncomingHDCall();
		androidHdCall.acceptIncomingCall();
		androidHdCall.endOngoingCall();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 185)
	public void webInitiatesCallAndAndroidRejects() throws Exception {
		webHDCall.initiateCallFromContacts();
		androidHdCall.receivesIncomingHDCall();
		androidHdCall.declineIncomingCall();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 186)
	public void webInitiatesCallAndMissedCallAtAndroid() throws Exception {
		// androidHdCall.clearAllAndroidNotifications();
		webHDCall.initiateCallFromContacts();
		androidHdCall.receivesIncomingHDCall();
		Utils.shortSleep();
		webHDCall.endUnansweredCall();
		androidHdCall.receivedMissedCallNotification();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 187)
	@NavigateTo(ContactsPage.class)
	public void androidInitiatesCallAndWebNoAnswer() throws Exception {
		androidHdCall.initiateCallFromContacts();
		webHDCall.receivesIncomingCall();
		Utils.shortSleep();
		androidHdCall.endOngoingCall();
		androidHdCall.callEnded();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 188)
	@NavigateTo(CallLogPage.class)
	public void androidInitiatesCallFromExistingCallLogs() throws Exception {
		androidHdCall.initiateOneToOneCallFromExistingCallLogs();
		androidHdCall.endOngoingCall();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 189)
	@NavigateTo(WebCallLogsPage.class)
	public void webInitiatesCallFromExistingCallLogs() throws Exception {
		webHDCall.initiateCallFromExistingCallLogs();
		webHDCall.endUnansweredCall();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 190)
	public void webDeleteAllCallLogs() throws InterruptedException {
		webHDCall.deleteAllCallLogs();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 191)
	public void webDeleteMultipleCallLogs() throws InterruptedException {
		webHDCall.deleteMultipleCallLogs();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 192)
	@NavigateTo(CallLogPage.class)
	public void androidDeleteAllCallLogs() {
		androidHdCall.deleteAllCallLogs();
	}
    
	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 193)
	public void webInitiateNewCallFromCallLogPage() throws InterruptedException {
		webHDCall.initiateCallFromCallLogs();
		webHDCall.endUnansweredCall();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 194)
	public void androidInitiateNewCallFromCallLogPage() {
		androidHdCall.initiateCallFromCallLogs();
		androidHdCall.endOngoingCall();
	}
       
	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 195)
	public void webMuteTheCall() throws Exception {
		webHDCall.initiateOneToOneCallFromOneToOneConversationWeb();
		androidHdCall.receivesIncomingHDCall();
		androidHdCall.acceptIncomingCall();
		webHDCall.muteCall();
		webHDCall.unMuteCall();
		webHDCall.endOngoingCallWeb();
	}
	/*@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 196, dependsOnMethods = { "webMuteTheCall" })
	public void webUnmuteTheCall() throws Exception {
		webHDCall.initiateOneToOneCallFromOneToOneConversationWeb();
		androidHdCall.receivesIncomingHDCall();
		androidHdCall.acceptIncomingCall();
		webHDCall.unMuteCall();
		webHDCall.endOngoingCallWeb();
	}*/
	
	
	

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 197, dependsOnMethods = { "webMuteTheCall" })
	public void webToggleSpeaker() throws Exception {
	    webHDCall.initiateOneToOneCallFromOneToOneConversationWeb();
		androidHdCall.receivesIncomingHDCall();
		androidHdCall.acceptIncomingCall();
		webHDCall.toggleSpeaker();
		webHDCall.endOngoingCallWeb();
		
	}
	
	/*
	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 198)
	@NavigateTo(ConversationsPage.class)
	public void androidSendsMessageDuringTheCall() throws Exception {
		androidSendingMessageInStreamlinedConversationUsingCreateButton();
		/*androidHdCall.initiateOneToOneCallFromOneToOneConversation();
		webHDCall.receivesIncomingCall();
		webHDCall.acceptIncomingCallWeb();
		androidHdCall.sendMessageDuringTheCall();
		androidHdCall.endOngoingCall();
	}

*/
	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 199)
	@NavigateTo(WebConversationsPage.class)
	public void webSendsMessageDuringCall() throws InterruptedException {
		
		
		webHDCall.initiateOneToOneCallFromOneToOneConversationWeb();
		androidHdCall.receivesIncomingHDCall();
		androidHdCall.acceptIncomingCall();
		webHDCall.sendMessageDuringTheCall();
		webHDCall.endOngoingCallWeb();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 200)
	@NavigateTo(CallLogPage.class)
	public void androidSearchMissedCallFromMissedCallTab() throws Exception {
		androidHdCall.searchMissedCallLogFromMissedCallTab();
	}

	@Test(groups = { Constants.ONE_TO_ONE_HD_CALL }, priority = 201)
	@NavigateTo(WebCallLogsPage.class)
	public void webSearchMissedCallFromMissedCallTab() throws Exception {
		webHDCall.searchMissedCallFromMissedCallTab();
	}

	@Test(groups = { Constants.GROUP_HD_CALL, Constants.QUICK_POLL }, priority = 202)
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
		webGroupCall.secondUserReceivesGroupCall();
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
		webGroupCall.secondUserReceivesGroupCall();
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
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.endGroupCall();

	}

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 207)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiatesAGroupCallAndParticipantsLeaveTheCall() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		androidGroupCall.leaveOngoingGroupCall();
		webGroupCall.leaveOngoingGroupCallFromSecondUser();
		webGroupCall.endGroupCall();

	}

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 208)
	@NavigateTo(WebConversationsPage.class)
	public void webInitiatesAGroupCallAndAndroidRejoinsTheCall() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		androidGroupCall.leaveOngoingGroupCall();
		androidGroupCall.rejoinTheGroupCall();
		webGroupCall.endGroupCall();

	}
	

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 209)
	@NavigateTo(WebConversationsPage.class)
	public void webOwnerCanMuteAllParticipants() throws InterruptedException {
		conv.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		webGroupCall.initiateGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.androidReceivesGroupCall();
		androidGroupCall.acceptGroupCall();
		webGroupCall.ownerCanMuteAllParticipants();
		webGroupCall.endGroupCall();
	}
	

	@Test(groups = { Constants.GROUP_HD_CALL }, priority = 210)
	@NavigateTo(ConversationsPage.class)
	public void androidOwnerCanMuteAllParticipants() throws Exception {
		conv_page_android.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(),
				Config.getInstance().getIosUserDisplayName());
		androidGroupCall.initiateGroupCall();
		webGroupCall.receivesGroupCall();
		webGroupCall.acceptGroupCall();
		webGroupCall.secondUserReceivesGroupCall();
		webGroupCall.acceptGroupCallFromSecondUser();
		androidGroupCall.ownerCanMuteAllParticipants();
		androidGroupCall.endGroupCall();

	}

	@Test(groups = { Constants.QUICK_POLL }, priority = 211)
	@NavigateTo(WebConversationsPage.class)
	public void createQuickPollFromWebAndParticipantsVote() throws InterruptedException {
		webQuickPoll.createPoll();
		androidQuickPoll.voteForPoll();
		webQuickPoll.voteForPollFromSecondWebUser();
		webQuickPoll.voteForPollToEnd();
		webQuickPoll.checkIfPollConcluded();
	}

	@Test(groups = { Constants.QUICK_POLL }, priority = 212)
	@NavigateTo(ConversationsPage.class)
	public void createQuickPollFromAndroidAndParticipantsVote() throws Exception {
		androidQuickPoll.createQuickPoll();
		webQuickPoll.voteForPoll();
		webQuickPoll.voteForPollFromSecondWebUser();
		androidQuickPoll.voteForPollToEnd();
		androidQuickPoll.checkIfPollConcluded();

	}

	@Test(groups = { Constants.CLEAN_UP }, priority = 213)
	public void webConversationCleanUp() {
		conv.webConversationCleanUp();
	}

	// @AfterMethod
	public void aftertest(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			String screenShot_Path = Screenshot.captureScreenShot(Driver.driver, result.getName());
			String image = logger.addScreenCapture(screenShot_Path);
			logger.log(LogStatus.FAIL, "Headers", image);
		}
	}

//	@AfterTest
//	public void reportSending() {
//		email.ReportSending();
//		DriverManager.getWebDriver().quit();
//	}

	
}
