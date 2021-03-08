package com.infinite.netsfere.automationtool.modules.android.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.android.pages.BottomNavigationBar;
import com.infinite.netsfere.automationtool.modules.android.pages.ContactsPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContactTest extends BaseTestCases {
	
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	ContactsPage cont;
	
	@BeforeClass
	public void init() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		cont = new ContactsPage();
	}	
	
	
	@Test
	@NavigateTo(ContactsPage.class)
	public void guestLabelForGuestInContact() throws Exception{
		//try{
			cont.searchForAndSelect(Config.getInstance().getGuestDisplayName());
			Assert.assertEquals(Config.getInstance().getGuestLabel(), cont.guestAvatarIcon.getText());
			
			
			Utils.navigateBack(driver);
			Utils.veryShortSleep();
			Utils.navigateBack(driver);
			Utils.navigateBack(driver);
			
	//}
//		catch (Exception e) {
//			Assert.assertFalse(true);
//		}
	}

}
