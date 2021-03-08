package com.infinite.netsfere.automationtool.modules.web.pages;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebSettingsPage extends WebGenericListPage implements BasePage {
	
	WebDriver driver;
	WebDriverWait webwait;
//	WebIoOperations webOpt = new WebIoOperations();
	private static Logger log = LogManager.getLogger(WebContactsPage.class.getName());
	static String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	public static String oldName;
	
	
	public WebSettingsPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
	}
	
	@FindBy(xpath="//div[@class='mainDiv']//div[@class='sideBarMenu']//div[@title='Settings']//img")
	public WebElement profileIcon;
	

//	@FindBy(xpath="//div[@class='mainDiv']/div[2]//div[2]/div/div/div//button")
	@FindBy(xpath="//span[text()='Logout']")
	public WebElement logoutButton;
	
	@FindBy(xpath="//span[text()='Settings']")
	public WebElement settingsTab;
	
	@FindBy(xpath="//span[text()='Profile']")
	public WebElement profileTab;
	
	@FindBy(xpath="//div[text()='Access Requests']")
	public WebElement accessRequest;
	
	@FindBy(xpath="//div[text()='Quick Replies']")
	public WebElement quickReplies;
	
	@FindBy(xpath="//div[text()='Change Password']")
	public WebElement changePassword;
	
	@FindBy(xpath="//input[@type='password' and @placeholder='Enter current password']")
	public WebElement currentPasswordTextBox;
	
	@FindBy(xpath="//input[@type='password' and @placeholder='Enter new Password']")
	public WebElement newPasswordTextBox;
	
	@FindBy(xpath="//input[@type='password' and @placeholder='Confirm Password']")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(xpath="//button/span[text()='Submit']")
	public WebElement submitButton;
	
	@FindBy(xpath="//span[text()='Password Changed Successfully']")
	public WebElement passwordChangeMessage;
	
	@FindBy(xpath="//div[text()='Help']")
	public WebElement help;
	
	@FindBy(xpath="//div[text()='Feedback']")
	public WebElement feedback;
	
	@FindBy(xpath="//div[text()='Support']")
	public WebElement support;
	
	@FindBy(xpath="//div[text()='Legal & Privacy']")
	public WebElement legalAndPrivacy;
	
	@FindBy(xpath="//div[text()='Version Info']")
	public WebElement versionInfo;
	
	@FindBy(xpath="//div[span[@class='icon ion-chevron-left']]/div/div[contains(text(),'Version Info')]")
	public WebElement versionInfoText;
	
	@FindBy(xpath="//span[@class='icon ion-chevron-left']")
	public WebElement backButtonOnPage;
	
	@FindBy(xpath="//div[text()='Developer Info']")
	public WebElement developerInfo;
	
	@FindBy(xpath="//div[span[@class='icon ion-chevron-left']]/div/div[contains(text(),'Developer Info')]")
	public WebElement developerInfoText;
	
	@FindBy(xpath="//div[@class='mainDiv']/div[2]/div/div/div[2]/div/div/div//div[@class='']//div[@class='scrollbox']/div[@class='table-view']/div[2]/div/div[2]/textarea[1]")
	public WebElement firstQuickReplyText;
	
	@FindBy(xpath="//span[text()='close']")
	public WebElement closeButton;
	
	@FindBy(xpath="//div[@class='mainDiv']/div[2]//div[2]/div[2]/input[@type='text']")
	public WebElement meetingPointURLName;
	
	@FindBy(xpath="//img[@src='images/ChangeProfileImageBadge.png']")
	public WebElement changePicButton;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement savePicButton;
	
	public void logoutButtonClick(){
		profileTab.click();
		Utils.veryShortSleep();
		webio.scrollToThePageEnd();
		logoutButton.click();
	}
	
	public void clickQuickREply(){
		quickReplies.click();
	}
	
	public void editQuickReplyText(){
		String olsString = firstQuickReplyText.getText();
		firstQuickReplyText.click();
		firstQuickReplyText.sendKeys("Hello");
		String newString = firstQuickReplyText.getText();
		Assert.assertNotSame(olsString, newString);
	}
	
	public void clickHelpLink(){
		help.click();
	}
	
	public void clickLegalLink(){
		legalAndPrivacy.click();
	}
	
	public void clickVersionLink(){
		versionInfo.click();
	}
	
	public void clickBackButton(){
		backButtonOnPage.click();
	}
	
	public void clickDeveloperInfo(){
		developerInfo.click();
	}
	
	public void clickCloseButton(){
		closeButton.click();
	}
	
	public void clickProfileTab(){
		profileTab.click();
	}
	
	public void clickAndEditMeetingPoint(){
		String randomDate = new SimpleDateFormat("mmss").format(new java.util.Date());
		oldName = meetingPointURLName.getText();
		meetingPointURLName.click();
		String newName = oldName+randomDate;
		WebIoOperations.clearText(meetingPointURLName);
		meetingPointURLName.sendKeys(newName);
		
	}
	
	public void setBackOldName(){
		WebIoOperations.clearText(meetingPointURLName);
		meetingPointURLName.sendKeys(oldName);
	}
	
	public void clickProfileIcon(){
		profileIcon.click();
	}
	
	public void clickOnChangeProfilePicIcon() throws InterruptedException {
		clickProfileTab();
		Thread.sleep(3000);
		changePicButton.click();
	}
	public void clickChangePassword(String currentPwd, String newPwd, String cofirmPwd){
		changePassword.click();
		Utils.veryShortSleep();
		currentPasswordTextBox.sendKeys(currentPwd);
		newPasswordTextBox.sendKeys(newPwd);
		confirmPasswordTextBox.sendKeys(cofirmPwd);
		
	}
	
	public void clickSubmitButton() throws Exception{
		try{
			if(submitButton.isEnabled()){
			submitButton.click();
			}
		}catch (NoSuchElementException e) {
			throw new Exception("Button is not enabled");
		}
		Utils.veryShortSleep();
	}
	
	public boolean isAt() {
		try {
			return settingsTab.isDisplayed();
		
	}catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in Contacts page");
			}
	}
	return false;
	}

	public void navigateTo() throws Exception {
		WebNavigationBar.getInstance().navigateToUserSettingPage();
		settingsTab.click();
	}
	

	@Override
	WebElement getFirstListItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
