package com.infinite.netsfere.automationtool.modules.web.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.springframework.context.annotation.DependsOn;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;
import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.modules.web.pages.ConversationDetailsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.NewConversationPage;
import com.infinite.netsfere.automationtool.modules.web.pages.SaveAttachmentToDevicePage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebAttachmentFromDevicePage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebAttachmentPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebBoxPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebBroadcastLivePage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChannelsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebDracoonPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebExportConversationPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebGenericListPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebLeaveConversationPage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;

public class WebConversationTestCases extends BaseTestCases{
	
	
	WebConversationsPage webconv; 
	WebDriverWait webWait;
	WebDriver driver ;
	WebLeaveConversationPage webLeaveConversationPage;
	String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	String guestUsername;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	WebExportConversationPage webExportConversationPage;
	WebAttachmentFromDevicePage webAttachmentPage;
	SaveAttachmentToDevicePage saveAttachmentPage;
	WebChatPage webChatPage;
	NewConversationPage newConversationPage;
	ConversationDetailsPage conversationDetailsPage;
	WebAttachmentPage webAttachment;
	WebBroadcastLivePage broadcastPage;
	WebChannelTestcases channel;
	WebIoOperations webio;
	WebBoxPage boxPage;
	WebDracoonPage dracoon;
	
	private static Logger log = LogManager.getLogger(WebChannelTestcases.class.getName());
	
