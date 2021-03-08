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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.utils.Config;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import com.infinite.netsfere.automationtool.utils.WebIoOperations;

public class WebContactsPage extends WebGenericListPage implements BasePage{

	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebHdOneToOneCallElements hdCall=new WebHdOneToOneCallElements();
	String username = Config.getInstance().getAndroidUserDisplayName();
	private static Logger log = LogManager.getLogger(WebContactsPage.class.getName());
	public WebContactsPage() {
		
		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		
	}
	
	@FindBy(xpath="//div[@class='click-ripple']//..//span[@class='icon ion-android-call']")
	public WebElement firstContactCall;
	
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[1]/div/div[@class='table-view']/div[2]")
	public WebElement firstContact;
		/*
	 * Guest
	 */
//	@FindBy(xpath="//div[@isguestuser='true']/div/div/svg/g/text")
	@FindBy(xpath="//div[@isguestuser='true']/div/div/div/..//*[name()='svg']//*[name()='text']")
	public WebElement guestBadge;
	
	public void callFromContact() {
		
		firstContactCall.click();
		hdCall.waitUntilCallRings();
	}

	@Override
	WebElement getFirstListItem() {
		WebElement cont = null;
		List<WebElement> contList = driver.findElements(By.xpath("//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[1]/div/div[@class='table-view']/div/div"));
		if(contList.size()>=1)
		{
			cont = contList.get(0);
			
		}
		return cont;
	}

	public boolean isAt() {
		try {
			return driver.getCurrentUrl().contains("https://web.netsferetest.com/#/contacts");
		
	}catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in Contacts page");
			}
	}
	return false;
	}

	public void navigateTo() throws Exception {
		WebNavigationBar.getInstance().navigateToContactsage();
		
	}
}
