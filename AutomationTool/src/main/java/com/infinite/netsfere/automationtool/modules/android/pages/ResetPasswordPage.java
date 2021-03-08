package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ResetPasswordPage {
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	ChatPage chatPage;
	
	public ResetPasswordPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		chatPage = new ChatPage();
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/text_forgot_password_info']")
	public WebElement resetPasswordPage;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/email_text']")
	public WebElement emailText;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/button_reset_password']")
	public WebElement resetPasswordButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/alertTitle' and @text='Password Reset']")
	public WebElement passwordResetMailSentPopUp;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	public WebElement okButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/message' and @text='You may only send one request every 10 minutes.']")
	public WebElement resetWarningMessage;
	
	public void enterMailIdToResetPasword(String mailId) {
		emailText.sendKeys(mailId);
	}
	
	public void clickOnResetPassword() {
		resetPasswordButton.click();
	}
	
	public void waitForConfirmPopUp() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/alertTitle' and @text='Password Reset']")));
	}
	
	public void clickOnOKButton() {
		okButton.click();
	}
	
	

}
