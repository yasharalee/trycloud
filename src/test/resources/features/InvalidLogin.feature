
@invalid-login
Feature: As a user, I should be able to log in.

  Scenario Outline: Verify user login fail with invalid credentials
    Given user on login page
    Given user enters "<userName>""<password>" credentials
    Then verify "<message>" message should be displayed

    Examples:
      | userName | password    | message                     |
      | User9    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password  |