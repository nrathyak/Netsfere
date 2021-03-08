package com.infinite.netsfere.automationtool.modules.web.pages;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.AndroidBase;

public class WebAttachmentFromDevicePage  {

	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebChatPage chatPage;
	 private static Logger log = LogManager.getLogger(WebAttachmentFromDevicePage.class.getName());

	
	public WebAttachmentFromDevicePage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		chatPage = new WebChatPage();
		
	}

	
	
	@FindBy(xpath="//div[contains(text(),'From Device')]")
	public WebElement fromDeviceButton;
	
	@FindBy(xpath="//div[contains(text(),'Add Attachment')]")
	public WebElement addAttachmentPopUp;

	@FindBy(xpath="//div[contains(text(),'From Cloud Storage')]")
	public WebElement fromCLoudStorageButton;

	@FindBy(xpath="//span[@class='icon ion-location']")
	public WebElement addLocationLink;
	
	
	@FindBy(xpath="//div[@title='Create Poll']")
	public WebElement createPollButton;
	
	@FindBy(xpath="//span[text()='Send']")
	public WebElement sendLocation;
	
	@FindBy(xpath="//span[text()='Other Location']")
	public WebElement otherLocation;
	
	
	@FindBy(xpath="//input[@placeholder='Search location...']")
	public WebElement searchLocation;
	
	@FindBy(xpath="//div[@class=\"autocomplete-dropdown-container\"]")
	public WebElement dropDownSelect;
	
	@FindBy(xpath="//div[text()='Add Box Account']")
	public WebElement addBoxAccount;
	
	@FindBy(xpath="//div[text()='Add Dracoon Account']")
	public WebElement addDracoonAccount;
	
	@FindBy(xpath="//div[text()='convergenceinfinite@gmail.com']")
	public WebElement boxAccount;
	
	@FindBy(xpath="//div[text()='Test']")
	public WebElement testAccount;
	
	@FindBy(xpath="//div[text()='Giff.gif']")
	public WebElement gifFile;
	
	@FindBy(xpath="//span[text()='Attach']")
	public WebElement attachButton;
	
	@FindBy(xpath="//div[text()='DRACOON']")
	public WebElement dracoonAccount;
	
	@FindBy(xpath="//div[text()='netsfere_attachments']")
	public WebElement dracoonAttachment;
	
	@FindBy(xpath="//div[text()='CSVFile.csv']")
	public WebElement csvFile;
	
	@FindBy(xpath="//div[text()='temp.jpg']")
	public WebElement jpgFile;
	
	@FindBy(xpath="//div[text()='PDFFile.pdf']")
	public WebElement pdfFile;
	
	public void clickOnAddBoxAccount() {
		addBoxAccount.click();
	}
	
	public void clickOnAddDracoonAccount() {
		addDracoonAccount.click();
	}
	
	public void selectBoxAccountAttachment() throws InterruptedException {
		boxAccount.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Test']")));
		testAccount.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Giff.gif']")));
		Thread.sleep(2000);
		webio.scrollDownToElement(pdfFile);
		pdfFile.click();
		attachButton.click();
	}
	
	public void selectDracoonAccountAttachment() {
		dracoonAccount.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='netsfere_attachments']")));
		dracoonAttachment.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='CSVFile.csv']")));
		csvFile.click();
		attachButton.click();
	}
	
	public void clickOnFromCloudStorageButton() {
		fromCLoudStorageButton.click();
	}
	
	public void send() throws IOException {
		Runtime.getRuntime().exec("D:\\Netsfere\\GifFileUpload.exe");
		//Runtime.getRuntime().exec("D:\\GifFileUpload.exe");
	}
	
	
	public void shareMyLocationLink(){
		chatPage.addButtonClick();
		Utils.veryShortSleep();
		
		addLocationLink.click();
		Utils.shortSleep();
		sendLocation.click();
//		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[div[div[a/img[contains(@src, 'https://maps.googleapis.com')]]]]/div[2]/div/div/span")));
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[div[div[a/img[contains(@src, 'https://maps.googleapis.com')]]]]/div")));
	}
	
	public void shareOtherLocationLink(String locationPin) throws InterruptedException {
		chatPage.addButtonClick();
		Utils.veryShortSleep();
		addLocationLink.click();
		Utils.shortSleep();
		otherLocation.click();
		searchLocation.sendKeys(locationPin);
		webio.ActionsSpaceAndBackspace();
		dropDownSelect.click();
		Utils.shortSleep();
		sendLocation.click();
		
	}
	
	
	public void sendAttachFromDevice() throws Exception {
		try{
		if(addAttachmentPopUp.isDisplayed()) {
			Utils.shortSleep();
			fromDeviceButton.click();
			//AutoIT framework used for window based file browser
     		Runtime.getRuntime().exec("D:\\Netsfere\\GifFileUpload.exe");
			//Runtime.getRuntime().exec("D:\\GifFileUpload.exe");
			webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Send')]")));
			chatPage.addAttachmentButton.click();
			webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-check']")));
		}
		}
		catch(NoSuchElementException e)
		{
			log.error("Attachment pop-up not found");
			throw new Exception();
		}
		
		
	}

	
}
