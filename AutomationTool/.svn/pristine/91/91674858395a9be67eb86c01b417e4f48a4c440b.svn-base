package com.infinite.netsfere.automationtool.modules.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebResetPasswordPage {
	WebDriver driver;
	WebDriverWait webwait;
	WebDriver secondDriver;
	private static Logger log = LogManager.getLogger(WebLoginPage.class.getName());
	WebIoOperations webOpt = new WebIoOperations();
	
	public WebResetPasswordPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		
	}
	
	@FindBy(xpath="//div[contains(text(),'Reset Password')]")
	public WebElement resetPasswordPage;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement emailText;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement resetButton;
	
	@FindBy(xpath="//div[contains(text(),'Password Reset')]")
	public WebElement passwordResetPopUp;
	
	@FindBy(xpath="//span[contains(text(),'OK')]")
	public WebElement okButton;
	
	@FindBy(xpath="//tr[1][td[6][div[div[div[span[span[contains(text(),'NetSfere Password Reset')]]]]]]]")
	public WebElement resetPasswordMail;
	
	@FindBy(xpath="//div[contains(text(),'Reset Password')]")
	public WebElement resetPasswordGmailButton;
	
	
	@FindBy(xpath="//input[@id='newPassword']")
	public WebElement newPasswordText;
	
	@FindBy(xpath="//input[@id='newPassword2']")
	public WebElement confirmPasswordText;
	
	@FindBy(xpath="//button[@id='orgNextButton']")
	public WebElement changeButton;
	
	@FindBy(xpath="//button[@id='warningCancelButton']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//button[@id='okButton']")
	public  WebElement okbutton2;
	
	@FindBy(xpath="//div[@class='ns-noticeTitle' and text()='Failed To Reset Password']")
	public WebElement failedReset;
	
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement cancelResetPassword;
	
	@FindBy(xpath="//span[text()='You may only send one request every 10 minutes']")
	public WebElement resetWarning;
	
	public void enterEmailToResetPassword(String mailId) {
		emailText.sendKeys(mailId);
	}
	
	public void clickOnResetButton() {
		resetButton.click();	
	}
	
	public void waitForConfirmPopUp() {
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Password Reset')]")));
	}
	
	public void clickOnOKButton() {
		okButton.click();
	}
	
	public void clickOnCancelResetPasswordButton() {
		cancelResetPassword.click();
	}
	
	public void resetPasswordThroughGmail() {
		driver.navigate().refresh();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1][td[6][div[div[div[span[span[contains(text(),'NetSfere Password Reset')]]]]]]]")));
		resetPasswordMail.click();
		Utils.veryShortSleep();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		resetPasswordGmailButton.click();	
		
	}

	public void enterPasswordInResetPasswordPageAndConfirm() {
		webOpt.SwitchWindow(driver);
		driver.navigate().refresh();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Reset Your Password']")));
		newPasswordText.sendKeys(Config.getInstance().getNewPassword());
		confirmPasswordText.sendKeys(Config.getInstance().getConfirmPassword());
		changeButton.click();
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ns-noticeTitle' and text()='Password Sucessfully Reset']")));
		okbutton2.click();
	}
}
