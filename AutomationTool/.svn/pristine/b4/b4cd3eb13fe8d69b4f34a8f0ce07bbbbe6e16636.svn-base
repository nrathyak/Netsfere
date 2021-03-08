package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DracoonPage {

	AndroidDriver<AndroidElement> driver;
	WebDriverWait andwait;
	
	public DracoonPage(){
		driver = DriverManager.getAndroidDriver();
		andwait = Utils.getShortWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='login-std-tf-input-username']")
	public WebElement usernameText;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='login-std-tf-input-password']")
	public WebElement passwordText;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='login-std-button-login' and @text='Login']")
	public WebElement loginButton;
	
	public void loginToDracoon(String username,String password) {
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
	}
	
	
}
