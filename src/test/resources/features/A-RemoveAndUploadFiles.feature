Feature: As a user, I should be able to remove files from favorites and upload a file directly

  @all @remove-file
  Scenario Outline: verify users to remove files to Favorites
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    When the users click action-icon from random file or  folder on the page
    And user choose the Remove from favorites option
    And user click the sub-module on the left side
      | Favorites |
    Then Verify that the file is removed from the Favorites sub-module’s table

    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |

  @all @upload-file
  Scenario Outline: verify users to upload a file from Files
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And user clicks Upload file and uploads
      | filePath2 |
    Then verify the file is displayed on the page


    Given user enters <credential com number> from credentials excel "<sheet>"
    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |