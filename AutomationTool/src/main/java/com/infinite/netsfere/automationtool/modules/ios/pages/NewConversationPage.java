package com.infinite.netsfere.automationtool.modules.ios.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
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

public class NewConversationPage {
	
	IOSDriver<IOSElement> IosDriver;
	String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static Logger log = LogManager.getLogger(NewConversationPage.class.getName());
	
	public NewConversationPage() throws InterruptedException, IOException {
		IosDriver = DriverManager.getIOSDriver();
		WebDriverWait mediumWait;
		WebDriverWait shortWait;		
		mediumWait = Utils.getMediumWait(IosDriver);
		shortWait = Utils.getShortWait(IosDriver);
		PageFactory.initElements(new AppiumFieldDecorator(IosDriver), this);
	}
			
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Skip']	")	
	public WebElement onboardTipsSkipButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Conversations']")
	public WebElement conversationsNavBar;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='NETS_NavBarTitleText']")
	public WebElement newConversationNavBarlabelText;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='NETS_NavbarPromptText']")
	public WebElement changeConversationTitlebutton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Create']")
	public WebElement createConversationButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	public WebElement createNewConversationBackButton;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search Name or Invite by Email']")
	public WebElement getAddParticipantSearchBox;
	
	@iOSFindBy(xpath = "//XCUIElementTypeCell[@name='NETS_NewConvCellStack']")
	public List<WebElement> searchedParticipantsList;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='NETS_SelectedParticipantsContainer']/XCUIElementTypeOther/XCUIElementTypeCollectionView")
	public WebElement selectedParticipantsContainer;
	
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='NETS_SelectedParticipantsContainer']/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell")
	public List<WebElement> selectedParticipantsList;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText")
	public List<WebElement> selectedParticipantsDisplayNameList;	
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Send Message to Create Conversation']")
	public WebElement sendMessageToCreateConversationTextBox;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_ComposeChatSendButton']")
	public WebElement composedMessageSendButton;
	
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='NETS_ComposeChatQuickReplyButton']")
	public WebElement quickReplyButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	public WebElement cancelParticipantSearchButton;
	
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Clear text']")
	public WebElement  clearParticipantSearchTextBox;
	
	
	public WebElement getOnBoardTipsSkipButton() {
		return onboardTipsSkipButton;
	}
	
	public WebElement getConversationsnavbar() {
		return conversationsNavBar;
	}
	
	public WebElement getConversationsnavBarLabelText() {
		return newConversationNavBarlabelText;
	}
	
	public WebElement getChangeConversationTitlebutton() {
		return changeConversationTitlebutton;
	}
	
	public WebElement getCreateConversationButton() {
		return createConversationButton;
	}
	
	public WebElement getCreateNewConversationPageBackButton() {
		return createNewConversationBackButton;
	}
	
	public WebElement getAddParticipantSearchBox() {
		return getAddParticipantSearchBox;
	}
	
	public  List<WebElement> getSearchedParticipantsList() {
		return searchedParticipantsList;
	}
	
	public WebElement getSelectedparticipantsContainer() {
		return selectedParticipantsContainer;
	}
	
	public List<WebElement> getSelectedParticipantsList() {
		return selectedParticipantsList;
	}
	
	public WebElement getSendMessageToCreateConversationTextBox() {
		return sendMessageToCreateConversationTextBox;
	}
	
	public WebElement getComposedMessageSendButton() {
		return composedMessageSendButton;
	}	
	
	public WebElement getQuickReplyButton() {
		return quickReplyButton;
	}
	public WebElement getCancelParticipantSearchButton() {
		return cancelParticipantSearchButton;
	}
	public WebElement getClearParticipantSearchTextBox() {
		return clearParticipantSearchTextBox;
	}
	public List<WebElement> getSelectedParticipantsDisplayNameList() {
		return selectedParticipantsDisplayNameList;
	}
	
	public boolean isAt() {		
		try {
			if((getConversationsnavbar()).isEnabled()) {
				return true;
			} else {
				return false;
			}
		}catch ( NoSuchElementException e)  {
			log.error("ERROR :  Not in New Conversation page ");
			return false;
		}
	}
		
	public void selectParticipant(String userName) throws Exception {
		getAddParticipantSearchBox().clear();
		getAddParticipantSearchBox().sendKeys(userName);	
		Utils.shortSleep();
		// need to scroll down 
		Utils.scrolldown(IosDriver);		
		if ( getSearchedParticipantsList().isEmpty()) {
			throw new Exception ( " No Contact matched with Search String :" + userName);
		} else {
			getSearchedParticipantsList().get(0).click();
		}		
	}
	
	public void clickOnCreateButton() {								
		getCreateConversationButton().click();
	}
		
	public void deselectParticipant(String userName) throws Exception{
		// using the same  logic to select or deselct a participant. 
		selectParticipant(userName);		
	}
	
	//TO-Do
	// Add method to  create title  to the new conversation.
	// add method to click send button. 
	// add method to put initial message

}
