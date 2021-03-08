
package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAttachmentPage{
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebDriverWait shortWait;
	public static final String project_Dir= System.getProperty("user.dir");
	WebSettingsPage setPage;
	
	public WebAttachmentPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		shortWait = Utils.getShortWait(driver);
		webio = new WebIoOperations();
		setPage = new WebSettingsPage();
	}
	
	@FindBy(xpath="//span[@class='icon ion-plus-circled']")
	public WebElement sendAttachmentButton;

	@FindBy(xpath="//div[contains(text(),'From Device')]")
	public WebElement fromDeviceButton;
	
	@FindBy(xpath="//span[contains(text(),'Send')]")
	public WebElement sendButton;
	
	@FindBy(xpath="//span[text()='Yes']")
	public WebElement yesButton;
	
	@FindBy(xpath="//span[text()='No']")
	public WebElement noButton;
	
	
	@FindBy(xpath="//div[text()='Cancel Upload?']")
	public WebElement cancelUploadPopUp;

	public void sendAttachmentFromDevice(String filename, String extension) throws FindFailed {

		String project_Dir = System.getProperty("user.dir");
		Screen scn = new Screen();
		Pattern fileInputTextBox = new Pattern(project_Dir + "\\Attachment\\" + "FileTextBox.PNG");
		Pattern openButton = new Pattern(project_Dir + "\\Attachment\\" + "OpenButton.PNG");
		sendAttachmentButton.click();
		Utils.veryShortSleep();
		fromDeviceButton.click();
		scn.wait(fileInputTextBox, 20);
		scn.type(fileInputTextBox, project_Dir + "\\Attachment\\" + filename + "." + extension);
		scn.click(openButton);
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Send')]")));
		sendButton.click();	
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='fa fa-check']")));	

	} 
	
	public void webChangeProfilePicFromDevice(String filename, String extension) throws InterruptedException, FindFailed {
		String project_Dir = System.getProperty("user.dir");
		Screen scn = new Screen();
		Pattern fileInputTextBox = new Pattern(project_Dir + "\\Attachment\\" + "FileTextBox.PNG");
		Pattern openButton = new Pattern(project_Dir + "\\Attachment\\" + "OpenButton.PNG");
		setPage.clickOnChangeProfilePicIcon();
		scn.wait(fileInputTextBox, 20);
		scn.type(fileInputTextBox, project_Dir + "\\Attachment\\" + filename + "." + extension);
		scn.click(openButton);
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Save']")));
		setPage.savePicButton.click();
		Utils.shortSleep();
	}
        
    }








