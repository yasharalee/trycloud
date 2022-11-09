Feature: As a user, I should be able to access to Talks module
  User Story: As a user, I should be able to access to Talks module

  @access_talk-module @Talk-comb
  Scenario Outline:
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud"

    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |

    @send_message @Talk-comb
  Scenario Outline: verify users to send a message
    Given When the users log in with valid "<username>" and "<password>"
    When the user clicks the "Talk" module
    And user search user from the search box
      | User4 |
    And user chose correct option from result list and clicks
      | User4 |
    And user write a message to chosen user
      | Hello from world |
    And user clicks to submit button
    Then the user should be able to see the message is displayed on the conversation log
      | Hello from world |





    Examples:
      | username | password    |
      | User17   | Userpass123 |
      | User47   | Userpass123 |
      | User77   | Userpass123 |
      | User107  | Userpass123 |