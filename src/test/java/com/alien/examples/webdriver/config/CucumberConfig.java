package com.alien.examples.webdriver.config;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.OutputHelper;
<<<<<<< HEAD
import com.alien.examples.webdriver.helpers.PropertyHelper;
import com.alien.examples.webdriver.runtime.RuntimeState;
import com.alien.utils.webdriver.WebDriverFactory;
=======
import com.alien.examples.webdriver.runtime.RuntimeState;
>>>>>>> branch 'master' of https://github.com/andypaton/alien-example-webdriver.git


@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
<<<<<<< HEAD
	
	@Bean()
	WebDriver webdriver(){
		try {
			return WebDriverFactory.getWebDriver();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
			
=======
		
//	@Bean(destroyMethod="quit")
//	CucumberWebDriver webDriver() {
//		CucumberWebDriver webdriver =  null;
//		return webdriver;
//	}
	
//	@Bean(destroyMethod="quit")
//	WebDriverUtility webDriverUtility() {
//		WebDriverUtility webDriverUtility =  null;
//		return webDriverUtility;
//	}
	
>>>>>>> branch 'master' of https://github.com/andypaton/alien-example-webdriver.git
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}
	
	@Bean
	RuntimeState runtimeState() {
		return new RuntimeState();
	}
<<<<<<< HEAD
	
	@Bean
	PropertyHelper propertyHelper() {
		return new PropertyHelper();
	}
=======

>>>>>>> branch 'master' of https://github.com/andypaton/alien-example-webdriver.git
}