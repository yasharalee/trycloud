
  @accessFile @all
    Feature: As a user, I should be able to access to Files module
      User Story: As a user, I should be able to access to Files module.

      Scenario Outline: verify users can select all the uploaded files from the page
        Given When the users log in with valid "<username>" and "<password>"
        When the user clicks the "Files" module
        And user click the top-left checkbox of the table
        Then verify all the files are selected


        Examples:
          | username | password    |
          | User17   | Userpass123 |
          | User47   | Userpass123 |
          | User77   | Userpass123 |
          | User107  | Userpass123 |