package com.alien.examples.webdriver.config;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.CucumberReportHelper;
import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.helpers.PageObjectHelper;

@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
	
	@Bean(destroyMethod="quit")
	WebDriver webDriver() {
		
	    System.setProperty("webdriver.gecko.driver", "/Users/andypaton/GeckoDriver/geckodriver");
	    System.setProperty("webdriver.chrome.driver", "/Users/andypaton/eclipse-workspace/webdriver-example/src/test/resources/drivers/chrome/chromedriver");

	    WebDriver webdriver =  null;

		return webdriver;
	}
	
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}
	
	@Bean()
	PageObjectHelper pageObjectHelper() {
		return new PageObjectHelper();
	}
	
	@Bean()
	CucumberReportHelper cucumberReportHelper() {
		return new CucumberReportHelper();
	}

}