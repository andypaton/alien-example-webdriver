package com.alien.examples.webdriver.runtime;

import cucumber.api.Scenario;
<<<<<<< HEAD

public class RuntimeState {
	
	public Scenario scenario;
	
=======
import cucumber.api.java.Before;

public class RuntimeState {
	
	private Scenario scenario;
	
	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
	}

>>>>>>> branch 'master' of https://github.com/andypaton/alien-example-webdriver.git
}
