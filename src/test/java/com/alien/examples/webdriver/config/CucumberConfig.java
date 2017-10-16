package com.alien.examples.webdriver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alien.examples.webdriver.helpers.OutputHelper;
import com.alien.examples.webdriver.helpers.PropertyHelper;
import com.alien.examples.webdriver.runtime.RuntimeState;


@Configuration
@ComponentScan(basePackages={"com.alien.examples.webdriver"})
public class CucumberConfig {
			
	@Bean()
	OutputHelper outputHelper() {
		return new OutputHelper();
	}
	
	@Bean
	RuntimeState runtimeState() {
		return new RuntimeState();
	}
	
	@Bean
	PropertyHelper propertyHelper() {
		return new PropertyHelper();
	}

}