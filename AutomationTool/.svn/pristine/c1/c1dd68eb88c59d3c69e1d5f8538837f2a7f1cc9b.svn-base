package com.infinite.netsfere.automationtool.asserts;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.modules.android.pages.CallLogPage;
import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AssertionsAndroid {
	
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait androidWait;
	ChatPage chatpage = new ChatPage();
	WebConversationsPage webconvpage = new WebConversationsPage();
	CallLogPage callLogPage = new CallLogPage();
	String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static String guestTitle = "guest";
	private static String guestBadgeConv = "GUEST";
	
	private static Logger log = LogManager.getLogger(AssertionsAndroid.class.getName());

	
	
	public AssertionsAndroid() {
		driver = DriverManager.getAndroidDriver();
		androidWait = Utils.getLongWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_guest_badge' and @index='1']")
	public WebElement guestBadge;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.infinite.netsfere:id/conversation_row_layout' and @index='0']")
	public WebElement recentConversation;
	

	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/number_of_people_in_conversation_textview' and @index='1']")
	public WebElement participantCount;
	
	/*
	 * Chat page elements
	 */


	/*
	 * Assertion elements for Hd Call
	 */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label' and @text='Incoming Call…']")
	public WebElement incomingCall;

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/message_content_textview']")
	public WebElement quickReplyMessage;
	

	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/call_label' and @text='In Call']")
	public WebElement inCall;
	




	
	public void groupConvertationAssertion(){
		driver.navigate().back();
//		ownerNameAsDefaultTitle.click();
		chatpage.clickMoreMenu();
		chatpage.clickDetailsButton();
		String participant = participantCount.getText();
		String numOfParticipants = participant.substring(0, participant.indexOf(' '));
		int count = Integer.parseInt(numOfParticipants);
		if(count >2){
			log.info("Group conversation Created");
		}else{
			Assert.assertEquals(true, false,"Its not group conversation");
		}
		
		driver.navigate().back();
		Utils.shortSleep();
		driver.navigate().back();		
		
	}
	

		
//	public void leaveConversationAsParticipantAssertion() throws InterruptedException{
//		//driver.navigate().back();
//		ownerNameAsDefaultTitle.click();
//		Thread.sleep(1000);
//		log.info(chatpage.placeholderForConversation.getText());
//		Assert.assertEquals(true, chatpage.placeholderForConversation.getText().contains("left this conversation."));
//		
//		
//	}
//	
//	public void transferOwnershipAssertion() throws InterruptedException{
//		ownerNameAsDefaultTitle.click();
//		Thread.sleep(1000);
//		Assert.assertEquals(true, chatpage.placeholderForConversation.getText().contains("is the new owner."));
//		
//	}
//	
//	public void attachmentAssertion() throws InterruptedException{
//		ownerNameAsDefaultTitle.click();
//		Thread.sleep(1000);
//		try {
//			if(driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Chrysanthemum.jpg\")") != null) {
//				log.info("Android received Png image Successfully.");
//			}
//		}
//		catch(Exception e) {
//			log.error("Android did not receive Png image sent by web.");
//		}
//		
//	}
	
	/*
	 * methods for Call Assertion
	 */
	
	
	
	public void inCallAndroidAssertion() {
		Assert.assertEquals(true, inCall.getText().contains("In Call"));
	}
	
	public void declineCallAssertion() {
		Assert.assertNotEquals(driver.currentActivity(), Constants.ACTIVITY_CALL_SCREEN);
	}
	
	public void deleteCallLogsAssertion() {
		Assert.assertEquals(true, callLogPage.noCalls.getText().equals("No Calls"));
	}
	
//	public void addingGuestAssertion(){
//		Utils.veryShortSleep();
//		Assert.assertEquals("Now", conversationTime.getText());
//		Assert.assertEquals(guestBadgeConv, guestBadge.getText());
//	}
	

}
