package com.infinite.netsfere.automationtool.modules.android.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.QuickPollPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class QuickPollTestCases extends BaseTestCases {

	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	ConversationTestCases convTestCases;
	ChatPage chatPage;
	QuickPollPage quickPoll;
	
	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		convTestCases =  new ConversationTestCases();
		convTestCases.init();
		chatPage =  new ChatPage();
		quickPoll = new QuickPollPage();
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void createQuickPoll() throws Exception {
		convTestCases.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(), Config.getInstance().getIosUserDisplayName());
		chatPage.clickOnInsertAttachment();
		Utils.veryShortSleep();
		chatPage.clickOnCreatePoll();
		quickPoll.createPoll();
		Utils.veryShortSleep();
		Assert.assertEquals(true, chatPage.activePoll.getText().contains("Active Poll"));
		
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void voteForPoll() {
		//Utils.navigateToHomeScreen(driver);
		quickPoll.clickOnPollIcon();
		Assert.assertEquals(true, chatPage.activePoll.getText().contains("Active Poll"));
		chatPage.clickOnActivePoll();
		quickPoll.voteForPoll();
		Assert.assertEquals(true, quickPoll.changeVoteButton.getText().contains("Change Vote"));
		Utils.navigateToHomeScreen(driver);
	}
	
	@Test
	@NavigateTo(ConversationsPage.class)
	public void voteForPollToEnd() {
//		quickPoll.clickOnPollIcon();
		Assert.assertEquals(true, chatPage.activePoll.getText().contains("Active Poll"));
		chatPage.clickOnActivePoll();
		quickPoll.voteForPoll();
		Assert.assertEquals(true, quickPoll.concludedPoll.getText().contains("Tap to see more detail") );		
	}
	@Test
	public void netsfereUserCreateAQuickPollWithGuest() throws Exception
	{
		convTestCases.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(), Config.getInstance().getGuestUser());
		chatPage.clickOnInsertAttachment();
		Utils.veryShortSleep();
		chatPage.clickOnCreatePoll();
		quickPoll.createPoll();
		Utils.veryShortSleep();
		Assert.assertEquals(true, chatPage.activePoll.getText().contains("Active Poll"));
	}
	@Test
	public void guestUserCreatePollWithNetsfereUser() throws Exception
	{
		convTestCases.createGroupConversationWithTitle(Config.getInstance().getWebUserDisplayName(), Config.getInstance().getAndroidUserDisplayName());
		chatPage.clickOnInsertAttachment();
		Utils.veryShortSleep();
		chatPage.clickOnCreatePoll();
		quickPoll.createPoll();
		Utils.veryShortSleep();
		Assert.assertEquals(true, chatPage.activePoll.getText().contains("Active Poll"));
	}
	
	
	@Test
	public void checkIfPollConcluded() {
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		quickPoll.pollConcludedCheck();
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_CHAT_SCREEN);
		Utils.navigateToHomeScreen(driver);
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);
	}
	
	
}
