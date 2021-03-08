package com.infinite.netsfere.automationtool.modules.web.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.modules.android.pages.HDOneToOneCallElements;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebLoginPage implements BasePage{
	
	WebDriver driver;
	WebDriverWait webwait;
	WebDriver secondDriver;
	
	private static Logger log = LogManager.getLogger(WebLoginPage.class.getName());
	
	
	public WebLoginPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		
	}
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement emailId;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement passwordfield;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitButton;

	@FindBy(xpath="//div[contains(text(),'Welcome to NetSfere')]")
	public WebElement loginheader;
	
	@FindBy(xpath="//div[text()='Login']")
	public WebElement loginpage;
	
	@FindBy(xpath="//span[text()='Invalid email address and/or password']")
	public WebElement invalidErrorMessage;
	
	
	@FindBy(xpath="//div[contains(text(),'Welcome to NetSfere')]")
	public WebElement welcomeText;
	
	@FindBy(xpath="//span[text()='Invalid email address and/or password']")
	public WebElement invalidCredentialsError;
	
	@FindBy(xpath="//a[text()='Terms of Service and Privacy Policy']")
	public WebElement termsofServiceandPrivacyPolicy; 
	
	@FindBy(xpath="//h2[text()='NetSfere Terms of Service']")
	public WebElement termsofServiceandPrivacyPolicyPageTitle; 
	
	@FindBy(xpath="//a[@href='#/resetpw']")
	public WebElement forgotPasswordButton;
	
	
	@FindBy(xpath="//a[text()='About']")
	public WebElement aboutButton;
	
	
	@FindBy(xpath="//h1[text()='NetSfere Enterprise Messaging']")
	public WebElement aboutPageTitle;
	
	@FindBy(xpath="//a[text()='Help']")
	public WebElement helpButton; 

	@FindBy(xpath="//div[text()='NetSfere Help Center']")
	public WebElement helpPageTitle;
	
	@FindBy(xpath="//div[@id='feature-intro']/..//span[@class='material-icons']")
	public WebElement closeButton;
	
	public void clickingTermsofServicesAndPrivacyPolicy()
	{
	  termsofServiceandPrivacyPolicy.click();  
	}
	
	public void aboutButton()
	{
	  aboutButton.click();  
	}
	
	public void helpButton()
	{
		helpButton.click();
	}
	
	public void submitUsernamePassword(String username , String password){
		WebIoOperations.clearText(emailId);
		WebIoOperations.clearText(passwordfield);
		emailId.sendKeys(username);
		passwordfield.sendKeys(password);
	}
	
	public void submitUsernamePasswordSecondUser(String username , String password){
		WebIoOperations.clearText(secondDriver.findElement(By.xpath("//input[@type='email']")));
		WebIoOperations.clearText(secondDriver.findElement(By.xpath("//input[@type='password']")));
		secondDriver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		secondDriver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	}
	
	public void loginButton(){
		submitButton.click();
		try {
		if(invalidCredentialsError.isDisplayed()){
			Utils.veryShortSleep();
			submitButton.click();
		}
		}catch(Exception e) {
			log.info("Invalid credential pop up not found");
		}
		
	}
	public boolean isLoginPage() {
		
		boolean flag = false;
		if(loginpage.isDisplayed()==true)
		{
			return true;
		}
		else{
			return flag;
		}
	}
	
	public void initialiseSecondDriver() {
		this.secondDriver = DriverManager.getSecondWebDriver();
		PageFactory.initElements(secondDriver, this);
	}

	public void clickOnForgotPassword() {
		forgotPasswordButton.click();
	}

	public boolean isAt() {
		try {
			return driver.getCurrentUrl().equals("https://web.netsferetest.com/#/login");
		}catch(Exception e) {
			if(e instanceof NoSuchElementException) {
				log.info("Not in login Page");
			}
		}
		return false;
	}
	
	
	public boolean termsAndPolicyPageTitleVerify()
	{
		String s=termsofServiceandPrivacyPolicyPageTitle.getText();
		if(s.contains("NetSfere Terms of Service"))
		{
			return true;
		}
		return false;
	}
	public boolean aboutPageTitleVerify()
	{
		String s=aboutPageTitle.getText();
		if(s.contains("NetSfere Enterprise Messaging"))
		{
			return true;
		}
		return false;
	}
	public boolean helpPageTitleVerify()
	{
		String s=helpPageTitle.getText();
		if(s.contains("NetSfere Help Center"))
		{
			return true;
		}
		return false;
	}
	
	public void checkForNewIntroPage() {
		Utils.veryShortSleep();
		try {
			Utils.veryShortSleep();
			if(closeButton.isDisplayed()) {
				closeButton.click();
			}
				
		}catch(Exception e) {
			log.info("New feature intro page isnt available");
		}
	}


	public void navigateTo() throws Exception {
		// Login Page loads once browser is launched.
		
	}
	
	
}
