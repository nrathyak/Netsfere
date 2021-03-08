package com.infinite.netsfere.automationtool.modules.android.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.android.pages.LoginPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ResetPasswordPage;
import com.infinite.netsfere.automationtool.modules.android.pages.SideNavigation;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTestCases extends BaseTestCases {

	IntroPage introPage;
	LoginPage loginPage;
	ConversationsPage conversationsPage;
	SideNavigation sideNavigation;
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait longWait;
	ResetPasswordPage resetPage;

	@BeforeClass
	public void init() {
		introPage = new IntroPage();
		loginPage = new LoginPage();
		conversationsPage = new ConversationsPage();
		sideNavigation = new SideNavigation();
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		longWait = Utils.getLongWait(driver);
		resetPage = new ResetPasswordPage();
	}

	@Test(description="Navigate from into page to login page")
	@NavigateTo(IntroPage.class)
	public void goToLoginScreen() throws InterruptedException {
		introPage.clickLoginButton();
//		Assert.assertTrue(ExpectedConditions.visibilityOf(loginPage.getLoginButton()).apply(driver).isDisplayed());
	}

	@Test(description="Login to NetSfere with valid credentials")
	@NavigateTo(LoginPage.class)
	public void loginWithInValidCredentials() throws IOException {
		loginPage.enterEmailAndPassword("invalid.test@netsferetest.com", "xxxx");
		loginPage.clickLoginButton();
		mediumWait.until(ExpectedConditions.alertIsPresent());
		loginPage.waitForErrorPopUpAndClose();
	}

	@Test
	@NavigateTo(LoginPage.class)
	public void loginWithValidCredentials(String email, String password) throws IOException {
		loginPage.enterEmailAndPassword(email,
				password);
		loginPage.clickLoginButton();
		loginPage.checkForNewFeaturePage();
//		mediumWait.until(ExpectedConditions.visibilityOf(conversationsPage.getLoadingView()));
		longWait.until(ExpectedConditions.visibilityOf(conversationsPage.getConversationList()));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);
		if (Config.getInstance().reInstallApp()) {
			loginPage.closeFullDiskEncryptionAlert();
			loginPage.waitForPermissionsAlertAndClose();
		}
	}
	
	@Test
	@NavigateTo(LoginPage.class)
	public void loginAsGuestUser() throws InterruptedException{
		goToLoginScreen();
		loginPage.enterEmailAndPassword(Config.getInstance().getGuestUser(),Config.getInstance().getAndroidUserPassword());
		loginPage.clickLoginButton();
		mediumWait.until(ExpectedConditions.visibilityOf(conversationsPage.getLoadingView()));
		longWait.until(ExpectedConditions.visibilityOf(conversationsPage.getConversationList()));
		Assert.assertEquals(driver.currentActivity(), Constants.ACTIVITY_MAIN_SCREEN);
		if (Config.getInstance().reInstallApp()) {
			loginPage.closeFullDiskEncryptionAlert();
			loginPage.waitForPermissionsAlertAndClose();
		}
	}
	
	@Test
	@NavigateTo(LoginPage.class)
	public void resetPassword(String mailId) throws InterruptedException {
		goToLoginScreen();
		loginPage.clickOnForgotPassword();
		Assert.assertEquals(true, resetPage.resetPasswordPage.getText().contains("Enter your registered email"));
		resetPage.enterMailIdToResetPasword(mailId);
		resetPage.clickOnResetPassword();
		resetPage.waitForConfirmPopUp();
		Assert.assertEquals(true, resetPage.passwordResetMailSentPopUp.getText().contains("Password Reset"));
		resetPage.clickOnOKButton();
		Assert.assertTrue(ExpectedConditions.visibilityOf(loginPage.getLoginButton()).apply(driver).isDisplayed());
		
	}
	
	
	
	@Test
	@NavigateTo(LoginPage.class)
	public void unableToResetPassword(String mailId) throws InterruptedException {
		goToLoginScreen();
		loginPage.clickOnForgotPassword();
		Assert.assertEquals(true, resetPage.resetPasswordPage.getText().contains("Enter your registered email"));
		resetPage.enterMailIdToResetPasword(mailId);
		resetPage.clickOnResetPassword();
		Assert.assertEquals(true, resetPage.resetWarningMessage.getText().contains("You may only send one request every 10 minutes."));
		resetPage.clickOnOKButton();
	}
	
	
	@Test
	public void logOut(){
		try {
			Utils.veryShortSleep();
			sideNavigation.clickOnNavigationBar();
			Utils.veryShortSleep();
			sideNavigation.logout();
		} catch (Exception e) {
			Assert.fail(e.getMessage(), e);
		}
	}
	
	@Test
	@NavigateTo(IntroPage.class)
	public void clickOnTermsOfServiceAndPrivacyPolicyButton() throws InterruptedException
	
	{
		goToLoginScreen();
		loginPage.clickingTermsofServicesAndPrivacyPolicy();
		mediumWait.until(ExpectedConditions.visibilityOf(loginPage.termsOfServiceAndPrivacyPolicyTitle));
		Assert.assertEquals(true, loginPage.termsAndPolicyPageTitleVerify());
		Utils.navigateBack(driver);
		Utils.navigateBack(driver);
	}
	@Test
	@NavigateTo(LoginPage.class)
	public void clickOnHelpButton()
	{
		loginPage.moreDetailsButton();
		Utils.veryShortSleep();
		loginPage.helpButton();
		mediumWait.until(ExpectedConditions.visibilityOf(loginPage.helpButtonTitle));
		Assert.assertEquals(true, loginPage.helpPageTitleVerify());
		driver.navigate().back();
	}
	
	
	@Test
	@NavigateTo(LoginPage.class)
	public void clickVersionInfoButton()
	{
		loginPage.moreDetailsButton();
		Utils.veryShortSleep();
		loginPage.versionInfoButton();
		mediumWait.until(ExpectedConditions.visibilityOf(loginPage.versionInfoPageTitle));
		Assert.assertEquals(true, loginPage.versionInfoPageTitleVerify());
		driver.navigate().back();
	}

}
