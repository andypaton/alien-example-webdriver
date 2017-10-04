package com.alien.examples.webdriver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.utils.webdriver.CucumberWebDriver;

@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
	
	@Bean(destroyMethod="quit")
	CucumberWebDriver webDriver() {
		CucumberWebDriver webdriver =  null;
		return webdriver;
	}
	
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}

}