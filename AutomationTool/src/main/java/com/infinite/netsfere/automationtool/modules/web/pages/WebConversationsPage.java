package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

import io.appium.java_client.functions.ExpectedCondition;

public class WebConversationsPage extends WebGenericListPage implements BasePage {

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebLeaveConversationPage leaveConversationPage;
	private static Logger log = LogManager.getLogger(WebConversationsPage.class.getName());
	private static final String user2 = Config.getInstance().getAndroidUserDisplayName();
	private static final String guestDisplayName = Config.getInstance().getGuestDisplayName();


	public WebConversationsPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		leaveConversationPage = new WebLeaveConversationPage();

	}

	/*
	 * Conversation Link
	 */

	@FindBy(xpath = "//button[@title='Start Conversation']")
	public WebElement startConversationButton;

	@FindBy(xpath = "//input[@type='text' and @class='namegenEmailReplace']")
	public WebElement searchcontactstextbox;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[6]/div[1]/div[@class='scrollbox']/div[@class='table-view']/div[4]/div/div[@class='click-ripple']")
	public WebElement contactSelect;

	@FindBy(xpath = "//span[text()='Create']")
	public WebElement createButton;

	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElement cancelButton;

	@FindBy(xpath = "//span[text()='Discard']")
	public WebElement discardButton;

	@FindBy(xpath = "//span[@class='icon ion-gear-a']")
	public WebElement conversationSetting;

	@FindBy(xpath = "/html//div[@class='mainDiv']//div[2]/input[@type='text']")
	public WebElement conversationTitle;

	@FindBy(xpath = "//button/span[text()='Save']")
	public WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Conversation created')]")
	public WebElement conversationCreatedPage;

	@FindBy(xpath = "//div[@class='mainDiv']//div[3]//div[2]/div/div[2]/span")
	public WebElement title;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']//span[@class='fa fa-unlock-alt']")
	public WebElement netcConversation;

	@FindBy(xpath = "//div[contains(text(),'Favorite')]")
	public WebElement favorite;
	
	@FindBy(xpath="//span[contains(text(),'Favorite')]")
	public WebElement favoriteConvTab;
	
	@FindBy(xpath="//span[@class='icon ion-star']")
	public WebElement favoriteConv;
	
	@FindBy(xpath="//div[contains(text(),'Unfavorite')]")
	public WebElement unFavoriteConv;
	
	@FindBy(xpath ="//div[contains(text(),'Mute')]")
	public WebElement muteConv;
	
	@FindBy(xpath ="//div[contains(text(),'Unmute')]")
	public WebElement unmuteConv;
	
	
	@FindBy(xpath="//span[contains(text(),'All')]")
	public WebElement allConv;

	/*
	 * Add or remove participant
	 */

	@FindBy(xpath = "//div[@class='mainDiv']//div[1]/div[2]//div[@class='scrollbox']/div[@class='table-view']/div[4]//div[3]/div[1]")
	public WebElement removeicon;

	/*
	 * Leave conversation elements
	 */
	@FindBy(xpath = "//span[@class='fa fa-sign-out']")
	public WebElement leaveConversation;

	/*
	 * export Elements
	 */
	@FindBy(xpath = "//span[contains(text(),'email')]")
	public WebElement exportConversation;

	/*
	 * Guest pop up
	 */

	@FindBy(xpath = "//div[text()='Customize Your Invitation to Guest']")
	public String guestPopUpText;

	@FindBy(xpath = "//button/span[text()='Send']")
	public WebElement sendInvitationButton;

	/*
	 * Poll Button in conversationList
	 */
	@FindBy(xpath="//span[@title='POLL']")
	public WebElement pollLabel;
	
	/*
	 * Guest Tag from conversation List
	 */
	@FindBy(xpath = "//div[@class='mainDiv']/div[1]//div[@class='scrollbox']/div[@class='table-view']/div[3]//span[@title='GUEST']")
	public WebElement guestTag;

	@FindBy(xpath = "//span[@class='fa fa-check' and @title ='Sent']")
	public WebElement sentMark;
	
	/*
	 * Meeting icon
	 */
	
	/*@FindBy(xpath="//div[@class='mainDiv']//div[2]/button[2]")
	public WebElement meetingIcon;*/
	
	@FindBy(xpath="//span[contains(text(),'Schedule Meeting')]")
	public WebElement meetingIcon;
	
	
	
	
	/*
	 * Badge count elements
	 */
	
	@FindBy(xpath="//div[@title='Conversations']//..//div[2]")
	public WebElement convBadgeCount;
	
	@FindBy(xpath="//span[contains(text(),'Unread')]")
	public WebElement unreadTab;
	
	@FindBy(xpath="//span[text()='All']")
	public WebElement allTab;
	
	@FindBy(xpath="//span[contains(text(),'Unread')]/../span[2]")
	public WebElement unreadBadgeCount;
	
	//************
	@FindBy(xpath="//span[text()='now']")
	public WebElement recentCreatedConversation;
	
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div[3]/div/div[3]/div[2]/div[2]")
	public WebElement recentConversation;
	
	@FindBy(xpath="//div[span[text()='3']]")
	public WebElement participantCount;
	
	@FindBy(xpath="//div[@class='mainDiv']//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span")
	public WebElement messageFromAndroid;
	
	@FindBy(xpath="//span[@class='icon ion-navicon-round']/../../../../div[@class='table-view']/div[3]")
	public WebElement firstConversation;
	
	@FindBy(xpath="//span/button//span[@class='icon ion-android-more-vertical']")
	public WebElement convOptions;
	
	@FindBy(xpath="//*[@id='leftColumn']/div/div[2]/div[3]/div/div[3]/div[3]/span/div/div/div/button[1]")
	public WebElement favoriteAllTab;
	
	@FindBy(xpath="//*[@id='leftColumn']/div/div[2]/div[3]/div/div[3]/div[3]/span/div/div/div/button[2]")
	public WebElement muteAllTab;
	
	@FindBy(xpath="//*[@id='leftColumn']/div/div[2]/div[3]/div/div[3]/div[3]/span/div/div/div/button[3]")
	public WebElement leaveAllTab;
	
	//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div[3]/div
	
