package com.infinite.netsfere.automationtool.modules.web.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public abstract class WebGenericListPage {
	
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	String username = Config.getInstance().getAndroidUserDisplayName();
	private static Logger log = LogManager.getLogger(WebGenericListPage.class.getName());

	
	abstract WebElement getFirstListItem();
	
	public WebGenericListPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		
		
	}
	
	
	/*
	 * Elements
	 */
	


	@FindBy(xpath="//input[@type='text']")
	public WebElement searchBox;


	
	@FindBy(xpath="//input[@type='text']//..//span[contains(text(),'close')]")
	public WebElement clearText;
	
	@FindBy(xpath="//div[contains(text(),'Cancel')]")
	public WebElement cancelSearch;
		
	/*
	 * Methods
	 */
	
	public void searchFor(String searchString) throws Exception {
		try {
				Utils.veryShortSleep();
				// Click on search icon
				searchBox.click();
				searchBox.clear();
				// Enter item name in search box
				searchBox.sendKeys(searchString);
				// Wait for sometime to refresh the list
				//TODO: Need to come up with a better wait solution, instead of blindly waiting 
				Utils.shortSleep();
		}catch(NoSuchElementException e) {
			
			log.error("SearchBox is not visible");
			throw new Exception("SearchBox is not visible");
		}
		
	}
	
	public void clickOnFirstListItem() throws Exception {
		try {
			getFirstListItem().click();
		} catch (NoSuchElementException e) {
			log.error("No items in the list");
			throw new Exception("No items in the list");
		}
	}
		
	public void searchForAndSelect(String itemName) throws Exception {
		searchFor(itemName);
		clickOnFirstListItem();
		clickOnCancelButton();
	}
	
	//Click on cancel button
	public void clickOnCancelButton() {
		cancelSearch.click();
	}
		
}
