package com.infinite.netsfere.automationtool.modules.android.pages;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends GenericListPage implements BasePage{
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait mediumWait;
	WebDriverWait shortWait;
	SideNavigation side;
	private static Logger log = LogManager.getLogger(IntroPage.class.getName());
	public final String mobileNumber = "9535158751";
	public final String regex = "\\d+"; 
	 


	public SettingsPage() {
		driver = DriverManager.getAndroidDriver();
		mediumWait = Utils.getMediumWait(driver);
		shortWait = Utils.getShortWait(driver);
		side = new SideNavigation();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.infinite.netsfere:id/display_pic_imageview' and @index='0']")
	public WebElement profileIconSettingPage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/subtitle_textview' and @index='3']")
	public WebElement meetingUrlEditButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
	public WebElement meetingPointTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @text='UPDATE']")
	public WebElement updateButtonOfMeetingPointURL;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
	public WebElement phoneNumber;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@resource-id='com.infinite.netsfere:id/design_menu_item_text' and @text='Settings']")
	public WebElement settingsTab;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/call_ringtone_options_switch' and @text='OFF']")
	public WebElement notificationToneOFF;   
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/call_ringtone_options_switch' and @text='ON']")
	public WebElement notificationToneON;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/notification_light_option_switch' and @index= '2']")
	public WebElement notificationLight;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/popup_options_switch' and @text='OFF']")
	public WebElement popNotificationOFF;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/popup_options_switch' and @text='ON']")
	public WebElement popNotificationON;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")
	public WebElement okButtonPopupNotification;
	
	@AndroidFindBy(xpath="//android.widget.Switch[@resource-id='com.infinite.netsfere:id/call_ringtone_options_switch' and @index='1']")
	public WebElement netsfereCallRingtone;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@resource-id='com.infinite.netsfere:id/video_options_spinner' and @index='2']")
	public WebElement videoQuality;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id = 'android:id/text1'  and @index = '0']")
	public WebElement lowQuality;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id = 'android:id/text1'  and @index = '1']")
	public WebElement mediumQuality;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id = 'android:id/text1'  and @index = '2']")
	public WebElement highQuality;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/video_options_2nd_line_textview' and @index='1']")
	public WebElement pixel;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/change_password_textView' and @index='14']")
	public WebElement changePassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/current_password_text' and @index='0']")
	public WebElement currentPassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/new_password_text' and @index='0']")
	public WebElement newPassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.infinite.netsfere:id/re_password_text' and @index='0']")
	public WebElement confirmPassword;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/button_change_password' and @text='CHANGE PASSWORD']")
	public WebElement changePasswordSubmitButton;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/request_layout' and @index='16']")
	public WebElement accessRequest;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/quick_reply_textView' and @index='18']")
	public WebElement quickReply;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1' and @index='0']")
	public WebElement firstQuickReply;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/alertTitle' and @text='Edit Message']")
	public WebElement editQuickReplyTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1' and @index='1']")
	public WebElement updateButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/save_item' and @index='0']")
	public WebElement saveQuickReply;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.infinite.netsfere:id/report_an_issue_layout' and @index='20']")
	public WebElement shareDeviceLog;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.infinite.netsfere:id/button_fullsync' and @index='22']")
	public WebElement reloadAllData;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.infinite.netsfere:id/button_logout']")
	public WebElement logout;
	
	//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/logoutButton']
	@ AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.infinite.netsfere:id/logoutButton']")
	public WebElement mainLogout;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement settingsBackButton;
	
	public void clickNetsfereNotificationToneON(){
		notificationToneOFF.click();	
	}
	public void clickNetsfereNotificationToneOFF(){
		notificationToneON.click();
		
	}
	
	
		
	public void clickNetsferePopUpNotificationON(){
		popNotificationOFF.click();
	}
	
	public void clickOnOKNetsferePopUpNotification(){
	       okButtonPopupNotification.click();
		}
	public void clickNetsferePopUpNotificationOFF()
	{
		popNotificationON.click();
	}
	
	
	
	
	public boolean checkNotificationTone(){
		if(popNotificationON.getText().contains("ON")){
			return true;
		}
		return false;
	}
	public boolean checkPopNotification(){
		if(popNotificationOFF.getText().contains("OFF")){
			return true;
		}
		return false;
	}
	
	
	//netsfere notification callRingtone ON and OFF
	public void enableNotificationTone(){
		try{
			if(checkNotificationTone()==true){
			log.info("Notification Tone is enabled");
			}
		}catch (Exception e) {
			clickNetsfereNotificationToneON();
		}
			
	}
	
	public void disableNotificationTone(){
		try{
			if(checkNotificationTone()==false){
			log.info("Notification Tone is disabled");
			}
		}catch (Exception e) {
			clickNetsfereNotificationToneOFF();
		}
	}
	
	
	
	//netsfere popUp Notification ON and OFF
	
	public void enablePopNotification(){
		/*try{
			if(checkPopNotification()==true){
			log.info("Notification Tone is enabled");
			}*/
		//}catch (Exception e) {
			clickNetsferePopUpNotificationON();
			clickOnOKNetsferePopUpNotification();
		//}
			
	}
	
	public void disablePopNotification(){
		try{
			if(checkPopNotification()==false){
			log.info("Notification Tone is disabled");
			}
		}catch (Exception e) {
			clickNetsferePopUpNotificationOFF();
		}
	}

	public void clickQuickReply(){
		quickReply.click();
	}
	
	public void editQuickReply(String str){
		firstQuickReply.click();
		editQuickReplyTextBox.sendKeys(str);
		updateButton.click();
		saveQuickReply.click();
		Utils.veryShortSleep();
	}
	
	public void clickVideoCaptureQuality(String str){
	/**
	 * Here user need to pass 'low' , 'medium' , 'high'
	 * based on which it will select the video quality	
	 */
		videoQuality.click();
		if(str.equalsIgnoreCase("low")){
			lowQuality.click();
		}else if(str.equalsIgnoreCase("medium")){
			mediumQuality.click();
		}else if(str.equalsIgnoreCase("high")){
			highQuality.click();
		}
		
	}
	
	
	public boolean pixelCheck(String str){
		if(str.equalsIgnoreCase("low")){
			return pixel.getText().contains("480p");
		}else if(str.equalsIgnoreCase("medium")){
			return pixel.getText().contains("720p");
		}else if(str.equalsIgnoreCase("high")){
			return pixel.getText().contains("1080p");
		}
		return false;
	}
	
	public void clickProfileIconOfSettingPage(){
		profileIconSettingPage.click();
	}
	
	public void editMeetingPointUrl(String str){
		meetingUrlEditButton.click();
		meetingPointTextBox.sendKeys(str);
		updateButton.click();
	}
	
	public void clickEditPhoneNumber(){
		phoneNumber.click();
		//In regex include special character and 2 more digit
		if(phoneNumber.getText().matches(regex)){
			String oldNumber = phoneNumber.getText();
			phoneNumber.clear();
			phoneNumber.sendKeys(convertIntToString());
			String newNumber = phoneNumber.getText();
			saveQuickReply.click();
			Assert.assertNotSame(oldNumber, newNumber);
		}else{
			phoneNumber.sendKeys(mobileNumber);
			saveQuickReply.click();
		}
		
	}
	
	public void clickLogoutButton(){
		
		logout.click();
	}
	
	public void clickChangePassword(String currentPwd, String newPwd, String cofirmPwd){
		changePassword.click();
		Utils.veryShortSleep();
		currentPassword.sendKeys(currentPwd);
		newPassword.sendKeys(newPwd);
		confirmPassword.sendKeys(cofirmPwd);
		
	}
	
	public void clickSubmitButton() throws Exception{
		try{
			if(changePasswordSubmitButton.isEnabled())
			{
				changePasswordSubmitButton.click();
			}
		}catch (NoSuchElementException e) {
			throw new Exception("Button is not enabled");
		}
		Utils.veryShortSleep();
	}	
	
	
	public void clickOnLogoutButton() {
		mainLogout.click();
	}
	
	public void clickOnBackButton() {
		settingsBackButton.click();
	}
	
	@Override
	public boolean isAt() {
		try {
			return driver.currentActivity().equals(Constants.ACTIVITY_SETTING_SCREEN);
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in intro screen");
			}
		}
		return false;
	}

	@Override
	public void navigateTo() throws Exception {
    	Utils.navigateToHomeScreen(driver);
//		BottomNavigationBar.getInstance().navigateToConversationsPage();
		side.clickOnNavigationBar();
		side.clickOnSettingsTab();	
	}
	
	

	@Override
	WebElement getFirstListItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	WebElement getFirstCreatedConvListItem() {
		// TODO Auto-generated method stub
		return null;
	}

	//Generating 10 digit number everytime this method execute
	private static int getRndNumber() {
	    Random random=new Random();
	    int randomNumber=0;
	    boolean loop=true;
	    while(loop) {
	        randomNumber=random.nextInt();
	        if(Integer.toString(randomNumber).length()==10 && !Integer.toString(randomNumber).startsWith("-")) {
	            loop=false;
	        }
	        }
	    return randomNumber;
	}
	
	//Converting int to String as sendKeys used to take char or String
	public String convertIntToString(){
		int num = getRndNumber();
		String randNum = Integer.toString(num);
		return "+91"+randNum;
		
	}
}
