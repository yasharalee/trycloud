
  @add_file @all
    Feature: As a user, I should be able to access to Files module - Favorites button
      User Story: As a user, I should be able to add file to favorites.

    Scenario Outline: Verify users to add files to Favorites
      Given When the users log in with valid "<username>" and "<password>"
      When the user clicks the "Files" module
      When the user clicks action-icon from any file on the page
      And user choose the Add to favorites option
      And user click the Favorites sub-module on the left side
      Then Verify the chosen file is listed on the table





      Examples:
        | username | password    |
        | User17   | Userpass123 |
        | User47   | Userpass123 |
        | User77   | Userpass123 |
        | User107  | Userpass123 |