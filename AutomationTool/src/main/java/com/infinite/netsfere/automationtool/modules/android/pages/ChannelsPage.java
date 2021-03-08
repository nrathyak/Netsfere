package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChannelsPage extends GenericListPage implements BasePage {

	private static final String ID_CONVERSATION_ROW_LAYOUT = "conversation_row_layout";

	private static final String PAGE_TITLE = "Broadcast";
	 private static Logger log = LogManager.getLogger(ChannelsPage.class.getName());

	AndroidDriver<AndroidElement> driver;
	
	public ChannelsPage() {
		driver = DriverManager.getAndroidDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.infinite.netsfere:id/"
			+ ID_CONVERSATION_ROW_LAYOUT + "' and @index='0']")
	public WebElement firstChannel;


	// methods
	@Override
	WebElement getFirstListItem() {
		return firstChannel;
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
		// Click on channels icon in bottom navigation bar
		BottomNavigationBar.getInstance().navigateToChannelsPage();
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