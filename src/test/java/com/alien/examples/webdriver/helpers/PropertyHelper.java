package com.alien.examples.webdriver.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.alien.examples.webdriver.steps.WebSuiteClassRule;

public class PropertyHelper {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSuiteClassRule.class);


    @Value("${screenshots}")
    private String screenshots;
    
    public boolean showScreenshots(){    
    	
    		LOGGER.debug("Show ALL screenshots set to : " + screenshots);
        return Boolean.valueOf(screenshots);
    }
}
