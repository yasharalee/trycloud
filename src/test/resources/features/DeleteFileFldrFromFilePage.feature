Feature: As a user, I should be able to delete a file/folder.
  User Story: As a user, I should be able to delete a file/folder.

  @remove-folder-from-page
  Scenario Outline:
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    When the users click action-icon from random file or folder on the page to remove
    And user choose the submenu from given below
      |Delete folder|
      |Delete file|
    Then Verify the deleted file is not displayed on the page



    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |