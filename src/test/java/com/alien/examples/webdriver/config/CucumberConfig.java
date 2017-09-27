package com.alien.examples.webdriver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.utils.webdriver.CucumberWebDriver;

@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
	
//	@Bean(destroyMethod="quit")
//	WebDriver webDriver() {
//		
//	    System.setProperty("webdriver.gecko.driver", "/Users/andypaton/GeckoDriver/geckodriver");
//	    System.setProperty("webdriver.chrome.driver", "/Users/andypaton/eclipse-workspace/webdriver-example/src/test/resources/drivers/chrome/chromedriver");
//
//	    WebDriver webdriver =  null;
//
//		return webdriver;
//	}
	
	@Bean(destroyMethod="quit")
	CucumberWebDriver webDriver() {
		CucumberWebDriver webdriver =  null;
		return webdriver;
	}
//	
//	@Bean()
//	WebDriverUtility webDriverUtility(){
//		return new WebDriverUtility();
//	}
	
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}

}