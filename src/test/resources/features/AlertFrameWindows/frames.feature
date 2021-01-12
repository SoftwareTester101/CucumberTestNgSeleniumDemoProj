@regression
  Feature: Frames
    @frame
    Scenario: frames
      Given I am on the homepage of Tools QA
      When I click on the "Alerts, Frame & Windows" from the main menu
      Then I click on the "Frames" from the sub menu
      Then I get the value from the 1 frame
      Then I get the value from the 2 frame
      Then I scroll the side bar on the second frame

    @nestedFrames
    Scenario: nested frames
      Given I am on the homepage of Tools QA
      When I click on the "Alerts, Frame & Windows" from the main menu
      Then I click on the "Nested Frames" from the sub menu
      Then I get the value from the parent frame
      Then I get the value from the child frame
