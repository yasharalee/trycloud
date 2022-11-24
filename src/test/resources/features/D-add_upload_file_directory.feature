Feature: As a user, I should be able to remove files from the favorites and upload a file directly

  @all @add_directory
  Scenario Outline: Verify users can add the folder
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users clicks on the submenu option
      | New folder |
    And user write a "<folder name>"
    When the user click submit icon
    Then Verify the "<folder name>" is displayed on the page

    Examples:
      | sheet       | credential com number |folder name |
      | credentials | 1                     |Ferrari11     |
      | credentials | 2                     |Ferrari11    |
      | credentials | 3                     |Ferrari11     |
      | credentials | 4                     |Ferrari11     |


  @all @upload_file_inside_folder
  Scenario Outline: Verify users can upload a file inside a folder
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    And user choose a folder  from the page
    When the user clicks the add icon on the top
    And user uploads a file inside the chosen folder
      | filePath1 |
    Then Verify the File is displayed on the page


    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |