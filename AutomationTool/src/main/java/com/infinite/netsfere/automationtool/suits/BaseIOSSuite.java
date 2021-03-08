package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.infinite.netsfere.automationtool.utils.InitIOSSetup;

public class BaseIOSSuite {

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException, InterruptedException {
		InitIOSSetup.startAppiumServer();
	}

	@AfterClass(alwaysRun = true)
	public void stopTest() throws InterruptedException {
		InitIOSSetup.stopAppiumServer();
	}

}
