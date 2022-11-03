@access-moduls @all
Feature: As a user, I should be accessing all the main modules of the app.
  User Story: As a user, I should be accessing all the main modules of the app.


  Scenario Outline: Verify users accessing all the main modules of the app.

    Given When the users log in with valid "<username>" and "<password>"
    Then Then Verify the user see the following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

    Examples:

      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |



