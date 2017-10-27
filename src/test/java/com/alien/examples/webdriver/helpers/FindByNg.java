package com.alien.examples.webdriver.helpers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FindByNg {
	
	  String rootSelector() default "";
	  String repeater() default "";
	  String binding() default "";
	  String exactBinding() default "";
	  String model() default "";
	  String options() default "";
	  String buttonText() default "";
	  String partialButtonText() default "";
	  
	  String cssSelector() default "";
	  String searchText() default "";

}
