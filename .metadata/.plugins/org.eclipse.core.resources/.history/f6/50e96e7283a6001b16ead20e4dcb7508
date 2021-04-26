package com.infinite.netsfere.automationtool.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class DriverManager {

	private static AndroidDriver<AndroidElement> androidDriver;
	private static IOSDriver<IOSElement> IosDriver;
	private static WebDriver webDriver;
	private static WebDriver secondWebDriver;
	private static WebDriver signUpDriver;
	private static Logger log = LogManager.getLogger(DriverManager.class.getName());

	public static AndroidDriver<AndroidElement> getAndroidDriver() {
		if (androidDriver != null) {
			return androidDriver;
		}

		File f = new File("resources");
		File app_path = new File(f, "NetSfere.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.11.1");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Config.getInstance().getAndroidDeviceName());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.getInstance().getAndroidVersion());

		//New code added
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constants.androidPackageName);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				Constants.androidPackageName + ".SplashActivity");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1800000");

		if (Config.getInstance().reInstallApp()) {
			capabilities.setCapability(MobileCapabilityType.APP, app_path.getAbsolutePath());
		} else {
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		}
		log.info("Connecting to Android device");

		try {
			androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return androidDriver;
	}

	public static IOSDriver<IOSElement> getIOSDriver() throws InterruptedException, IOException {

		if (IosDriver != null) {
			return IosDriver;
		}

		File f = new File("resources");
		File app_path = new File(f, "NetSfere.ipa");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.9.1");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Config.getInstance().getIosDevicename());
		cap.setCapability(MobileCapabilityType.UDID, Config.getInstance().getIosDeviceUDID());
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.getInstance().getIosVersion());

		cap.setCapability(MobileCapabilityType.APP, app_path.getAbsolutePath());

		if (Config.getInstance().reInstallApp()) {
			cap.setCapability(MobileCapabilityType.NO_RESET, false);
		} else {
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
		}
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
		try {
			IosDriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		IosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return IosDriver;

	}

	public static WebDriver getWebDriver() {
		if (webDriver != null) {
			return webDriver;
		}

		File f = new File("resources");
			
			if (Constants.browser.equals("firefox")) {
				File driverPath = new File(f, "geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath());			
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("dom.webnotifications.enabled", false);
				options.addPreference("geo.enabled", true);
				options.addArguments("--disable-infobars");
				options.addArguments("use-fake-ui-for-media-stream");
				options.addArguments("use-fake-device-for-media-stream");
				options.addArguments("start-maximized");
				options.addArguments("--disable-extensions");
				options.addPreference("permissions.default.microphone", 1);
				options.addPreference("permissions.default.camera", 1);
				webDriver = new FirefoxDriver(options);
			
		} else if (Constants.browser.equals("Chrome")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			File driverPath = new File(f, "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			options.setExperimentalOption("prefs", prefs);
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("use-fake-ui-for-media-stream");
			options.addArguments("use-fake-device-for-media-stream");
			options.addArguments("--enable-notifications");
			System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
			webDriver = new ChromeDriver(options);

		}
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		webDriver.get(Constants.url);
		//webDriver.get(Constants.beta_url);
		return webDriver;
	}
	
	public static WebDriver getSignUpWebDriver() {
//		if (signUpDriver != null) {
//			return signUpDriver;
//		}
//
//		File f = new File("resources");
//		if (Constants.browser.equals("firefox")) {
//			File driverPath = new File(f, "geckodriver.exe");
//			System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath());
//			signUpDriver = new FirefoxDriver();
//		} else if (Constants.browser.equals("Chrome")) {
//			File driverPath = new File(f, "chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_setting_values.notifications", 1);
//			options.setExperimentalOption("prefs", prefs);
//			options.addArguments("use-fake-ui-for-media-stream");
//			options.addArguments("--enable-notifications");
//			System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
//			signUpDriver = new ChromeDriver(options);
//
//		}
//		signUpDriver.manage().window().maximize();
//		signUpDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
//		signUpDriver.get(Constants.sign_up_url);
//		//webDriver.get(Constants.url);
		return signUpDriver;
	}

	public static WebDriver getSecondWebDriver() {
		if (secondWebDriver != null) {
			return secondWebDriver;
		}

		File f = new File("resources");
		if (Constants.browser1.equals("firefox")) {
			File driverPath = new File(f, "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath());
			secondWebDriver = new FirefoxDriver();

			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			ffprofile.setPreference("media.navigator.permission.disabled", true);
			(secondWebDriver).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			(secondWebDriver).manage().window().maximize();

		} else if (Constants.browser1.equals("Chrome")) {
			File driverPath = new File(f, "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("use-fake-ui-for-media-stream");
			options.addArguments("--enable-notifications");
			System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
			secondWebDriver = new ChromeDriver(options);

		}
		secondWebDriver.manage().window().maximize();
		secondWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		return secondWebDriver;
	}

}