	@BeforeClass
	public void init(){
		driver = DriverManager.getWebDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		webconv = new WebConversationsPage();
		webLeaveConversationPage = new WebLeaveConversationPage();
		webExportConversationPage = new WebExportConversationPage();
		webAttachmentPage = new WebAttachmentFromDevicePage();
		saveAttachmentPage = new SaveAttachmentToDevicePage();
		webChatPage = new WebChatPage();
		newConversationPage = new NewConversationPage();
		conversationDetailsPage = new ConversationDetailsPage();
		webAttachment= new WebAttachmentPage();
		broadcastPage = new WebBroadcastLivePage();
		channel = new WebChannelTestcases();
		webio = new WebIoOperations();
		boxPage = new WebBoxPage();
		dracoon = new WebDracoonPage();
		}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createConversationWithoutTitle() throws Exception{
//		try{
			makeSureToBeInNewConversationPage();
			newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			newConversationPage.createConversationbutton();
			Thread.sleep(3000);
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
//		}
//		catch(Exception e){
//		Assert.assertFalse(true);
//	
//		}
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void modifyDefaultTitle() throws Exception{
//		try{
				createConversationWithoutTitle();
				Utils.shortSleep();
				conversationDetailsPage.conversationSettings();
				newConversationPage.conversationTitle(conversationTitle);
				conversationDetailsPage.saveButton();
				Thread.sleep(3000);
				Assert.assertEquals(true, newConversationPage.convTitle.getText().contains("2021"));
//		}
//		catch(Exception e){
//			Assert.assertFalse(true);
//		}
				
	}
	@Test
	@NavigateTo(WebConversationsPage.class)
	public String createConversationWebWithTitle() throws Exception{
		String conversationTitle = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			Utils.veryShortSleep();
			webconv.clickOnNewConversation();
			makeSureToBeInNewConversationPage();
			newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			newConversationPage.conversationTitle("New"+conversationTitle);	
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
			return conversationTitle;
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void groupConversationWithTitle(String participant1, String participant2) throws InterruptedException{
		try{
			webconv.clickOnNewConversation();
			makeSureToBeInNewConversationPage();
			newConversationPage.searchAndSelectContact(participant1);
			newConversationPage.searchAndSelectContact(participant2);
			newConversationPage.conversationTitle("Group"+conversationTitle);
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
		}
		catch(NoSuchFieldError e){
		Assert.assertFalse(true);
		
		log.error("No such contact present");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void groupConversationWithoutTitle() throws InterruptedException{
		try{
			webconv.clickOnNewConversation();
			makeSureToBeInNewConversationPage();
			newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			newConversationPage.searchAndSelectContact(Config.getInstance().getIosUserDisplayName());
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
		}
		catch (Exception e) {
			Assert.assertFalse(true);
			
		}
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void webSendsMessageInAConversation() throws Exception {
		createConversationWebWithTitle();
		webChatPage.messageTextbox(Config.getInstance().getMessageFromWeb());
		Utils.veryShortSleep();
		webChatPage.sendMessageButton();
		Utils.shortSleep();
		Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void addParticipant() throws InterruptedException{
		try{
				webconv.clickOnNewConversation();
				makeSureToBeInNewConversationPage();
				newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
				newConversationPage.createConversationbutton();
				Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
				conversationDetailsPage.conversationSettings();
				newConversationPage.searchAndSelectContact(Config.getInstance().getIosUserDisplayName());
				conversationDetailsPage.saveButton();
				Thread.sleep(2000);
				Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("this conversation"));
		}
		catch (Exception e) {
			Assert.assertFalse(true);
			
		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void removeParticipant() throws Exception{
		createConversationWithoutTitle();
		try{
			conversationDetailsPage.conversationSettings();
			newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
			conversationDetailsPage.saveButton();
			Thread.sleep(5000);
			Assert.assertEquals(true, webChatPage.removePlaceholder.getText().contains("left this conversation"));
		}
		catch(Exception e){
			Assert.assertFalse(true);
			
		}

	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendQuickReply(){
		try{
				createConversationWebWithTitle();
				Utils.shortSleep();
				webChatPage.clickQuickReply();
				Assert.assertEquals(Config.getInstance().getKeyMessageSentStatus(), webChatPage.sentMark.getAttribute("title"));
				
		}
		catch (Exception e) {
			Assert.assertFalse(true);
			
		}
		
	}
	
	@Test(dependsOnMethods = { "createConversationWebWithTitle" })
	@NavigateTo(WebConversationsPage.class)
	public void sendMyLocation(){
//		try{
			webAttachmentPage.shareMyLocationLink();
				Assert.assertEquals(true, webChatPage.sentButtonForLocation.isDisplayed());
//		}
//		catch (Exception e) {
			
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendOtherLocation() throws InterruptedException {
//		try{
			webAttachmentPage.shareOtherLocationLink(Config.getInstance().getLocation());
				Assert.assertEquals(true, webChatPage.sentButtonForLocation.isDisplayed());
//		}
//		catch (Exception e) {
			
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void searchAndSelectConversationWeb() throws InterruptedException
	{
		try{
			webconv.searchForAndSelect(conversationTitle);
		}
		catch (Exception e) {
			
//			Assert.assertFalse(true);
//			Assert.fail(e.getMessage());
			log.error("Unable to search a conversation");
		}
//		webconv.clickOnCancelButton();
	}

	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void leaveConversationAsParticipant() throws InterruptedException {
//		try{
			groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getIosUserDisplayName());
			conversationDetailsPage.clickOnLeaveConversation();
			mediumWait.until(ExpectedConditions.visibilityOf(webLeaveConversationPage.transferOwnershipPopUp));
			webLeaveConversationPage.transferOwnershipWithoutLeavingConversation();
			mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Conversation created')]//..//div//div//div//span[contains(text(),'is the new owner')]")));
			Assert.assertEquals(true ,webChatPage.newOwner.getText().contains("new owner"));
			conversationDetailsPage.clickOnLeaveConversation();
			mediumWait.until(ExpectedConditions.visibilityOf(webLeaveConversationPage.leaveConversationPopUp));
			webLeaveConversationPage.leaveConversation();
			Utils.veryShortSleep();
			Assert.assertEquals(true ,webChatPage.netcChatText.getText().contains("Welcome to NetSfere"));
			searchAndSelectConversationWeb();
//		}
//		catch (Exception e) {
//			
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void transferOwnershipAndLeaveConversation() throws InterruptedException {
//		try{
			groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getIosUserDisplayName());
			conversationDetailsPage.clickOnLeaveConversation();
			webLeaveConversationPage.clickOnFirstParticipant();
			webLeaveConversationPage.clickOnTransferOwnership();
			Thread.sleep(3000);
			webLeaveConversationPage.leaveConversation();
			Utils.shortSleep();
			Assert.assertEquals(true ,webChatPage.netcChatText.getText().contains("Welcome to NetSfere"));
			searchAndSelectConversationWeb();
//		}
//		catch (Exception e) {
//			
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void destroyConversationAsOwner() throws InterruptedException {
		try{
			groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getIosUserDisplayName());
			conversationDetailsPage.clickOnLeaveConversation();
			mediumWait.until(ExpectedConditions.visibilityOf(webLeaveConversationPage.transferOwnershipPopUp));
			webLeaveConversationPage.destroyConversation();
			Utils.veryShortSleep();
			Assert.assertEquals(true ,webChatPage.netcChatText.getText().contains("Welcome to NetSfere"));
			searchAndSelectConversationWeb();
	}
	catch (Exception e) {
		
		Assert.assertFalse(true);
	}
	}

	// Murali
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void navigateToRecentConversation() throws Exception {			
		webconv.clickRecentConv();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void favoriteConversation() throws Exception {		
		createConversationWebWithTitle();
		webconv.favoriteConversation();		
	}
	
	@Test(dependsOnMethods = { "favoriteConversation" })
	@NavigateTo(WebConversationsPage.class)
	public void unFavoriteConversation() throws Exception {
		navigateToRecentConversation();
		webconv.unFavoriteConversation();		
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void muteConversation() throws Exception {		
		createConversationWebWithTitle();
		webconv.muteConversation();		
	}
	
	@Test(dependsOnMethods = { "muteConversation" })
	@NavigateTo(WebConversationsPage.class)
	public void unMuteConversation() throws Exception {
		navigateToRecentConversation();
		webconv.unMuteConversation();		
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void exportFirstConversation() {
		try{
			streamlinedConversationByClickingCreateButton();
			webconv.clickOnFirstConversation();
			conversationDetailsPage.clickOnExportConversation();
			webExportConversationPage.exportNetcConversation();
			Utils.shortSleep();
		}
		catch (Exception e) {
			
			Assert.assertFalse(true);
		}
		
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendAttachmentFromDevice() throws InterruptedException, IOException {
		try{
			createConversationWebWithTitle();
			//webChatPage.addButtonClick();
			webAttachment.sendAttachmentFromDevice("PNG", "png");
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));	
		}
		catch (Exception e) {
			log.error("Unable to send attachments from web conversation");
			Assert.assertFalse(true);
		}
	}
	
	
	@Test(dependsOnMethods = {"sendAttachmentFromDevice"})
	public void saveAttachmentToDevice() {
//		try{
			saveAttachmentPage.saveAttachment();
//		}
//		catch (Exception e) {
//			
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public String addGuestUserInConversation() throws InterruptedException{
//		try{
			Utils.veryShortSleep();
			webconv.clickOnNewConversation();
			String guestUser = Config.getInstance().getGuestEmail();
			String userName = guestUser.substring(0, 19);
			System.out.println(userName);
			newConversationPage.addGuestUser(guestUser);
			newConversationPage.conversationTitle("guest"+conversationTitle);	
			newConversationPage.createConversationForGuestUser();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
			Assert.assertEquals(true, webconv.guestTag.isDisplayed());
//		}
//		catch(Exception e){
//			log.error("Unable to create conversation with title");
//			Assert.assertFalse(true);
//		}
		return userName;
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createConversationWithExistingGuestUser() throws InterruptedException {
		Utils.veryShortSleep();
		webconv.clickOnNewConversation();
		String guestUser = Config.getInstance().getGuestUser();
//		String userName = guestUser.substring(0, 19);
//		System.out.println(userName);
		newConversationPage.addGuestUser(guestUser);
		newConversationPage.conversationTitle("guest"+conversationTitle);	
		newConversationPage.createConversationbutton();
//		webChatPage.guestPopUp();
		Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
		Assert.assertEquals(true, webconv.guestTag.isDisplayed());
	}
	
	@NavigateTo(WebConversationsPage.class)
	public void groupConversationGuestUserWithTitle(String participant1, String participant2) throws InterruptedException{
		try{
			webconv.clickOnNewConversation();
			makeSureToBeInNewConversationPage();
			newConversationPage.searchAndSelectContact(participant1);
			newConversationPage.searchAndSelectGuestContact(participant2);
			newConversationPage.conversationTitle("Group"+conversationTitle);
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
		}
		catch(NoSuchFieldError e){
		Assert.assertFalse(true);
		
		log.error("No such contact present");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendingMessageToGuestUser() throws InterruptedException{
		//try{
			netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
			Utils.shortSleep();
			webChatPage.messageTextbox(Config.getInstance().getGuestMessage());
			Utils.veryShortSleep();
			webChatPage.sendMessageButton();
			Utils.shortSleep();
			Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
			
//		}catch(Exception e){
//			log.error("Unable to send Mail to guest");
//			Assert.assertFalse(true);
//		}
	}
	
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void addGuestUserToExistingConversation() throws Exception {
		createConversationWithoutTitle();
		try{
			conversationDetailsPage.conversationSettings();
			newConversationPage.searchAndSelectGuestContact(Config.getInstance().getGuestDisplayName());
			conversationDetailsPage.saveButton();
			Thread.sleep(2000);
			Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("this conversation"));
	}
	catch (Exception e) {
		Assert.assertFalse(true);
	}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void removeGuestUserFromExistingConversation() throws Exception {
		netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
		try{
			conversationDetailsPage.conversationSettings();
			newConversationPage.searchAndSelectGuestContact(Config.getInstance().getGuestDisplayName());
			conversationDetailsPage.saveButton();
			Thread.sleep(2000);
			Assert.assertEquals(true, webChatPage.removePlaceholder.getText().contains("left this conversation"));
		}
		catch(Exception e){
			Assert.assertFalse(true);
			
		}
		
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void destroyConversationWithGuest() throws InterruptedException {
		netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
		conversationDetailsPage.clickOnLeaveConversation();
		webLeaveConversationPage.destroyConversation();
		Utils.shortSleep();
		Assert.assertEquals(true ,webChatPage.netcChatText.getText().contains("Welcome to NetSfere"));
		searchAndSelectConversationWeb();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void netsfereUserSendDocumentToGuestUser(){
		try{
			addGuestUserInConversation();
			Utils.shortSleep();
			webChatPage.addButtonClick();
			webAttachmentPage.sendAttachFromDevice();
			Utils.shortSleep();
			Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
			
		}catch(Exception e){
			log.error("Unable to send attachment to guest");
			Assert.assertFalse(true);
		}
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void guestUserSendLocationtoWebInAConversation() throws InterruptedException
	{
		
		Utils.veryShortSleep();
		netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
		/*webconv.clickOnNewConversation();
		newConversationPage.addGuestUser(Config.getInstance().getAndroidUserEamil());
		newConversationPage.conversationTitle("guest"+conversationTitle);	
		newConversationPage.createConversationbutton();
		Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
		Assert.assertEquals(true, webconv.guestTag.isDisplayed());
		Utils.veryShortSleep();*/
		sendMyLocation();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendPNGToGuestUser() throws FindFailed, InterruptedException{
		try{
		netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
		Utils.shortSleep();
		webAttachment.sendAttachmentFromDevice("PNG", "png");
		Utils.shortSleep();
		Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
		}
		catch(Exception e){
		log.error("Unable to send Attachment");
			Assert.assertFalse(true);
		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendPDFToGuestUser() throws FindFailed, InterruptedException{
		try{
			/*netsfereUserCreateConversationWithAlreadyActivatedGuestUser();
			Utils.shortSleep();*/
			/*webChatPage.messageTextbox(Config.getInstance().getGuestMessage());
			Utils.veryShortSleep();*/
			webAttachment.sendAttachmentFromDevice("PDFFile", "pdf");
			Utils.shortSleep();
			Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
			
		}
		catch (Exception e) {
			log.error("Unable to send PDF file to guest user from web conversation");
			Assert.assertFalse(true);
		}
	}
	
	//location
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendLocationToGuestInaConversation() throws InterruptedException
	{
		try{
		addGuestUserInConversation();
		Utils.shortSleep();
		sendMyLocation();
		Utils.shortSleep();
		Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
		}
		catch(Exception e){
		log.error("Unable to send location to guest");
		Assert.assertFalse(true);
		}
	}

	@Test
	@NavigateTo(WebConversationsPage.class)
	public void guestUserSendingMessageToNetsfereUser() throws InterruptedException{
//		try{
			Thread.sleep(3000);
			webconv.clickOnNewConversation();
			newConversationPage.addGuestUser(Config.getInstance().getAndroidUserEamil());
			newConversationPage.conversationTitle("guest"+conversationTitle);	
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
			Assert.assertEquals(true, webconv.guestTag.isDisplayed());
			Utils.shortSleep();
			webChatPage.messageTextbox(Config.getInstance().getGuestMessage());
			Thread.sleep(2000);
			webChatPage.sendMessageButton();
			Utils.shortSleep();
			Assert.assertEquals(true, webChatPage.sentMark.isDisplayed());
//		}
//		catch(Exception e){
//			log.error("Unable to create conversation with title");
//			Assert.assertFalse(true);
//		}
	}

	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void netsfereUserCreateConversationWithAlreadyActivatedGuestUser() throws InterruptedException{
//		try{
			Thread.sleep(3000);
			webconv.clickOnNewConversation();
			newConversationPage.addGuestUser(Config.getInstance().getGuestUser());
			webio.spacebar();
			newConversationPage.conversationTitle("guest"+conversationTitle);	
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().startsWith("Conversation created"));
			Assert.assertEquals(true, webconv.guestTag.isDisplayed());
//		}
//		catch(Exception e){
//			log.error("Unable to create conversation with title");
//			Assert.assertFalse(true);
//		}
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void guestUserCreateConversationWithNetsfereUser() throws InterruptedException{
//		try{
			Thread.sleep(3000);
			webconv.clickOnNewConversation();
			newConversationPage.addGuestUser(Config.getInstance().getAndroidUserEamil());
			newConversationPage.conversationTitle("guest"+conversationTitle);	
			newConversationPage.createConversationbutton();
			Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
			Assert.assertEquals(true, webconv.guestTag.isDisplayed());
			Utils.shortSleep();
//		}
//		catch(Exception e){
//			log.error("Unable to create conversation with title");
//			Assert.assertFalse(true);
//		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void startLiveFromConversation() throws Exception {
		createConversationWebWithTitle();
		webChatPage.clickOnLiveButton();
		webChatPage.clickOnBroadcastLiveButton();
		try {
			mediumWait.until(ExpectedConditions.visibilityOf(broadcastPage.liveLabelOnBroadcastLive));
		} catch (Exception e) {
			log.error("Timeout happen when waiting for LIVE button");
			Assert.fail();
		}
		Assert.assertEquals(true, broadcastPage.liveLabelOnBroadcastLive.isDisplayed());
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void validateBadgeCountInConversation() {
		try {
			if(webconv.numberOfUnreadConversation()!=null) {
				log.info("Unread message present in the conversation");
			}
		}catch(NoSuchElementException e) {
			log.error("No Unread message in the conversation");
		}
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void validateMessageInUnreadTab() throws Exception {
		webconv.clickOnUneadTab();
		webconv.validateBadgeCountInUnreadTab();
		webconv.clickOnAllTab();
	}
	
	
	@Test
	public void webWithoutTitleAssertion(){
		Assert.assertEquals("now", webconv.recentCreatedConversation.getText());
		webconv.recentConversation.click();
		Assert.assertEquals(Config.getInstance().getAndroidUserDisplayName(), webconv.fetchingOwnerNameDefaultTitle());
		Utils.shortSleep();
	} 
	
	@Test
	public void modifiedTitle() throws InterruptedException{
		Thread.sleep(3000);
		Assert.assertEquals(true, webChatPage.modifiedTitle.getText().contains("2021"));
	}
	
	@Test
	public void conversationWithTitle(){
		Assert.assertEquals(true, webconv.recentConversation.getText().contains("2021"));
	}
	
	@Test
	public void groupConversationParticipantCountAssertion(){
		webconv.groupConversationParticipantCheck();
	}
	
	@Test
	public void addParticipantAssertion(){
		webconv.recentConversation.click();
		Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("joined this conversation"));
	}
	
	@Test
	public void quickReplyAssertion(){
		webconv.recentConversation.click();
		Utils.shortSleep();
		Assert.assertEquals("Hello!", webChatPage.quickReplyMessage.getText());
		driver.navigate().back();
		}
	
	@Test
	public void leaveConversationAsParticipantAssertion(){
		webconv.recentConversation.click();
		Assert.assertEquals(true, webChatPage.removePlaceholder.getText().contains("left this conversation."));
		
	}
	
	@Test
	public void webConversationCleanUp() {
		webconv.webCleanUp();
	}
	
	@Test
	public void transferOwnershipAssertion(){
		webconv.recentConversation.click();
		Assert.assertEquals(true, webChatPage.newOwner.getText().contains("is the new owner."));
	}
	
	
	@Test
	public void addingGuestAssertion(){
		Assert.assertEquals(Config.getInstance().getGuestDisplayName(), webconv.addingGuestAssertion().contains(Config.getInstance().getGuestDisplayName()));
		Utils.shortSleep();
	}
	
	@Test
	public void androidGuestSendingMessageAssertion(){
		webconv.recentConversation.click();
		Assert.assertEquals(true, webconv.messageFromAndroid.getText().contains("2021"));
	}
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void streamlinedConversationByClickingCreateButton()
	{
		try{
		makeSureToBeInNewConversationPage();
		newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
		webChatPage.streamlineMessageTextbox(Config.getInstance().getMessageFromWeb());
		newConversationPage.createConversationbutton();
		Assert.assertEquals(Config.getInstance().getKeyMessageSentStatus(), webChatPage.sentMark.getAttribute("title"));
		}
		catch(Exception e){
			log.error("Unable to send messgae in streamline conversation by clicking on create button");
			
		}
	}
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void streamlinedConversationByClickingSendButton()
	{
		try{
		makeSureToBeInNewConversationPage();
		newConversationPage.searchAndSelectContact(Config.getInstance().getAndroidUserDisplayName());
		webChatPage.streamlineMessageTextbox(Config.getInstance().getMessageFromWeb());
		webChatPage.sendMessageButton();
		Utils.shortSleep();
		Assert.assertEquals(Config.getInstance().getKeyMessageSentStatus(), webChatPage.sentMark.getAttribute("title"));
		}
		catch(Exception e){
			log.error("Unable to send messgae in streamline by clicking on send button");
			
		}
	}
	
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void webUserAsParticipantUnableToEditParticipantsInConversation(){
		webconv.clickRecentConv();
		Assert.assertEquals(false, conversationDetailsPage.editParticipantsLink());
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void webUserAsParticipantUnableToEditTitleInConversation(){
		webconv.clickRecentConv();
		Assert.assertEquals(false, conversationDetailsPage.settingButtonOnConversation());
	}
	
	@Test
	public void forwardMessageToAConversation() {
		Utils.veryShortSleep();
		webChatPage.clickOnMessageForwardArrow();
		webChatPage.clickOnFirstConversationAndForward();
		Assert.assertEquals(true, webChatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	public void forwardMessageToMultipleConversation() {
		Utils.veryShortSleep();
		webChatPage.clickOnMessageForwardArrow();
		webChatPage.clickOnMultipleConversationAndForward();
		Assert.assertEquals(true, webChatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	public void assertForwardedTab() {
		webconv.clickOnFirstConversation();
		Utils.veryShortSleep();
		Assert.assertEquals(true, webChatPage.forwardedTab.isDisplayed());
	}
	
	@Test
	public void inlineReply() {
		webconv.clickOnFirstConversation();
		Utils.veryShortSleep();
		webChatPage.clickOnReplyButton();
		webChatPage.messageTextbox("Yes..!Please...");
		webChatPage.sendMessageButton();
		mediumWait.until(ExpectedConditions.visibilityOf(webChatPage.sentMark));
	}
	
	@Test
	public void composeMessageInAConversation() {
		webChatPage.messageTextbox("Yes..!Please...");
		webChatPage.sendMessageButton();
		mediumWait.until(ExpectedConditions.visibilityOf(webChatPage.sentMark));
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendAttachmentFromBox() throws InterruptedException {
		groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getIosUserDisplayName());
		webChatPage.addButtonClick();
		Thread.sleep(3000);
		webAttachmentPage.clickOnFromCloudStorageButton();
		Thread.sleep(3000);
		try {
			if(webAttachmentPage.boxAccount.isDisplayed()) {
				webAttachmentPage.selectBoxAccountAttachment();
				mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Send')]")));
				webAttachment.sendButton.click();
				mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-check']")));
			}
		}catch(Exception e) {
		webAttachmentPage.clickOnAddBoxAccount();
		webio.SwitchWindowBack("1");
		mediumWait.until(ExpectedConditions.visibilityOf(boxPage.boxPage));
		boxPage.loginToBox(Config.getInstance().getBoxEmail(), Config.getInstance().getBoxPassword());
		webio.SwitchWindowBack("0");
		Thread.sleep(2000);
		webAttachmentPage.selectBoxAccountAttachment();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Send')]")));
		webAttachment.sendButton.click();
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-check']")));
		}
		
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void sendAttachmentFromDracoon() throws InterruptedException {
		groupConversationWithTitle(Config.getInstance().getAndroidUserDisplayName(), Config.getInstance().getIosUserDisplayName());
		webChatPage.addButtonClick();
		Thread.sleep(3000);
		webAttachmentPage.clickOnFromCloudStorageButton();
		Thread.sleep(3000);
		try {
			if(webAttachmentPage.dracoonAccount.isDisplayed()) {
				webAttachmentPage.selectDracoonAccountAttachment();
				mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Send')]")));
				webAttachment.sendButton.click();
				mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-check']")));
			}
		}catch(Exception e) {
		webAttachmentPage.clickOnAddDracoonAccount();
		webio.SwitchWindowBack("1");
		mediumWait.until(ExpectedConditions.visibilityOf(dracoon.getDracoon_username_textbox()));
		dracoon.loginToDracoon(Config.getInstance().getDracoonUsername(), Config.getInstance().getDracoonPassword());
		webio.SwitchWindowBack("0");
		Thread.sleep(2000);
		webAttachmentPage.selectDracoonAccountAttachment();
		mediumWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Send')]")));
		webAttachment.sendButton.click();
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fa fa-check']")));
		}
		
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void createSelfConversation() throws Exception {
		makeSureToBeInNewConversationPage();
		newConversationPage.createConversationbutton();
		Thread.sleep(3000);
		Assert.assertEquals(true ,webChatPage.conversationCreatedPage.getText().contains("Conversation created"));
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void addParticipantToSelfConversation() throws Exception {
		createSelfConversation();
		conversationDetailsPage.conversationSettings();
		newConversationPage.searchAndSelectContact(Config.getInstance().getIosUserDisplayName());
		conversationDetailsPage.saveButton();
		Thread.sleep(2000);
		Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("this conversation"));
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void addMultipleParticipantsToAConversation() throws Exception {
		createConversationWebWithTitle();
		conversationDetailsPage.conversationSettings();
		newConversationPage.searchAndSelectContact(Config.getInstance().getIosUserDisplayName());
		newConversationPage.searchAndSelectContact(Config.getInstance().getSecondWebUserDisPlayName());
		conversationDetailsPage.saveButton();
		Thread.sleep(2000);
		Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("this conversation"));
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void addParticipantToAGroupConversation() throws InterruptedException {
		groupConversationWithoutTitle();
		conversationDetailsPage.conversationSettings();
		newConversationPage.searchAndSelectContact(Config.getInstance().getSecondWebUserDisPlayName());
		conversationDetailsPage.saveButton();
		Thread.sleep(2000);
		Assert.assertEquals(true, webChatPage.joiningPlaceHolder.getText().contains("this conversation"));
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void favoriteConversationFromAllTab() throws Exception {
		createConversationWebWithTitle();
		webio.mouseHover(webconv.firstConversation);
		Thread.sleep(2000);
		webconv.clickOnConvMoreOptions();
		webconv.favoriteAllTab();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void muteConversationFromAllTab() throws Exception {
		createConversationWebWithTitle();
		webio.mouseHover(webconv.firstConversation);
		webconv.clickOnConvMoreOptions();
		webconv.muteAllTab();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void leaveConversationFromAllTab() throws Exception {
		createConversationWebWithTitle();
		webio.mouseHover(webconv.firstConversation);
		webconv.clickOnConvMoreOptions();
		webconv.leaveAllTab();
	}

	/*
	 * Helper methods
	 */
	// This method will make sure to be at New Conversation Page 
	public void makeSureToBeInNewConversationPage() throws Exception {
		log.info("In makeSureToBeInNewConversationPage");
		if (!newConversationPage.isAt()) {
			newConversationPage.navigateTo();
		}
	}
	

}
