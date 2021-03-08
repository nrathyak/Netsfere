package com.infinite.netsfere.automationtool.modules.web.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.modules.web.pages.WebChatPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebConversationsPage;
import com.infinite.netsfere.automationtool.modules.web.pages.WebGroupCallElements;
import com.infinite.netsfere.automationtool.modules.web.pages.WebHdOneToOneCallElements;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

public class WebGroupCallTestCases {
	
	WebDriver driver ;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	WebGroupCallElements groupCall;
	WebConversationTestCases webConvTestCases;
	WebConversationsPage webconv;
	WebHdOneToOneCallElements hdOneToOneCall;
	WebDriver secondDriver;
	WebChatPage webChatPage;
	
	
	@BeforeClass
	public void init() {
		driver = DriverManager.getWebDriver();
		secondDriver = DriverManager.getSecondWebDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		groupCall= new WebGroupCallElements();
		webConvTestCases = new WebConversationTestCases();
		webConvTestCases.init();
		webconv = new WebConversationsPage();
		hdOneToOneCall = new WebHdOneToOneCallElements();
		webChatPage = new WebChatPage();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void initiateGroupCall() throws InterruptedException {

		webChatPage.clickOnCallButton();
		groupCall.isAtSelectParticipantsPage();
		groupCall.clickOnPlaceCallButton();
		groupCall.isAtGroupCallPage();
		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
		Utils.veryShortSleep();
	}
	
	@Test
	public void endGroupCall() throws InterruptedException {
		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
		groupCall.clickOnEndGroupCall();
		Assert.assertEquals(true, groupCall.groupCallEnded.getText().contains("has ended a group call."));
	}
	
	@Test
	public void acceptGroupCallFromSecondUser() {
		groupCall.acceptFromSecondUser(secondDriver);
//		Assert.assertEquals(true, secondDriver.findElement(By.xpath("//span[contains(text(),'Group Call')]")).getText().contains("Group Call"));
	}
	
	
	
	@Test
	public void leaveOngoingGroupCallFromSecondUser() throws InterruptedException {
		groupCall.leaveGroupCallFromSecondUser(secondDriver);
//		Assert.assertEquals(false, secondDriver.findElement(By.xpath("//span[contains(text(),'Group Call')]")).getText().contains("Group Call"));
//		Assert.assertTrue(secondDriver.findElement(By.xpath("//span[contains(text(),'Group Call')]")).getText().contains("Group Call"));
	}
	
	@Test
	public void secondUserRejoinsGroupCall() {
		groupCall.rejoinGroupCallFromSecondUser(secondDriver);	
	}
	
	
	@Test
	public void ownerCanMuteAllParticipants() throws InterruptedException{
		groupCall.clickOnMuteAll();
		
		
		
	}
	
	
	@Test
	public void acceptGroupCall() {
		hdOneToOneCall.acceptIncomingCall();
		groupCall.clickOnGroupCall();
		Utils.veryShortSleep();
		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
	}

	@Test
	public void secondUserReceivesGroupCall() {	
		Assert.assertEquals(true, secondDriver.findElement(By.xpath("//div[text()='Incoming call...']")).getText().contains("Incoming call..."));
		
	
	}
	@Test
	public void receivesGroupCall() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incoming call...')]")));
		Assert.assertEquals(true, groupCall.groupIncomingCall.getText().contains("Incoming call..."));
	}
	
	@Test
	public void declineGroupCall() {
		hdOneToOneCall.declineIncomingCall();
		Assert.assertEquals(true, groupCall.startedGroupCallPlaceholder.getText().contains("has started a group call."));
	}
	
	@Test
	public void closeTheSecondUserBrowser() {
		secondDriver.close();
		
	}
	
	@Test
	public void addDynamicUser(String user) throws InterruptedException {
		groupCall.addDynamicUser(user);
		Assert.assertEquals(true, groupCall.ringAll.isDisplayed());
		
	}
	
	@Test
	public void initiateScreenShare() {
		groupCall.initiateScreenshare();
	}
	
	@Test
	public void stopScreenshare() {
		groupCall.stopScreenShare();
	}
	
	@Test
	public void viewScreenshareAssertion() {
		groupCall.viewScreenshare();
	}
	
	@Test
	public void endScreenshareAssertion() {
		groupCall.endScreenshare();
	}
	
	@Test
	@NavigateTo(WebConversationsPage.class)
	public void initiateGroupCallWithSelectedParticipants() throws InterruptedException {
		webChatPage.clickOnCallButton();
		groupCall.isAtSelectParticipantsPage();
		groupCall.clickOnDeselectParticipants();
		groupCall.clickOnPlaceCallButton();
		groupCall.isAtGroupCallPage();
		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
		Utils.veryShortSleep();	
	}
	
	@Test
	public void waitTillNoAnswerByparticipants() {
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='no answer']")));
		Assert.assertEquals(true, groupCall.noanswerStatus.getText().equals("no answer"));
	}
	
	@Test
	public void groupIncomingCallAssertion() {
		Utils.shortSleep();
		Assert.assertEquals(true, groupCall.groupIncomingCall.getText().contains("Incoming call..."));
	}
	
	@Test
	public void groupInCallAssertion() {
		Assert.assertEquals(true, groupCall.groupCall.getText().equals("Group Call"));
	}
	
	@Test
	public void secondWebUserJoinsScreenShare() {
		secondUserRejoinsGroupCall();
		groupCall.joinScreenshareFromSecondWebUser(secondDriver);
	}
	
	@Test
	public void connectedStatusAssertion(){
		Assert.assertEquals(true, groupCall.connectedStatus.getText().equals("connected"));
	}
	
	@Test
	public void disconnectedStatusAssertion(){
		Assert.assertEquals(true, groupCall.disconnectedStatus.getText().equals("disconnected"));
	}
	
	@Test
	public void locatingStatusAssertion(){
		mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='locating']")));
		Assert.assertEquals(true, groupCall.locatingStatus.getText().equals("locating"));
	}
	
	@Test
	public void declinedStatusAssertion(){
		Assert.assertEquals(true, groupCall.declinedStatus.getText().equals("declined"));
	}
	
	@Test
	public void notcalledStatusAssertion(){
		Assert.assertEquals(true, groupCall.notcalledStatus.getText().equals("not called"));
	}
	
	@Test
	public void endOrDisconnectGroupCall() {
		groupCall.endCall();
	}
	
	@Test
	public void endOrDisconnectCallFromSecondUser() {
		groupCall.endCallFromSecondWebUser(secondDriver);
	}
	
	
}
