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

public class SaveAttachmentToDevicePage {
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	
	
	public SaveAttachmentToDevicePage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		
	}

	
	@FindBy(xpath="//span[@class='fa fa-cloud-download']")
	public WebElement saveAttachmentButton;
	
	@FindBy(xpath="//div[contains(text(),'Save Attachment')]")
	public WebElement saveAttachmentPopUp;
	
	@FindBy(xpath="//div[contains(text(),'Device')]")
	public WebElement saveToDevice;
	
	@FindBy(xpath="//span[contains(text(),'close')]")
	public WebElement closeButton;
	
	@FindBy(xpath="//div[@class='bubbleWrap']")
	public WebElement sentAttachment;
	
	public void saveAttachment() {
		if(sentAttachment.isDisplayed()) {
			sentAttachment.click();
		}
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-cloud-download']")));
		Utils.shortSleep();
		saveAttachmentButton.click();
		Utils.veryShortSleep();
		if(saveAttachmentPopUp.isDisplayed()) {
			saveToDevice.click();
			closeButton.click();
		}
	}

}
