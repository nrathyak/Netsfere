package com.infinite.netsfere.automationtool.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.web.test.WebChannelTestcases;

public class WindowsAppiumSetup {
	
	private static Logger log = LogManager.getLogger(WindowsAppiumSetup.class.getName());

	@Test
	public static void startAppiumServerNetsfere() throws InterruptedException {

		Runtime runtime = Runtime.getRuntime();

		// start appium server
		try {
			log.info("Starting appium server...");
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 ");
			Thread.sleep(10000);

			String line;
			String pidInfo = "";
			do {
				log.info("Waiting for appium server to start.....");
				Thread.sleep(3000);
				Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					pidInfo += line;
				}
				input.close();

				if (pidInfo.contains("node.exe")) {
					log.info("appium server started.....");
				}

			} while (!(pidInfo.contains("node.exe")));

		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(3000);
	}
	
	@Test
	public static void stopAppiumServerNetsfere() {
		// Check if any appium session running & kill it.
		Runtime runtime = Runtime.getRuntime();
		try {
			log.info("Killing the exisiting appium sessions...");
			runtime.exec("taskkill /F /IM node.exe /T");
			Thread.sleep(2000);
			runtime.exec("taskkill /F /IM adb.exe /T");
			Thread.sleep(2000);
			runtime.exec("taskkill /F /IM cmd.exe /T");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
