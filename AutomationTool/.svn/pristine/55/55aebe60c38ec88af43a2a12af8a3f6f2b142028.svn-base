package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Log;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExportConversationPage {
	
	ConversationsPage conversationsPage;
	private static Logger log = LogManager.getLogger(ExportConversationPage.class.getName());

	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/message']")
	public WebElement exportwarning;
	
//	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @index='1']")
    @AndroidFindBy(xpath="//android.widget.Button[@text='OK']")	
	public WebElement warningaccept;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/message_editText']")
	public WebElement custommessage;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='"+Constants.androidPackageName+":id/send_imageView' and @index='2']")
	public WebElement sendmail;
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	public ExportConversationPage(){
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	

	public void exportEmailConversation() {
		Utils.veryShortSleep();
		
		try{
		if(exportwarning.isDisplayed()){
			warningaccept.click();
		}
		}catch(Exception e){
			log.error("Warning not displayed");
		}
		finally{
		custommessage.sendKeys("Exporting conversation..!");
		sendmail.click();
		}
		}
		
	
	public void waitTillEmailSent() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/\"+ID_NEW_CONVERSATION_FAB+\"' and @index='1']")));
	}


}
