@GoldenGoose @Home @GoldenGoose_Home
Feature: XYPOS - Home_GoldenGoose

  Background:
    Given I access the XY login page
    When I enter the Username for "goldengoose"
    And I click on Continue button
    And I enter the Password
    Then I click on Continue button

  @sanity
  Scenario: Validate successful login and verify homepage
    Then verify I am present in homepage