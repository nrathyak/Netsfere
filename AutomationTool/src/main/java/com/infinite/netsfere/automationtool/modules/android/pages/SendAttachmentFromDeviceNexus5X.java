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

public class SendAttachmentFromDeviceNexus5X {

	
	AndroidDriver<AndroidElement> driver;
	
	WebDriverWait mediumWait;
	public SendAttachmentFromDeviceNexus5X(){
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/insert_photo_button']")
	public WebElement attachPhoto;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.google.android.apps.photos:id/toolbar']")
	public WebElement selectAPhotoPage;
	
	@AndroidFindBy(uiAutomator = "text(\"Camera\")")
	public WebElement attachCameraPhoto;
	
	@AndroidFindBy(xpath="//android.view.View[@index='1']")
	public WebElement selectAPhoto;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/send_button']")
	public WebElement imageSendButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/message_status_imageview']")
	public WebElement imageSentButton;
	
	public void clickOnAttachPhoto() {
		attachPhoto.click();
	}
	
	public void sendImageFromDevice() {
		if(selectAPhotoPage.isDisplayed())
		{
			attachCameraPhoto.click();
			selectAPhoto.click();
			mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.infinite.netsfere:id/send_button']")));
			imageSendButton.click();
			mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/message_status_imageview']")));
		}
	}
	
}
