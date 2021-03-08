package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactDetailsPage implements BasePage {

	AndroidDriver<AndroidElement> driver;
	
	WebDriverWait mediumWait;
	public ContactDetailsPage(){
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.ToggleButton[@resource-id='com.infinite.netsfere:id/call_button']")
	public WebElement callIcon;
	
	                    
	
	public void clickOnCallFromContactsButton() {
		callIcon.click();
	}

	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_CONTACT_DETAILS_SCREEN
		return driver.currentActivity().equals(Constants.ACTIVITY_CONTACT_DETAILS_SCREEN);
	}

	public void navigateTo() throws Exception {
		// Doing nothing, because this is a contact details page which is linked
		// with a particular contact, which is not known at this point.
	}

	
}
