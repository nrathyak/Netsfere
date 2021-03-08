package com.infinite.netsfere.automationtool.asserts;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.modules.android.pages.ChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebCallLogsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChannelsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebGroupCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebHdOneToOneCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebNavigationBar;
import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AssertionWeb {
	
	WebDriver driver;
	WebDriverWait webwait;
	WebConversationsPage webconv = new WebConversationsPage();
	AndroidDriver<AndroidElement> androidDriver;
	ChatPage chatpage = new ChatPage();
	WebHdOneToOneCallElements hdCall = new WebHdOneToOneCallElements();
	WebGroupCallElements groupCall = new WebGroupCallElements();
	WebCallLogsPage callLog = new WebCallLogsPage();
	private static final String user2 = Config.getInstance().getAndroidUserDisplayName();
	WebChannelsPage webchannel= new WebChannelsPage();
	private static final String guestDisplayName = Config.getInstance().getGuestDisplayName();
	WebChatPage webChatPage = new WebChatPage();
	WebNavigationBar webNavigationBar = new WebNavigationBar();
	private static Logger log = LogManager.getLogger(AssertionWeb.class.getName());

	
	
	public AssertionWeb() {
		
		this.driver = DriverManager.getWebDriver();
		androidDriver = DriverManager.getAndroidDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		
	}
	
	@FindBy(xpath="//span[text()='1 min']")
	public WebElement recentCreatedConversation;
	

//	@FindBy(xpath="+ownerName+")
//	public WebElement ownerNameAsDefaultTitle;
//	
	@FindBy(xpath="//span[contains(text(),'2019')]")
	public WebElement modifiedTitle;
	
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div[3]/div/div[3]/div[2]/div[2]")
	public WebElement recentConversation;
	
	@FindBy(xpath="//div[span[text()='3']]")
	public WebElement participantCount;
	
	@FindBy(xpath="//div[@class='mainDiv']//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span")
	public WebElement messageFromAndroid;
	
	
	//channel elements
	
	@FindBy(xpath="//div[@class='mainDiv']//div[1]//div[@class='scrollbox']/div[@class='table-view']/div[2]/div/div[3]/div[3]/div[1]")
     public WebElement recentChannel;
	
	/*
	 * Hd Call elements
	 */
	
	@FindBy(xpath="//span[contains(text(),'Incoming call...')]")
	public WebElement incomingcall;
	

	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[3]//div[@class='table-view']//div[@class='bubbleWrap']/div/span/span")
	public WebElement quickReplyMessage;
	
	
	/*
 * Group call elements
 */
	@FindBy(xpath="//div[contains(text(),'Incoming call...')]")
	public WebElement groupIncomingCall;
	

//	public void webWithoutTitleAssertion(){
//		Assert.assertEquals("1 min", recentCreatedConversation.getText());
//		recentConversation.click();
//		String ownerNameAsDefaultTitle  = driver.findElement(By.xpath("//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[3]//div[3]//div[.='"+user2+"']")).getText();
//		Assert.assertEquals(Config.getInstance().getAndroidUserDisplayName(), ownerNameAsDefaultTitle);
//		Utils.shortSleep();
//	}

//	public void modifiedTitle() throws InterruptedException{
//		Thread.sleep(3000);
//		Assert.assertEquals(true, modifiedTitle.getText().contains("2019"));
//	}
//	
//	public void conversationWithTitle(){
//		Assert.assertEquals(true, recentConversation.getText().contains("2019"));
//	}
//	
//	public void groupConversationAssertion(){
//		recentConversation.click();
//		String participant = participantCount.getText();
//		String numOfParticipants = participant.substring(0, participant.indexOf(' '));
//		int count = Integer.parseInt(numOfParticipants);
//		if(count >2){
//			log.info("Group conversation Created");
//		}else{
//			Assert.assertEquals(true, false,"Its not group conversation");
//		}
//	}
	
//	public void addParticipantAssertion(){
//		recentConversation.click();
//		Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("joined this conversation."));
//	}
	
	/*
	 * HD call assertion methods
	 */
//	public void incomingCallWebAssertion() throws InterruptedException {
//		Utils.shortSleep();
//		
//		Assert.assertEquals(true, incomingcall.getText().equals("Incoming call..."));
//		//Assert.assertEquals(true, incomingcall.getText().contains("Incoming call..."));
//	}
	
//	public void inCallWebAssertion() {
//		Utils.shortSleep();
//		Assert.assertEquals(true, hdCall.inCall.getText().contains("In call"));
//	}
//	
//	public void groupIncomingCallAssertion() {
//		Utils.shortSleep();
//		Assert.assertEquals(true, groupIncomingCall.getText().contains("Incoming call..."));
//	}
	
//	public void groupInCallAssertion() {
//		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
//	}

	
//	public void quickReplyAssertion(){
//		recentConversation.click();
//		Utils.shortSleep();
////		Assert.assertEquals(chatpage.firstQuickReply.getText(), quickReplyMessage.getText());
//		Assert.assertEquals("Hello!", quickReplyMessage.getText());
//		driver.navigate().back();
//		}
	
//	public void leaveConversationAsParticipantAssertion(){
//		recentConversation.click();
//		Assert.assertEquals(true, webChatPage.removePlaceholder.getText().contains("left this conversation."));
//		
//	}
	
//	public void transferOwnershipAssertion(){
//		recentConversation.click();
//		Assert.assertEquals(true, webChatPage.newOwner.getText().contains("is the new owner."));
//	}

//	public void declinedCallAssertion() throws InterruptedException {
//		webNavigationBar.navigateToCallLogsPage();
//		Thread.sleep(2000);
//		Assert.assertEquals(true, callLog.declinedCall.getText().equals("Declined Call"));
//	}
	
//	public void deleteCallLogsAssertion() {
//		Assert.assertEquals(true, callLog.noCallHistory.getText().equals("No Call History"));
//	}
	
//	public void addingGuestAssertion(){
//		Assert.assertEquals("1 min", recentCreatedConversation.getText());
//		recentConversation.click();
//		String ownerNameAsDefaultTitle  = driver.findElement(By.xpath("//div[@class='mainDiv']//div[@class='scrollbox']/div[@class='table-view']/div[3]//div[3]//div[contains(text(),'"+guestDisplayName+"')]")).getText();
//		Assert.assertEquals(Config.getInstance().getGuestDisplayName(), ownerNameAsDefaultTitle.contains(guestDisplayName));
//		Utils.shortSleep();
//	}
	
//	public void androidGuestSendingMessageAssertion(){
//		recentConversation.click();
//		Assert.assertEquals(true, messageFromAndroid.getText().contains("2019"));
//	}
	//channel assertion methods
	
//	public void quickReplyAssertionChannel(){
//		recentChannel.click();
//		Utils.shortSleep();
//		Assert.assertEquals("Hello!", quickReplyMessage.getText());
//		driver.navigate().back();
//		}

	
	
}


