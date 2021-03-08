package com.infinite.netsfere.automationtool.modules.web.test;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.web.pages.SignUpPage;
import com.infinite.netsfere.automationtool.modules.web.pages.UserActivation;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import bsh.util.Util;

public class SignUpTestCase {
	
	
	SignUpPage signUp; 
	WebDriverWait webWait;
	WebDriver driver ;
	WebDriver signUpDriver;
	UserActivation useract;
	String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	
	
	@BeforeClass
	public void init(){
		signUp = new SignUpPage();
		useract = new UserActivation();
		driver = DriverManager.getWebDriver();
		signUpDriver = DriverManager.getSignUpWebDriver();
		webWait = Utils.getLongWait(signUpDriver);
	}
	
	@Test
	public void signUpOrg() throws InterruptedException{
		
		signUp.createNewOrg(Config.getInstance().getNewOrgEmail(), Config.getInstance().getNewOrgAdminName(), Config.getInstance().getNewOrgName());
		Utils.veryShortSleep();
		signUp.skipUserAdd();
		
	}
	
	@Test
	public void signUpAndAddUser() throws InterruptedException {
		signUp.createNewOrg(Config.getInstance().getNewOrgEmail(), Config.getInstance().getNewOrgAdminName(), Config.getInstance().getNewOrgName());
		signUp.inviteNewUser(Config.getInstance().getNewOrgUserName(), Config.getInstance().getNewOrgUserEmail(), Config.getInstance().getNewOrgNewUserCount());
	}
	
	
	@Test
	public void activateAdminOrg() throws InterruptedException{
		useract.navigationToGmail();
		useract.loginButton(Config.getInstance().getGmailId(), Config.getInstance().getGmailPassword());
		useract.selectCreatedOrganizationMail();
		Utils.shortSleep();
		useract.activateUser();
	}
	
	@Test
	public void loginToGmail() throws InterruptedException{
		useract.navigationToGmail();
		useract.loginButton(Config.getInstance().getGmailId(), Config.getInstance().getGmailPassword());
	}
	
	@Test
	public void activateGuestUser(String user) throws InterruptedException {
		useract.activateUserFromGmail(user);
	}
	
	@Test
	public void duplicateOrg() throws InterruptedException{
		signUpOrg();
		Assert.assertTrue(useract.duplicateOrgMail());
	}
	
	@Test
	public void closeSignUpDriver() {
		signUpDriver.close();
	}

}
