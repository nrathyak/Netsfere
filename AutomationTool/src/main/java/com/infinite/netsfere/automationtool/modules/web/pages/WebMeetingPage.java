package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.web.test.WebHDOneToOneCallTestCases;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebMeetingPage implements BasePage {

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webIo;
	WebHdOneToOneCallElements hdCall;
	private static Logger log = LogManager.getLogger(WebMeetingPage.class.getName());

	public WebMeetingPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webIo = new WebIoOperations();
		hdCall = new WebHdOneToOneCallElements();

	}

	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='sideBarMenu']//div[@title='Meetings']/button")
	public WebElement meetingIconNavigationLink;

	@FindBy(xpath = "//img[@alt='Create Meeting']")
	public WebElement createNewMeetingButton;

	@FindBy(xpath = "//div[@class='table-view']/div[2]//span[@class='icon ion-android-delete']")
	public WebElement deleteRecentMeeting;

	@FindBy(xpath = "//span[.='delete']")
	public WebElement deleteText;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Meeting Title']")
	public WebElement meetingTitleTextBox;

	@FindBy(xpath = "//textarea[@class='namegenTextLong']")
	public WebElement meetingDescriptionTextBox;

	@FindBy(xpath = "//div[@class='mainDiv']//div[3]//div[2]/div[1]/div/div[2]/select[@name='']")
	public WebElement meetingTypeElement;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Meeting Location']")
	public WebElement meetingLocation;

	@FindBy(xpath = "//span[text()='Create']")
	public WebElement createMeeting;

	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElement cancelWhileCreatingMeeting;

	@FindBy(xpath = "//input[@type='text' and @item= 'contacts']")
	public WebElement searchContactTextBox;

