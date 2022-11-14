Feature: As a user, I should be able to search any item/ users from the homepage.
  User Story: As a user, I should be able to search any item/ users from the homepage.

  @verify_search_res @all
  Scenario Outline: Verify users can search any files/folder/users from the search box.
    Given user enters <credential com number> from credentials excel "<sheet>"
    When the user clicks the right side "Search" module
    And users search any existing "<file/folder/user>" name
    Then verify the app displays the expected "<file/folder/user>" in result option


    Given user enters <credential com number> from credentials excel "<sheet>"
    Examples:
      | sheet       | credential com number |file/folder/user |
      | credentials | 1                     |hi            |
      | credentials | 2                     |User4            |
      | credentials | 3                     |User4            |
      | credentials | 4                     |hi            |