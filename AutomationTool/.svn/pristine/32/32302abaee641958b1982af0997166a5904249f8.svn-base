package com.infinite.netsfere.automationtool.utils;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;

import io.appium.java_client.android.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class AndroidBase {
	
	
	
	private static Logger log = LogManager.getLogger(AndroidBase.class.getName());
	public static void startAppiumServerNetsfere() throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		// start appium server
		try {
			log.info("Starting appium server...");
			String OS = System.getProperty("os.name").toLowerCase();
			 if( isMac(OS) ) {
				 String[] cmdScript = new String[]{"/bin/bash", "appium -a 127.0.0.1 -p 4723"}; 
				 runtime.exec(cmdScript);				 
			 } else {			
				runtime.exec("cmd.exe /c start cmd.exe /k \"adb devices ");
				Thread.sleep(10000);
				runtime.exec("taskkill /F /IM cmd.exe /T");
				Thread.sleep(5000);
				runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 ");
				Thread.sleep(10000);
				Thread.sleep(10000);
			 }			
			
			String line;
			String pidInfo ="";
			do {
				log.info("Waiting for appium server to start.....");
				Thread.sleep(3000);
				Process p ;
				String process_cmd = "ps -eo  pid,args | grep appium | grep -v grep";				
				 if( isMac(OS) ) {
					 p = Runtime.getRuntime().exec(process_cmd);
					 Thread.sleep(1000);
				 } else {	
					p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
				 }
				BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					pidInfo+=line; 
				}
				input.close();

				if(pidInfo.contains("node.exe"))
				{
					log.info("appium server started.....");
				} 
				
			}while(!(pidInfo.contains("node.exe")));
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		
	}
	
	public static void stopAppiumServerNetsfere() throws InterruptedException {
		Runtime runtime = Runtime.getRuntime();	
		try {
			log.info("Killing the appium process");
			String OS = System.getProperty("os.name").toLowerCase();
			if( isMac(OS) ) {
				runtime.exec("pkill appium");				 
				 Thread.sleep(1000);
			 } else {	
				 runtime.exec("taskkill /F /IM node.exe /T");
				// kill the cmd windows
				log.info("Killing the cmd windows opened");
				runtime.exec("taskkill /F /IM cmd.exe /T");
				Thread.sleep(2000);
			 }			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static AndroidDriver<AndroidElement> initializeAndroidDriverNetsfere() throws InterruptedException, IOException {
		
		File f = new File("src/main/java");
		File app_path = new File(f,"NetSfere.apk");
		
		Properties prop = new Properties();
		String project_Dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(project_Dir+"\\Properties_File");
		prop.load(fis);
		
		DesiredCapabilities capabilities = new DesiredCapabilities() ;
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");		

		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("device_name"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,prop.getProperty("device_android_version"));
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.infinite.netsfere");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.infinite.netsfere.SplashActivity");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1800000");
		
		//capabilities.setCapability(MobileCapabilityType.APP , app_path.getAbsolutePath());
		
		capabilities.setCapability(MobileCapabilityType.NO_RESET , true);
		log.info("Connecting to Android device & Installing the App");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub") ,capabilities); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		return driver ;		
	}
	
	public static void stopAndroidInstanceandKill(){
		 //Check if any appium session running & kill it. 
		Runtime runtime = Runtime.getRuntime();
		
		DesiredCapabilities capabilities = new DesiredCapabilities() ;
		capabilities.setCapability("unicodeKeyboard", false);
		capabilities.setCapability("resetKeyboard", false);
		try {
			log.info("Killing the exisiting chrome browsers...");
			runtime.exec("taskkill /F /IM chromedriver.exe /T");
			log.info("Killing the exisiting appium sessions...");
			runtime.exec("taskkill /F /IM node.exe /T");
			Thread.sleep(2000);
			runtime.exec("taskkill /F /IM adb.exe /T");
			Thread.sleep(2000);
			runtime.exec("taskkill /F /IM cmd.exe /T");
			Thread.sleep(2000);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static boolean isMac(String OS) {

		return (OS.indexOf("mac") >= 0);

	}
	

}
