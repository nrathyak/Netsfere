package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.ios.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.ios.test.ConversationTestCases;
import com.infinite.netsfere.automationtool.modules.ios.test.LoginTestCases;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.InitIOSSetup;
import com.infinite.netsfere.automationtool.utils.Utils;


public class IOSSanity  extends BaseIOSSuite {
	LoginTestCases loginTestCases;
	ConversationTestCases ConversationTestCases;
	@BeforeClass(alwaysRun = true)
	public void beforeClass()  throws IOException, InterruptedException{
			super.beforeClass();		
			loginTestCases = new LoginTestCases();
			ConversationTestCases = new ConversationTestCases();
			loginTestCases.init();
			ConversationTestCases.init();
	}
	
	//Login related
		@Test(groups={Constants.GROUP_LOGIN}, priority=1)
		public void goToLoginScreen() throws IOException{
//			loginTestCases.CancelAppUograde();
			Utils.shortSleep();
			loginTestCases.goToLoginScreen();
		}
		
		@Test(groups={Constants.GROUP_LOGIN, Constants.GROUP_NEGATIVE_TEST}, priority=2)
		public void loginWithInValidCredentials() throws IOException {
			loginTestCases.loginWithInValidCredentials();	
			
		}
		
		
		
		
		@Test(groups={Constants.GROUP_LOGIN}, priority=3)
		public void loginWithValidCredentials() throws IOException {
			loginTestCases.loginWithValidCredentials();	
			
		}
		
//		@Test(groups={Constants.GROUP_CONVERSATION}, priority=3)
//		public void searchNetc() {
//			ConversationTestCases.scrollDownConversationList();	
//			ConversationTestCases.gotoNetc();
//			// to be removed later
//			//XCUIElementTypeButton[@name="Back"]
//			Utils.shortSleep();
//			
//			ConversationTestCases.gotoConversationspage();
//			ConversationTestCases.cancelConversationSearch();			
//		
//		}
		
//		@Test(groups={Constants.GROUP_CONVERSATION}, priority=4)
//		public void gotoFirstConversation() throws IOException {
//			ConversationTestCases.gotoFirstConversation();
//			Utils.shortSleep();
//			ConversationTestCases.gotoConversationspage();		
//		}
		
		/*@Test(groups={Constants.GROUP_CONVERSATION}, priority=5)
		public void createNewConversation() throws IOException {
			ConversationTestCases.createnewSelfConversation();
			Utils.shortSleep();				
		}*/
		
		@Test(groups={Constants.GROUP_CONVERSATION}, priority=5)
//		@Parameters("participants")
//		public void createNewConversation( String participants) throws Exception {
		public void createNewConversation() throws Exception {
//			ConversationTestCases.createnewConversationWithParticipants(participants);
			ConversationTestCases.createnewConversationWithParticipants();
			Utils.shortSleep();	
			ConversationTestCases.sendMessage();
			ConversationTestCases.chatDetails();
		}
		
//		@Test(groups={Constants.GROUP_CONVERSATION}, priority=5)
//		public void gotoNetc() {
//			ConversationTestCases.gotoNetc();
//		}
			

}
