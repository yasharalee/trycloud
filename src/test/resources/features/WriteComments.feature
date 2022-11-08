Feature: As a user, I should be able to write comments to files/folders.
  User Story: As a user, I should be able to write comments to files/folders.

  @all @write-comment
  Scenario Outline:
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    When the users click action-icon from random file or folder  on the page
    And user choose the submenu from given menu below
      | Details |
    And user write a comment inside the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section.


    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |