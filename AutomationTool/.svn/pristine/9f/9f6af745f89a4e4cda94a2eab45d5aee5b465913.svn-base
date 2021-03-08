package com.infinite.netsfere.automationtool.modules.ios.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	IOSDriver<IOSElement> IosDriver;
	WebDriverWait IosWait;
	WebDriverWait IosVeryShortWait;
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());

	public LoginPage() throws InterruptedException, IOException {
		IosDriver = DriverManager.getIOSDriver();
		IosWait = Utils.getMediumWait(IosDriver);
		IosVeryShortWait = Utils.getVeryShortWait(IosDriver);
		PageFactory.initElements(new AppiumFieldDecorator(IosDriver), this);
	}
	
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Login']")
	public WebElement loginPagelabel;
	
	@iOSFindBy(id = "NETS_LoginEmail")
	public WebElement iosEmailTextbox;

	@iOSFindBy(id = "NETS_LoginPassword")
	public WebElement iosPasswordTextbox;

	@iOSFindBy(id ="NETS_LoginButton")
	public WebElement loginButton;
	
	@iOSFindBy(id ="Go")
	public WebElement GoButton;
	
	@iOSFindBy(id= "OK")
	public WebElement okButton;

	@iOSFindBy(id = "Cancel")
	public WebElement cancelButton;	
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getUserIDTextbox() {
		return iosEmailTextbox;
	}

	public boolean isAt() {
		Utils.getVeryShortWait(IosDriver);
		try {
			if ( getUserIDTextbox().isEnabled() && getLoginButton().isEnabled()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			log.error("Could not find UserID text box in Login Page");
			return false;
		}
	}
	public boolean isLoginTextVisible() {
		if ( getUserIDTextbox().isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	public void enterEmailAndPassword(String email, String password) {
		iosEmailTextbox.clear();
		iosPasswordTextbox.clear();
		iosEmailTextbox.sendKeys(email);
		iosPasswordTextbox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
	
	public void clickGoButton() {
		GoButton.click();
	}

	public void waitForInvalidEmailErrorPopUpAndClose() {
		IosWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='Invalid email address and/or password']")));
		okButton.click();
	}
	public void waitForNetworkErrorPopUpAndClose() {
		IosWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='Network error occurred']")));
		okButton.click();
	}
	
	

}