@regression
Feature: radio Bttn

  @radioBttn
  Scenario: verify Radio Buttons
    Given I am on the homepage of Tools QA
    When I click on the "Elements" from the main menu
    Then I click on the "Radio Button" from the sub menu
    Then I verify the radio button "Yes, Impressive" is Enabled
    Then I click on the radio bttn "Impressive"
    Then I verify the radio button "No" is Disabled