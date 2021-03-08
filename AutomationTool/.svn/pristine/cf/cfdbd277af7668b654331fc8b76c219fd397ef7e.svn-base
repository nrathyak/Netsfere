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

public class BoxPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait andwait;
	
	public BoxPage(){
		driver = DriverManager.getAndroidDriver();
		andwait = Utils.getShortWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text='Log in to grant access to Box']")
	public WebElement boxPage;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='login']")
	public WebElement emailText;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='password']")
	public WebElement passwordText;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Authorize']")
	public WebElement authorizeButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='consent_accept_button' and @text='Grant access to Box']")
	public WebElement grantAccessToBox;
	
	
	public void loginToBox(String username,String password) {
		emailText.sendKeys(username);
		passwordText.sendKeys(password);
		authorizeButton.click();
	}
	
	public void clickOnGrantAccessButton() {
		grantAccessToBox.click();
	}

}
