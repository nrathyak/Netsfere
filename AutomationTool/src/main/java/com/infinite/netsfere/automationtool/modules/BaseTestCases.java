package com.infinite.netsfere.automationtool.modules;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.infinite.netsfere.automationtool.annotations.NavigateTo;
import com.infinite.netsfere.automationtool.annotations.SingleInstance;

/**
 * This is the base class for all classes having test cases (@Test methods).
 * It's mandatory for any class having @Test methods to extend this class
 * */
public class BaseTestCases {

	//createPageObjectsMarkedAsSingleInstance
	public BaseTestCases() {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(SingleInstance.class)) {
				try {					
					field.set(this, PageFactory.getInstance().getObject(field.getType()));
				} catch (Exception e) {					
					e.printStackTrace();
					System.out.println("Failed to initialize field : "+field.getName()+" in "+getClass().getName());
				}
			}
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void makeSureWeAreInCorrectPageBeforeExecutingTestCase(Method testCase) {
		if (testCase == null) {
			return;
		}
		NavigateTo goTo = testCase.getAnnotation(NavigateTo.class);
		if (goTo == null) {
			return;
		}
		Class<?> page = goTo.value();
		try {
			BasePage pageObject = PageFactory.getInstance().getPage(page);
			if (!pageObject.isAt()) {
				pageObject.navigateTo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
