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

public class BroadcastLivePage implements BasePage {
	
	AndroidDriver<AndroidElement> driver;
	
	public BroadcastLivePage() {
		driver = DriverManager.getAndroidDriver();	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/stop_button']")
	public WebElement endBroadcastLiveButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/text_live' and @index='0']")
	public WebElement liveLabelOnBroadcastLive;
	
	public void clickEndBroadcastLive() {
		endBroadcastLiveButton.click();
	}

	public boolean isAt() {
		return driver.currentActivity().equals(Constants.ACTIVITY_BROADCAST_LIVE_PAGE);
	}

	public void navigateTo() throws Exception {
		// Doing nothing, because this is a live broadcast page which is linked
		// with a particular conversation, which is not known at this point.
	}
}
