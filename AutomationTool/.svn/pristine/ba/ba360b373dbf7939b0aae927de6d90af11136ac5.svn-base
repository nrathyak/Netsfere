package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebBroadcastLivePage implements BasePage {


	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	private static Logger log = LogManager.getLogger(WebBroadcastLivePage.class.getName());

	public WebBroadcastLivePage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();

	}
	
//	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[2]/span[@title='LIVE']")
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[1]//span[@title='LIVE']")
	public WebElement liveLabelOnBroadcastLive;

	@FindBy(xpath = "//img[@src='/images/live/stopBroadcastBtn@3x.png']")
	public WebElement endBroadcastLiveButton;
	
	public void clickOnEndBroadcastLiveButton() {
		endBroadcastLiveButton.click();

	}

	public boolean isAt() {
		try {
			return driver.getCurrentUrl().contains("stream");
		}catch(Exception e) {
			if(e instanceof NoSuchElementException)
			{
			log.info("Currently not in broadcast live page");
					
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// TODO Auto-generated method stub
		//broadcast is initiated either from conversation or channels.
	}
	
}

