@dynamicProperties
Feature: Dynamic Properties

  Scenario: verify dynamic properties
    Given I am on the homepage of Tools QA
    When I click on the "Elements" from the main menu
    Then I click on the "Dynamic Properties" from the sub menu
    Then I pause "5" seconds
    Then I should see "Visible After 5 Seconds" button 
    Then I should see the "Color Change" button text in red