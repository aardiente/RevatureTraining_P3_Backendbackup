Feature: A user can follow another user

Background: A User is on the login page
		Given the User is logged in on the login page
		When the User selects ther Login page
		And the User inputs "email" into the username field
		And the User Owner inputs "password" into the password field
		And the User Owner clicks login
		Then the User is directed to the homepage

Scenario: Follow a User
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes









  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

