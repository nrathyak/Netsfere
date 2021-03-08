package com.infinite.netsfere.automationtool.modules.web.test;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	static String scrShotDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	private static Logger log = LogManager.getLogger(Screenshot.class.getName());
	public static String captureScreenShot(WebDriver driver, String screenshotName){
		
		
		try
			{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				String destination = "D:\\Netsfere_4.0.0\\AutomationToolUdated\\Screenshots\\"+screenshotName+scrShotDate+".png";
				File dest = new File(destination);
				FileUtils.copyFile(source, dest);
				log.info("Screenshot Taken");
				
				return destination;
				
			}
		catch(Exception e)
		{
			log.error("Exception while taking screeshot "+e.getMessage());
			
			return e.getMessage();
		}
		
	}

}
