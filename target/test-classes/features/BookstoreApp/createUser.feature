@register
Feature: Create user for bookstore

  Scenario: create user
    Given I am on the homepage of Tools QA
    Then I click on the "Book Store Application" from the main menu
    Then I click on the "Login" from the sub menu
    Then I click on the "New User" button on the Login page
    Then I enter the first name as "Raziye"
    Then I enter the last name as "Kamal"
    Then I enter the username as "rKamal009"
    Then I enter the password as "NycManhattan0980@"
    Then I manually click the captcha
    Then I click on the Register button

    @selectBooks
    Scenario: login
      Given I am on the homepage of Tools QA
      Then I click on the "Book Store Application" from the main menu
      Then I click on the "Login" from the sub menu
      Then I enter the username as "rKamal009"
      Then I enter the password as "NycManhattan0980@"
      Then I click on the login button
      Then I scroll to the Go to the bookstore button
      Then I click on the Go To Book Store button
      Then I select the book called "Git Pocket Guide"
      Then I click on the Add To Your Collection button
      Then I click on the OK on alert
      Then I go Back To Book Store
      Then I increase the row number to 20
      Then I select the book called "You Don't Know JS"
      Then I click on the Add To Your Collection button
      Then I click on the OK on alert
      Then I click on the "Profile" from the sub menu
      Then I should see the selected books on the table
      Then I delete all books
      Then I capture a screenshot of the current page
      

      