//	@FindBy(xpath="//div[@class='scrollbox']/div[2]/div/div")
//	public WebElement conversationList;
	
	
	//-- //div[@class='scrollbox']/div[2]/div[8]
	/*
	 * Methods
	 */
	public void clickRecentConv(){
         recentConversation.click();
	 }
	public String fetchingOwnerNameDefaultTitle(){
		String ownerNameAsDefaultTitle  = driver.findElement(By.xpath("//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[3]//div[3]//div[.='"+user2+"']")).getText();
		return ownerNameAsDefaultTitle;
	}
	public void clickOnNewConversation() {
		startConversationButton.click();
	}
	
	public void clickMeetingIcon(){
		if(meetingIcon.isDisplayed()){
			Utils.veryShortSleep();
			meetingIcon.click();
		}
	}

	public void searchAndSelectContact(String androidDisplayName) throws InterruptedException {
		searchcontactstextbox.sendKeys(androidDisplayName);
		webio.ActionsSpaceAndBackspace();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[6]/div[1]/div[@class='scrollbox']/div[@class='table-view']/div[4]/div/div[3]/div[.='"
						+ androidDisplayName + "']")));
		contactSelect.click();
	}

	public void addGuestUser(String guestUser) {
		searchcontactstextbox.sendKeys(guestUser);
		webio.spacebar();
	}

	public void createConversationbutton() {
		createButton.click();
		Utils.shortSleep();
		// webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Conversation
		// created')]")));
	}

	public void discardConversation() {
		cancelButton.click();
		discardButton.click();
	}

	public void conversationSettings() {
		conversationSetting.click();
	}
	public void favoriteConversation() {
		favoriteConv.click();
		Utils.veryShortSleep();
		Assert.assertTrue(unFavoriteConv.isDisplayed());
	}
	public void unFavoriteConversation() {
		unFavoriteConv.click();
		Utils.veryShortSleep();
		Assert.assertTrue(favoriteConv.isDisplayed());
	}
	
	public void muteConversation() {
		muteConv.click();
		Utils.veryShortSleep();
		Assert.assertTrue(unmuteConv.isDisplayed());
	}
	
	public void unMuteConversation() {
		unmuteConv.click();
		Utils.veryShortSleep();
		Assert.assertTrue(muteConv.isDisplayed());
	}
	

	public void conversationTitle(String title) throws InterruptedException {
		conversationTitle.sendKeys(title);
		Thread.sleep(3000);

	}

	public void saveButton() {
		saveButton.click();
		webwait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Conversation created')]")));
	}

	public void clickOnLeaveConversation() {
		Utils.veryShortSleep();
		leaveConversation.click();
		Utils.veryShortSleep();
	}

	public void removepariticipanticon() {
		removeicon.click();
	}

	public void clickOnExportConversation() {
		exportConversation.click();
	}

	public void guestPopUp() throws InterruptedException {
		Thread.sleep(3000);
		sendInvitationButton.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Conversation created')]")));
	}

	
	public void groupConversationParticipantCheck(){
		recentConversation.click();
		String participant = participantCount.getText();
		String numOfParticipants = participant.substring(0, participant.indexOf(' '));
		int count = Integer.parseInt(numOfParticipants);
		if(count >2){
			log.info("Group conversation Created");
		}else{
			Assert.fail();
		}
	}
	
	public String addingGuestAssertion(){
		Assert.assertEquals("1 min", recentCreatedConversation.getText());
		recentConversation.click();
		String ownerNameAsDefaultTitle  = driver.findElement(By.xpath("//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[3]//div[3]//div[contains(text(),'"+guestDisplayName+"')]")).getText();
		return ownerNameAsDefaultTitle;
		
	}
	
	
	
	
	
	public String numberOfUnreadConversation() {
		String unread = convBadgeCount.getText();
		System.out.println(unread);
		return unread;
	}
