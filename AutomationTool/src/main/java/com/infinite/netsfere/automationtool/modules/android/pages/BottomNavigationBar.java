package com.infinite.netsfere.automationtool.modules.android.pages;

 

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

 

import com.infinite.netsfere.automationtool.utils.DriverManager;

import com.infinite.netsfere.automationtool.utils.Utils;

 

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

 

public class BottomNavigationBar {

 

                //private static final String ID_BOTTOM_NAV_BAR = "bottom_navigation_small_container";

                private static BottomNavigationBar instance = null;

                AndroidDriver<AndroidElement> driver;

                WebDriverWait mediumWait;

 

                public static BottomNavigationBar getInstance() {

                                if (instance == null) {

                                                instance = new BottomNavigationBar();

                                }

                                return instance;

                }

               

                public BottomNavigationBar() {

                                driver = DriverManager.getAndroidDriver();

                                mediumWait = Utils.getMediumWait(driver);

                                PageFactory.initElements(new AppiumFieldDecorator(driver), this);

                }

 

                @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_meetings' and @index='4']")

                public WebElement meetingIcon;

 

                @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_channels' and @index='3']")

                public WebElement channelIcon;
                
                
               

 

                @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_contacts'  and @index='2']")

                public WebElement contactIcon;

               

                @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_calls' and @index='1']")

                public WebElement callLogIcon;

 

                @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.infinite.netsfere:id/nav_conversations' and @index='0']")

                public WebElement conversationIcon;

 

                public void navigateToConversationsPage() throws Exception {

                                try {

                                                conversationIcon.click();

                                } catch (Exception e) {

                                                throw new Exception("Bottom navigation bar/Conversation icon is not visible");

                                }

                }

 

                public void navigateToChannelsPage() throws Exception {

                                try {

                                                channelIcon.click();

                                } catch (Exception e) {

                                                throw new Exception("Bottom navigation bar/Channels icon is not visible");

                                }

                }

 

                public void navigateToContactsPage() throws Exception {

                                try {

                                                contactIcon.click();

                                } catch (Exception e) {

                                                throw new Exception("Bottom navigation bar/Contact icon is not visible");

                                }

                }

 

                public void navigateToCallLogsPage() throws Exception {

                                try {

                                                callLogIcon.click();

                                } catch (Exception e) {

                                                throw new Exception("Bottom navigation bar/Call Logs icon is not visible");

                                }

                }

 

                public void navigateToMeetingsPage() throws Exception {

                                try {

                                                meetingIcon.click();

                                } catch (Exception e) {

                                                throw new Exception("Bottom navigation bar/Meetings icon is not visible");

                                }

                }

 

}

