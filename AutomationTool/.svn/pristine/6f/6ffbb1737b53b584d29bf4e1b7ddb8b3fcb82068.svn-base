package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

import io.appium.java_client.android.AndroidElement;

public class WebCallLogsPage extends WebGenericListPage implements BasePage{

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebHdOneToOneCallElements hdCall=new WebHdOneToOneCallElements();
	private static Logger log = LogManager.getLogger(WebCallLogsPage.class.getName());
	
	public WebCallLogsPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		
	}
	
	@FindBy(xpath="//div[@class='mainDiv']//div[@class='table-view']//span[.='Declined Call']")
	public WebElement declinedCall;
	
	@FindBy(xpath="//button[@title='Make Call']")
	public WebElement makeCallButton;
	
	@FindBy(xpath="//span[contains(text(),'Select a contact to call.')]")
	public WebElement selectContactPage;
	
	@FindBy(xpath="//span[contains(text(),'Select a contact to call.')]//..//..//input[@type='text']")
	public WebElement callLogContactSearch;
	
	@FindBy(xpath="//span[@class='icon ion-android-more-vertical']")
	public WebElement moreOptions;
	
	@FindBy(xpath="//span[contains(text(),'Delete All')]")
	public WebElement deleteAllOption;
	
	@FindBy(xpath="//span[@class='icon ion-android-delete' and @title='Delete']")
	public WebElement deleteSelected;
	
	@FindBy(xpath="//div[contains(text(),'Delete selected call')]")
	public WebElement deletePopUp;
	
	@FindBy(xpath="//div[contains(text(),'Delete selected call')]//..//span[contains(text(),'Delete')]")
	public WebElement deleteConfirm;
	
	@FindBy(xpath="//div[contains(text(),'No Call History')]")
	public WebElement noCallHistory;
	
	@FindBy(xpath="//div[contains(text(),'No call logs to delete')]")
	public WebElement noCallLogs;
	
	@FindBy(xpath="//span[contains(text(),'OK')]")
	public WebElement okConfirm;
	
	@FindBy(xpath="//span[@class='fa fa-times-circle']")
	public WebElement closeButton;
	
	@FindBy(xpath="//span[text()='Missed']")
	public WebElement missedCallTab;
	
	@FindBy(xpath="//span[text()='Missed Call']")
	public WebElement missedCall;
	
	public void clickOnMakeCallButton() {
		makeCallButton.click();
	}
	
	public void selectContactFromCallLogsAndClick() throws InterruptedException {
		if(selectContactPage.isDisplayed()) {
			callLogContactSearch.sendKeys(Config.getInstance().getAndroidUserDisplayName());
			webio.ActionsSpaceAndBackspace();
			webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='scrollbox']//div[@displayname='"+Config.getInstance().getAndroidUserDisplayName()+"']")));
			driver.findElement(By.xpath("//div[@class='scrollbox']//div[@displayname='"+Config.getInstance().getAndroidUserDisplayName()+"']")).click();
			hdCall.waitUntilCallRings();
		}
	}
	
	public void clickOnMoreOptions() {
		moreOptions.click();
	}
	
	public void clickOnDeleteAllOption() {
		deleteAllOption.click();
	}
	
	
	public void checkIfCallLogsPresent() {
		try {
			if(noCallLogs.isDisplayed()) {
				log.info("No Call Logs to delete");
				okConfirm.click();
				}
			}catch(Exception e){
				log.error("Call Logs present");
			}
	}
	
	public void enterContactInMissedCallSearchTab(String contact) throws Exception {
		if(checkIfNoCallsHistoryPresent()!=true) {
			searchForAndSelect(contact);
			Utils.veryShortSleep();
		}
	}
	public void deleteMultipleCallLogs() throws InterruptedException {
		try {
			Utils.veryShortSleep();
			if(noCallLogs.isDisplayed()) {
				log.info("No Call Logs to delete");
				Utils.veryShortSleep();
				okConfirm.click();
				}
			}catch(Exception e) {
				log.error("Call Logs present");
				log.error("Delete multiple logs");
				
			List<WebElement> checkList = driver.findElements(By.xpath("//span[contains(text(),'check')]"));
			if(checkList.size()>3) {
			
					Thread.sleep(3000);
					checkList.get(0).click();
					checkList.get(1).click();	
					checkList.get(2).click();
					deleteSelected.click();
					if(deletePopUp.isDisplayed()) {
						deleteConfirm.click();
						}
			}else {
				checkList.get(0).click();
				closeButton.click();
			}
			
			}
		}

		
		
	
	
	public void deleteAllCallLogs() {
		try {
		if(noCallLogs.isDisplayed()) {
			log.info("No Call Logs to delete");
			okConfirm.click();
			}
		}catch(Exception e){
			
		deleteSelected.click();
		if(deletePopUp.isDisplayed()) {
			deleteConfirm.click();
			}
		}
	}
	
	public void clickOnFirstCallLogButton() {
		List<WebElement> callLogButtonList = driver.findElements(By.xpath("//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[2]/div[@class='table-view']/div//span[@class='icon ion-android-call']"));
		if(callLogButtonList.size()>=1) {
			callLogButtonList.get(0).click();
		}else {
			log.info("No existing call logs");
		}
	}
	
	public void clickOnMissedCallTab() {
		missedCallTab.click();
	}
	
	public boolean checkIfNoCallsHistoryPresent() {
		
		boolean result = false;
		try {
		if (noCallHistory.isDisplayed()) {
			result =  true;
		} 
		}catch(Exception e) {
			System.out.println(e);
			result =  false;
		}
		return result;
		
	}
	
	@Override
	WebElement getFirstListItem() {
		//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[2]//div[@class='table-view']/div
		WebElement conv = null;
		List<WebElement> conv_list = driver.findElements(By.xpath("//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[2]/div[@class='table-view']/div"));
		if(conv_list.size()>=1)
		{
			conv = conv_list.get(1);
			
		}
		return conv;
		
	}

	public boolean isAt() {
		try {
			
			return driver.getCurrentUrl().contains("https://web.netsferetest.com/#/calls");
			
		}catch(Exception e) {
			if(e instanceof org.openqa.selenium.NoSuchElementException) {
				log.info("Not In call logs page ");
			}
		}
		return false;
	}

	public void navigateTo() throws Exception {
		// TODO Auto-generated method stub
		//need to find an alternative if call is going on
		WebNavigationBar.getInstance().navigateToCallLogsPage();
	}
}




