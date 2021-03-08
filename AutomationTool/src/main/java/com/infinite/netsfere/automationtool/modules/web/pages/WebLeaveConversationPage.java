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

public class WebLeaveConversationPage {

	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	String displayname;
	public WebLeaveConversationPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
	}
	
	/*
	 * transfer ownership and destroy conversation elements
	 */

	@FindBy(xpath="//div[contains(text(),'Transfer Ownership')]")
	public WebElement transferOwnershipPopUp;
	
	@FindBy(xpath="//div[contains(text(),'Transfer Ownership')]//..//div[@class='table-view']/div[2]")
	public WebElement selectFirstParticipant;
	
	@FindBy(xpath="//div[@class='table-view']//..//label//div/div[2]")
	public WebElement leaveConversationCheck;
	
	@FindBy(xpath="//span[contains(text(),'transfer')]")
	public WebElement transferOwnership;
		
	@FindBy(xpath="//span[contains(text(),'Destroy')]")
	public WebElement destroyConversation;
	
	@FindBy(xpath="//div[contains(text(),'Destroy Conversation')]")
	public WebElement destroyConversationPopUp;
	
	@FindBy(xpath="//span[contains(text(),'Destroy')]")
	public WebElement destroyConfirm;
	/*
	 * Change Owner web Elements
	 */

	@FindBy(xpath="//div[contains(text(),'Change Owner')]")
	public WebElement changeOwnerPopUp;
	

	@FindBy(xpath="//span[contains(text(),'Change Owner')]")
	public WebElement changeOwnerConfirm;
	

	@FindBy(xpath="//div[contains(text(),'Leave Conversation')]")
	public WebElement leaveConversationPopUp;
	
	@FindBy(xpath="//div[contains(text(),'Leave Conversation')]//..//span[contains(text(),'Leave')]")
	public WebElement leaveConfirm;
	
	public void clickOnFirstParticipant() {
		if(transferOwnershipPopUp.isDisplayed())
		{
			selectFirstParticipant.click();
		}
	}
	
	
	public void clickOnTransferOwnership() {
		if(transferOwnership.isEnabled())
		{
			transferOwnership.click();
		}
	}
	public void transferOwnershipWithoutLeavingConversation() {
			clickOnFirstParticipant();
			Utils.veryShortSleep();
			leaveConversationCheck.click();
			transferOwnership.click();
			webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Change Owner')]")));
			if(changeOwnerPopUp.isDisplayed())
			{
				Utils.veryShortSleep();
				changeOwnerConfirm.click();
				
			}
		}
	
	public void destroyConversation() {
		try{
			if(transferOwnershipPopUp.isDisplayed())
			{
				destroyConversation.click();
				webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Destroy Conversation')]")));
				if(destroyConversationPopUp.isDisplayed())
				{
					Utils.veryShortSleep();
					destroyConfirm.click();
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage()+e.getClass());
		}
	}
	public void leaveConversation() {
		if(leaveConversationPopUp.isDisplayed())
		{
			leaveConfirm.click();
		}
	}
}
