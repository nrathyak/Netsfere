package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.infinite.netsfere.automationtool.utils.Constants;
import com.infinite.netsfere.automationtool.utils.DriverManager;

public class BaseWebSuite {

	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		DriverManager.getWebDriver().get(Constants.url);
	}

	@AfterClass
	public void stopTest() {
		DriverManager.getWebDriver().quit();
	}
	
}