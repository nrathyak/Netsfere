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

public class WebChannelsPage extends WebGenericListPage implements BasePage {
	WebDriver driver;
	WebDriverWait webwait;
	WebIoOperations webio;
	WebConversationsPage webconv;
	WebChatPage webChatPage;
	String channelNameForWeb = Config.getInstance().getChannelWeb();
	String channelNameForAndroid = Config.getInstance().getChannelAndroid();
	private static Logger log = LogManager.getLogger(WebChannelsPage.class.getName());


	public WebChannelsPage() {

		this.driver = DriverManager.getWebDriver();
		PageFactory.initElements(driver, this);
		webwait = Utils.getLongWait(driver);
		webio = new WebIoOperations();
		webconv = new WebConversationsPage();
		webChatPage = new WebChatPage();
	}
	// channel Icon on web

	@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div[2]")
	public WebElement firstChannel;

	//@FindBy(xpath = "//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[2]/span[2]")
	
	
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[1]/span")
	public WebElement channelTitle;
	
	@FindBy(xpath = "//div[@class='mainDiv']//div[@class='table-view']//span[@title='Sent']")
	public WebElement messageStatusSent;
	
	
	//*******
	@FindBy(xpath="//div[@class='mainDiv']//div[1]//div[@class='scrollbox']/div[@class='table-view']/div[2]/div/div[3]/div[3]/div[1]")
    public WebElement recentChannel;
	
	@FindBy(xpath="//div[@class='mainDiv']/div[1]/div[3]/div[1]/div[2]/div/div[1]/span/../div/div[1]/../button[1]/div[2]//*[name()='svg']")
	public WebElement moreOptions;
	

	public void clickOnMoreOptions() {
		moreOptions.click();
	}

	@Override
	WebElement getFirstListItem() {
		WebElement conv = null;
		List<WebElement> conv_list = driver.findElements(By.xpath(
				"//div[@class='mainDiv']/div[1]/div[3]//div[@class='scrollbox']/div[@class='table-view']/div/div"));
		if (conv_list.size() >= 1) {
			conv = conv_list.get(0);

		}
		return conv;
	}




	public boolean isAt() {
		try {
			return driver.getCurrentUrl().contains("https://web.netsferetest.com/#/channels");
		
	}catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				log.info("Currently not in Channels page");
			}
	}
	return false;
	}



	public void navigateTo() throws Exception {
		WebNavigationBar.getInstance().navigateToChannelsPage();
		
	}

	
	public String messageSentStatusAssertion(){
		List<WebElement> placeholder_list=driver.findElements(By.xpath("//div[@class='mainDiv']//div[@class='table-view']//span[@class='fa fa-check']"));
		int lastElement=placeholder_list.size()-1;
		String s1=placeholder_list.get(lastElement).getAttribute("title");
		return s1;
			
	}

}
