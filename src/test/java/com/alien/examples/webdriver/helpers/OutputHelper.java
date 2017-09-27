package com.alien.examples.webdriver.helpers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alien.utils.report.CucumberReport.ReportBuilder;

import cucumber.runtime.ScenarioImpl;


@ContextConfiguration(classes={cucumber.runtime.ScenarioImpl.class})
public class OutputHelper {
	
	@Autowired ScenarioImpl scenario;

    public void showMessage(String header, String message) throws IOException {
        new ReportBuilder().createSection(header, message).build(scenario).write();
    }
    
}
