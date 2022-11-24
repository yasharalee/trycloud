
Feature: As a user, I should be able to access to Contacts module.
User Story: As a user, I should be able to access to Contacts module.

  @verify-contact-title @all
  Scenario Outline: verify user access to Talks module
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud QA"

    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |