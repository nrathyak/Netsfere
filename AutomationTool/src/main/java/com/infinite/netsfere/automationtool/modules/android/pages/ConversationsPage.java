package com.infinite.netsfere.automationtool.modules.android.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ConversationsPage extends GenericListPage implements BasePage {

	private static final String ID_CONVERSATION_ROW_LAYOUT = "conversation_row_layout";
	private static final String ID_NEW_CONVERSATION_FAB = "new_conversation_fab";
	private static final String ID_PERMISSION_POPUP = "permission_message";
	private static final String ID_ALLOW_PERMISSION_BUTTON = "permission_allow_button";
	private static final String ID_DENY_PERMISSION_BUTTON = "permission_deny_button";
	private static final String ID_CONVERSATION_NAME_TEXT = "conversation_name_text";
	private static final String ID_LOADING_CONVERSATIONS_VIEW = "loading";
	private static final String ID_CONVERSATION_LIST = "conversation_list";
	private static final String ID_NO_CONVERSATIONS_TEXT = "no_conversations";
	private static final String TEXT_ALLOW_MEDIA_MESSAGE = "Allow NetSfere to access photos, media and files on your device?";
	private static final String PAGE_TITLE = "Conversations";
	private static final String ID_SELECT_DIALOG_LIST = "select_dialog_listview";
	private static final String ID_SELECT_DIALOG_OPTIONS = "text1";
	
	
	
	
	private static Logger log = LogManager.getLogger(ConversationsPage.class.getName());

	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;

	public ConversationsPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.infinite.netsfere:id/"
			+ ID_CONVERSATION_ROW_LAYOUT + "' and @index='0']")
	public WebElement firstConversation;
		
	
//	@AndroidFindBy(xpath="//android.widget.Relativelayout[@index='1']")
//	public WebElement firstCreatedConversation;	
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/"
	+ ID_CONVERSATION_NAME_TEXT + "' and @index='1']")
	public WebElement firstCreatedConversation;
	
	/*@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@resource-id='com.infinite.netsfere:id/conversation_list']/android.widget.RelativeLayout[@index='1']")
	public WebElement firstCreatedConversation;*/
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/"
//			+ ID_CONVERSATION_ROW_LAYOUT + "' and @index='1']")
//	public WebElement firstCreatedConversation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_guest_badge' and @index='1']")
	public WebElement firstCreatedGuestConversation;
	

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.infinite.netsfere:id/"
			+ ID_NEW_CONVERSATION_FAB + "' and @index='1']")
	public WebElement newConversationFab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.android.packageinstaller:id/"
			+ ID_PERMISSION_POPUP + "' and @text='" + TEXT_ALLOW_MEDIA_MESSAGE + "']")
	public WebElement allowMediaPopup;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/"
			+ ID_ALLOW_PERMISSION_BUTTON + "']")
	public WebElement allowMediaButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/"
			+ ID_DENY_PERMISSION_BUTTON + "']")
	public WebElement denyMediaButton;

	@AndroidFindBy(id = "" + ID_LOADING_CONVERSATIONS_VIEW)
	private WebElement loadingView;

//	@AndroidFindBy(id = "" + ID_CONVERSATION_LIST)
//	private WebElement conversationList;
	
	@AndroidFindBy(id = "com.infinite.netsfere:id/" + ID_CONVERSATION_LIST)
	private WebElement conversationList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/"
			+ ID_NO_CONVERSATIONS_TEXT + "' and @text='No Conversations']")
	public WebElement noConversation;
	
	
//	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.infinite.netsfere:id/" 
//	+ ID_SELECT_DIALOG_LIST + "']" + "/android.widget.TextView[@resource-id='android:id/" 
//			+ ID_SELECT_DIALOG_OPTIONS + "' and  @text='Mute']")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Mute']")	
	public WebElement muteConversation;
	
