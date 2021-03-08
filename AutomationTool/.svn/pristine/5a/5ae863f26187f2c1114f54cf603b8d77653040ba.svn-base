package com.infinite.netsfere.automationtool.modules.android.pages;



import java.nio.file.WatchEvent;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CallLogPage extends GenericListPage implements BasePage {
	
	

	private static final String PAGE_TITLE = "Calls";
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	ConversationsPage convPage = new ConversationsPage();
	private static Logger log = LogManager.getLogger(GenericListPage.class.getName());

	public CallLogPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//@AndroidFindBy(uiAutomator = "text(\"Calls\")")
	
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_calls' and @index='1']")
	public WebElement calLogPage;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']")
	public WebElement firstCallLog;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']")
	public WebElement firstCallLogContact;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/call_button']")
	public WebElement callButtonCallLog;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/display_picture_imageview']")
	public WebElement listOfCallLogContacts;

	//@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/new_call_fab']")
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/new_call_fab' and @text='Make call']")
	public WebElement newCallButton;
	
	

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.infinite.netsfere:id/search_contacts_text_input']")
	public WebElement searchContact;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/call_button']")
	public WebElement initiateCallButton;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']")
	public WebElement firstContact;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']")
	public WebElement secondContact;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/delete_call_log']")
	public WebElement deleteLogs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_search']")
	public WebElement moreOptionButton;
	
                        	

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/title' and @index='0']")
	public WebElement selectAllButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/no_calls']")
	public WebElement noCalls;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Missed Call']")
	public WebElement missedCallNotification;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.android.systemui:id/clear_all']")
	public WebElement clearAllNotification;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_search']")
	public WebElement searchCallLog;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/search_src_text']")
	public WebElement enterContactInCallLog;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@resource-id='com.infinite.netsfere:id/spinner_nav']")
	public WebElement callOptions;
	
	/*@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Missed']")
	public WebElement missedCallTab;*/
	
	@AndroidFindBy(xpath="//android.widget.CompoundButton[@index='1']")
	public WebElement missedCallTab;
	
	 @AndroidFindBy(xpath="android.widget.LinearLayout[@index='0']")
     public WebElement firstMissedCall;
	 
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Collapse']")
	public WebElement backButton;
	
	
	
	
	
	
	public void clickOnFirstMissedCall()
	{
		firstMissedCall.click();
	}
	
	
	
	
	public void getListOfCallLogs() {
		List<AndroidElement> myElements = driver.findElements(By.xpath(
				"//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/display_picture_imageview']"));

	}

	public void clickOnNewCallButton() {
		newCallButton.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//android.widget.EditText[@resource-id='com.infinite.netsfere:id/search_contacts_text_input']")));
	}

	public void searchContactIncallLogsAndInitiateCall() {
		searchContact.sendKeys(Config.getInstance().getWebUserDisplayName());
		Utils.veryShortSleep();
		initiateCallButton.click();
	}

	public List<AndroidElement> listOfCallLogs() {
		List<AndroidElement> li = driver.findElements(By.xpath(
				"//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/display_picture_imageview' and @index='0']"));
		return li;

	}
	
	public void checkIfNoCallLogsPresentAndSearchForContact(String contact) throws Exception {
		try {
			if(noCalls.isDisplayed()) {
				log.info("No Missed call logs present");
			}	
		}catch(Exception e) {
			
		searchForAndSelect(contact);
			
			Utils.veryShortSleep();
		log.error("Searched Call log not present");	
		}
	}

	public void deleteMultipeCallLogs() {

		List<AndroidElement> callLogs = listOfCallLogs();
		if (callLogs.size() > 1) {
			Utils.longPressElement(callLogs.get(0));
			Utils.longPressElement(callLogs.get(1));
			deleteLogs.click();
		}

		else {
			log.info("No Multiple call logs to delete");
		}
	}

	public void deleteAllCallLogs() {
		List<AndroidElement> callLogs = listOfCallLogs();
		if (callLogs.size() > 0) {
			Utils.longPressElement(callLogs.get(0));
			moreOptionButton.click();
			selectAllButton.click();
			deleteLogs.click();
		} else {
			log.info("No Call Logs to delete");
		}
	}

	public void openNotificationsInAndroidAndValidateMissedCall() throws InterruptedException {
		driver.openNotifications();

		try {
			if (missedCallNotification != null) {
				log.info("Missed call notification is present...");
				missedCallNotification.click();
				Thread.sleep(5000);
			}
		} catch (NoSuchElementException e) {
			log.error("Notification does not exist...");
		}
	}

	public void clearALlNotification() {
		driver.openNotifications();
		Utils.veryShortSleep();
		if (clearAllNotification.isEnabled()) {
			clearAllNotification.click();
		}
	}
		public void clickOnSearchCallLog() {
		searchCallLog.click();
	}
	public void enterContactInCallLog(String contactName) {
		enterContactInCallLog.sendKeys(contactName);
	}
	
	public void clickOnFirstCallButtonInTheList() {
		List<AndroidElement> callList = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/call_button' and @index='6']"));
		if(callList.size()>=1) {
			callList.get(0).click();
		}else {
			log.info("No existing Call logs");
		}
		
	}
	
	public void clickOnCallOptions() {
		callOptions.click();
	}
	
	public void clickOnMissedCallTab() {
		missedCallTab.click();
	}
	
	public void clickOnBackButton() {
		try {
			while(backButton.isDisplayed()) {
				backButton.click();
			}
		}catch(NoSuchElementException e) {
			log.error("Back Button not present");
		}
		
	}
	
	
	
	
//	public void clickOnSearchCallLogs() {
//		searchCallLog.click();
//		searchContact.sendKeys(keysToSend);
//	}

	@Override
	WebElement getFirstListItem() {
		//List<AndroidElement> firstCallLogList = driver.findElements(By.xpath("//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/call_detail_layout' and @index='1']"));
		List<AndroidElement> firstCallLogList = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc='Collapse']"));
		
		return firstCallLogList.get(0);
	}
	
	
	
	

	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_MAIN_SCREEN and page title is equal to PAGE_TITLE
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_MAIN_SCREEN) && getPageTitle() != null
					&& getPageTitle().equals(PAGE_TITLE);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in main screen");
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// Navigate to home screen first
		Utils.navigateToHomeScreen(driver);
		// Click on call logs icon in bottom navigation bar
		BottomNavigationBar.getInstance().navigateToCallLogsPage();
	}

	@Override
	WebElement getFirstCreatedConvListItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
