package com.infinite.netsfere.automationtool.modules.android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ConversationDetailsPage implements BasePage {
		 
	AndroidDriver<AndroidElement> driver;
	WebDriverWait andwait;
	
	public ConversationDetailsPage(){
		driver = DriverManager.getAndroidDriver();
		andwait = Utils.getShortWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/etConvTitle']")
	public WebElement titleBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/save_item']")
	public WebElement saveButton;

	
	@AndroidFindBy(uiAutomator = "text(\"LEAVE CONVERSATION\")")
	public WebElement leaveFromDetails;

	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_create']")
	public WebElement createButton;


	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/conversation_title_edit_text']")
	public WebElement titleBoxWithParticipant;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/edit_participants_textView' and @text='Edit Participants']")
	public WebElement editParticipants;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/number_of_people_in_conversation_textview']")
	public WebElement numberOfParticipants;
	
	/*
	 * Guest Invitation pop up	
	 */
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/send_button']")
	public WebElement sendInvitationButton;
	
	/*
	 * Changes as per 4.2 clients
	 */
	
	@AndroidFindBy(xpath="//android.widget.ToggleButton[@resource-id='com.infinite.netsfere:id/leave_button']")
	public WebElement leaveButton;
	
	
	
	                    
	
	public void enterConversationTitle(String title) {
		titleBox.clear();
		titleBox.sendKeys(title);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public void enterConversationTitleWithParticipant(String title) {
		titleBoxWithParticipant.sendKeys(title);
	}
	
	public void clickOnCreateButton() {
		createButton.click();
	}
	
	public void editParticipant(){
		editParticipants.click();
	}
	
	public String numberOfParticipants() {
		String participants = numberOfParticipants.getText();
		String numOfParticipants = participants.substring(0, participants.indexOf(' '));
		
		return numOfParticipants;
		
	}
	
	public void inviteGuestMessageButtonClick(){
		andwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Guest Invite' and @index='1']")));
		sendInvitationButton.click();
	}
	
	/*
	 * Methods as per 4.2 clients
	 */
	public void clickOnLeaveButton() {
		leaveButton.click();
	}
	
	public boolean isAt() {
		return driver.currentActivity().equals(Constants.ACTIVITY_CONVERSATION_DETAILS_PAGE);
	}

	public void navigateTo() throws Exception {
		// Doing nothing, because this is a conversation details page which is
		// linked with a particular conversation, which is not known at this
		// point.
	}
	
	
}
