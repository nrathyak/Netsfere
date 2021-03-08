package com.infinite.netsfere.automationtool.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.infinite.netsfere.automationtool.modules.BasePage;
import com.infinite.netsfere.automationtool.modules.PageFactory;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NavigateTo {
	Class<?> value();
}
