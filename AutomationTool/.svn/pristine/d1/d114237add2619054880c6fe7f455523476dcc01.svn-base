package com.infinite.netsfere.automationtool.modules.ios.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IntroPage {

	IOSDriver<IOSElement> IosDriver;

	public IntroPage() throws InterruptedException, IOException {
		IosDriver = DriverManager.getIOSDriver();
		PageFactory.initElements(new AppiumFieldDecorator(IosDriver), this);
	}
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
	public WebElement appUpdatelaterButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Update']")
	public WebElement appUpdateButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_LoginButton']")
	public WebElement loginButton;
	
	@iOSFindBy(id = "NETS_SignupButton")
	public WebElement signupButton;
	
	
	public boolean isAt() {
		if( getLoginButton().isEnabled() && getSignUpButton().isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	public WebElement getAppUpdateButton() {
		return appUpdateButton;
	}
	public void updateApp() {
		appUpdateButton.click();
	}
	public WebElement getAppUpdatelaterButton() {
		return appUpdatelaterButton;
	}	
	public void  cancelAppUpdate() {
		appUpdatelaterButton.click();
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void clickLoginButton() {
		loginButton.click();
	}	
	public WebElement getSignUpButton() {
		return signupButton;
	}
	public void clickSignUpButton() {
		signupButton.click();
	}

}
