package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class ConversationDetailsPage {

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;

	public ConversationDetailsPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();

	}

	/*
	 * Add or remove participant
	 */

	@FindBy(xpath = "//div[@class='mainDiv']//div[1]/div[2]//div[@class='scrollbox']/div[@class='table-view']/div[4]//div[3]/div[1]")
	public WebElement removeicon;

	/*
	 * Leave conversation elements
	 */
	@FindBy(xpath = "//div[contains(text(),'Leave')]")
	public WebElement leaveConversation;

	/*
	 * export Elements
	 */
	@FindBy(xpath = "//span[@class='icon ion-android-mail']")
	public WebElement exportConversation;

	@FindBy(xpath = "//span[@class='icon ion-gear-a']")
	public WebElement conversationSetting;

	@FindBy(xpath = "//button/span[text()='Save']")
	public WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Favorite')]")
	public WebElement favorite;
	
	@FindBy(xpath="//div[text()='Edit Participant(s)']")
	public WebElement editParticipants;
	
	public boolean settingButtonOnConversation(){
		try{
			if(conversationSetting.isDisplayed()){
				return true;
			}
		}
			
			catch (Exception e) {
				e.getMessage();
			}
			return false;
	}
	
	public boolean editParticipantsLink(){
		try{
			if(editParticipants.isDisplayed()){
				return true;
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return false;
		
	}

	public void conversationSettings() {
		conversationSetting.click();
	}

	public void saveButton() {
		saveButton.click();
		Utils.veryShortSleep();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Conversation created')]")));
	}

	public void clickOnLeaveConversation() throws InterruptedException {
		leaveConversation.click();
		Thread.sleep(4000);
//		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Leave Conversation')]")));
	}

	public void removepariticipanticon() {
		removeicon.click();
	}

	public void clickOnExportConversation() {
		exportConversation.click();
	}

}
