Feature: As a user, I should be able to delete a file/folder.
  User Story: As a user, I should be able to delete a file/folder.

  @all @remove-folder-from-page
  Scenario Outline:
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    When the users click action-icon from random file or folder on the page
    And user choose the submenu from given below
      |Delete folder|
      |Delete file|
    Then Verify the deleted file is not displayed on the page

    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |