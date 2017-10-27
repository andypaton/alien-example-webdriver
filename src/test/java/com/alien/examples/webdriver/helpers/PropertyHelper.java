package com.alien.examples.webdriver.helpers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.alien.examples.webdriver.steps.WebSuiteClassRule;

public class PropertyHelper {
	
    private static final Logger LOGGER = Logger.getLogger(PropertyHelper.class.getName());


    @Value("${screenshots}")
    private String screenshots;
    
    public boolean showScreenshots(){    
    	
    		LOGGER.debug("Show ALL screenshots set to : " + screenshots);
        return Boolean.valueOf(screenshots);
    }
}
