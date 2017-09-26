@bbc
Feature: bbc home page
	
	As a follower of the BBC
	I want to navigate to their website
	So that I can receive all the latest news

  @wip
  Scenario: Load BBC home page
    Given URL "http://www.bbc.com/" is opened in "Chrome"
    When the BBC home page is loaded
    Then BBC Cookies policy is displayed

  Scenario: Sign in
    Given the BBC home page is opened in "Chrome"
    When the "Sign in" link is selected
    Then the "Sign in" page is displayed
    
  @wip  
  Scenario: News
    Given the BBC home page is opened in "Firefox"
    When the "News" link is selected
    Then the "News" page is displayed