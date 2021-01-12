@select
Feature: Widgets

  @accordian @ignore
  Scenario: drag
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Accordian" from the sub menu
    Then I click on the "What is Lorem Ipsum?" option
    Then I click on the "Where does it come from?" option
    Then I click on the "Why do we use it?" option
    Then I close the "Why do we use it?" option
    Then I close the "What is Lorem Ipsum?" option
    Then I close the "Where does it come from?" option

  @range  @ignore
  Scenario: range
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Slider" from the sub menu
    Then I slide to "-50"
    Then I slide to "260"

  @progress
  Scenario: progress
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Progress Bar" from the sub menu
    Then I click on the "Start" button on the widgets page

  @tooltips @ignore
  Scenario: Tool Tips
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Tool Tips" from the sub menu
    Then I hover over "Hover me to see" button on the widgets page
    Then I hover over "Hover me to see" textbox on the widgets page
    Then I hover over "Contrary" link on the widgets page

  @menu
  Scenario: menu
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Menu" from the sub menu
    Then I hover over "Main Item 2" main on the menu page
    Then I hover over "SUB SUB LIST »" submenu on the menu page
    Then I hover over "Sub Sub Item 2" subsubmeu on the menu page
    Then I hover over "Main Item 1" main on the menu page
    Then I hover over "Main Item 3" main on the menu page

  @selectMenu
  Scenario: Select Menu
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Select Menu" from the sub menu
    Then I click on the "Select Option" dropdown on the Select Menu page
    Then I select "Group 1, Option 1" under the Select Value
#    Then I refresh the page
    Then I pause "3" seconds
    Then I select "Group 2, Option 2" under the Select Value
#    Then I refresh the page
    Then I pause "3" seconds
    Then I select "Another root option" under the Select Value
    Then I click on the "Select Title" dropdown on the Select Menu page
    Then I select "Prof." from the Select Title dropdown

  @oldSelect
  Scenario: Select Menu 2
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Select Menu" from the sub menu
    Then I click on the "Old Select Menu" dropdown on the Select Menu page

  @multiSelect
  Scenario: multi Select
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Select Menu" from the sub menu
    Then I click on the "Multi Select Menu" dropdown on the Select Menu page
    Then I select "Blue,Red" from the Select Title dropdown
    Then I click on the "Multiselect drop down" label

  @standardSelect
  Scenario: standard Select
    Given I am on the homepage of Tools QA
    When I click on the "Widgets" from the main menu
    Then I click on the "Select Menu" from the sub menu
    Then I select "volvo,Opel" from the Standard multi Select dropdown

    @date
    Scenario: date
      Given I am on the homepage of Tools QA
      When I click on the "Widgets" from the main menu
      Then I click on the "Date Picker" from the sub menu
      Then I click on the "Select Date" button on the Date Picker page
      Then I select the date as "10/08/2010" on the Date Picker page
      Then I click on the "Date And Time" button on the Date Picker page
      Then I select the date and time as "October 28, 2024 16:15" button on the Date Picker page

