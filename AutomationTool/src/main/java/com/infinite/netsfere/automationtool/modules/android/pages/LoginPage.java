package com.infinite.netsfere.automationtool.modules.android.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends GenericListPage implements BasePage {

	AndroidDriver<AndroidElement> driver;
	WebDriverWait androidWait;
	 private static Logger log = LogManager.getLogger(LoginPage.class.getName());


	public LoginPage() {
		driver = DriverManager.getAndroidDriver();
		androidWait = Utils.getLongWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.infinite.netsfere:id/email_text")
	public WebElement android_email_textbox;


	@AndroidFindBy(id = "com.infinite.netsfere:id/password_text")
	public WebElement android_password_textbox;

	@AndroidFindBy(id ="com.infinite.netsfere:id/login_button")
    public WebElement loginButton;
	
	//@AndroidFindBy(id ="com.infinite.netsfere:id/login_button_intro")
	//public WebElement loginButton;

	@AndroidFindBy(uiAutomator = "text(\"Full Disk Encryption\")")
	public WebElement full_disk_encrytion_pop_up;

	@AndroidFindBy(uiAutomator = "text(\"DON'T SHOW AGAIN\")")
	public WebElement dontShowAgainButton;

	@AndroidFindBy(uiAutomator = "text(\"Allow NetSfere to access photos, media, and files on your device?\")")
	public WebElement allow_media_text;

	@AndroidFindBy(uiAutomator = "text(\"ALLOW\")")
	public WebElement allow_button;

	@AndroidFindBy(uiAutomator = "text(\"OK\")")
	public WebElement ok_button;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/forgot_password_button']")
	public WebElement forgotPasswordButton;
	

	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/terms_button' and @index='1']")
    public WebElement termsOfServiceAndPrivacyPolicyButton;
	
	@AndroidFindBy(uiAutomator="text(\"NetSfere Terms of Service\")")
	public WebElement termsOfServiceAndPrivacyPolicyTitle;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/more_imageView' and @index='0']")
	public WebElement moreDetails;
	
	
	
	@AndroidFindBy(uiAutomator = "text(\"Help\")")
	public WebElement helpButton;
	
	@AndroidFindBy(uiAutomator="text(\"NetSfere Help Center\")")
	public WebElement helpButtonTitle;
			
	@AndroidFindBy(uiAutomator="text(\"Version Info\")")
	public WebElement versionInfoButton;
	
	@AndroidFindBy(uiAutomator="text(\"NetSfere\")")
	public WebElement versionInfoPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/close_button']")
	public WebElement closeButton;
	
	
	public void clickingTermsofServicesAndPrivacyPolicy()
	{
		termsOfServiceAndPrivacyPolicyButton.click();  
	}
	
	
	public void helpButton()
	{
		helpButton.click();
	}
	public void versionInfoButton()
	{
		versionInfoButton.click();
	}
	
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void moreDetailsButton()
	{
	moreDetails.click();
	}

	public void enterEmailAndPassword(String email, String password) {
		android_email_textbox.clear();
		android_password_textbox.clear();
		android_email_textbox.sendKeys(email);
		android_password_textbox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void waitForErrorPopUpAndClose() {
		androidWait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.TextView[@text='" + Constants.invalidLoginAlertMessage + "']")));
		ok_button.click();
	}

	public void closeFullDiskEncryptionAlert() {
		if (ExpectedConditions.visibilityOf(full_disk_encrytion_pop_up).apply(driver).isDisplayed()) {
			dontShowAgainButton.click();
		}
	}

	public void waitForPermissionsAlertAndClose() {
		try {
			Utils.getShortWait(driver).until(ExpectedConditions.visibilityOf(allow_media_text));
			allow_button.click();
		} catch (NoSuchElementException e) {

		} catch (TimeoutException te) {

		}
	}
	
	public void clickOnForgotPassword() {
		forgotPasswordButton.click();
	}
	
	
	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_MAIN_SCREEN and page title is equal to PAGE_TITLE
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_LOGIN_SCREEN);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in intro screen");
			}
		}
		return false;
	}
	public boolean termsAndPolicyPageTitleVerify()
	{
		String s=termsOfServiceAndPrivacyPolicyTitle.getText();
		if(s.contains("NetSfere Terms of Service"))
		{
			return true;
		}
		return false;
	}
	
	public boolean helpPageTitleVerify()
	{
		String s=helpButtonTitle.getText();
		if(s.contains("NetSfere Help Center"))
		{
			return true;
		}
		return false;
	}

	public boolean versionInfoPageTitleVerify()
	{
		String s=versionInfoPageTitle.getText();
		if(s.contains("NetSfere"))
		{
			return true;
		}
		return false;
	}
	public void navigateTo() throws Exception {
		//Do nothing as it already in Login Screen
		//clickLoginButton();
	}
	
	public void checkForNewFeaturePage() {
		Utils.veryShortSleep();
		try {
			Utils.veryShortSleep();
			if(closeButton.isDisplayed()) {
				closeButton.click();
			}
				
		}catch(Exception e) {
			log.info("New feature intro page isnt available");
		}	
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