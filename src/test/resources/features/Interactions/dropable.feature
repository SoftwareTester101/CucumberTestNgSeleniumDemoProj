Feature: Dropable

  @simpleDragDrop
  Scenario: drag me
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Droppable" from the sub menu
    Then I drag the "Drop me" to the "Dropped!"
    Then I click on the "Accept" link on the droppable page
#    Then I drag the "notAcceptable" to the "Dropped!"
    Then I pause "3" seconds
    Then I drag the "acceptable" to the "Dropped!"

#    Then I click on the "Prevent Propogation" link on the droppable page
#    Then I click on the "Revert Draggable" link on the droppable page
  @acceptDragDrop
  Scenario: acceptDragDrop
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Droppable" from the sub menu
    Then I click on the "Accept" link on the droppable page
#    Then I drag the "notAcceptable" to the "Dropped!"
    Then I pause "3" seconds
    Then I drag the "Acceptable" to the "Dropped!" on  the "Acccept" tab

  @revert
  Scenario: revert
    Given I am on the homepage of Tools QA
    When I click on the "Interactions" from the main menu
    Then I click on the "Droppable" from the sub menu
    Then I click on the "Revert Draggable" link on the droppable page
#    Then I drag the "notAcceptable" to the "Dropped!"
    Then I pause "3" seconds
#    Then I drag the "revertable" to the "Dropped!" on  the "Revert" tab
    Then I drag the "notRevertable" to the "Dropped!" on  the "Revert" tab



