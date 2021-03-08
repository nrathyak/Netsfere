package com.infinite.netsfere.automationtool.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Config {
	
	private static Logger log = LogManager.getLogger(Config.class.getName());
	static String randomDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static final String KEY_AndroidUserDisplayName = "AndroidUser_DisplayName";
	private static final String KEY_IosUserDisplayName = "iosUserDisplayName";
	private static final String KEY_IosUserEmail = "iosUser";
	private static final String KEY_IosUserPassword = "password";
	private static final String KEY_AndroidUserEmail = "android_user";
	private static final String KEY_AndroidUserPassword = "password";
//	private static final String KEY_AndroidDeviceName = "device_name";
//	private static final String KEY_AndroidVersion = "device_android_version";
	private static final String KEY_ReinstallApp = "reinstall_app";
	private static final String KEY_WebUserDisplayName = "WebUser_DisplayName";
	private static final String KEY_MessageFromAndroid = "message_from_android";
	private static final String KEY_MessageFromWeb = "conversation_message_web";
	private static final String KEY_MessageGuestFromWeb = "webGuestMessage";
	private static final String KEY_MessageGuestFromAndroid = "androidGuestMessage";
	
	/*
	 * channel
	 */
	private static final String KEY_ChannelForWeb="channelNameForWeb";
	private static final String Key_ChannelForAndroid="channelNameForAndroid";
	private static final String Key_Message= "channel_Restriction_Message";
	private static final String Key_ChannelMessageFromWeb="channelMessageWeb";
	private static final String Key_ChannelPlaceholderText="ChannelPlaceholderTextForEndingBroadcast";
	private static final String Key_ChannelMessageFromAndroid="channel_message_from_android";
			/*
	 * New Org SignUp
	 */
	private static final String KEY_NewOrgAdminEmail = "newOrg"+randomDate+"@nrathya.netsferetest.org";
	private static final String KEY_NewOrgAdminName = "newOrg"+randomDate+"";
	private static final String KEY_NewOrgName = "newOrgAdmin"+randomDate+"";
	private static final String KEY_NewOrgUserName = "newUser"+randomDate+"";
	private static final String KEY_NewOrgUserEmail = "newUser"+randomDate+"@nrathya.netsferetest.org";
	private static final String KEY_NewOrgNewUserCount = "numberOfUsers";
	
	/*
	 * Guest User
	 */
	private static final String KEY_GuestEmailId = "guest"+randomDate+"@nrathya.netsferetest.org";
	private static final String KEY_WebGuestDispalyName = "webGuestUser";
	private static final String KEY_AndroidGuestDisplayName = "androidGuestUser";
	private static final String KEY_GuestUser = "guestUser";
	private static final String KEY_GuestDisplayName = "guestDisplayName";
	private static final String KEY_GuestLabel = "guestLabel";
	/*
	 * Third user for group call
	 */
	private static final String KEY_WebSecondUserDisplayName = "webSecondUserDisplayName";
	private static final String KEY_WebSecondUserEmail = "webSecondUser";
	
	/*
	 * Quick Poll question and answer
	 */
	
	private static final String KEY_QuickPollQuestion = "quickPollQuestion";
	private static final String KEY_QuickPollAnswerOne = "quickPollOptionOne";
	private static final String KEY_QuickPollAnswerTwo = "quickPollOptionTwo";
	private static final String KEY_QuickPollAnswerThree = "quickPollOptionThree";
	private static final String KEY_QuickPollAnswerFour = "quickPollOptionFour";
	
	/*
	 * Gmail test account
	 */
	
	private static final String KEY_GmailId = "testGmailId";
	private static final String KEY_GmailPassword = "testGmailPassword";
	
	/*
	 * Message Status
	 */
	private static final String KEY_messageSentStatus = "messageSentStatus";
	
	/*
	 * Dracoon account Username and password
	 */
	private static final String KEY_DracoonUsername = "Dracoon_account_username";
	private static final String KEY_DracoonPassword = "Dracoon_account_password";

 	private static final String KEY_WebUserEmail = "webUser";
	private static final String KEY_WebPassword = "password";
	
	/*
	 * Meeting
	 */
	private static final String KEY_MeetingTitle = "meetingTitle";
	private static final String KEY_MeetingDescription = "meetingDescription";
	private static final String KEY_MeetingLocation = "meetingLocation";
	private static final String KEY_MeetingTypeLIVE = "meetingTypeLive";
	private static final String KEY_MeetingTypeHDCall = "meetingTypeHDCall";
	private static final String KEY_MeetingTypeGroupCall = "meetingTypeGroupCall";
	private static final String KEY_MeetingTypeOthers = "meetingTypeOthers";
	private static final String KEY_MeetingCancelText = "cancelMeetingText";
	private static final String KEY_MeetingCancelBadge = "meetingCanceledBadge";
	private static final String KEY_MeetingCancelledBadge ="meetingCancelledBadge";
	private static final String KEY_MeetingDoneBadge = "meetingDoneBadge";
	private static final String Key_MeetingStartedBadge="meetingStartedBadge";
	private static final String KEY_MeetingLiveBadge = "meetingLiveBadge";
	private static final String KEY_MeetingMOM = "meetingMOM";
	
	
	
	/*
	 * Reset password credentials
	 */
	
	private static final String KEY_NewPassword = "newPassword";
	private static final String KEY_ConfirmPassword = "confirmPassword";
	
	/*
	 * Location address
	 */
	
	private static final String KEY_Location= "location";
	
	/*
	 * Box credentials
	 */
	private static final String KEY_BOX_email = "Box_account_email";
	private static final String KEY_BOX_password = "Box_account_password";
	
	private static Config instance;
	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}
	private Properties properties;
	private Properties credentials;
	private String androidDeviceId;
	private String IosDeviceUDID;
	private String androidVersion;
	private String IosVersion;
	private String IosDevicename;
	private Config() {
		loadProperties();	
		loadCredentials();
		loadAndroidDeviceId();
		loadAndroidVersion();
		if (Utils.isMacOS()) {
			loadIOSDeviceId();
			loadIosVersion();
			loadIosDevicename();
		}
	}
	
	private void loadProperties() {
		properties = new Properties();
		String OS = System.getProperty("os.name").toLowerCase();
		String project_Dir = System.getProperty("user.dir");
		FileInputStream fis;
		try {
			if( OS.indexOf("mac") >= 0) {
				fis = new FileInputStream(project_Dir+"/config.properties");
			} else {
				fis = new FileInputStream(project_Dir+"\\config.properties");
			}
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadCredentials() {
		credentials = new Properties();
		String OS = System.getProperty("os.name").toLowerCase();
		String project_Dir = System.getProperty("user.dir");
		FileInputStream fis;
		try {
			if( OS.indexOf("mac") >= 0) {
				fis = new FileInputStream(project_Dir+"/credentials.properties");
			} else {
				fis = new FileInputStream(project_Dir+"\\credentials.properties");
			}
			credentials.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadAndroidDeviceId() {
		Runtime runtime = Runtime.getRuntime();
		try {			
			Process p = runtime.exec("adb devices");
			InputStream is = p.getInputStream();
			BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
			String s= (reader.readLine());  //Get first line
			s = reader.readLine();  // Get second line (first device details)
			if (s != null) {
				androidDeviceId = s.split("\t")[0];
			}
			log.info("Reading android device list : "+androidDeviceId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void loadIOSDeviceId() {
		Runtime runtime = Runtime.getRuntime();
		try {			
			Process p = runtime.exec("ios-deploy -c");
			InputStream is = p.getInputStream();
			BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
			String s= (reader.readLine());  //Get first line
			s = reader.readLine();  // Get second line (first device details)
			if (s != null) {
				IosDeviceUDID = s.split(" ")[2];
			}
			log.info("Reading IOS device list : "+IosDeviceUDID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void loadAndroidVersion() {
		Runtime runtime = Runtime.getRuntime();
		try {			
			Process p = runtime.exec("adb shell getprop ro.build.version.release");
			InputStream is = p.getInputStream();
			BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
			androidVersion = (reader.readLine());  //Get first line
			log.info("Reading android version : "+androidVersion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// iphone 7
	private void loadIosVersion() {
		Runtime runtime = Runtime.getRuntime();
		try {			
			Process p = runtime.exec("ios-deploy -c");
			InputStream is = p.getInputStream();
			BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
			String s = (reader.readLine());  //Get first line
			s = reader.readLine();  // Get second line (first device details)
			if (s != null) {
				IosVersion = (s.split("'")[1]);
				Pattern pattern = Pattern.compile("\\d{1,2}.\\d");
				Matcher m = pattern.matcher(IosVersion);
				if (m.find()) {
					IosVersion = IosVersion.split(" ")[2];
				} else {
					loadIosVersionForOtherDevices();
				}
				IosVersion.trim();				
			}
			log.info("Reading iOS version : "+IosVersion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// iphone x, iphone se
	private void loadIosVersionForOtherDevices() {
		Runtime runtime = Runtime.getRuntime();
		try {			
			Process p = runtime.exec("instruments -s devices | grep -v Simulator");
			InputStream is = p.getInputStream();
			BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
			String s = (reader.readLine());  //Get first line
			s = reader.readLine();  			// Get second line 
			s = reader.readLine();			// Get third line 
			if (s != null) {
				IosVersion = (s.split("\\(")[1]).split("\\)")[0];
				IosVersion.trim();				
			}
			log.info("Reading iOS version : "+IosVersion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Works for iphone 7
	private void loadIosDevicename() {
		//IosDevicename = "D22AP";
		//return;
		Runtime runtime = Runtime.getRuntime();
		try {			
			Process p = runtime.exec("ios-deploy -c");
			InputStream is = p.getInputStream();
			BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
			String s = (reader.readLine());  //Get first line
			s = reader.readLine();  			// Get second line (first device details)
			if (s != null) {
				IosDevicename = (s.split(",")[1]);//.split(" ")[0];
				//IosDevicename = IosDevicename+" "+(s.split("'")[1]).split(" ")[1];
				IosDevicename.trim();				
			}
			log.info("Reading iOSDevicename : "+IosDevicename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public String getAndroidDeviceName() {		
		return androidDeviceId;
	}
	
	public String getIosDeviceUDID() {		
		return IosDeviceUDID;
	}
	
	public String getAndroidVersion() {
		//return properties.getProperty(KEY_AndroidVersion);
		return androidVersion;
	}
	
	public String getIosVersion() {		
		return IosVersion;
	}
	public String getIosDevicename() {		
		return IosDevicename;
	}
	public String getAndroidUserDisplayName() {
		return credentials.getProperty(KEY_AndroidUserDisplayName);
	}
	
	public String getAndroidUserEamil() {
		return credentials.getProperty(KEY_AndroidUserEmail);
	}
	
	public String getAndroidUserPassword() {
		return credentials.getProperty(KEY_AndroidUserPassword);
	}	
	
	public boolean reInstallApp() {
		return properties.getProperty(KEY_ReinstallApp, "false").equalsIgnoreCase("true");
	}
	
	public String getWebUserDisplayName() {
		return credentials.getProperty(KEY_WebUserDisplayName);
	}
	
	
	public String getMessageFromAndroid() {
		return properties.getProperty(KEY_MessageFromAndroid);
	}
	
	public String getWebUserEmail() {
		return credentials.getProperty(KEY_WebUserEmail);
	}
	
	public String getWebUserPassword() {
		return credentials.getProperty(KEY_WebPassword);
	}
	
	public String getMessageFromWeb(){
		return properties.getProperty(KEY_MessageFromWeb);
	}
	
	public String getDracoonUsername(){
		return credentials.getProperty(KEY_DracoonUsername);
	}
	public String getDracoonPassword(){
		return credentials.getProperty(KEY_DracoonPassword);
	}
	public String getIosUserDisplayName(){
		return credentials.getProperty(KEY_IosUserDisplayName);
	}
	/*
	 * group call user
	 */
	public String getSecondWebUserEmail() {
		return credentials.getProperty(KEY_WebSecondUserEmail);
	}

	public String getSecondWebUserPassword() {
		return credentials.getProperty(KEY_WebPassword);
	}

	public String getSecondWebUserDisPlayName() {
		return credentials.getProperty(KEY_WebSecondUserDisplayName);
	}

	/*
	 * SignUp
	 */
	public String getNewOrgEmail(){
		return KEY_NewOrgAdminEmail;
	}
	
	public String getNewOrgAdminName(){
		return KEY_NewOrgAdminName;
	}
	public String getNewOrgName(){
		return KEY_NewOrgName;
	}
	public String getNewOrgUserName(){
		return KEY_NewOrgUserName;
	}
	public String getNewOrgUserEmail(){
		return KEY_NewOrgUserEmail;
	}
	
	
	public String getNewOrgNewUserCount() {
		return credentials.getProperty(KEY_NewOrgNewUserCount);
	}
	
	public String getGmailId(){
		return credentials.getProperty(KEY_GmailId);
	}
	
	public String getGmailPassword(){
		return credentials.getProperty(KEY_GmailPassword);
	}
	
	public String getGuestEmail(){
		return KEY_GuestEmailId;
	}
	

	public String getIosUserEamil() {
		return credentials.getProperty(KEY_IosUserEmail);
	}
	public String getIosUserPassword() {
		return credentials.getProperty(KEY_IosUserPassword);
	}
	
	public String getGuestMessage(){
		return properties.getProperty(KEY_MessageGuestFromWeb);
	}
	
	public String getandroidGyestMessage(){
		return properties.getProperty(KEY_MessageGuestFromAndroid);
	}
	
	public String getWebGuestDisplayName(){
		return properties.getProperty(KEY_WebGuestDispalyName);
	}
	
	public String getAndroidGuestDisplayName(){
		return properties.getProperty(KEY_AndroidGuestDisplayName);
	}
	public String getGuestUser(){
		return credentials.getProperty(KEY_GuestUser);
	}
	
	public String getGuestDisplayName(){
		return credentials.getProperty(KEY_GuestDisplayName);
	}
	
	public String getGuestLabel(){
		return properties.getProperty(KEY_GuestLabel);
	}
	
	
	public String getKeyQuickpollquestion() {
		return properties.getProperty(KEY_QuickPollQuestion);
	}

	public String getKeyQuickpollanswerone() {
		return properties.getProperty(KEY_QuickPollAnswerOne);
	}

	public String getKeyQuickpollanswertwo() {
		return properties.getProperty(KEY_QuickPollAnswerTwo);
	}

	public String getKeyQuickpollanswerthree() {
		return properties.getProperty(KEY_QuickPollAnswerThree);
	}

	public String getKeyQuickpollanswerfour() {
		return properties.getProperty(KEY_QuickPollAnswerFour);
	}
	public String getKeyMessageSentStatus(){
		return properties.getProperty(KEY_messageSentStatus);
	}
	
	/*
	 * Reset Password
	 */
	
	public String getNewPassword() {
		return properties.getProperty(KEY_NewPassword);
	}
	
	public String getConfirmPassword() {
		return properties.getProperty(KEY_ConfirmPassword);
	}
	
	/*
	 * Channel
	 */
	

	public String getChannelWeb(){
		return credentials.getProperty(KEY_ChannelForWeb);
	}
	public String getChannelAndroid()
	{
		return credentials.getProperty(Key_ChannelForAndroid);
	}
	public String getRestrictionMessage()
	{
		return properties.getProperty(Key_Message);
	}
	public String getMessageFromChannel()
	{
		return properties.getProperty(Key_ChannelMessageFromWeb);
		
	}
	public String getTextChannelPlaceholder()
	{
		return properties.getProperty(Key_ChannelPlaceholderText);
	}
	public String getMessageFromChannelAndroid()
	{
		return properties.getProperty(Key_ChannelMessageFromAndroid);
	}
	
	public String getMeetingTitle(){
		return properties.getProperty(KEY_MeetingTitle)+randomDate;
	}
	
	public String getMeetingDescription(){
		return properties.getProperty(KEY_MeetingDescription);
	}
	
	public String getMeetingLocation(){
		return properties.getProperty(KEY_MeetingLocation);
	}
	
	public String getMeetingTypeLive(){
		return properties.getProperty(KEY_MeetingTypeLIVE);
	}
	
	public String getMeetingTypeHDCall(){
		return properties.getProperty(KEY_MeetingTypeHDCall);
	}
	
	public String getMeetingTypeGroupCall(){
		return properties.getProperty(KEY_MeetingTypeGroupCall);
	}
	
	public String getMeetingTypeOthers(){
		return properties.getProperty(KEY_MeetingTypeOthers);
	}
	
	public String getCancelledMeetingText(){
		return properties.getProperty(KEY_MeetingCancelText);
	}
	
	public String getCanceledMeetingBadge(){
		return properties.getProperty(KEY_MeetingCancelBadge);
	}
	
	public String getCancelledMeetingBadge(){
		return properties.getProperty(KEY_MeetingCancelledBadge);
	}
	
	public String getDoneMeetingBadge(){
		return properties.getProperty(KEY_MeetingDoneBadge);
	}
	public String getStartedMeetingBadge(){
		return properties.getProperty(Key_MeetingStartedBadge);
	}
	
	public String getLiveMeetingBadge(){
		return properties.getProperty(KEY_MeetingLiveBadge);
	}
	
	public String getMeetingMOM(){
		return properties.getProperty(KEY_MeetingMOM);
	}
	
	public String getLocation() {
		return properties.getProperty(KEY_Location);
	}
	
	/*
	 * Box credentials
	 */
	
	public String getBoxEmail(){
		return credentials.getProperty(KEY_BOX_email);
	}
	
	public String getBoxPassword()
	{
		return credentials.getProperty(KEY_BOX_password);
	}
}
