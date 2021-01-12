@regression
Feature: Alert
  @alert
  Scenario: verify alerts
    Given I am on the homepage of Tools QA
    When I click on the "Alerts, Frame & Windows" from the main menu
    Then I click on the "Alerts" from the sub menu
    Then I pause "2" seconds
    Then I click on the "Alert Bttn" button on the Alerts page
    Then I confirm the alert
    Then I click on the "Timer Alert" button on the Alerts page
    Then I pause "5" seconds
    Then I verify the "This alert appeared after 5 seconds" on the alert
    Then I confirm the alert
    Then I click on the "Confirm Alert" button on the Alerts page
    Then I confirm the alert
    Then I click on the "Promt Alert" button on the Alerts page
    Then I input "ABV" in the textbox on the alert
    Then I cancel the alert