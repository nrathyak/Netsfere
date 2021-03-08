package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class UserActivation {
	
//	WebDriver driver;
	WebDriver signupDriver;
//	WebDriverWait webWait1;
	WebDriverWait webWait1;
	WebIoOperations webOpt = new WebIoOperations();
	
	
	public UserActivation() {
		
//		this.driver = DriverManager.getWebDriver();
		this.signupDriver = DriverManager.getSignUpWebDriver();
		PageFactory.initElements(signupDriver, this);
//		PageFactory.initElements(driver, this);
//		webWait1 = Utils.getLongWait(driver);
//		webWait1 = Utils.getMediumWait(signupDriver);
	}
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement emailTextbox;
	
	@FindBy(xpath="//span[text()='Next']")
	public WebElement nextButton;
	
	@FindBy(xpath="//input[@name='password']")
//	@FindBy(xpath="//div[@id='password']")
	public WebElement gmailpasswordTextbox;
	
	@FindBy(xpath="//img[@class='gb_Wa']")
	public WebElement gmailLogo;
	
	@FindBy(xpath="//tr[1][td[6][div[div[div[span[span[text()='Your NetSfere Organization is Ready']]]]]]]")
	public WebElement latestCreatedOrganizationMail;
	
//	@FindBy(xpath="//span[contains(text(),'Join my NetSfere conversation')]")
	@FindBy(xpath="//tr[@class='zA zE byw']")
	public WebElement guestUserInvitationMail;
	
	@FindBy(xpath="//div[text()='Get Started']")
	public WebElement activationButtonInMail;
	
	@FindBy(xpath="//input[@type='password' and @placeholder='Enter password']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@type='password' and @placeholder='Confirm password']")
	public WebElement confirmPasswordTextBox;
	
	@FindBy(xpath="//span[@class='icon ion-android-checkbox-outline-blank']")
	public WebElement checkBox;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement activateButton;
	
	@FindBy(xpath="//div[text()='Activate Your Account']")
	public WebElement activationPageText;
	
	@FindBy(xpath="//div[text()='Join Conversation ']")
	public WebElement joinConversation;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Enter display name']")
	public WebElement displayName;
	
	@FindBy(xpath="//tr[1][td[6][div[div[div[span[span[contains(text(),'Duplicate Account Created For')]]]]]]]")
	public WebElement duplicateOrganisationMail;
	
	@FindBy(xpath="//h2[contains(text(),'Duplicate Account Created')]")
	public WebElement duplicateText;

	@FindBy(xpath="//span[@class='CJ']")
	public WebElement moreMail;
	
	@FindBy(xpath="//a[@title='Spam']")
	public WebElement spamMail;
	
	@FindBy(xpath="//input[@aria-label='Search mail']")
	public WebElement searchMail;
	
	@FindBy(xpath="//span[text()='View messages.']")
	public WebElement viewMoreMail;
	
	/*
	 * additional gmail elements
	 */
	@FindBy(xpath="//table[@role='grid']//tr[@role='row']")
	public WebElement allMails;
	
	@FindBy(xpath="//span[@class='T-Jo J-J5-Ji']")
	public WebElement selectAllMails;
	
	@FindBy(xpath="//span[@role='link' and  contains(text(),'Select all ')] ")
	public WebElement selectAll;
	
	@FindBy(xpath="//div[@class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA' and @data-tooltip='Delete']")
	public WebElement deleteAll;
	
	@FindBy(xpath="//button[@name='ok' and @class='J-at1-auR J-at1-atl']")
	public WebElement deleteConfirm;
	
	@FindBy(xpath="//span/a[@title='Inbox']")
	public WebElement inbox;
	
	@FindBy(xpath="//td[@class='TC' and contains(text(),'Hooray, no spam here!')]")
	public WebElement noSpamMail;
	
	@FindBy(xpath="//span[@role='button' and contains(text(),'Delete all spam messages now')]")
	public WebElement deleteSpam;
	
	@FindBy(xpath="//div//span[@role='heading' and contains(text(),'Confirm deleting messages')]/parent::div/following-sibling::div[2]//button[@name='ok']")
	public WebElement confirmSpamDelete;
	
	/*
	 * Navigating to gmail
	 */
	
	public void navigationToGmail(){
		signupDriver.navigate().to(Constants.activation_url);
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Create account']")));
	}
	
	public void loginButton(String username , String password) throws InterruptedException{
		emailTextbox.sendKeys(username);
		nextButton.click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
		Utils.veryShortSleep();
		gmailpasswordTextbox.sendKeys(password);
		nextButton.click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='gb_ua']")));
		gmailCleanUp();
		
	}
	
	public void gmailCleanUp() {
		try {
            webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span/a[@title='Inbox']"))));
                   if ( allMails.isDisplayed()) {          
                                selectAllMails.click();
                   try {
                	   Utils.veryShortSleep();
//                   webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[@role='link' and  contains(text(),'Select all ')] "))));
                         if ( selectAll.isDisplayed()) {
                                selectAll.click();
                         } 
                   }catch(Exception e) {   
                       
                                deleteAll.click();        
                                deleteConfirm.click();
                         
                   }
                   } else {                                              
                     webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//td[@class='TC' and contains(text(),'No new mail!')]"))));
                         inbox.click();
                   }
            } catch ( Exception e) {
                         System.out.println("Inbox emails are less than 50");
            }
                   
                         
            moreMail.click();
            Utils.veryShortSleep();
            spamMail.click();
            
            try {
                   if( noSpamMail.isDisplayed()) {
//                       Assert.assertEquals(true, true);
                         System.out.println("No Mails in Spam Folder");
                   }
            } catch ( Exception e) {
            webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[@role='button' and contains(text(),'Delete all spam messages now')]"))));
                   deleteSpam.click();
                   confirmSpamDelete.click();
                   Utils.veryShortSleep();
                   inbox.click();
            }                    

	}
	
	public void selectCreatedOrganizationMail() throws InterruptedException{
		Utils.veryShortSleep();
		try {
			if(latestCreatedOrganizationMail.isDisplayed()) {
				latestCreatedOrganizationMail.click();
			}
		}catch(Exception e) {
			moreMail.click();
			spamMail.click();
			webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[1][td[6][div[div[div[span[span[text()='Your NetSfere Organization is Ready']]]]]]]")));
			latestCreatedOrganizationMail.click();
		}
		
//		latestCreatedOrganizationMail.click();
		Thread.sleep(3000);
		//webOpt.scrollDownToElement(activateButton);
		JavascriptExecutor js = (JavascriptExecutor) signupDriver;
		js.executeScript("window.scrollBy(0,500)");
		activationButtonInMail.click();
	}
	
	
	public boolean duplicateOrgMail(){
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[1][td[6][div[div[div[span[span[contains(text(),'Duplicate Account Created For')]]]]]]]")));
		duplicateOrganisationMail.click();
		String data = duplicateText.getText();
		if(data.contains("Duplicate Account")){
			return true;
		}
		return false;
		
	}
	
	public void activateUser(){
		webOpt.SwitchWindow(signupDriver);
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Activate Your Account']")));
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password' and @placeholder='Enter password']")));
		passwordTextBox.sendKeys(Config.getInstance().getWebUserPassword());
		confirmPasswordTextBox.sendKeys(Config.getInstance().getWebUserPassword());
		checkBox.click();
		activateButton.click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Welcome to NetSfere']")));
		signupDriver.close();
		webOpt.SwitchWindow(signupDriver);
	}
	
	public void activateUserFromGmail(String guestUser) throws InterruptedException{
		
		try {
//			searchMail.sendKeys(guestUser);
//			Utils.getVeryShortWait(signupDriver);
		webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='"+guestUser+"']/../../../following-sibling::td//span[contains(text(),'Join my NetSfere')]")));
		
		}catch(Exception e) {
			moreMail.click();
			Utils.veryShortSleep();
			spamMail.click();
			webWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='"+guestUser+"']/../../../following-sibling::td//span[contains(text(),'Join my NetSfere')]")));
		}
		Utils.veryShortSleep();
		signupDriver.findElement(By.xpath("//span[@name='"+guestUser+"']/../../../following-sibling::td//span[contains(text(),'Join my NetSfere')]")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) signupDriver;
		js.executeScript("window.scrollBy(0,250)");
		joinConversation.click();
		webOpt.SwitchWindow(signupDriver);
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Activate Your Account']")));
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password' and @placeholder='Enter password']")));
		displayName.sendKeys(Config.getInstance().getWebGuestDisplayName());
		passwordTextBox.sendKeys(Config.getInstance().getWebUserPassword());
		confirmPasswordTextBox.sendKeys(Config.getInstance().getWebUserPassword());
		checkBox.click();
		activateButton.click();
		webWait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Welcome to NetSfere']")));
		
	}

}
