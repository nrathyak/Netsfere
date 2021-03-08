package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;



public class WebQuickPollPage {

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebDriver secondDriver;
	WebConversationsPage conversationPage;
	WebChatPage chatPage;
	WebAttachmentFromDevicePage attachmentPage;
	
	
	public WebQuickPollPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		conversationPage = new WebConversationsPage();
		chatPage = new WebChatPage();
		attachmentPage = new WebAttachmentFromDevicePage();
	}
	

	@FindBy(xpath="//span[contains(text(),'Vote in Poll')]")
	public WebElement voteInPollPage;
	
	@FindBy(xpath="//button[contains(text(),'Vote')]")
	public WebElement voteButton;

	@FindBy(xpath="//span[contains(text(),'New Poll')]")
	public WebElement newPollPage;
	
	@FindBy(xpath="//textarea[@placeholder='Enter poll question']")
	public WebElement pollQuestion;
	
	@FindBy(xpath="//input[@placeholder='Answer 1']")
	public WebElement firstAnswer;
	
	@FindBy(xpath="//input[@placeholder='Answer 2']")
	public WebElement secondAnwer;
	
	@FindBy(xpath="//input[@placeholder='Answer 3']")
	public WebElement thirdAnswer;
	
	@FindBy(xpath="//input[@placeholder='Answer 4']")
	public WebElement fourthAnswer;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	public WebElement createPoll;
	

	@FindBy(xpath="//span[contains(text(),'Poll Results')]")
	public WebElement pollResultsPage;
	
	@FindBy(xpath="//div[contains(text(),'Poll closed')]")
	public WebElement pollClosed;
	
	public void clickOnPollCreated() {
		conversationPage.pollLabel.click();
		Utils.veryShortSleep();
	}
	
	public void voteForPoll() throws InterruptedException {
		if(chatPage.activePoll.isDisplayed()) {
			chatPage.activePoll.click();
			Thread.sleep(2000);
			if(voteInPollPage.isDisplayed()) {
				List<WebElement> pollList = driver.findElements(By.xpath("//span[@class='icon ion-android-radio-button-off']"));
				if(pollList.size()>=1)
				{
					Thread.sleep(3000);
					pollList.get(0).click();
					
				}
			}
			voteButton.click();
		}
	}
	
	
	public void voteForPollFromSecondUser() throws InterruptedException {
		this.secondDriver = DriverManager.getSecondWebDriver();
		secondDriver.findElement(By.xpath("//span[@title='POLL']")).click();
		Utils.shortSleep();
		if(secondDriver.findElement(By.xpath("//span[contains(text(),'Active Poll')]")).isDisplayed()) {
			secondDriver.findElement(By.xpath("//span[contains(text(),'Active Poll')]")).click();
			Thread.sleep(2000);
			if(secondDriver.findElement(By.xpath("//span[contains(text(),'Vote in Poll')]")).isDisplayed()) {
				List<WebElement> pollList1 = secondDriver.findElements(By.xpath("//span[@class='icon ion-android-radio-button-off']"));
				if(pollList1.size()>=1)
				{
					Thread.sleep(3000);
					pollList1.get(1).click();
					
				}
			}
			secondDriver.findElement(By.xpath("//button[contains(text(),'Vote')]")).click();
		}
		Utils.veryShortSleep();
		Assert.assertEquals(true, secondDriver.findElement(By.xpath("//span[contains(text(),'Change vote')]")).getText().contains("Change vote"));
		
	}

	
	public void clickOnCreatePoll() {
		Utils.veryShortSleep();
		attachmentPage.createPollButton.click();
	}

	public void createPoll() {
		Utils.veryShortSleep();
		if(newPollPage.isDisplayed()) {
			pollQuestion.sendKeys(Config.getInstance().getKeyQuickpollquestion());
			firstAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswerone());
			secondAnwer.sendKeys(Config.getInstance().getKeyQuickpollanswertwo());
			thirdAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswerthree());
			fourthAnswer.sendKeys(Config.getInstance().getKeyQuickpollanswerfour());
			createPoll.click();
			Utils.shortSleep();
		}
	}
	
	public void pollClosed() {
		chatPage.concludedPoll.click();
		Utils.veryShortSleep();
	}
}
