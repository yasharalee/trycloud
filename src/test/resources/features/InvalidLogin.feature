@invalid-login
Feature: As a user, I should be able to log in.

  Scenario Outline: Verify user login fail with invalid credentials
    Given user on login page
    Given user enters <credential com number> from credentials excel "<sheet>"
    Then verify <message> message should be displayed

    Examples:
      | sheet              | credential com number | message |
      | invalidCredentials | 1                     | 1       |
      | invalidCredentials | 2                     | 2       |
      | invalidCredentials | 3                     | 3       |