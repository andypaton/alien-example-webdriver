package com.alien.examples.webdriver.runtime;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class RuntimeState {
	
	private Scenario scenario;
	
	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
	}

}
