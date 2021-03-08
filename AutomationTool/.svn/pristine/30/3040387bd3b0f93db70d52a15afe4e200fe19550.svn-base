package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class AboutNetsfere extends GenericListPage implements BasePage{
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	SideNavigation side;
	private static Logger log = LogManager.getLogger(IntroPage.class.getName());
	
	public AboutNetsfere() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		side = new SideNavigation();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/terms_of_service_textView' and @index='1']")
	public WebElement legalAndPrivacy;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/licences_textView' and @index='3']")
	public WebElement openSourceLicenses;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/version_info_textView' and @index='5']")
	public WebElement versionInfo;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/developer_info_layout' and @index='7']")
	public WebElement developerInfo;
	
	public void clickLegalPrivacy(){
		legalAndPrivacy.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='NetSfere Terms of Service' and @index='1']")));
	}
	
	public void clickOpenSourceLicenses(){
		openSourceLicenses.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@index='1']")));
	}
	
	public void clickVersionInfo(){
		versionInfo.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='NetSfere' and @index='0']")));
		
	}
	
	public void clickDeveloperInfo(){
		developerInfo.click();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Developer Info']")));
	}

	@Override
	public boolean isAt() {
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_ABOUT_NETSFERE_SCREEN);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in intro screen");
			}
		}
		return false;
	}

	@Override
	public void navigateTo() throws Exception {
		Utils.navigateToHomeScreen(driver);
		BottomNavigationBar.getInstance().navigateToConversationsPage();
		side.clickOnNavigationBar();
		side.clickOnAboutNetsfere();
		
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
