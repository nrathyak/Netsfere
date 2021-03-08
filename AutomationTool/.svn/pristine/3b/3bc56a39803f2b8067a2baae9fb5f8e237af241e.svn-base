package com.infinite.netsfere.automationtool.modules.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebBoxPage {
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;

	public WebBoxPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();

	}
	
	
	@FindBy(xpath="//h2[text()='Log in to grant access to Box']")
	public WebElement boxPage;
	
	@FindBy(xpath="//input[@title='Email Address']")
	public WebElement emailAddress;
	
	@FindBy(xpath="//input[@title='Password']")
	public WebElement passwordText;
	
	@FindBy(xpath="//input[@title='Authorize']")
	public WebElement authoriseButton;
	
	@FindBy(xpath="//button[@title='Grant access to Box']")
	public WebElement grantAccessButton;
	
	
	public void loginToBox(String email, String password) {
		emailAddress.sendKeys(email);
		passwordText.sendKeys(password);
		authoriseButton.click();
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Grant access to Box']")));
		grantAccessButton.click();
	}

}
