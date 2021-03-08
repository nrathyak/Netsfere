package com.infinite.netsfere.automationtool.modules.web.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebSettingsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.UserActivation;
import com.infinite.netsfere.automationtool.modules.web.pages.WebLoginPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebResetPasswordPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.Driver;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebLoginTestCases extends BaseTestCases{
	
	
	WebLoginPage logEle; 
	WebSettingsPage setEle;
	WebDriverWait webWait;
	WebDriverWait webWait1;
	WebDriver driver ;
	WebDriver secondDriver ;
	WebIoOperations webOpt = new WebIoOperations();
	
	
	WebResetPasswordPage resetPage;
	UserActivation userAct;
	
	@BeforeClass
	public void init(){
		logEle = new WebLoginPage();
		setEle = new WebSettingsPage();
		driver = DriverManager.getWebDriver();
		webWait = Utils.getLongWait(driver);
		resetPage = new  WebResetPasswordPage();
		userAct = new UserActivation();
		
	}
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void login() throws Exception{
		//Assert.assertTrue(logEle.isLoginPage());
		logEle.submitUsernamePassword(Config.getInstance().getWebUserEmail(), Config.getInstance().getWebUserPassword());
		logEle.loginButton();
		logEle.checkForNewIntroPage();
		webWait.until(ExpectedConditions.visibilityOf(logEle.welcomeText));
		Assert.assertEquals("NetSfere", driver.getTitle());
		
	}
	
	@Test
	public void logout(){
		setEle.logoutButtonClick();
	}
	
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void clickTermsOfServicesAndPrivacyPolicyButton()
	{
		logEle.clickingTermsofServicesAndPrivacyPolicy();
		webOpt.SwitchWindow(driver);
		webWait.until(ExpectedConditions.visibilityOf(logEle.termsofServiceandPrivacyPolicyPageTitle));
		Assert.assertEquals(true, logEle.termsAndPolicyPageTitleVerify());
		driver.close();
		webOpt.SwitchWindow(driver);
	}
	@Test
	@NavigateTo(WebLoginPage.class)
	public void clickAboutButton()
	{
		logEle.aboutButton();
		webOpt.SwitchWindow(driver);
		webWait.until(ExpectedConditions.visibilityOf(logEle.aboutPageTitle));
		Assert.assertEquals(true, logEle.aboutPageTitleVerify());
		driver.close();
		webOpt.SwitchWindow(driver);
	}
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void clickHelpButton()
	{
		logEle.helpButton();
		webOpt.SwitchWindow(driver);
		Utils.veryShortSleep();
		webWait.until(ExpectedConditions.visibilityOf(logEle.helpPageTitle));
		Assert.assertEquals(true, logEle.helpPageTitleVerify());
		driver.close();
		webOpt.SwitchWindow(driver);
	}
	
	
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void loginWithGuestUser() throws Exception{
		Assert.assertTrue(logEle.isLoginPage());
		logEle.submitUsernamePassword(Config.getInstance().getGuestUser(), Config.getInstance().getWebUserPassword());
		logEle.loginButton();
		webWait.until(ExpectedConditions.visibilityOf(logEle.welcomeText));
		Utils.veryShortSleep();
		Assert.assertEquals("NetSfere", driver.getTitle());
	}
	
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void loginWithInvalidUsername() throws Exception{
		Assert.assertTrue(logEle.isLoginPage());
		logEle.submitUsernamePassword("xxxxxx@netsferetest.org", Config.getInstance().getWebUserPassword() );
		logEle.loginButton();
		webWait.until(ExpectedConditions.visibilityOf(logEle.invalidErrorMessage));
		Assert.assertEquals(true, logEle.invalidErrorMessage.getText().contains("Invalid email"));
	}
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void loginWithInvalidPassword() throws Exception{
		Assert.assertTrue(logEle.isLoginPage());
		logEle.submitUsernamePassword(Config.getInstance().getWebUserEmail(), "xxxxxxxx");
		logEle.loginButton();
		webWait.until(ExpectedConditions.visibilityOf(logEle.invalidErrorMessage));
		Assert.assertEquals(true, logEle.invalidErrorMessage.getText().contains("Invalid email"));
	}
	
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void resetPassword(String mailId) throws InterruptedException {
		Assert.assertTrue(logEle.isLoginPage());
		logEle.clickOnForgotPassword();
		Assert.assertEquals(true, resetPage.resetPasswordPage.getText().contains("Reset Password"));
		resetPage.enterEmailToResetPassword(mailId);
		resetPage.clickOnResetButton();
		resetPage.waitForConfirmPopUp();
		resetPage.clickOnOKButton();
		Assert.assertTrue(logEle.isLoginPage());
		
		
	}
	
	@Test
	public void resetPasswordThroughGmail() throws InterruptedException {
		userAct.navigationToGmail();
		userAct.loginButton(Config.getInstance().getGmailId(), Config.getInstance().getGmailPassword());
		resetPage.resetPasswordThroughGmail();
		resetPage.enterPasswordInResetPasswordPageAndConfirm();
		webWait.until(ExpectedConditions.visibilityOf(logEle.loginpage));
		Assert.assertTrue(logEle.isLoginPage());
	}
	
	//Login after reset password and logout
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void cancelResetPassword() {
		Assert.assertTrue(logEle.isLoginPage());
		logEle.clickOnForgotPassword();
		Assert.assertEquals(true, resetPage.resetPasswordPage.getText().contains("Reset Password"));
		resetPage.clickOnCancelResetPasswordButton();
		Assert.assertTrue(logEle.isLoginPage());
	}
	
	
	@Test
	@NavigateTo(WebLoginPage.class)
	public void unableToResetPassword(String mailId) {
		Assert.assertTrue(logEle.isLoginPage());
		logEle.clickOnForgotPassword();
		Assert.assertEquals(true, resetPage.resetPasswordPage.getText().contains("Reset Password"));
		resetPage.enterEmailToResetPassword(mailId);
		resetPage.clickOnResetButton();
		Utils.veryShortSleep();
		Assert.assertEquals(true, resetPage.resetWarning.getText().contains("You may only send one request every 10 minutes"));
	}
	
	@Test
	public void loginWithSecondWebUser(String iosUsername , String password) {
		logEle.initialiseSecondDriver();
		secondDriver= DriverManager.getSecondWebDriver();
		webWait1 = Utils.getLongWait(secondDriver);
		secondDriver.get(Constants.url);
		Utils.veryShortSleep();
		logEle.submitUsernamePassword(iosUsername , password);
		logEle.loginButton();
		logEle.checkForNewIntroPage();
		webWait.until(ExpectedConditions.visibilityOf(logEle.welcomeText));
		Assert.assertEquals("NetSfere", driver.getTitle());
		
	}
	
}
