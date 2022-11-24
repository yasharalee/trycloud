Feature: As a user, I should be able to remove files from favorites and upload a file directly

  @all @remove-file
  Scenario Outline: verify users to remove files to Favorites
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    When the users click action-icon from random file or  folder and chooses "Remove from favorites"

    And user click the sub-module on the left side
      | Favorites |
    Then Verify that the file is removed from the Favorites sub-module’s table

    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |

  @all @upload-file
  Scenario Outline: verify users to upload a file from Files
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And user clicks Upload file and uploads
      | filePath2 |
    Then verify the file is displayed on the page


    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |