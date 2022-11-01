@login-sol
Feature: Loging in with valid credentials

  Scenario Outline: user must be able to login to account using valid credentials
    Given user on login page
    Given user enters "<userName>""<password>" credentials
    Then user should be able access dashboord

    Examples:
      | userName | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |