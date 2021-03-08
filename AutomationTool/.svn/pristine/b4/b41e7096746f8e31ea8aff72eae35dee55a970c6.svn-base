package com.infinite.netsfere.automationtool.modules.web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.web.pages.WebAttachmentFromDevicePage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebQuickPollPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

public class WebQuickPollTestCases {

	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	WebDriver driver;
	WebQuickPollPage quickPoll;
	WebConversationTestCases convCases;
	WebConversationsPage convPage;
	WebChatPage webChatPage;

	@BeforeClass
	public void init() {
		driver = DriverManager.getWebDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		quickPoll = new WebQuickPollPage();
		convCases = new WebConversationTestCases();
		convCases.init();
		convPage = new WebConversationsPage();
		webChatPage = new WebChatPage();

	}

	@Test
	public void voteForPollToEnd() throws InterruptedException {
		quickPoll.clickOnPollCreated();
		quickPoll.voteForPoll();
		Utils.veryShortSleep();
		Assert.assertEquals(true, webChatPage.concludedPoll.getText().contains("Click or tap to see more detail"));
	}

	@Test
	public void voteForPoll() throws InterruptedException {
		quickPoll.clickOnPollCreated();
		quickPoll.voteForPoll();
		Utils.veryShortSleep();
		Assert.assertEquals(true, webChatPage.changeVoteButton.getText().contains("Change vote"));
	}

	@Test
	public void voteForPollFromSecondWebUser() throws InterruptedException {
		quickPoll.voteForPollFromSecondUser();
	}

	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createPoll() throws InterruptedException {
		convCases.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getIosUserDisplayName());
		webChatPage.addButtonClick();
		quickPoll.clickOnCreatePoll();
		quickPoll.createPoll();
		Assert.assertEquals(true, webChatPage.activePoll.getText().equals("Active Poll"));
	}

	@Test
	public void checkIfPollConcluded() {
		quickPoll.pollClosed();
		if(quickPoll.pollResultsPage.isDisplayed()) {
			Assert.assertEquals(true, quickPoll.pollClosed.getText().contains("Poll closed "));
		}
	}
	@Test
	public void netsfereUserCreateAQuickPollWithGuest() throws InterruptedException
	{
		convCases.groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getGuestUser());
		webChatPage.addButtonClick();
		quickPoll.clickOnCreatePoll();
		quickPoll.createPoll();
		Assert.assertEquals(true, webChatPage.activePoll.getText().equals("Active Poll"));
		
		
	}

	
		
	
}
