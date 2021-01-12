Feature: Practice Form

  @form
  Scenario: Practice Form
    Given I am on the homepage of Tools QA
    When I click on the "Forms" from the main menu
    Then I click on the "Practice Form" from the sub menu
    Then I fill last name with ""
    Then I fill first name with ""
    Then I fill email with ""
    Then I select gender as "Female"
    Then I fill mobile number with ""
    Then I fill address with ""
    Then I fill date of birth with "13/09/2000"
#    Then I fill subjects with ""
    Then I select hobbies as "Reading,Sports,Music"
    Then I pause "3" seconds
    Then I select state as "Haryana"
    Then I select city as "Karnal"
    Then I select image as "C://Users//Mira//Documents//cat.jpg"
    Then I submit the form