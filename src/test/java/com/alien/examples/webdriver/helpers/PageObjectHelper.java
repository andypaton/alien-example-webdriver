package com.alien.examples.webdriver.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

public class PageObjectHelper {
	
	public static final int ONE_SECOND = 1;
	public static final int FIVE_SECONDS = 5;
	public static final int TEN_SECONDS = 10;
	public static final int THIRTY_SECONDS = 30;
	public static final int SIXTY_SECONDS = 60;
	public static final String ELEMENT_IS_CLICKABLE = "elementIsClickable";
	public static final String ELEMENT_IS_VISIBLE = "elementIsVisible";
	

	public void waitUntilElementExists(WebDriver webdriver, final By by){
		
	    new FluentWait<WebDriver>(webdriver)
		  	.withTimeout(TEN_SECONDS,TimeUnit.SECONDS)
		  	.pollingEvery(FIVE_SECONDS,TimeUnit.SECONDS)
		  	.ignoring(NoSuchElementException.class)
		  	.until(new ExpectedCondition<Boolean>(){
		  			public Boolean apply(WebDriver wd){
		  				wd.findElement(by);
		  				return true;
		  			}
		  		});
	}
	
	public boolean isElementPresent(WebDriver webDriver, By by) {
		
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
        try {  
    	        waitUntilElementExists(webDriver, by);  
            return true;  
        }  
        catch(NoSuchElementException e) {
            return false;  
        }  
    }
}
