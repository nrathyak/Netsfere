package com.infinite.netsfere.automationtool.modules.android.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactsPage extends GenericListPage implements BasePage {

	private static final String PAGE_TITLE = "Contacts";

	AndroidDriver<AndroidElement> driver;

	WebDriverWait mediumWait;
	
	private static Logger log = LogManager.getLogger(ContactsPage.class.getName());


	public ContactsPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/bottom_navigation_small_item_icon' and @index='2']")
	public WebElement contactLink;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_search']")
	public WebElement contactSearchIcon;
	
	/*@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/profile_detail_layout' and @index='1']")
	public List<WebElement> firstContact;*/
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/header_textview' and @index='0']")
	public WebElement firstContact;
	
	/*@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/display_picture_imageview' and @index='1']")
	public WebElement firstContact;*/
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@resource-id='com.infinite.netsfere:id/select_checkBox']")
	public WebElement searchedContact;
	
	@AndroidFindBy(uiAutomator = "text(\"Contacts\")")
	public WebElement contactsPage;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/search_src_text']")
	public WebElement contactNameSearchBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/guest_avatar_icon' and @text='G']")
	public WebElement guestAvatarIcon;
	
	
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/bottom_navigation_small_container' and @index='0']")
	public WebElement conversationButton;
	
	
	public void clickOnConversationTab() {
		conversationButton.click();
	}
	
	public void navigateToContactPage(){
		if(contactsPage.isDisplayed()){
			
		}
		else{
			contactLink.click();
		}
	}

	@Override
	WebElement getFirstListItem() {
		return firstContact;
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
		// Click on contacts icon in bottom navigation bar
		BottomNavigationBar.getInstance().navigateToContactsPage();
	}
	
	public BasePage getSingleInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	WebElement getFirstCreatedConvListItem() {
		// TODO Auto-generated method stub
		return null;
	}


}
