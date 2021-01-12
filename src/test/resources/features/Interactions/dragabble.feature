Feature: Draggable

  @drag
  Scenario: drag
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Dragabble" from the sub menu
    Then I drag the "dragBox" on the "Simple" tab
    Then I click on the "Axis Restricted" link on the droppable page
    Then I drag the "dragX" on the "Axis" tab
    Then I drag the "dragY" on the "Axis Restricted" tab
    Then I click on the "Container Restricted" link on the droppable page
    Then I drag the "containedBox" on the "Container" tab
    Then I drag the "containedBox2" on the "Container2" tab
