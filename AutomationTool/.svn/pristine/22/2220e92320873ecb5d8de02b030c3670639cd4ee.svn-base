package com.infinite.netsfere.automationtool.modules.android.test;

import java.text.SimpleDateFormat;

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
import com.infinite.netsfere.automationtool.modules.android.pages.SideNavigation;
import com.infinite.netsfere.automationtool.modules.android.pages.SignUpPage;
import com.infinite.netsfere.automationtool.modules.web.pages.UserActivation;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignUpTestCases extends BaseTestCases{
	
	SignUpPage sign;
	SideNavigation sideNavigation;
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait longWait;
	UserActivation useract;
	static String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static final String companyEmail = "newOrg"+randomDate+"@sanjay.netsferetest.org";
	private static final String organisationName = "OrgName"+randomDate;
	private static final String fullName = "Name"+randomDate;
	private static final String ms3Region = "ms3";
	private static final String ms4Region = "ms4";
	private static final String ms8Region = "ms8";

	@BeforeClass
	public void init() {
		sign = new SignUpPage();
		useract = new UserActivation();
		sideNavigation = new SideNavigation();
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		longWait = Utils.getLongWait(driver);
	}

	@Test(description="Navigate from into page to login page")
	@NavigateTo(SignUpPage.class)
	public void androidUserCreateAccountThroughSignUp() {
		sign.createNewOrg(companyEmail, organisationName, fullName, ms3Region);
		Assert.assertTrue(sign.organizationCreatedText.isDisplayed());
		
	}
	
	@Test
	@NavigateTo(SignUpPage.class)
	public void duplicateOrg() throws InterruptedException{
		androidUserCreateAccountThroughSignUp();
		Assert.assertTrue(useract.duplicateOrgMail());
	}


}
