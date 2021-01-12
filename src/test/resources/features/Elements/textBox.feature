@regression
Feature:textBox

  @textBox
  Scenario: Elements
    Given I am on the homepage of Tools QA
    When I click on the "Elements" from the main menu
    Then I click on the "Text Box" from the sub menu
    Then I fill "Full Name" with ""
    Then I fill "Email" with ""
    Then I fill "Current Address" with ""
    Then I fill "Permanent Address" with ""
    Then I "Submit" the form
