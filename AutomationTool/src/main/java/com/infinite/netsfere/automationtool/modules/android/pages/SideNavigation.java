package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SideNavigation {

	private static final String ID_LOGOUT_ICON = "logoutButton";
	private static final String ID_LOGOUT_CONFIRMATION_TEXT = "message";
	private static final String ID_LOGOUT_BUTTON = "button1";

	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;

	public SideNavigation() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	public WebElement navigationBar;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/" + ID_LOGOUT_ICON
			+ "' and @index='8']")
	public WebElement logoutIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/" + ID_LOGOUT_CONFIRMATION_TEXT
			+ "' and @text='Are you sure you want to logout from NetSfere?']")
	public WebElement logoutConfirmationText;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/" + ID_LOGOUT_BUTTON + "' and @index='1']")
	public WebElement logoutButton;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@resource-id='com.infinite.netsfere:id/design_menu_item_text' and @text='About NetSfere']")
	public WebElement aboutNetsfere;
	
	//@AndroidFindBy(xpath="//android.widget.CheckedTextView[@resource-id='com.infinite.netsfere:id/design_menu_item_text' and @index='0']")
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@resource-id='com.infinite.netsfere:id/design_menu_item_text' and @text='Settings']")
    public WebElement settingsTab;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/logoutButton']")
	public WebElement mainLogout;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	public WebElement sideNavigation;
	
	public void clickOnNavigationBar() throws Exception {
		try {
			Utils.navigateToHomeScreen(driver);
			sideNavigation.click();
		} catch (NoSuchElementException e) {
			throw new Exception("Navigation bar is not visible");
		}
	}
	
	public void clickOnSettingsTab() throws Exception {
		try {
			settingsTab.click();
		} catch (NoSuchElementException e) {
			throw new Exception("Settings tab is not visible");
		}
	}

	public void logout() throws Exception {
		try {
			mainLogout.click();
		} catch (NoSuchElementException e) {
			throw new Exception("Logout is not visible");
		}
		try {
			if (logoutConfirmationText.isDisplayed()) {
				logoutButton.click();
			}
		} catch (NoSuchElementException e) {
			throw new Exception("Either logout confirmation box or logout button is not visible");
		
		}
	}
	public void clickOnAboutNetsfere() throws Exception
	{
		try{
			aboutNetsfere.click();
		}
		catch(NoSuchElementException e){
			throw new Exception("Not able to locate element");
			}
	}
	

}