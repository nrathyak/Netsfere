package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends GenericListPage implements BasePage {

	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	private static Logger log = LogManager.getLogger(IntroPage.class.getName());


	public SignUpPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="\\android.widget.Button[@resource-id='com.infinite.netsfere:id/get_started_button_intro' and @index='1']")
	public WebElement signUpButton;
	
	@AndroidFindBy(xpath="\\android.widget.EditText[@resource-id='com.infinite.netsfere:id/email_text' and @index='0']")
	public WebElement companyEmailAddressTextBox;
	
	@AndroidFindBy(xpath="\\android.widget.EditText[@resource-id='com.infinite.netsfere:id/organization_name_text' and @index='0']")
	public WebElement orgNameTextBox;
	
	@AndroidFindBy(xpath="\\android.widget.EditText[@resource-id='com.infinite.netsfere:id/name_text' and @index='0']")
	public WebElement fullNameTextBox;
	
	@AndroidFindBy(xpath="\\android.widget.TextView[@resource-id='com.infinite.netsfere:id/region_text' and @index='0']")
	public WebElement selectRegion;
	
	@AndroidFindBy(xpath="\\android.widget.CheckBox[@resource-id='com.infinite.netsfere:id/terms_accept_checkBox']")
	public WebElement checkBox;
	
	@AndroidFindBy(xpath="\\android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='MS3 Region']")
	public WebElement ms3Region;
	
	@AndroidFindBy(xpath="\\android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='MS4 Region']")
	public WebElement ms4Region;
	
	@AndroidFindBy(xpath="\\android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='MS8 Region']")
	public WebElement ms8Region;
	
	@AndroidFindBy(xpath="\\android.widget.Button[@resource-id='com.infinite.netsfere:id/button_signup' and @index='5']")
	public WebElement signUpCreateButton;
	
	@AndroidFindBy(xpath="\\android.widget.TextView[@resource-id='com.infinite.netsfere:id/subtitle_textview' and @text='Organization created for:']")
	public WebElement organizationCreatedText;
	
	public void createNewOrg(String companyEmail, String orgName , String fullName, String userRegionSelect ){
		companyEmailAddressTextBox.sendKeys(companyEmail);
		orgNameTextBox.sendKeys(orgName);
		fullNameTextBox.sendKeys(fullName);
		selectRegion.click();
		if(userRegionSelect.equalsIgnoreCase("ms3")){
			ms3Region.click();
		}else if(userRegionSelect.equalsIgnoreCase("ms4")){
			ms4Region.click();
		}else if(userRegionSelect.equalsIgnoreCase("ms8")){
			ms8Region.click();
		}
		
		signUpCreateButton.click();
		mediumWait.until(ExpectedConditions.visibilityOf(organizationCreatedText));
		driver.navigate().back();
		
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
		clickSignUpButton();
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
