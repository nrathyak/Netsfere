package com.infinite.netsfere.automationtool.modules.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class NewConversationPage implements BasePage{

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebConversationsPage webConversationsPage;
	WebChatPage webChat;
	private static Logger log = LogManager.getLogger(NewConversationPage.class.getName());
	
	public NewConversationPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		webConversationsPage = new  WebConversationsPage();
		webChat = new WebChatPage();

	}

	@FindBy(xpath = "//span[text()='Create']")
	public WebElement createButton;

	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElement cancelButton;

	@FindBy(xpath = "//span[text()='Discard']")
	public WebElement discardButton;

//	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div/span")
	
//	@FindBy(xpath="//div[@class='mainDiv']//div[3]//div[2]/div/div[2]/span")
	
	@FindBy(xpath="//div[@showmeeting='true']/span[1]")
	public WebElement convTitle;

	@FindBy(xpath = "//input[@type='text' and @class='namegenEmailReplace']")
	public WebElement searchcontactstextbox;

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div/div/div/div[@class='table-view']/div[4]/div")
//	@FindBy(xpath="/html//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[6]/div[1]/div[@class='scrollbox']/div[@class='table-view']/div[4]/div/div[1]")
	public WebElement contactSelect;

	@FindBy(xpath = "/html//div[@class='mainDiv']//div[2]/input[@type='text']")
	public WebElement newConversationTitle;

	public void searchAndSelectContact(String androidDisplayName) throws InterruptedException {
		searchcontactstextbox.sendKeys(androidDisplayName);
		webio.ActionsSpaceAndBackspace();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div/div/div/div[@class='table-view']/div/div[1]/div[.='"+ androidDisplayName +"']")));
		contactSelect.click();
	}
	
	public void searchAndSelectGuestContact(String guestDisplayName) throws InterruptedException 
	{
		searchcontactstextbox.sendKeys(guestDisplayName);
		webio.ActionsSpaceAndBackspace();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div/div/div/div[@class='table-view']/div[4]/div")));
		contactSelect.click();
	}

	public void addGuestUser(String guestUser) {
		searchcontactstextbox.sendKeys(guestUser);
		webio.spacebar();
	}

	public void createConversationbutton() {
		createButton.click();
		Utils.shortSleep();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Conversation created')]")));
	}
	
	public void createConversationForGuestUser() throws InterruptedException {
		createButton.click();
		Utils.veryShortSleep();
		webChat.guestPopUp();
	}

	public void discardConversation() {
		cancelButton.click();
		discardButton.click();
	}

	public void conversationTitle(String title) throws InterruptedException {
		newConversationTitle.sendKeys(title);
		Thread.sleep(3000);

	}

	public boolean isAt() {
		// To check if a new conversation page is open.
		try {
				return driver.getCurrentUrl().contains("https://web.netsferetest.com/#/conversations/new");
			
		}catch (Exception e) {
				if (e instanceof NoSuchElementException) {
					log.info("Currently not in new conversation page");
				}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// TODO Auto-generated method stub
		webConversationsPage.clickOnNewConversation();
		
	}

}
