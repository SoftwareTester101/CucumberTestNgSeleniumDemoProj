@regression
Feature: Modal

  @modal
  Scenario: modal
    Given I am on the homepage of Tools QA
    When I click on the "Alerts, Frame & Windows" from the main menu
    Then I click on the "Modal Dialogs" from the sub menu
    Then I click on the "showSmallModal" button on the Modal diaglog
    Then I close the "closeSmallModal" modal