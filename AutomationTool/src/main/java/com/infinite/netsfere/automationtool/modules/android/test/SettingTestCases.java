package com.infinite.netsfere.automationtool.modules.android.test;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.android.pages.AboutNetsfere;
import com.infinite.netsfere.automationtool.modules.android.pages.GenericListPage;
import com.infinite.netsfere.automationtool.modules.android.pages.SettingsPage;
import com.infinite.netsfere.automationtool.modules.android.pages.SideNavigation;
import com.infinite.netsfere.automationtool.utils.AndroidIoOperations;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SettingTestCases {
	
	private static Logger log = LogManager.getLogger(ConversationTestCases.class.getName());
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	SettingsPage set;
	AboutNetsfere abtNts;
	SideNavigation side;

	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		set = new SettingsPage();
		abtNts = new AboutNetsfere();
		side = new SideNavigation();
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanChangePassword() throws Exception{
		set.clickChangePassword(Config.getInstance().getAndroidUserPassword(),
				Config.getInstance().getNewPassword(),
				Config.getInstance().getConfirmPassword());
		set.clickSubmitButton();
		
		
	}
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanLogoutFromSettingPage(){
		set.clickLogoutButton();
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanEnableNetsfereCallRingtone(){
		set.enableNotificationTone();
		Assert.assertEquals("ON", set.notificationToneON.getText());
		
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanDisableNetsfereCallRingtone(){
		set.disableNotificationTone();
		Assert.assertEquals("OFF", set.notificationToneOFF.getText());	
	}
	
	
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanEnableNetsferePopNotification(){
		set.enablePopNotification();
		Assert.assertEquals("ON", set.popNotificationON.getText());
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanDisableNetsferePopNotification(){
		set.disablePopNotification();
		Assert.assertEquals("OFF", set.popNotificationOFF.getText());
		
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanEditQuickReply(){
		String randomDate = new SimpleDateFormat("mmss").format(new java.util.Date());
//		AndroidIoOperations.getInstance().scrollBottomToTop();
		set.clickQuickReply();
		String oldQuickReply = set.firstQuickReply.getText();
		set.editQuickReply("N"+randomDate);
		set.clickQuickReply();
		String newQuickReply = set.firstQuickReply.getText();
		Assert.assertNotSame(oldQuickReply, newQuickReply);
		set.editQuickReply(oldQuickReply);
		driver.navigate().back();
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanConfigureVideoCaptureQuality(){
		set.clickVideoCaptureQuality("low");
		Assert.assertSame(true, set.pixelCheck("low"));
	}
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanEditMeetingPointURL(){
		set.clickProfileIconOfSettingPage();
		String randomDate = new SimpleDateFormat("mmss").format(new java.util.Date());
		//set.clickProfileIconOfSettingPage();
		String oldMeetingURL = set.meetingUrlEditButton.getText();
		set.editMeetingPointUrl("usr"+randomDate);
		String newMeetingURL = set.meetingUrlEditButton.getText();
		Assert.assertNotSame(oldMeetingURL, newMeetingURL);
		set.clickOnBackButton();
		set.clickOnBackButton();
	}	
	
	@Test
	@NavigateTo(SettingsPage.class)
	public void androidCanEditMobileNumber(){
		set.clickProfileIconOfSettingPage();
		set.clickEditPhoneNumber();
		driver.navigate().back();
	}
	
	
	@Test
	@NavigateTo(AboutNetsfere.class)
	public void androidCanNavigateToLegalOrPrivacyPage() throws Exception{
		abtNts.clickLegalPrivacy();
		Assert.assertEquals(true, abtNts.legalAndPrivacy.getText().contains("Netsfere"));
		driver.navigate().back();
	}
	
	@Test
	@NavigateTo(AboutNetsfere.class)
	public void androidToNavigateToOpenSource() throws Exception{
		abtNts.clickOpenSourceLicenses();
		Assert.assertEquals(true, abtNts.openSourceLicenses.getText().contains("Licensing Information"));
		driver.navigate().back();
	}
	
	@Test
	@NavigateTo(AboutNetsfere.class)
	public void androidCanViewVersionInfo() throws Exception{
		abtNts.clickVersionInfo();
		Assert.assertEquals(true, abtNts.versionInfo.getText().contains("Netsfere"));
		driver.navigate().back();
	}
	
	@Test
	@NavigateTo(AboutNetsfere.class)
	public void androidCanViewDeveloperInfo(){
		abtNts.clickDeveloperInfo();
		Assert.assertEquals(true, abtNts.developerInfo.getText().contains("Developer"));
		driver.navigate().back();
	}
	
	@Test
	public void profileLogout() throws Exception {
		side.clickOnNavigationBar();
		side.logout();
		
	}
	
}
