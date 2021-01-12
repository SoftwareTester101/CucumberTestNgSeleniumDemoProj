Feature: sortable

  @sortable
  Scenario: sortable
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Sortable" from the sub menu
    Then I pause "5" seconds
    Then I replace the item "Six" with item "Two"
    Then I pause "5" seconds
    Then I replace the item "Four" with item "One"
    Then I pause "5" seconds
    Then I replace the item "Five" with item "Two"
    Then I pause "5" seconds
    Then I pause "5" seconds
    Then I capture a screenshot of the current page
    Then I verify the items in the sorted table as "Four,Six,One,Three,Five,Two"


  @selectable
  Scenario: selectable
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Selectable" from the sub menu
    Then I select the "Dapibus" from the list

  @ignore
  Scenario: Resizable
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Resizable" from the sub menu
    Then I resize the "Restricted" box width to "500" and height to "300"
    Then I click on the "Resizable" from the sub menu
    Then I resize the "Resizable" box width to "520" and height to "568"
    Then I capture a screenshot of the current page
