package com.infinite.netsfere.automationtool.modules.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebExportConversationPage {
	
	
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	private static Logger log = LogManager.getLogger(WebExportConversationPage.class.getName());
	public WebExportConversationPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
	}

	
	@FindBy(xpath="//span[@class='icon ion-android-more-vertical']")
	public WebElement selectMessage;
	
	@FindBy(xpath="//span[contains(text(),'Export All')]")
	public WebElement exportAll;
	
	@FindBy(xpath="//input[@placeholder='Type your custom message']")
	public WebElement customMessageText;
	
	@FindBy(xpath="//span[@class='icon ion-share']")
	public WebElement sendMail;
	
	@FindBy(xpath="//div[contains(text(),'Export Conversation to Email')]")
	public WebElement exportConversationPopUp;
	
//	@FindBy(xpath="//input[@placeholder='Type your custom message']")
//	public WebElement customMessageText;
	
	
	public void exportNetcConversation() {
		selectMessage.click();
		exportAll.click();
		Utils.veryShortSleep();
		try {
			if(exportConversationPopUp.isDisplayed())
				{
			customMessageText.sendKeys("Exporting Conversation..!");
			sendMail.click();
			log.info("NetC Conversation exported successfully..!");
				}
		}
		catch (Exception e) {
			
		}
	}
	
	
}
