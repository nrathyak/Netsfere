package com.infinite.netsfere.automationtool.modules;

import java.util.HashMap;

/**
 * This class is responsible for creating the single objects for page classes
 * and return the page object (via getPage method) when required. By using this factory,
 * we can reduce creating more number of duplicate objects for page classes
 * */
public class PageFactory {

	private static PageFactory instance;

	public static PageFactory getInstance() {
		if (instance == null) {
			instance = new PageFactory();
		}
		return instance;
	}

	private HashMap<Class<?>, Object> pages;

	private PageFactory() {
		pages = new HashMap<Class<?>, Object>();
	}

	public BasePage getPage(Class<?> pageClass) {
		return (BasePage) getObject(pageClass);
	}
	
	public Object getObject(Class<?> className) {
		if (pages.get(className) == null) {
			try {
				pages.put(className, className.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return pages.get(className);
	}
}
