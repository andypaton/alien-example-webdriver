@bbc
Feature: bbc home page
	
	As a follower of the BBC
	I want to navigate to their website
	So that I can receive all the latest news


  Scenario: Register - happy path
    Given the BBC home page is opened in "firefox"
    And the "Sign in" link is selected
    And the "Register Now" link is selected
    When valid registration details are entered
    Then the "Confirmation" page is displayed
    
  @wip  
  Scenario: Register - invalid DOB entered
    Given the BBC home page is opened in "firefox"
    And the "Sign in" link is selected
    And the "Register Now" link is selected
    When invalid date of birth details are entered
    Then the associated error is displayed
    
  @wip  
  Scenario: Example of "DataTable" - Sign in
    Given the BBC home page is opened in "firefox"
    When the "Sign in" link is selected
    Then the following links are displayed:
      | link  |
      | News  |
      | Sport |
    
  @wip  
  Scenario Outline: Example of "Scenario Outline" - Open <page> page in <browser>
    Given the BBC home page is opened in "firefox"
    When the "<page>" link is selected
    Then the "<page>" page is displayed
    Examples:
      | browser | page  |
      | firefox | News  |
      | chrome  | Sport |