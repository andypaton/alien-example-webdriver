package com.alien.examples.webdriver.config;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.runtime.RuntimeState;
import com.alien.utils.webdriver.WebDriverFactory;


@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
	
	@Bean()
	WebDriver webdriver(){
		return WebDriverFactory.getWebDriver();
	}
			
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}
	
	@Bean
	RuntimeState runtimeState() {
		return new RuntimeState();
	}

}