@regression
Feature: checkBox

  @checkBox
  Scenario: verify checkboxes
    Given I am on the homepage of Tools QA
    When I click on the "Elements" from the main menu
    Then I click on the "Check Box" from the sub menu
    Then I click on the Toggle of "Home"
    Then I click on the Toggle of "Desktop,Documents,Downloads"
    Then I click on the checkbox for "Desktop,Downloads"
    Then I click on the Toggle of "WorkSpace"
    Then I click on the checkbox for "React,Angular"
    Then I verify the following message in the body of the Checkbox page
  """
  You have selected : desktop notes commands react angular downloads wordFile excelFile
  """



