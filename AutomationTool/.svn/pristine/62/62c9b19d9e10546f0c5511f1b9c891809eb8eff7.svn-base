package com.infinite.netsfere.automationtool.modules.ios.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class QuickReplypage {

	
	IOSDriver<IOSElement> IosDriver;
	String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static Logger log = LogManager.getLogger(QuickReplypage.class.getName());
	
	public QuickReplypage() throws InterruptedException, IOException {
		IosDriver = DriverManager.getIOSDriver();
		WebDriverWait mediumWait;
		WebDriverWait shortWait;		
		mediumWait = Utils.getMediumWait(IosDriver);
		shortWait = Utils.getShortWait(IosDriver);
		PageFactory.initElements(new AppiumFieldDecorator(IosDriver), this);
	}
	
	@iOSFindBy(xpath = "//XCUIElementTypeTable[@name='NETS_QuickReplyOptionsView']")	
	public WebElement quickReplyOptionsView;
	
	
	@iOSFindBy(xpath = "//XCUIElementTypeTable[@name='NETS_QuickReplyOptionsView']/XCUIElementTypeCell")
	public List<WebElement> quickReplyOptionsList;
		
	public WebElement getQuickReplyOptionsView() {
		return quickReplyOptionsView;
	}
	public List<WebElement> getQuickReplyOptions() {
		return quickReplyOptionsList;
	}
	
	
	public boolean isAt() {		
		try {
			if(getQuickReplyOptionsView().isEnabled()) {
				return true;
			} else {
				return false;
			}
		}catch ( NoSuchElementException e)  {
			log.error("ERROR :  Not in QuickReply page ");
			return false;
		}
	}
	
	public void selectQuickReplyToSend() {
		getQuickReplyOptions().get(2).click();
	}
	
	
	
	
	
}
	