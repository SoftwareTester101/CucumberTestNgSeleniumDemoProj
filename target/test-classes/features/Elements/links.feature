@regression
Feature: Links

  @links
  Scenario: verify links
    Given I am on the homepage of Tools QA
    When I click on the "Elements" from the main menu
    Then I click on the "Links" from the sub menu
    Then I click on the "Home" link to open a new tab
    Then I click on the "" link to open a new tab
    Then I return to the default tab
    Then I click on the "Created" link and verify the status Code "201" and status text "Created" in bold
    Then I pause "2" seconds
    Then I click on the "No Content" link and verify the status Code "204" and status text "No Content" in bold
    Then I pause "2" seconds
    Then I click on the "Moved" link and verify the status Code "301" and status text "Moved Permanently" in bold
    Then I pause "2" seconds
    Then I click on the "Bad Request" link and verify the status Code "400" and status text "Bad Request" in bold
    Then I pause "2" seconds
    Then I click on the "Unauthorized" link and verify the status Code "401" and status text "Unauthorized" in bold
    Then I pause "2" seconds
    Then I click on the "Forbidden" link and verify the status Code "403" and status text "Forbidden" in bold
    Then I pause "2" seconds
    Then I click on the "Not Found" link and verify the status Code "404" and status text "Not Found" in bold