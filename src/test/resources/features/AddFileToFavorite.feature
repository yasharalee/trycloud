
  @add_file @all
    Feature: As a user, I should be able to access to Files module - Favorites button
      User Story: As a user, I should be able to add file to favorites.

    Scenario Outline: Verify users to add files to Favorites
      Given user enters <credential com number> from credentials excel "<sheet>"
      When the user clicks the "Files" module
      When the users click action-icon from random file or  folder and chooses "Add to favorites"
      And user click the sub-module on the left side
      |Favorites|
      Then Verify the chosen file is listed on the table


      Examples:
        | sheet       | credential com number |
        | credentials | 1                     |
        | credentials | 2                     |
        | credentials | 3                     |
        | credentials | 4                     |