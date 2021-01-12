@applySafeBalanceAccountFailedAttempt   @ignore
Feature: SafeBalance Banking Account application

  Scenario: verify SafeBalance Banking Account application flow
    Given I am on the homepage of the Bank of America
    Then I click on the Checking link
    Then I click on the Open a Checking Account image Link
    Then I scroll to SafeBalance Banking link
    Then I click on the open now link on the SafeBalance Banking link
    Then I enter the zip code with "10010" and click Go button if it exists
    Then I pause "1" seconds
    Then I select I only want a BOA SafeBalance card option
    Then I scroll to the Go to Application button in blue
    Then I click on the Go to Application button
    Then I click on the Continue button
    Then I pause "1" seconds
    Then I verify the warning message "Check and fix errors to continue."`
    Then I capture a screenshot of the current page
    Then I enter the first the name with "Will", last name with "Smith"
    Then I enter address with "6543 6 Ave 18th Floor" and city with "NYC"
    Then I select "State" as "NY"
    Then I clear zip code field and enter "10010"
    Then I enter the phone number with "987 897 9876"
    Then I enter the email address "will.smith876@gmail.com"
    Then I pause "3" seconds
    Then I reenter the email address "will.smith876@gmail.com"
    Then I click "Yes" to "Are you a US Citizen?"
    Then I enter SSN with "878-99-0989"
    Then I re-enter SSN with "878-99-0989"
    Then I click "No" to "Do you have dual citizenship?"
    Then I select "Country of Residence" as "United States"
    Then I enter the date of birth as "10101960"
    Then I select "Source of income" as "Social Security"
    Then I pause "1" seconds
    Then I select "Occupation" as "Unemployed"
    Then I pause "1" seconds
    Then I click on the Continue button
    Then I pause "5" seconds
#  I was directed to the following page after clicking the Continue button
    Then I verify the message header as "Account Setup"
    Then I verify the following message in the body
  """
  Now let's set up your features and decide how you'll add money to your new account.
  """
    Then I capture a screenshot of the current page

