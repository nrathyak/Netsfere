package com.infinite.netsfere.automationtool.modules.web.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.android.pages.BottomNavigationBar;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
public class WebNavigationBar {
	
	WebDriver driver;
	WebDriverWait webwait;
	private static WebNavigationBar instance = null;
	

	public static WebNavigationBar getInstance() {
		if (instance == null) {
			instance = new WebNavigationBar();
		}
		return instance;
	}
	
	
	public WebNavigationBar() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		
	}
	
	@FindBy(xpath="//span[@class='icon ion-ios-chatbubble']")
	public WebElement ConversationIcon;
	
	@FindBy(xpath="//span[@class='icon ion-person-stalker']")
	public WebElement contactIcon;
	
	@FindBy(xpath="//span[@class='icon ion-speakerphone']")
	public WebElement channelIcon;

	//@FindBy(xpath="//span[@class='icon ion-android-call']")
	
	@FindBy(xpath="//div[@class='sideBarMenuButton']//span[@class='icon ion-android-call']")
	public WebElement callIcon;
	
	@FindBy(xpath="//span[@class='icon ion-earth']")
	public WebElement administratorIcon;
	
	@FindBy(xpath="//span[@class='icon ion-person-add']")
	public WebElement addaUserIcon;
	

	@FindBy(xpath="//div[@class='sideBarMenuButton']//span[@class='fa fa-calendar']")
	public WebElement meetingsIcon;
	
	@FindBy(xpath="//div[@title='Settings']/div/img")
	public WebElement settingIcon;
	
	@FindBy(xpath="//span[text()='Settings']")
	public WebElement settingsPage;
	
	
	public void navigateToConversationsPage()
	{
		ConversationIcon.click();
	}
	public void navigateToContactsage()
	{
		contactIcon.click();	
	}
	public void navigateToChannelsPage()
	{
		channelIcon.click();
	}
	public void navigateToCallLogsPage()
	{
		callIcon.click();
	}
	
	public void navigateToMeetingsPage() {
		meetingsIcon.click();
	}
	
	public void navigateToUserSettingPage(){
		settingIcon.click();
		Utils.veryShortSleep();
		settingsPage.click();
	}

}

