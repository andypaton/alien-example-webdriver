@bbc
Feature: bbc home page
	
	As a follower of the BBC
	I want to navigate to their website
	So that I can receive all the latest news


  Scenario: Load BBC home page
    Given URL "http://www.bbc.com/" is opened in "Chrome"
    When the BBC home page is loaded
    Then BBC Cookies policy is displayed

