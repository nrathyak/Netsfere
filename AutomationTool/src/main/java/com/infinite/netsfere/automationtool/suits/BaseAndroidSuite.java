package com.infinite.netsfere.automationtool.suits;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.infinite.netsfere.automationtool.modules.BaseTestCases;
import com.infinite.netsfere.automationtool.utils.WindowsAppiumSetup;

public class BaseAndroidSuite extends BaseTestCases {

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException, InterruptedException {
		WindowsAppiumSetup.startAppiumServerNetsfere();
	}

	@AfterClass(alwaysRun = true)
	public void stopTest() {
		WindowsAppiumSetup.stopAppiumServerNetsfere();
	}
	
}