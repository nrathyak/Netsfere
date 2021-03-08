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

public class VideoCallPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	HDOneToOneCallElements hdCall;
	ChatPage chatPage;
	GroupCallElements groupCall;
	
	public VideoCallPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		hdCall = new HDOneToOneCallElements();
		chatPage = new ChatPage();
		groupCall = new GroupCallElements();
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/user_count_button']")
	public WebElement userCountButton;
	
	@AndroidFindBy(xpath="//android.widget.Chronometer[@resource-id='com.infinite.netsfere:id/call_duration']")
	public WebElement callDuration;
	
	public void viewVideoCallScreen() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.infinite.netsfere:id/user_count_button']")));
	}
	
	public void receiveGroupVideoCall() {
		hdCall.callAnswerButton.click();
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.infinite.netsfere:id/user_count_button']")));
		Utils.shortSleep();
	}
	
	public void endVideoCall() {
		callDuration.click();
	}
	
	public void clickOnVideoCallButton() {
		Utils.veryShortSleep();
		if(groupCall.numberOfParticipants.isDisplayed()) {
			groupCall.groupCallButton.click();
		}
		viewVideoCallScreen();
	}

}
