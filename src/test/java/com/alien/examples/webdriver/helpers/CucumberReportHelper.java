package com.alien.examples.webdriver.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;

public class CucumberReportHelper {
	
    private static final int IS_20 = 20;
    private static final int IS_500 = 500;
    private static final String IMAGE_PNG = "image/png";

    private WebDriverException cause;

    
    public void takeScreenShot(WebDriver webdriver, Scenario scenario, String linkText) {

        int count = 0;
        
        while (!snap(webdriver, scenario, linkText)) {

            count++;
            if (count > IS_20) {
            	
            	   System.err.println("Could not take screenshot: " + this.cause);

                break;
            }

            try {
                Thread.sleep(IS_500);
            } catch (InterruptedException e) {
                System.err.println("Waiting for page to load before attempting another screenshot.");
            }

        }

    }

    private boolean snap(WebDriver webdriver, Scenario scenario, String linkText) {

        boolean isScreenShotTaken = false;

        try {

            TakesScreenshot screenshotDriver = (TakesScreenshot) webdriver;

            final byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, IMAGE_PNG);
            isScreenShotTaken = true;

        } catch (WebDriverException cause) {

        	this.cause = cause;

        }

        return isScreenShotTaken;

    }

}
