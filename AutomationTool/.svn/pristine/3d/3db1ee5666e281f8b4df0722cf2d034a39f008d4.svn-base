package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class SignUpPage {
	
//	WebDriver driver;
	WebDriver signUpDriver;
	WebDriverWait webwait;
	WebIoOperations webOpt = new WebIoOperations();
	
	
	public SignUpPage() {
		
//		this.driver = DriverManager.getWebDriver();
		this.signUpDriver = DriverManager.getSignUpWebDriver();
		PageFactory.initElements(signUpDriver, this);
		webwait = Utils.getLongWait(signUpDriver);
	}
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement newAccountEmailId;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Organization Name']")
	public WebElement organizationName;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='First Last']")
	public WebElement nameTextBox;
	
//	@FindBy(xpath="//select")
	@FindBy(xpath="//span[text()='place']/../select")
	public WebElement regionSelect;
	
	@FindBy(xpath="//span[@class='icon ion-android-checkbox-outline-blank']")
	public WebElement checkBoxForTermsCondition;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath="//span[contains(text(),'Invite Users')]")
	public WebElement inviteUsersText;
	
	@FindBy(xpath="//div[@id='signup-root']//div[2]//div[2]//div[2]/div[1]//input[@type='text']")
	public WebElement addUserNameTextbox;
	
	@FindBy(xpath="//div[@id='signup-root']//div[2]//div[2]//div[2]/div[2]//input[@type='email']")
	public WebElement addUserEmailTextbox;
	
	@FindBy(xpath="//button[@name='InvitePersonButton']")
	public WebElement invitePersonButton;
	
	@FindBy(xpath="//span[text()='close']")
	public WebElement closeButton;
	
	@FindBy(xpath="//div[@id='signup-root']//div[@class='container-fluid']//div[@class='form-group']/p[1]")
	public WebElement createdOrganizationConfirmation;
	
	@FindBy(xpath="//p[text()='Skip for now']")
	public WebElement skipUserAddButton;
	
	@FindBy(xpath="//span[contains(text(),'Add another invitation')]")
	public WebElement addAnotherInvitation;
	
	public void selectRegion(){
		webOpt.Select(regionSelect, Constants.sign_up_region);
		//webOpt.Select(regionSelect, 1);
	}
	
	public void skipUserAdd(){
		skipUserAddButton.click();
	}
	
	public void checkBoxClick(){
		checkBoxForTermsCondition.click();
	}
	
	public void submitButtonClick(){
		submitButton.click();
	}
	
	public void closePopUpButtonAddUser(){
		if(inviteUsersText.isDisplayed()){
			closeButton.click();
		}
	}
	
	public void inviteNewUser(String name, String emailId,String numberOfUsers) throws InterruptedException{
		int iTest = Integer.parseInt(numberOfUsers);
		for(int i=1;i<=iTest;i++) {
		addUserNameTextbox.sendKeys(name);
		addUserEmailTextbox.sendKeys(emailId);
		addAnotherInvitation.click();
		}
		if(invitePersonButton.isEnabled()){
			invitePersonButton.click();
		}else{
			webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='InvitePersonButton']")));
		}
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='signup-root']//div[@class='container-fluid']//div[@class='form-group']/p[1]")));
	}
	
	public void createNewOrg(String orgadminEmail , String organizationname ,String adminName){
		newAccountEmailId.sendKeys(orgadminEmail);
		organizationName.sendKeys(organizationname);
		nameTextBox.sendKeys(adminName);
		Utils.shortSleep();
		selectRegion();	
		checkBoxClick();
		if(submitButton.isEnabled())
		{
			submitButtonClick();
		}else{
			webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
		}
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Invite Users')]")));
		
	}

}
