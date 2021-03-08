package com.infinite.netsfere.automationtool.modules.android.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.AndroidBase;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.Driver;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewConversationPage {
		
	private static final String ID_MESSAGE_STATUS_ICON = "message_status_imageview";
	private static final String ID_CHAT_LIST_VIEW = "chat_list_view";
	private static final String ID_MESSAGE_CONTENT_TEXTVIEW = "message_content_textview";
	private static final String ID_CONVERSATION_NAME_TEXT = "conversation_name_text";
	
	
	String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()); 
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	public NewConversationPage(){
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
		
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='android:id/search_src_text' and @index='0']")
	public WebElement userNameSearchBox;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/search_src_text' and @index='0']")
	public WebElement addparticipantusernamesearchBox;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@resource-id='com.infinite.netsfere:id/select_checkBox']")
	public WebElement searchedUserCheckBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_create']")
	public WebElement createConversationButton;		
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_search' and @index='0']")
	public WebElement actionSearch;
	
	
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/action_fab' and @index='2']")
	public WebElement saveButtonForNewPaarticipant;
	
	

	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/new_conversation_cell_layout' and @index='1']")
	public WebElement checkboxParticipant;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/invite_via_email' and @index='1']")
	public WebElement inviteLink;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/edit_people_textview' and @text='Edit Participants']")
	public WebElement editParticipants;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/save_item' and @index='0']")
	public WebElement saveItem;
	
	public boolean saveItemAfterChanges(){
		try{
			if(saveItem.isDisplayed()){
			return true;
			}
		}
		catch(Exception e){
			e.getMessage(); 
		}
		return false;
	}
	
	
	public boolean editParticipantTextPresent(){
		try{
			if(editParticipants.isDisplayed()){
				return true;
				}
			}
		catch(Exception e){
			e.getMessage(); 
		}
		return false;
	}
	public void selectUser(String userName) {
		userNameSearchBox.clear();
		userNameSearchBox.sendKeys(userName);
		Utils.veryShortSleep();
		searchedUserCheckBox.click();
	}
	
	public void inviteGuestUser(String userName) {
		userNameSearchBox.clear();
		userNameSearchBox.sendKeys(userName);
		Utils.shortSleep();
		inviteLink.click();
		
	}
	
	public void clickOnCreateButton() {								
		createConversationButton.click();
	}
	
	public void actionSearchEditParticipants(String userName) throws InterruptedException {
		Utils.shortSleep();
		actionSearch.click();
		Thread.sleep(2000);
		addparticipantusernamesearchBox.sendKeys(userName);
		Utils.shortSleep();
		searchedUserCheckBox.click();
	}
	
	public void saveButtonNewDetailPage(){
		saveButtonForNewPaarticipant.click();
	}
	
	public void deselectParticipant(){
		checkboxParticipant.click();
	}
	
	
}