//	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.infinite.netsfere:id/" 
//			+ ID_SELECT_DIALOG_LIST + "']" + "/android.widget.TextView[@resource-id='android:id/" 
//					+ ID_SELECT_DIALOG_OPTIONS + "' and  @text='Unmute']")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Unmute']")				
	public WebElement unMuteConversation;
	
	
//	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.infinite.netsfere:id/" 
//			+ ID_SELECT_DIALOG_LIST + "']"+ "/android.widget.TextView[@resource-id='android:id/" 
//					+ ID_SELECT_DIALOG_OPTIONS + "' and  @text='Favorite']")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Favorite']")
	public WebElement favoriteConversation;
	
//	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='com.infinite.netsfere:id/" 
//			+ ID_SELECT_DIALOG_LIST + "']" + "/android.widget.TextView[@resource-id='android:id/" 
//					+ ID_SELECT_DIALOG_OPTIONS + "' and  @text='Unfavorite']")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Unfavorite']")
	public WebElement unFavoriteConversation;
	
	
	/*
	 * Leave conversation elements
	 */
	@AndroidFindBy(uiAutomator = "text(\"Leave\")")
	public WebElement leaveconversation;

	/*
	 * Export to email elements
	 */

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1' and @index='2']")
	public WebElement exportmail;

	/*
	 * Guest
	 */
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_guest_badge' and @text='GUEST']")
	public WebElement guestBadge;
	
	/*
	 * Badge count elements
	 */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/bottom_navigation_notification' and @index='1']")
	public WebElement convBadgeCount;
	
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@resource-id='com.infinite.netsfere:id/spinner_nav']")
	public WebElement convDropDown;
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Unread']")
	@AndroidFindBy(xpath="//android.widget.CompoundButton[@text='Unread']")
	public WebElement unreadTab;
	
	@AndroidFindBy(xpath="//android.widget.CompoundButton[@text='All']")
	public WebElement allTab;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_unread_badge']")
	public WebElement unreadBadgeCount;
	
	/*
	 * Assertion elements
	 */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/message_time_text' and @text='Now']")
	public WebElement conversationTime;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_name_text' and @index=1]")
	public WebElement ownerNameAsDefaultTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/message_content_textview' and @index='0']")
	public WebElement messageFromWebGuest;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='1']")
	public WebElement updatedTitle;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/mute_image']")
	public WebElement muteIcon;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/favorite_image']")
	public WebElement favoriteIcon;

	public void waitTillEmailSent() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.Button[@resource-id='com.infinite.netsfere:id/"
						+ ID_NEW_CONVERSATION_FAB + "' and @index='1']")));
	}

	public WebElement getLoadingView() {
		return loadingView;
	}

	public WebElement getConversationList() {
		return conversationList;
	}

	public void clickOnNewConversationFab() throws Exception {
		try {
		newConversationFab.click();
		} catch(NoSuchElementException e) {
			throw new Exception("New conversation floating button is not visible");
		}
	}
	
	public void clickOnFirstCreatedConversation(){
		firstCreatedConversation.click();
	}

	public String getFirstConversationName() {
		return getFirstListItem().findElement(By.id(ID_CONVERSATION_NAME_TEXT)).getText();
	}

	public void longPressonFirstConversationAndExport() throws Exception {
		Utils.longPressElement(ClickfirstConversationTitleInAllTab());
		try {
			exportmail.click();
		} catch (NoSuchElementException e) {
			throw new Exception("Export to email button is not visible on long press");
		}
	}
	
	public String validateUnreadBadgeCount() {
		String unread = convBadgeCount.getText();
		System.out.println(unread);
		return unread;	
	}
	
	public String firstConversationTitleInAllTab() {
		List<AndroidElement> conv= driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_name_text' and @index='1']"));
		String allConvTitle = conv.get(0).getText();
		return allConvTitle;
		
	}
	
	public WebElement firstCreatedConversation() {
		List<AndroidElement> conv= driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.infinite.netsfere:id/conversation_row_layout' and @index='0']"));
		WebElement allConvTitle = conv.get(1);
		return allConvTitle;
		
	}
	
	public void navigateToUnreadTab() {
//		convDropDown.click();
		unreadTab.click();
	}
	
	public void navigateToAllTab() {
//		convDropDown.click();
		allTab.click();
	}
	
	public String firstConversationTitleInUnreadTab() {
		List<AndroidElement> unreadConv = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_name_text']"));
		String unreadConvTitle=unreadConv.get(0).getText();
		return unreadConvTitle;
		
	}
	
	public void clickOnUnreadMessage() {
		List<AndroidElement> unreadBadgeCount = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_unread_badge']"));
		unreadBadgeCount.get(0).click();
	}
	
	//**** Searching the participant
	
	public AndroidElement firstMuteOrFavoriteConversation() {
		List<AndroidElement> firstConv = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.infinite.netsfere:id/conversation_row_layout' and @index='0']"));
		return firstConv.get(1);
		 
		
	}
	

	public void clickOnLeaveConversation() throws Exception {
		Utils.veryShortSleep();
		try {
			leaveconversation.click();
			Utils.veryShortSleep();
		} catch (NoSuchElementException e) {
			throw new Exception("Leave conversation button is not visible on long press");
		}
	}
	
	
	public void muteConversation() throws Exception {
		Utils.veryShortSleep();
//		try {
			Utils.longPressElement(firstCreatedConversation());
			muteConversation.click();
//			Utils.shortSleep();
//			Utils.longPressElement(muteIcon);
			mediumWait.until(ExpectedConditions.visibilityOf(muteIcon));
//			driver.navigate().back();
//		} catch (Exception e) {
//			if (e instanceof NoSuchElementException) {
//				log.info("No Options displayed for long press., or long press failed.");
//			}
//		}
	}
	
	public void unMuteConversation() throws Exception {
		Utils.veryShortSleep();
//		try {
			Utils.longPressElement(firstCreatedConversation());
			unMuteConversation.click();
			Utils.shortSleep();
			Utils.longPressElement(firstCreatedConversation());
			assertTrue(muteConversation.isDisplayed());
			driver.navigate().back();
//		} catch (Exception e) {
//			if (e instanceof NoSuchElementException) {
//				log.info("No Options displayed for long press., or long press failed.");
//			}
//		}
	}
	
	public void favoriteConversation() throws Exception {
		Utils.veryShortSleep();
//		try {
			Utils.longPressElement(firstCreatedConversation());
			favoriteConversation.click();
			Utils.veryShortSleep();
			Utils.longPressElement(firstCreatedConversation());					
			assertTrue(unFavoriteConversation.isDisplayed());
			driver.navigate().back();
//		} catch (Exception e) {
//			if (e instanceof NoSuchElementException) {
//				log.info("No Options displayed for long press., or long press failed.");
//			}
//		}
	}
	
	public void unFavoriteConversation() throws Exception {
		Utils.veryShortSleep();
//		try {
			Utils.longPressElement(firstCreatedConversation());
			unFavoriteConversation.click();
			Utils.shortSleep();
			Utils.longPressElement(firstCreatedConversation());
			assertTrue(favoriteConversation.isDisplayed());
			driver.navigate().back();
//		} catch (Exception e) {
//			if (e instanceof NoSuchElementException) {
//				log.info("No Options displayed for long press., or long press failed.");
//			}
//		}
	}
	
	
		public WebElement ClickfirstConversationTitleInAllTab() {
			List<AndroidElement> conv= driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_name_text' and @index='1']"));
			AndroidElement allConvTitle = conv.get(1);
			return allConvTitle;
			
		}
		
		public void clickOnFirstConversation() {
			ClickfirstConversationTitleInAllTab().click();
		}
	

	@Override
	WebElement getFirstListItem() {
		return firstConversation;
	}
	
	@Override
	WebElement getFirstCreatedConvListItem() {
		return firstCreatedConversation;
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
		// Click on conversations icon in bottom navigation bar
		BottomNavigationBar.getInstance().navigateToConversationsPage();
	}
	
	public BasePage getSingleInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
