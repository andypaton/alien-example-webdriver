package com.alien.examples.webdriver.runtime;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
		
	// Threads for running in parallel
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    
    public static WebDriver getWebDriver() {
    	    return webDriver.get();
    }
	
}
