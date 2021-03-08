package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infinite.netsfere.automationtool.modules.web.test.SignUpTestCase;
import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;

public class SetUpOrg {
	
	SignUpTestCase signup;
	WebDriver driver;
	
	
	@BeforeClass
	public void LoadProperties()  throws IOException, InterruptedException{
		
		signup = new SignUpTestCase();
		signup.init();
		DriverManager.getWebDriver().get(Constants.sign_up_url);
		driver = DriverManager.getWebDriver();
	}
	
	@Test
	public void newOrgSetUpActivateAdmin() throws InterruptedException{
		signup.signUpOrg();
		signup.activateAdminOrg();
		
	}
	
	@AfterTest
	public void reportSending(){
		driver.quit();
	}

}
