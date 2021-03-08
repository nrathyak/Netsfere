package com.infinite.netsfere.automationtool.modules.android.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infinite.netsfere.automationtool.suits.EndToENdSanity;
import com.infinite.netsfere.automationtool.utils.AndroidIoOperations;
import com.infinite.netsfere.automationtool.utils.DriverManager;
import com.infinite.netsfere.automationtool.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class GenericListPage {

                // The child class is responsible to tell about the first list item (WebElement)
                abstract WebElement getFirstListItem();
                abstract WebElement getFirstCreatedConvListItem();
                
                private static final String ID_SEARCH_ICON = "action_search";
                private static final String ID_SEARCH_BOX = "search_src_text";
                private static final String ID_SEARCH_CLOSE_BUTTON = "search_close_btn";
                private static final String ID_PAGE_TITLE = "action_bar_title";

                private static Logger log = LogManager.getLogger(GenericListPage.class.getName());

                AndroidDriver<AndroidElement> driver;
                WebDriverWait mediumWait;
                
                
                public GenericListPage() {
                                driver = DriverManager.getAndroidDriver();
                                mediumWait = Utils.getMediumWait(driver);
                                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
                }

                @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/" + ID_SEARCH_ICON + "']")
                public WebElement searchIcon;

                @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.infinite.netsfere:id/" + ID_SEARCH_BOX
                                                + "' and @index='0']")
                public WebElement searchBox;

                @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.infinite.netsfere:id/" + ID_SEARCH_CLOSE_BUTTON
                                                + "' and @index='1']")
                public static WebElement searchCloseButton;
                
                @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.infinite.netsfere:id/" + ID_PAGE_TITLE + "']")
                public WebElement pageTitle;
                
                
               @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Collapse']")
               public static WebElement backButton;
                
                
                

                public void searchFor(String searchString) throws Exception {
                                Utils.navigateToHomeScreen(driver);                     
                                // Click on search icon
                                try {
                                                                searchIcon.click();
                                } catch (NoSuchElementException e) {
                                                log.error("Search icon is not visible, assuming that search box is already expanded.");
                                }
                                // Enter item name in search box
                                try {
                                                searchBox.clear();
                                                searchBox.sendKeys(searchString);
                                } catch(NoSuchElementException e) {
                                                throw new Exception("Search text box is not visible");
                                }
                                // Wait for sometime to refresh the list
                                //TODO: Need to come up with a better wait solution, instead of blindly waiting 
                                Utils.shortSleep();
                }

                public void clickOnFirstListItem() throws Exception {
                                try {
                                               getFirstListItem().click();
                                } catch (NoSuchElementException e) {
                                                throw new Exception("No items in the list");
                                }
                }

                public void longPressonFirstListItem() throws Exception {
                                try {
//                                            AndroidIoOperations.longPressElement(getFirstListItem());
                                                Utils.longPressElement(getFirstListItem());
                                } catch (NoSuchElementException e) {
                                                throw new Exception("No items in the list");
                                }
                }
                
//            public void longPressonFirstCreatedConvItem() throws Exception {
//                            try {
////                                        AndroidIoOperations.longPressElement(getFirstListItem());
//                                            Utils.longPressElement(getFirstCreatedConvListItem());
//                            } catch (NoSuchElementException e) {
//                                            throw new Exception("No items in the list");
//                            }
//            }

                public void searchForAndSelect(String itemName) throws Exception {
                                searchFor(itemName); 
                                clickOnFirstListItem();
                }
                
                public String getPageTitle() {                       
                                return pageTitle.getText();                          
                }

                public static void clickOnCloseAndBackButton() {
                	searchCloseButton.click();
                	backButton.click();
                }
                
                public static void clickTabOnBackButton() {
                	backButton.click();
                }
                
}
