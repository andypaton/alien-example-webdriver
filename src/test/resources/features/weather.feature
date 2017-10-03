@weather
Feature: obtain weather reports

  As someone about to go on holiday
  I want to check the weather forcast
  So that I can pack the correct clothes
  
  
  Scenario: Register - happy path
    Given the weather home page is opened in "firefox"
    And the Profile button is clicked
    When the Sign Up link is selected
    Then the Create Profile page is displayed
    
    @wip
  Scenario Outline: Sign up to the the weather website
    Given the weather page is opened in "<browser>"
    When the weather home page has loaded
    Then the Profile link is displayed
    Examples:
    |browser|
    |Chrome|
    |Firefox|

  @wip
  Scenario: Sign up details displayed
    Given the weather page is opened in "Firefox"
    When the "Sign up" is selected from profile
    Then Sign up entry details are displayed
      
  @wip
  Scenario: Sign up details entered
    Given Sign up details entry for is displayed
    When valid Sign up details are entered
    Then login details are displayed
    
  @wip
  Scenario: User logs in to account - happy path
    Given valid login details
    When the user logs in to the weather site
    Then the account home page is displayed
    
  @wip
  Scenario: User logs in to account - unhappy path
    Given invalid login details
    When the user logs in to the weather site
    Then invalid login details is displayed    
