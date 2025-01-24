@Damiani @Home @Damiani_Home
Feature: XYPOS - Home_Damiani

  Background:
    Given I access the XY login page
    When I enter the Username for "damiani"
    And I click on Continue button
    And I enter the Password
    Then I click on Continue button

  @sanity
  Scenario: Validate successful login and verify homepage
    Then verify I am present in homepage