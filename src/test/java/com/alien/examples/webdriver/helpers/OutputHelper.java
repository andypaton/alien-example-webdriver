package com.alien.examples.webdriver.helpers;

import java.io.IOException;

import com.alien.utils.report.CucumberReport.ReportBuilder;

import cucumber.api.Scenario;


public class OutputHelper {

    public void showMessage(Scenario scenario, String header, String message) throws IOException {
        new ReportBuilder().createSection(header, message).build(scenario).write();
    }
    
}
