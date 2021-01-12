#@signInNegative      @ignore
#Feature: Failed Sign In Error Message
#
#  Scenario: verify error message after failed sign in
#    Given I go to the home page of Bank Of America
#    Then I enter invalid username
#    Then I enter invalid password
#    Then I click on the Sign In button
#    Then I verify the following error message "The Online ID or Passcode you entered does not match our records"
#    Then I capture a screenshot of the current page