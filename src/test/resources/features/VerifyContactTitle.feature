
Feature: As a user, I should be able to access to Contacts module.
User Story: As a user, I should be able to access to Contacts module.

  @verify-contact-title @all
  Scenario Outline: verify user access to Talks module
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud QA"


    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |