package com.infinite.netsfere.automationtool.modules.android.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.AndroidIoOperations;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MeetingPage extends GenericListPage implements BasePage{
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait androidWait;
	ContactsPage cont;
	private static String service;
	private static final String PAGE_TITLE = "Meetings";
	private static Logger log = LogManager.getLogger(MeetingPage.class.getName());


	public MeetingPage() {
		
		cont = new ContactsPage();
		driver = DriverManager.getAndroidDriver();
		androidWait = Utils.getLongWait(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/new_meeting_fab' and @index='1']")
	public WebElement createNewMeetingFab;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/meeting_title']")
	public WebElement meetingTitleTextBox;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/meeting_description']")
	public WebElement meetingDescriptionTextBox;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/meeting_location']")
	public WebElement meetingLocation;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/value']")
	public WebElement serviceType;
	
//	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/imagePhoto']")
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/add_participants_icon']")
	public WebElement addContactIcon;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/action_fab']")
	public WebElement saveContactForMeetingButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_create']")
	public WebElement createMeeting;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/action_start_meeting' and @text='START MEETING']")
	public WebElement startMeetingButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/action_cancel_meeting' and @index='3']")
	public WebElement cancelMeetingButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/stop_button']")
	public WebElement stopLiveMeetingButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/end_meeting__button']")
	public WebElement endMeetingButtonLink;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	public WebElement endMeetingConfirmationButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/alertTitle']")
	public WebElement endMeetingConfimationTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='DONE']")
	public WebElement doneStatusBadge;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='CANCELLED']")
	public WebElement cancelledStatusBadge;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='Started']")
	public WebElement startedStatusBadge;
	
//	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/bottom_navigation_small_container' and @index='4']")
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_meetings' and @index='4']")
	public WebElement meetingNavigationLink;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/md_title' and @text='NetSfere LIVE']")
	public WebElement servicesNetsfereLive;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/md_title' and @text='NetSfere HD Voice (2 attendees only)']")
	public WebElement servicesNetsfereHDcall;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/md_title' and @text='NetSfere Group HD Audio']")
	public WebElement servicesNetsfereGroupCall;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/md_title' and @text='Other']")
	public WebElement servicesNetsfereOthers;
	
//	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/meeting_detail_layout' and @index='1']")
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='0']")
	public WebElement recentMeeting;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/conversation_unread_badge' and @index='3']")
	public WebElement newMeetingTag;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/action_accept_meeting' and @index='3']")
	public WebElement acceptButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/action_tentative_meeting' and @index='4']")
	public WebElement tentativeButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/action_reject_meeting' and @index='5']")
	public WebElement rejectButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/text_live' and @text='LIVE']")
	public WebElement liveMeetingBadge;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@resource-id='com.infinite.netsfere:id/checkBox' and  @index='0']")
	public WebElement groupCallParticipantCheckBox;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/call_fab']")
	public WebElement makeGroupCall;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @text='Delete Meeting']")
	public WebElement deleteIcon;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @text='DELETE']")
	public WebElement deleteButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_title' and @index='0']")
	public  List<WebElement> recentCreatedMeetingTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/message_content_textview' and @index='0']")
	public WebElement meetingMOM;
	
	
	
     @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='Done']")
     public WebElement doneStatus;
     
     @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='Started']")
     public WebElement startedStatus;
     
     @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and text='Cancelled']")
     public WebElement cancelledStatus;
     
     
     public String doneStatusAssertion(){
 		List<AndroidElement> doneStatus_list=driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='Done']"));
 		String s1=doneStatus_list.get(0).getText();
 		return s1;		
 	}
     
     
     public String startedStatusAssertion(){
  		List<AndroidElement> startedStatus_list=driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and @text='Started']"));
  		String s1=startedStatus_list.get(0).getText();
  		return s1;		
  	}
     
    public String cancellledStatusAssertion(){
    	List<AndroidElement> cancelledStatus_list=driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/meeting_status_badge' and text='Cancelled']"));
  		String s1=cancelledStatus_list.get(0).getText();
  		return s1;	
    	
    }
     
     
     
	public void serviceSelect(int index){
		switch(index){
		case 0: servicesNetsfereLive.click();
				break;
		case 1: servicesNetsfereHDcall.click();
				break;
		case 2: servicesNetsfereGroupCall.click();
				break;
		case 3: servicesNetsfereOthers.click();
				break;
		}
	}
	
	public void clickAddConctactIcon(){
		addContactIcon.click();
	}
	public void clickMeetingPageIcon(){
		meetingNavigationLink.click();
	}
	
	public void clickNewMeetingFab(){
		createNewMeetingFab.click();
	}
	
	public void editMeetingTitle(String meetingTitle){
		meetingTitleTextBox.click();
		meetingTitleTextBox.clear();
		meetingTitleTextBox.sendKeys(meetingTitle);
	}
	
	public void editMeetingDescription(String meetingDescription){
		meetingDescriptionTextBox.click();
		meetingDescriptionTextBox.clear();
		meetingDescriptionTextBox.sendKeys(meetingDescription);
	}
	
	public void editMeetingLocation(String meetLocation){
		meetingLocation.click();
		meetingLocation.clear();
		meetingLocation.sendKeys(meetLocation);
	}
	
	public void clickService(){
		serviceType.click();
	}
	
	public void searchSelectContactForMeeting(String userName) {
//		try{
		cont.contactSearchIcon.click();
		cont.contactNameSearchBox.sendKeys(userName);
		androidWait.until(ExpectedConditions.visibilityOf(cont.searchedContact));
		Utils.veryShortSleep();
		cont.searchedContact.click();
		
//		}catch (Exception e) {
//			
//		}
	}
	
	public void saveMeetingAfterSelectContact() {
		saveContactForMeetingButton.click();
	}
	
	public void createMeetingAfterSelectContact(){
		androidWait.until(ExpectedConditions.visibilityOf(createMeeting));
		createMeeting.click();
		androidWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.infinite.netsfere:id/action_edit']")));
	}
	
	public void startMeeting(){
	
		Utils.veryShortSleep();
		AndroidIoOperations.scroll();
		Utils.veryShortSleep();
		if(startMeetingButton.isDisplayed()){
			startMeetingButton.click();
		}
		Utils.veryShortSleep();
	}
	public void startMeetingForGroup(){
		Utils.veryShortSleep();
		AndroidIoOperations.scroll();
		Utils.veryShortSleep();
		if(startMeetingButton.isDisplayed()){
			startMeetingButton.click();
			Utils.veryShortSleep();
			List<AndroidElement> ls = driver.findElements(By.xpath("//android.widget.RelativeLayout[@index='0']"));
			for(int i=0;i<=ls.size()-1;i++){
				ls.get(i).click();
			}
			makeGroupCall.click();
			mediumWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.infinite.netsfere:id/header_button']")));
		}
	}
	
	public void cancelMeeting(){
		if(cancelMeetingButton.isDisplayed()){
			cancelMeetingButton.click();
		}
	}
	
	public void stopLiveMeeting(){
		try {
		if(stopLiveMeetingButton.isDisplayed()){
			Utils.shortSleep();
			stopLiveMeetingButton.click();
		}
			Utils.veryShortSleep();
			
			endMeetingConfirmation();
		}
		catch (Exception e) {
			log.info("Unable to stop meeting");
		}
		
	}
	
	public void endMeetingConfirmation(){
		endMeetingButtonLink.click();
		androidWait.until(ExpectedConditions.visibilityOf(endMeetingConfimationTitle));
		endMeetingConfirmationButton.click();
	}
	
	public void clickRecentMeeting(){
		
			recentMeeting.click();
		
	}
	
	
	
	public void clickAcceptButton(){
		
		AndroidIoOperations.scroll();
		acceptButton.click();
	}
	
	public void clickTentativeButton(){
		Utils.veryShortSleep();
		AndroidIoOperations.scroll();
		Utils.veryShortSleep();
		tentativeButton.click();
		Utils.veryShortSleep();
	}
	
	public void clickRejectButton(){
		Utils.veryShortSleep();
		AndroidIoOperations.scroll();
		Utils.veryShortSleep();
		rejectButton.click();
	}
	
	public void clickDeleteIcon(){
		deleteIcon.click();
		deleteButton.click();
	}
	

	@Override
	WebElement getFirstListItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isAt() {
		// Check and return true, if the current activity is
		// ACTIVITY_MAIN_SCREEN and page title is equal to PAGE_TITLE
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_MEETING_SCREEN) && getPageTitle()!=null && getPageTitle().equals(PAGE_TITLE);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in meeting screen");
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// Navigate to home screen first
		Utils.navigateToHomeScreen(driver);
		// Click on conversations icon in bottom navigation bar
		BottomNavigationBar.getInstance().navigateToMeetingsPage();
	}

	@Override
	WebElement getFirstCreatedConvListItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