//      @FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[@class='scrollbox']/div[@class='table-view']/div[4]//div[@class='click-ripple']")
	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[@class='scrollbox']/div[@class='table-view']/div[4]/div")
	public WebElement selectContact;

	@FindBy(xpath = "//span[text()='Start Meeting']")
	public WebElement startMeeting;

	@FindBy(xpath = "//span[text()='Cancel Meeting']")
	public WebElement cancelMeeting;

	@FindBy(xpath = "//textarea[@class='namegenTextLong' and @placeholder='Meeting canceled. You cannot send messages.']")
	public WebElement cancelledMeetingText;

	@FindBy(xpath = "//div[@class='mainDiv']//div[1]//button[4]/img[@src='/images/live/stopBroadcastBtn@3x.png']")
	public WebElement stopMeeting;

	@FindBy(xpath = "//span[text()='End Meeting']")
	public WebElement endMeeting;

	/*
	 * @FindBy(
	 * xpath="//div[text()='Are you sure you want to end this meeting ? If you want to share Meeting Minutes please click cancel and then end meeting.']"
	 * ) public WebElement endMeetingConfirmation;
	 */
	@FindBy(xpath = "//div[text()='Confirm End Meeting']")
	public WebElement endMeetingConfirmation;

	@FindBy(xpath = "//div[text()='Please note any media associated with this meeting will be terminated']//..//span[text()='End Meeting']")
	public WebElement endMeetingButton;

	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[2]/div")
	public WebElement firstCreatedMeeting;

	@FindBy(xpath = "//span[@class='icon ion-gear-a']")
	public WebElement meetingSettingButton;

	@FindBy(xpath = "//span[text()='Save']")
	public WebElement saveButton;

	@FindBy(xpath = "//input[text()='text']")
	public WebElement searchTextBox;

	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[2]/div")
	public WebElement recentMeeting;

	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[2]/div/div[3]/div[1]/div[3]")
	public WebElement newMeetingTag;

	@FindBy(xpath = "//span[text()='Accept']")
	public WebElement acceptButton;

	@FindBy(xpath = "//span[text()='Reject']")
	public WebElement rejectButton;

	@FindBy(xpath = "//span[text()='Tentative']")
	public WebElement tentativeButton;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[1]/div[@class='scrollbox']/div[@class='table-view']//span[@title='LIVE']")
	public WebElement liveLabelInMeeting;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[2]/span")
	public WebElement meetingTitle;

	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span[contains(text(),'This is an invitation for a  meeting')]")
	public WebElement meetingMOM;

	@FindBy(xpath = "//div[text()='DONE']")
	public WebElement doneStatus;

	@FindBy(xpath = "//div[text()='CANCELED']")
	public WebElement canceledStatus;

	@FindBy(xpath = "//div[text()='STARTED']")
	public WebElement startedStatus;

	/*
	 * Changes as per 4.4 clients
	 */

	@FindBy(xpath = "//div[text()='Confirm End Meeting']")
	public WebElement confirmEndMeeting;

	@FindBy(xpath = "//div[text()='Confirm End Meeting']//..//span[text()='End Meeting']")
	public WebElement endMeetingFinal;

	@FindBy(xpath = "//span[text()='Select Ring Participants']/../../..//div[@class='table-view']/div[1]/div")
	public WebElement selectParticipantDuringCall;

	public void clickingOnParticipant() {
		selectParticipantDuringCall.click();
	}

	public String doneStatusAssertion() {
		List<WebElement> doneStatus_list = driver.findElements(By.xpath("//div[text()='DONE']"));
		String s1 = doneStatus_list.get(0).getText();
		return s1;

	}

	public String cancelStatusAssertion() {
		List<WebElement> cancelStatus_list = driver.findElements(By.xpath("//div[text()='CANCELED']"));
		String s1 = cancelStatus_list.get(0).getText();
		return s1;

	}

	public String startedStatusAssertion() {
		List<WebElement> startedStatus_list = driver.findElements(By.xpath("//div[text()='STARTED']"));
		String s1 = startedStatus_list.get(0).getText();
		return s1;

	}

	public void meetingNavigatorLink() {
		meetingIconNavigationLink.click();
	}

	public void createNewMeetingIcon() {
		Utils.shortSleep();
		createNewMeetingButton.click();
	}

	public void meetingTitleTextBox(String meetingTitle) {
		meetingTitleTextBox.sendKeys(meetingTitle);
	}

	public void meetingDescriptionTextBox(String meetingDescription) {
		meetingDescriptionTextBox.sendKeys(meetingDescription);
	}

	public void meetingTypeSelect(int meetingType) {
		webIo.Select(meetingTypeElement, meetingType);
		webIo.Select(meetingTypeElement, meetingType);
	}

	public void meetingLocationTextBox(String meetingLocationText) {
		meetingLocation.sendKeys(meetingLocationText);
	}

	public void searchAndSelectContact(String userName) throws InterruptedException {
		searchContactTextBox.click();
		searchContactTextBox.sendKeys(userName);
		webIo.ActionsSpaceAndBackspace();
		Utils.shortSleep();
		selectContact.click();

	}

	public void createMeeting() {
		createMeeting.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Start Meeting']")));

	}

	public void startMeeting() {
		startMeeting.click();
		// webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mainDiv']//div[1]//button[4]/img[@src='/images/live/stopBroadcastBtn@3x.png']")));
		webwait.until(ExpectedConditions.visibilityOf(liveLabelInMeeting));
	}

	public void startMeetingForCall() {
		startMeeting.click();
	}

	public void cancelMeeting() {
		if (cancelMeeting.isDisplayed()) {
			cancelMeeting.click();
		}
	}

	public void stopMeeting() {
		webwait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='mainDiv']//div[1]//button[4]/img[@src='/images/live/stopBroadcastBtn@3x.png']")));
		stopMeeting.click();
		endMeeting.click();
		if (confirmEndMeeting.isDisplayed()) {
			endMeetingFinal.click();
		}
	}

	public void stopHDCallMeeting() {
		endMeeting.click();
		Utils.veryShortSleep();
		if (endMeetingConfirmation.isDisplayed()) {
			endMeetingButton.click();
		}
	}

	public void searchMeeting(String meetingName) {
		searchTextBox.click();
		searchTextBox.sendKeys(meetingName);

	}

	public void clickRecentMeeting() {
		if (newMeetingTag.isDisplayed())
			recentMeeting.click();
	}

	public void clickAcceptButton() {
		acceptButton.click();
	}

	public void clickRejectButton() {
		rejectButton.click();
	}

	public void clickDeleteIcon() {
		try {
			if (deleteRecentMeeting.isDisplayed()) {
				deleteRecentMeeting.click();
				Utils.veryShortSleep();
				deleteText.click();
			}
		} catch (Exception e) {
			log.info(e.getClass());
		}
	}

	public boolean isAt() {
		try {
			return driver.getCurrentUrl().contains("https://web.netsferetest.com/#/meetings");
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Not in meetings Page");
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// TODO Auto-generated method stub
		WebNavigationBar.getInstance().navigateToMeetingsPage();
	}

	public void clickTentativeButton() {
		tentativeButton.click();
	}

}
