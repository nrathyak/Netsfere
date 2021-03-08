package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class QuickPollPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	ChatPage chatPage;
	
	public QuickPollPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		chatPage = new ChatPage();
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='New Poll']")
	public WebElement newPollPage;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/poll_question_editView']")
	public WebElement pollQuestion;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Answer 1']")
	public WebElement firstAnswer;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Answer 2']")
	public WebElement secondAnswer;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Answer 3']")
	public WebElement thirdAnswer;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Answer 4']")
	public WebElement fourthAnswer;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/poll_multiple_choice_switch']")
	public WebElement multipleChoice;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/poll_show_results_switch']")
	public WebElement showResults;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@resource-id='com.infinite.netsfere:id/poll_time_limit_spinner']")
	public WebElement pollTimeSet;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/poll_create_button']")
	public WebElement createPollButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/poll_image']")
	public WebElement pollIcon;
	
	@AndroidFindBy(uiAutomator = "text(\"Vote in Poll\")")
	public WebElement voteInPollPage;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@index='0']")
	public WebElement firstOption;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/poll_vote_button']")
	public WebElement voteButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/poll_tap_textView']")
	public WebElement changeVoteButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/poll_more_info_textView']")
	public WebElement concludedPoll;
	
	@AndroidFindBy(uiAutomator = "text(\"Poll Results\")")
	public WebElement pollResultsPage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/poll_time_limit_text_view']")
	public WebElement pollClosed;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/poll_vote_button']")
	public WebElement dismissPoll;
	/*
	 * functions
	 */
	public void createPoll() {
		Utils.veryShortSleep();
		if(newPollPage.isDisplayed()) {
			pollQuestion.sendKeys(Config.getInstance().getKeyQuickpollquestion());
			firstAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswerone());
			secondAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswertwo());
			thirdAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswerthree());
			fourthAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswerfour());
//			driver.navigate().back();
			createPollButton.click();
		}
		Utils.shortSleep();
	}
	
	public void clickOnPollIcon() {
		pollIcon.click();
	}
	
	public void voteForPoll() {
		if(voteInPollPage.isDisplayed()) {
			firstOption.click();
		}
		voteButton.click();
		Utils.veryShortSleep();
	}
	
	public void pollConcludedCheck() {
		concludedPoll.click();
		if(pollResultsPage.isDisplayed()) {
			Assert.assertEquals(true, pollClosed.getText().contains("Poll closed"));
		}
		
		dismissPoll.click();
		Utils.veryShortSleep();
	}
	
	
	
}
