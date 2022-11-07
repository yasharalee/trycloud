@all
Feature: As a user, I should be able to remove files from favorites and upload a file directly

  @remove-file
  Scenario Outline: verify users to remove files to Favorites
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    When the users click action-icon from any file on the page to remove
    And user choose the Remove from favorites option
    And user click the "Favorites" sub-module on the left side
    Then Verify that the file is removed from the Favorites sub-module’s table

    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |

  @upload-file
  Scenario Outline: verify users to upload a file from Files
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And user clicks Upload file and uploads
      |filePath|
    Then verify the file is displayed on the page



    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |