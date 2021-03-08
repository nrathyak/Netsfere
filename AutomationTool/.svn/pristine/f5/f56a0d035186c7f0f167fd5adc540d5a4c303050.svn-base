package com.infinite.netsfere.automationtool.modules.web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebContactsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebNavigationBar;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

public class ContactsTestCases extends BaseTestCases{
	
	WebDriver driver;
	WebDriverWait webWait;
	WebContactsPage webConc;
	WebConversationsPage webconv;
	WebNavigationBar webNavigationBar;
	
	@BeforeClass
	public void init(){
		
		webConc = new WebContactsPage();
		webconv = new WebConversationsPage();
		driver = DriverManager.getWebDriver();
		webWait = Utils.getLongWait(driver);
		webNavigationBar = new WebNavigationBar();
	}
	
	@Test
	@NavigateTo(WebContactsPage.class)
	public void guestLabelForGuestContact() throws Exception{
//		try{
		webConc.searchForAndSelect(Config.getInstance().getGuestDisplayName());
		Assert.assertEquals(Config.getInstance().getGuestLabel(), webConc.guestBadge.getText());
		webNavigationBar.navigateToConversationsPage();
//		}
//		catch (Exception e) {
//			Assert.assertFalse(true);
//		}
	}
	/*
	 * Helper methods
	 */
	


}
