package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IntroPage extends GenericListPage implements BasePage {

	AndroidDriver<AndroidElement> driver;
	private static Logger log = LogManager.getLogger(IntroPage.class.getName());


	public IntroPage() {
		driver = DriverManager.getAndroidDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "text(\"Login\")")
	public WebElement loginButton;
	
	@AndroidFindBy(xpath="\\android.widget.Button[@resource-id='com.infinite.netsfere:id/get_started_button_intro' and @index='1']")
	public WebElement signUpButton;

	
	public WebElement getLoginButton() {
		return loginButton;
	}

	public void clickLoginButton() throws InterruptedException {
		loginButton.click();
		Thread.sleep(2000);
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}
	
	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_MAIN_SCREEN and page title is equal to PAGE_TITLE
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_INTRO_SCREEN);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in intro screen");
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
//		clickLoginButton();
	}


	@Override
	WebElement getFirstListItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	WebElement getFirstCreatedConvListItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
