@login-sol
Feature: Loging in with valid credentials

  Scenario Outline: user must be able to login to account using valid credentials
    Given user on login page
    Given user enters <credential com number> from credentials excel "<sheet>"
    Then user should be able access dashboord

    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |