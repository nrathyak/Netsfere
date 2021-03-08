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

public class CallDetailsPage implements BasePage {


	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;

	public CallDetailsPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Call Details\")")
	public WebElement callDetailsPage;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/call_button']")
	public WebElement callButtonFromDetails;
	
	
	public void clickOnCallButtonFromCallDetails() {
		if(callDetailsPage.isDisplayed()) {
			callButtonFromDetails.click();
		}
	}

	public boolean isAt() {
		return driver.currentActivity().equals(Constants.ACTIVITY_CALL_DETAILS_SCREEN);
	}

	public void navigateTo() {
		// Doing nothing, because this is a call details page which is linked
		// with a particular call log, which is not known at this point.
	}
}
