
Feature: As a user, I should be able to click any button under settings.
  User Story: As a user, I should be able to update settings.

  @all @update-settings
  Scenario Outline:
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Files" module
    And user clicks Settings on the left bottom corner
    Then the user should be able to click any buttons

    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |


   @all @storage-usage
  Scenario Outline: : Verify users to see the app storage usage
      Given When the users log in with valid "<username>" and "<password>"
      When the user clicks the "Files" module
      And user checks the current storage usage
      When the user clicks the add icon on the top
      And user clicks Upload file and uploads
        |filePath|
      And user refresh the page
      Then the user should be able to see storage usage is increased


      Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |