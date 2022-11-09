Feature: As a user, I should be able to remove files from the favorites and upload a file directly

  @all @add_directory
  Scenario Outline: Verify users can add the folder
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users clicks on the submenu option
      | New folder |
    And user write a "<folder name>"
    When the user click submit icon
    Then Verify the "<folder name>" is displayed on the page

    Examples:
      | username | password    | folder name |
      | User17   | Userpass123 | AudiA7      |
      | User47   | Userpass123 | AudiA7      |
      | User77   | Userpass123 | AudiA7      |
      | User107  | Userpass123 | AudiA7      |


  @all @upload_file_inside_folder
  Scenario Outline: Verify users can upload a file inside a folder
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    And user choose a folder  from the page
    When the user clicks the add icon on the top
    And user uploads a file inside the chosen folder
      | filePath4 |
    Then Verify the File is displayed on the page



    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |