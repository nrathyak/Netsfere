package com.infinite.netsfere.automationtool.modules.web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.WebSettingsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebAttachmentPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebContactsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebNavigationBar;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class SettingsTestCases extends BaseTestCases{
	
	WebDriver driver;
	WebDriverWait webWait;
	WebSettingsPage set;
	WebIoOperations webIo;
	WebAttachmentPage attach;
	public static final String helpUrl = "http://help.netsfere.com/#UserGuide";
	
	
	@BeforeClass
	public void init(){
		driver = DriverManager.getWebDriver();
		webWait = Utils.getLongWait(driver);
		set = new WebSettingsPage();
		webIo = new WebIoOperations();
		attach = new WebAttachmentPage();
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanChangePassword() throws Exception{
		set.clickChangePassword(Config.getInstance().getNewPassword(),
				Config.getInstance().getNewPassword(),
				Config.getInstance().getConfirmPassword());
		set.clickSubmitButton();
		Assert.assertEquals(true, set.passwordChangeMessage.getText().contains("Password Changed Successfully"));
		set.clickCloseButton();
		
	}
	
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanEditQuickReply(){
		set.editQuickReplyText();
	}

	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanNavigateToHelpPage(){
		set.clickHelpLink();
		webIo.SwitchWindow(driver);
		Assert.assertEquals(true, driver.getCurrentUrl().contains("http://help.netsfere.com/#UserGuide"));
		driver.close();
		webIo.SwitchWindow(driver);
		
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanNavigateLegalAndPrivatePage(){
		set.clickLegalLink();
		webIo.SwitchWindow(driver);
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://web.netsferetest.com/legal.html"));
		driver.close();
		webIo.SwitchWindow(driver);
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanViewVersionInfo(){
		set.clickVersionLink();
		Assert.assertEquals(true, set.versionInfoText.getText().contains("Version"));
		set.clickBackButton();
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanViewDeveloperInfo(){
		set.clickDeveloperInfo();
		Assert.assertEquals(true, set.developerInfoText.getText().contains("Developer"));
		set.clickBackButton();
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void webCanEditMeetingPointURL() throws InterruptedException{
		set.clickProfileTab();
		String oldName = set.meetingPointURLName.getText();
		set.clickAndEditMeetingPoint();
		set.clickCloseButton();
		set.clickProfileIcon();
		Thread.sleep(2000);
		set.clickProfileTab();
		String newName = set.meetingPointURLName.getText();
		Assert.assertNotSame(oldName, newName);
		set.setBackOldName();
		set.clickCloseButton();
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void changeProfilePic() throws FindFailed, InterruptedException {
		attach.webChangeProfilePicFromDevice("PNG", "png");
		set.clickCloseButton();
	}
	
	@Test
	@NavigateTo(WebSettingsPage.class)
	public void logout() {
		set.clickProfileTab();
		set.logoutButtonClick();
	}
}
