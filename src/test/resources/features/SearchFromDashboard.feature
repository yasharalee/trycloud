Feature: As a user, I should be able to search any item/ users from the homepage.
  User Story: As a user, I should be able to search any item/ users from the homepage.

  @verify_search_res @all
  Scenario Outline: Verify users can search any files/folder/users from the search box.
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the right side "Search" module
    And users search any existing "<file/folder/user>" name
    Then verify the app displays the expected "<file/folder/user>" in result option

    Examples:
      | username | password    | file/folder/user |
      | User17   | Userpass123 | hi            |
      | User47   | Userpass123 | User4            |
      | User77   | Userpass123 | User4            |
      | User107  | Userpass123 | User4            |