package com.infinite.netsfere.automationtool.modules.ios.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.ios.pages.ConversationsPage;
import com.infinite.netsfere.automationtool.modules.ios.pages.IntroPage;
import com.infinite.netsfere.automationtool.modules.ios.pages.LoginPage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class LoginTestCases {

	IntroPage introPage;
	LoginPage loginPage;
	ConversationsPage conversationsPage;
	IOSDriver<IOSElement> IosDriver;
	WebDriverWait veryShortWait;
	WebDriverWait shortWait;
	WebDriverWait mediumWait;
	WebDriverWait longWait;
	
	 private static Logger log = LogManager.getLogger(LoginTestCases.class.getName());


	@BeforeClass
	public void init() throws InterruptedException, IOException {
		introPage = new IntroPage();
		loginPage = new LoginPage();
		conversationsPage = new ConversationsPage();
		IosDriver = DriverManager.getIOSDriver();
		veryShortWait = Utils.getVeryShortWait(IosDriver);
		shortWait = Utils.getShortWait(IosDriver);
		mediumWait = Utils.getMediumWait(IosDriver);
		longWait = Utils.getLongWait(IosDriver);
		cancelAppUpgrade();
	}

	public void cancelAppUpgrade() {
		try {
			shortWait.until(ExpectedConditions.visibilityOf(introPage.getAppUpdatelaterButton()));
			if(introPage.getAppUpdatelaterButton().isEnabled()) {
				introPage.cancelAppUpdate();	
			}
		} catch ( Exception e) {
			log.error("No PopUp for app update.");
		} 

	}
	
	@Test
	public void goToLoginScreen() {
		if( introPage.isAt()) {
			introPage.clickLoginButton();
			Assert.assertEquals(loginPage.isLoginTextVisible(),true);
		} else {
			Assert.fail("Not at Intro Screen Page");			
		}		
	}

	@Test
	public void loginWithInValidCredentials() throws IOException {
		login("invaliduser@murali.netsferetest.org","abcdefgh");
		loginPage.waitForInvalidEmailErrorPopUpAndClose();
		//TO-do 
		// assertion to assert invalid email popup
	}

	@Test
	public void loginWithValidCredentials() throws IOException {
		login(Config.getInstance().getIosUserEamil(),Config.getInstance().getIosUserPassword());
		Utils.shortSleep();
		conversationsPage.waitForAllowMicrophoneAccessPopUpAndAllow();
		conversationsPage.waitForAllowNotificationsPopUpAndAllow();
		Assert.assertEquals(conversationsPage.isAt(), true);		
	}
	
	@Test
	public void cancelLogin() throws IOException {
		if(loginPage.isAt()) {
			loginPage.clickCancelButton();	
			Assert.assertEquals(introPage.isAt(),true);
		}		
	}
	
	private void login(String email , String password) {
		if(!loginPage.isAt()) {
			Assert.fail("Not at Login Page");	
			return;
		}
		loginPage.enterEmailAndPassword(email, password);
		loginPage.clickGoButton();
	}

}