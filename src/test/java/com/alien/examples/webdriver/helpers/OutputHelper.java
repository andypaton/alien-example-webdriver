package com.alien.examples.webdriver.helpers;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.examples.webdriver.config.CucumberConfig;
import com.alien.examples.webdriver.runtime.RuntimeState;
import com.alien.utils.report.CucumberReport.ReportBuilder;
import com.alien.utils.webdriver.WebDriverFactory;


@ContextConfiguration(classes=CucumberConfig.class)
public class OutputHelper {
	
	@Autowired 
    private RuntimeState runtimeState;
		
    public void showMessage(String header, String message) throws IOException {
        new ReportBuilder().createSection(header, message).build(runtimeState.scenario).write();
    }
    
    public void takeScreenshot() throws IOException {
        
    	runtimeState.scenario.write("\n");
        
        if (WebDriverFactory.webDriverExists()) {
            byte[] scrFile = ((TakesScreenshot) WebDriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            runtimeState.scenario.embed(scrFile, "image/jpeg");
        }    
    }
    
}
