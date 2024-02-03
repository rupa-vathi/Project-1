Feature:Login Functionality
  As a employee of the hotel
  I should calculate bill with the percentage what we offered

  Scenario: Test with Empty inputs

    Given I login to the page
    When I clear the tip Input element
    When I click on calculate button
    Then I verify the error text

    Scenario: Test with Invalid inputs

      Given I login to the page
      When I enter the tip percentage
      And I click on calculate button
      Then I verify the error text

      Scenario: Test with Valid inputs

        Given I login to the page
        When I enter bill and percentage
        And I click on calculate button
        Then I verify tip and total amount


