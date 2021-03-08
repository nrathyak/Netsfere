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

public class ScreensharePage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	HDOneToOneCallElements hdCall;
	ChatPage chatPage;
	
	public ScreensharePage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		hdCall = new HDOneToOneCallElements();
		chatPage = new ChatPage();
	}

	@AndroidFindBy(xpath="//android.view.View[@resource-id='com.infinite.netsfere:id/fullscreen_video_view']")
	public WebElement screenshareView;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_speaker']")
	public WebElement screenshareSpeaker;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_microphone']")
	public WebElement screenshareMute;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/close_button']")
	public WebElement closeButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/back_button']")
	public WebElement backButton;
	
	
	public void clickOnScreenshareView() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='com.infinite.netsfere:id/fullscreen_video_view']")));
		screenshareView.click();
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_speaker']")));
		Utils.veryShortSleep();
	}
	
	
	
}
