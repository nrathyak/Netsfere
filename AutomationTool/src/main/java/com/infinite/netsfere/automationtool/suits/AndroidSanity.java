package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.android.pages.ChannelsPage;
import com.infinite.netsfere.automationtool.modules.android.test.ChannelTestCase;
import com.infinite.netsfere.automationtool.modules.android.test.ConversationTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.HDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.modules.android.test.LoginTestCases;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.Utils;

public class AndroidSanity extends BaseAndroidSuite {

	LoginTestCases loginTestCases;
	ConversationTestCases conversationTestCases;
	HDOneToOneCallTestCases hDOneToOneCallTestCases;
	ChannelTestCase channelTestCase;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass()  throws IOException, InterruptedException{
		super.beforeClass();
		loginTestCases = new LoginTestCases();
		loginTestCases.init();
		conversationTestCases = new ConversationTestCases();
		conversationTestCases.init();
		hDOneToOneCallTestCases = new HDOneToOneCallTestCases();
		hDOneToOneCallTestCases.init();
		channelTestCase = new ChannelTestCase();
		channelTestCase.init();
	}
	
	//Login related
	@Test(groups={Constants.GROUP_LOGIN}, priority=1)
	public void goToLoginScreen() throws IOException, InterruptedException{
		loginTestCases.goToLoginScreen();
	}
	
	@Test(groups={Constants.GROUP_LOGIN, Constants.GROUP_NEGATIVE_TEST}, priority=2)
	public void loginWithInValidCredentials() throws IOException {
		loginTestCases.loginWithInValidCredentials();					
	}
	
	@Test(groups={Constants.GROUP_LOGIN}, priority=3)
	public void loginWithValidCredentials() throws IOException {
		loginTestCases.loginWithValidCredentials(Config.getInstance().getAndroidUserEamil(),
				Config.getInstance().getAndroidUserPassword());		
	}
	
	//Conversation related	
	@Test(groups={Constants.GROUP_CONVERSATION}, priority=5)
	public void createConversationWithoutTitle() throws IOException{
		conversationTestCases.createConversationWithoutTitle();
	}
	
	@Test(groups={Constants.GROUP_CONVERSATION}, priority=6)
	public void updateExistingConversationTitleFromChatScreen() throws IOException{
		conversationTestCases.updateExistingConversationTitleFromChatScreen();
	}
	
	@Test(groups={Constants.GROUP_CONVERSATION}, priority=7)
	public void sendMessageFromChatScreen() throws IOException{
		conversationTestCases.sendMessageFromChatScreen();
	}
	
	@Test(groups={Constants.GROUP_CONVERSATION}, priority=8)
	public void searchForRandomConversationAndOpen() throws IOException{
		conversationTestCases.searchForRandomConversationAndOpen();
	}
	
	@Test(groups={Constants.GROUP_CONVERSATION}, priority=9)
	@Parameters("title")
	public void searchForParticularConversationAndOpen(String title) throws IOException{
		conversationTestCases.searchForParticularConversationAndOpen(title);
	}
	
	// HD one to one call related
	@Test(groups={Constants.ONE_TO_ONE_HD_CALL}, priority=10)
	public void initiateOneToOneCallFromOneToOneConversation() throws Exception {
		hDOneToOneCallTestCases.initiateOneToOneCallFromOneToOneConversation();
		hDOneToOneCallTestCases.endOngoingCall();
	}
	
	@Test(groups={Constants.ONE_TO_ONE_HD_CALL}, priority=11)
	public void initiateCallFromContacts() throws Exception {
		hDOneToOneCallTestCases.initiateCallFromContacts();
		hDOneToOneCallTestCases.endOngoingCall();
	}
	
	@Test(groups={Constants.ONE_TO_ONE_HD_CALL}, priority=12)
	public void initiateCallFromCallLogs() {
		hDOneToOneCallTestCases.initiateCallFromCallLogs();
		hDOneToOneCallTestCases.endOngoingCall();
	}
	
	@Test(groups={Constants.ONE_TO_ONE_HD_CALL}, priority=13)
	public void deleteMultipleCallLogs() {
		hDOneToOneCallTestCases.deleteMultipleCallLogs();
	}
	
	@Test(groups={Constants.ONE_TO_ONE_HD_CALL}, priority=14)
	public void deleteAllCallLogs() {
		hDOneToOneCallTestCases.deleteAllCallLogs();
	}
	
	//Channel Test cases
	@Test(groups={Constants.CHANNEL_BROADCAST}, priority = 15)
	@NavigateTo(ChannelsPage.class)
	public void searchForChannel() {
		channelTestCase.searchAndSelectChannelAndCancel();
	}
	
	@Test(groups={Constants.CHANNEL_BROADCAST}, priority = 16)
	@NavigateTo(ChannelsPage.class)
	public void sendQuickReply() {
		channelTestCase.sendQuickReply();
	}
	///logout tc add 
	
}