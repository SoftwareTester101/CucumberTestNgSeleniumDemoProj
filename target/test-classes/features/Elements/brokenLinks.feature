@brokenLinks
Feature: Broken Links

  Scenario: verify links
    Given I am on the homepage of Tools QA
    When I click on the "Elements" from the main menu
    Then I click on the "Broken Links - Images" from the sub menu
    Then I click on the valid link
    Then I return to the default page
    Then I click on the broken link
    Then I capture a screenshot of the current page