/*	
	public String firstConversationTitleInAllTAb() {
		List<WebElement> convtitle = driver.findElements(By.xpath("//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div/div"));
		String firstConvTitle = convtitle.get(1).getText();
		System.out.println(firstConvTitle);
		return firstConvTitle;
	}
	*/
	
	public void validateBadgeCountInUnreadTab() throws Exception {
		String unreadMessageCount = unreadBadgeCount.getText();
		clickOnFirstListItem();
		String unreadMessageCount2= unreadBadgeCount.getText();
		if(unreadMessageCount!=unreadMessageCount2) {
			log.info("One Unread conversation read");
		}
	}
	public void clickOnUneadTab() {
		unreadTab.click();
	}
	
	public void clickOnAllTab() {
		allTab.click();
	}
	
	public void clickOnConvMoreOptions() {
		convOptions.click();
	}
	
	public void favoriteAllTab() {
		favoriteAllTab.click();
		Utils.veryShortSleep();
		Assert.assertTrue(unFavoriteConv.isDisplayed());
	}
	
	public void muteAllTab() {
		muteAllTab.click();
		Utils.veryShortSleep();
		Assert.assertTrue(unmuteConv.isDisplayed());
	}
	
	public void leaveAllTab() {
		leaveAllTab.click();
	}
	public void webCleanUp() {
		List<WebElement> conv_list = driver.findElements(By.xpath(
				"//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div/div"));
		if(conv_list.size()<=1) {
			log.info("Only Netc conversation present");
		}
		else if(conv_list.size()>1) {
			while(conv_list.size()>5) {
				conv_list.get(5).click();
				leaveConversation.click();
				try {
					leaveConversationPage.leaveConversation();
					Utils.veryShortSleep();
				}
				catch(Exception e) {
					leaveConversationPage.destroyConversation();
					Utils.veryShortSleep();
				}
				finally {
					conv_list = driver.findElements(By.xpath(
							"//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div/div"));
				}
			}
			
		}
	}
	
	public void clickOnFirstConversation() {
		firstConversation.click();
	}

	@Override
	WebElement getFirstListItem() {
		WebElement conv = null;
		List<WebElement> conv_list = driver.findElements(By.xpath(
				"//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div/div"));
		if (conv_list.size() >= 1) {
			conv = conv_list.get(0);

		}
		return conv;
	}


	public boolean isAt() {
		try {
			return driver.getCurrentUrl().contains("https://web.netsferetest.com/#/conversations");
		
	}catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in Conversations page");
			}
	}
	return false;
	}


	public void navigateTo() throws Exception {
		
		WebNavigationBar.getInstance().navigateToConversationsPage();
	}

}