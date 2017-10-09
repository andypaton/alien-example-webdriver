package com.alien.examples.webdriver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.OutputHelper;


@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
	
	
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
	
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}

}