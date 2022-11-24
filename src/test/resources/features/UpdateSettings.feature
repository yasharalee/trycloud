
Feature: As a user, I should be able to click any button under settings.
  User Story: As a user, I should be able to update settings.

  @all @update-settings
  Scenario Outline:
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the "Files" module
    And user clicks Settings on the left bottom corner
    Then the user should be able to click any buttons

    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |


   @all @storage-usage
  Scenario Outline: : Verify users to see the app storage usage
     Given user enters <credential com number> from credentials excel "<sheet>"
      When the user clicks the "Files" module
      And user checks the current storage usage
      When the user clicks the add icon on the top
      And user clicks Upload file and uploads
        |filePath|
      And user refresh the page
      Then the user should be able to see storage usage is increased


     Examples:
       | sheet       | credential com number |
       | credentials | 1                     |
       | credentials | 2                     |
       | credentials | 3                     |
       | credentials | 4                     |