package com.alien.examples.webdriver.helpers;

import org.springframework.beans.factory.annotation.Value;

public class PropertyHelper {

    @Value("${screenshots}")
    private String screenshots;
    
    public boolean showScreenshots(){    	
        return Boolean.valueOf(screenshots);
    }
}
