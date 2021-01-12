@regression
Feature: windows

  @windows
  Scenario: verify windows
    Given I am on the homepage of Tools QA
    When I click on the "Alerts, Frame & Windows" from the main menu
    Then I click on the "Browser Windows" from the sub menu
    Then I click on the "New Tab" button on the Browser Windows page
    Then I click on the "New Window" button on the Browser Windows page
    Then I click on the "Message" button on the Browser Windows page

