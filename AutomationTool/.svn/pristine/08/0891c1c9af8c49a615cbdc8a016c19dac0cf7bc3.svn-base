package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.Driver;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebDracoonPage {
	
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;

	public WebDracoonPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();

	}
	
	@FindBy(xpath="//div[@class='mainDiv']//div[6]//div[@title='From Cloud Storage']")
	private WebElement from_cloud_storage_link;
	
	@FindBy(xpath="//div[@class='mainDiv']//div[2]/div[.='Add Dracoon Account']")
	private WebElement add_dracoon_account_link;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement dracoon_username_textbox;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement dracoon_password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement dracoon_login_button;
	
	@FindBy(xpath="//h1[text()='Client-Autorisation']")
	private WebElement client_authorization_text;
	
	@FindBy(xpath="//button[@value='approve']")
	private WebElement approve_client;
	
	@FindBy(xpath="//button[@id='oauth-approval-deny']")
	private WebElement deny_client;
	
	@FindBy(xpath="//div[div[text()='DRACOON']]/div[text()='murali.tallapudi@netsfere.com']")
	private WebElement dracoon_email_id;
	
	@FindBy(xpath="//div[@class='mainDiv']//div/div[6]/div/div[2]//div[2]/div[1]//div[2]/div[.='Test Attachments']")
	private WebElement dracoon_attachment_folder;
	
	@FindBy(xpath="//div[@class='mainDiv']//button[2]/span[.='Attach']")
	private WebElement dracoon_attach_button;
	

	public WebElement getDracoon_attach_button() {
		return dracoon_attach_button;
	}

	public WebElement getFrom_cloud_storage_link() {
		return from_cloud_storage_link;
	}

	public WebElement getAdd_dracoon_account_link() {
		return add_dracoon_account_link;
	}

	public WebElement getDracoon_username_textbox() {
		return dracoon_username_textbox;
	}

	public WebElement getDracoon_password() {
		return dracoon_password;
	}

	public WebElement getDracoon_login_button() {
		return dracoon_login_button;
	}

	public WebElement getClient_authorization_text() {
		return client_authorization_text;
	}

	public WebElement getApprove_client() {
		return approve_client;
	}

	public WebElement getDeny_client() {
		return deny_client;
	}

	public WebElement getDracoon_email_id() {
		return dracoon_email_id;
	}

	public WebElement getDracoon_attachment_folder() {
		return dracoon_attachment_folder;
	}
	
	public  static boolean isDracoonAccountExist(WebDriver webDriver) {		
		List<WebElement> elems = webDriver.findElements(By.xpath("//div[contains(text(),'DRACOON')]/../.."));		
		if ( elems.size() >= 1) {
			return true;
		} else {
			return false;
		}		
		
	}
	
	public void loginToDracoon(String username,String password) {
		dracoon_username_textbox.sendKeys(username);
		dracoon_password.sendKeys(password);
		dracoon_login_button.click();
//		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@value='approve']")));
//		approve_client.click();
	}
	
	
}
