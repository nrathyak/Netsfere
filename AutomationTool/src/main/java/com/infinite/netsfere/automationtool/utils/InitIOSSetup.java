package com.infinite.netsfere.automationtool.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.os.CommandLine;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("deprecation")
public class InitIOSSetup {
	
	private static Logger log = LogManager.getLogger(InitIOSSetup.class.getName());
	@Test
	public static void startAppiumServer() throws InterruptedException {

		DefaultExecutor executor = new DefaultExecutor();
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		try {
			log.info("Killing Existing Appium server");
			stopAppiumServer();
			Thread.sleep(3000);
			CommandLine command = new CommandLine("/usr/local/bin/node");
			command.addArgument("/usr/local/lib/node_modules/appium/build/lib/main.js", false);
			command.addArgument("--address", false);
			command.addArgument("127.0.0.1");
			command.addArgument("--port", false);
			command.addArgument("4723");
			command.addArgument("--no-reset", false);
			executor.setExitValue(1);
			executor.execute(command, resultHandler);
			Thread.sleep(50000);
			log.info("Appium Server starting");
			Thread.sleep(5000);
			log.info("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void stopAppiumServer() throws InterruptedException {
		File f = new File("resources/killAppium.sh");
		CommandLine stopAppiumCmd = new CommandLine(f.getAbsolutePath());
		DefaultExecutor executor = new DefaultExecutor();
		try {
			executor.execute(stopAppiumCmd);
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

}
